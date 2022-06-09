package com.ticketingapplication.converter;

import com.ticketingapplication.dto.RoleDTO;
import com.ticketingapplication.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDTOConverter implements Converter<String, RoleDTO> {

    private final RoleService roleService;

    public RoleDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }



    @Override
    public RoleDTO convert(String source) {
       return roleService.findById(Long.parseLong(source));

    }
}
