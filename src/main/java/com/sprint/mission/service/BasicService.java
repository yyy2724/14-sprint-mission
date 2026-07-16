package com.sprint.mission.service;

import com.sprint.mission.entity.BaseEntity;
import com.sprint.mission.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface BasicService<T> {
    void create(T channel);
    T read(UUID id);
    void update(T channel);
    void delete(UUID id);
    List<T> readAll();
}
