package com.sprint.mission.service.jcf;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;
import com.sprint.mission.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {

    private final Map<UUID, Message> data;

    public JCFMessageService() {
        this.data = new HashMap<>();
    }

    @Override
    public void create(Message message) {
        if(data.containsKey(message.getId())){
            throw new IllegalArgumentException("해당 채널이 이미 존재합니다.");
        }
        data.put(message.getId(), message);
    }

    @Override
    public Message read(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        return data.get(id);
    }

    @Override
    public void update(Message message) {
        if(!data.containsKey(message.getId())){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        data.put(message.getId(), message);
    }

    @Override
    public void delete(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        data.remove(id);
    }

    @Override
    public List<Message> readAll() {
        return new ArrayList<>(data.values());
    }
}
