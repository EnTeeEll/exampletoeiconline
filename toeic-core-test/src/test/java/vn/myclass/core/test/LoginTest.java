//package vn.myclass.core.test;
//
//import org.apache.log4j.Logger;
//import org.testng.annotations.Test;
//import vn.myclass.core.dao.UserDao;
//import vn.myclass.core.daoimpl.UserDaoImpl;
//import vn.myclass.core.persistence.entity.UserEntity;
//
//public class LoginTest {
//    private final Logger log = Logger.getLogger(this.getClass());
//
//    @Test
//    public void checkIsUserExist() {
//
//        UserDao userDao = new UserDaoImpl();
//        String name = "nguyenthanhlong";
//        String password = "123456";
//        UserEntity entity = userDao.isUserExist(name,password);
//        if(entity != null) {
//            log.error("Login sucess");
//        } else {
//            log.error("Login fail");
//        }
//    }
//
//    @Test
//    public void checkFindRoleByUser() {
//        UserDao userDao = new UserDaoImpl();
//        String name = "nguyenthanhlong";
//        String password = "123456";
//        UserEntity entity = userDao.findRoleByUser(name,password);
//        log.error(entity.getRole().getRoleId()+" - " + entity.getRole().getName());
//    }
//}
