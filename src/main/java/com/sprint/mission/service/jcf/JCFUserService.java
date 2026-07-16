package com.sprint.mission.service.jcf;

import com.sprint.mission.entity.Message;
import com.sprint.mission.entity.User;
import com.sprint.mission.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {

    private final Map<UUID, User> data;

    public JCFUserService() {
        this.data = new HashMap<>();
    }

    @Override
    public void create(User user) {
        if(data.containsKey(user.getId())){
            throw new IllegalArgumentException("해당 채널이 이미 존재합니다.");
        }

        data.put(user.getId(), user);
    }

    @Override
    public User read(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        return data.get(id);
    }

    @Override
    public void update(User user) {
        if(!data.containsKey(user.getId())){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        data.put(user.getId(), user);
    }

    @Override
    public void delete(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        data.remove(id);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(data.values());
    }
}
