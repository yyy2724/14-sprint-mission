package com.sprint.mission.service;

import com.sprint.mission.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelService {

    void create(Channel channel);
    Channel read(UUID id);
    void update(Channel channel);
    void delete(UUID id);
    List<Channel> readAll();


}
