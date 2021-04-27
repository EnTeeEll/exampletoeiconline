package vn.myclass.core.utils;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {

    public static RoleDTO entity2DTO(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setName(entity.getName());
        dto.setRoleId(entity.getRoleId());
        return dto;
    }

    public static RoleEntity dto2Entity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setName(dto.getName());
        entity.setRoleId(dto.getRoleId());
        return entity;
    }
}
