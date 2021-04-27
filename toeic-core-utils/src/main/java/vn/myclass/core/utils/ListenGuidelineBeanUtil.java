package vn.myclass.core.utils;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidlineEntity;

public class ListenGuidelineBeanUtil {

    public static ListenGuidelineDTO entity2DTO (ListenGuidlineEntity entity) {
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setListenGuidlineId(entity.getListenGuidlineId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setImage(entity.getImage());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public static ListenGuidlineEntity dto2Entity (ListenGuidelineDTO dto) {
        ListenGuidlineEntity entity = new ListenGuidlineEntity();
        entity.setListenGuidlineId(dto.getListenGuidlineId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setImage(dto.getImage());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }
}
