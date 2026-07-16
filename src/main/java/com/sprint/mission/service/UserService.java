package com.sprint.mission.service;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;
import com.sprint.mission.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void create(User user);
    User read(UUID id);
    void update(User user);
    void delete(UUID id);
    List<User> readAll();


}
