package com.sprint.mission.service;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    void create(Message message);
    Message read(UUID id);
    void update(Message message);
    void delete(UUID id);
    List<Message> readAll();

}
