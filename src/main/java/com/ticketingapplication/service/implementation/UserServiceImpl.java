package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends  AbstractMapService<String , UserDTO> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public void delete(UserDTO object) {
       super.map.remove(object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO findById(String  id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String  id) {
      super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }


}
