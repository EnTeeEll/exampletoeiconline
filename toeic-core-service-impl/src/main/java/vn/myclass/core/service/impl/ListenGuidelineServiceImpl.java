package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidlineEntity;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {

    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();

    /*public Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String sortDirection,
                                                                    Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();

        Object[] objects = listenGuidelineDao.findByProperty(property, value, sortExpression, sortDirection, offset, limit);
        // convert Entity to DTO
        for (ListenGuidlineEntity item : (List<ListenGuidlineEntity>)objects[1]) {
            ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entity2DTO(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }*/
}
