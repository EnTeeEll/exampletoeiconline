/*
package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("USER");
        roleDao.update(roleEntity);
    }

    @Test
    public void checkSaveRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("ADMIN");
        RoleEntity entity2 = new RoleEntity();
        entity2.setRoleId(2);
        entity2.setName("USER");
        roleDao.save(entity);
        roleDao.save(entity2);
    }

    @Test
    public void checkFindById() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = roleDao.findById(1);
    }

    @Test
    public void checkFindByProperty() {
        RoleDao roleDao = new RoleDaoImpl();
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;

        Object[] objects = roleDao.findByProperty(property,value,sortExpression,sortDirection);
    }

    @Test
    public void checkDelete() {
        List<Integer> listIds = new ArrayList<Integer>();
        listIds.add(1);
        listIds.add(2);
        RoleDao roleDao = new RoleDaoImpl();
        Integer count = roleDao.delete(listIds);
    }
}
*/
