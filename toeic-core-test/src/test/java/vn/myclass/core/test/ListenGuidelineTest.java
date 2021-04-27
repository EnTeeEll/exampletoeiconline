package vn.myclass.core.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest {

    ListenGuidelineDao listenGuidelineDao;
    @BeforeTest
    public void initData() {
        listenGuidelineDao = new ListenGuidelineDaoImpl();
    }

    @Test
    public void testFindByProperties() {
//        Object[] result = listenGuidelineDao.findByProperty(null,null, null, null,
//                                                            4, 2);
    }

    @Test
    public void checkApiFindByProperty() {
        Map<String, Object> property = new HashMap<String, Object>();
        property.put("title","Bai hd 3");
        property.put("content","Noi dung bai hd 3");
        Object[] objects = listenGuidelineDao.findByProperty(property,null,null,null,null);
    }
}
