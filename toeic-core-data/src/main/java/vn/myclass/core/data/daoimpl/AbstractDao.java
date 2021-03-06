package vn.myclass.core.data.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.myclass.core.common.constant.CoreConstant;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T> {
    private Class<T> persistenceClass;

    public AbstractDao() {
        // get name of T. (T = Entity)
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
        // Because AbstractDao return name of T but type of T is Class<T>
        // so, we need convert it into String.
    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session.get(persistenceClass, id);
            if (result == null) throw new ObjectNotFoundException("NOT FOUND " + id, null);
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection,
                                   Integer offset, Integer limit) {
        List<T> list = new ArrayList<T>();
        Object totallItem = 0;

        String[] params = new String[property.size()];
        Object[] values = new Object[property.size()];
        int i = 0;
        for (Map.Entry item:property.entrySet()) {
            params[i] = (String) item.getKey();
            values[i] = item.getValue();
            i++;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("FROM ");
            sql.append(getPersistenceClassName());
            if (property.size() > 0) {
                for (int i1 = 0; i1 < params.length; i1++ ) {
                    if(i1 == 0) {
                        sql.append(" WHERE ").append(params[i1]).append("= :"+params[i1]+"");
                    } else {
                        sql.append(" AND ").append(params[i1]).append("= :"+params[i1]+"");
                    }
                }
            }
            if(sortExpression != null && sortDirection != null){
                sql.append(" ORDER BY ").append(sortExpression);
                sql.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"ASC":"DESC"));
            }
            Query query1 = session.createQuery(sql.toString());

            if (property.size() > 0) {
                for (int i2 = 0; i2 < params.length; i2++) {
                    query1.setParameter(params[i2],values[i2]);
                }
            }

            // paging
            if (offset != null && offset >= 0) {
                query1.setFirstResult(offset);
            }
            if (limit != null && limit > 0) {
                query1.setMaxResults(limit);
            }

            list = query1.list();

            StringBuilder sql1 = new StringBuilder("SELECT COUNT(*) FROM ");
            sql1.append(getPersistenceClassName());
            if (property.size() > 0) {
                for (int j = 0; j < params.length; j++) {
                    if ( j == 0) {
                        sql1.append(" WHERE ").append(params[j]).append("= :"+params[j]+"");
                    } else {
                        sql1.append(" AND ").append(params[j]).append("= :"+params[j]+"");
                    }
                }
            }
            Query query2 = session.createQuery(sql1.toString());
            if (property.size() > 0) {
                for (int k = 0; k < params.length; k++) {
                    query2.setParameter(params[k],values[k]);
                }
            }
            totallItem = query2.list().get(0);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return new Object[]{totallItem,list};
    }

    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (ID item: ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return count;
    }
}
