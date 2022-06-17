package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.RoleDTO;
import com.ticketingapplication.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl extends AbstractMapService<Long, RoleDTO> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object );
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public RoleDTO findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(RoleDTO object) {
     super.map.remove(object);
    }

    @Override
    public void deleteById(Long aLong) {
     super.deleteById(aLong);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(), object);
    }

}
