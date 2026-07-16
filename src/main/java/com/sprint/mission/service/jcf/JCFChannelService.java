package com.sprint.mission.service.jcf;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.service.ChannelService;

import java.util.*;

public class JCFChannelService implements ChannelService {

    private final Map<UUID, Channel> data;

    public JCFChannelService() {
        this.data = new HashMap<>();
    }

    @Override
    public void create(Channel channel) {

        if(data.containsKey(channel.getId())){
            throw new IllegalArgumentException("해당 채널이 이미 존재합니다.");
        }

        data.put(channel.getId(), channel);
    }

    @Override
    public Channel read(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }
        return data.get(id);
    }

    @Override
    public void update(Channel channel) {
        if(!data.containsKey(channel.getId())){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }

        data.put(channel.getId(), channel);
    }

    @Override
    public void delete(UUID id) {
        if(!data.containsKey(id)){
            throw new IllegalArgumentException("해당 채널이 존재하지 않습니다.");
        }

        data.remove(id);
    }

    @Override
    public List<Channel> readAll() {
        return new ArrayList<>(data.values());
    }

}
