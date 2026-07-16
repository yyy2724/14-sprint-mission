package com.sprint.mission.service.jcf;

import com.sprint.mission.entity.BaseEntity;
import com.sprint.mission.entity.Channel;
import com.sprint.mission.service.BasicService;

import java.util.*;

public abstract class JCFBasicService<T extends BaseEntity> implements BasicService<T> {
    private final Map<UUID, T> data;

    public JCFBasicService() {
        this.data = new HashMap<>();
    }

    @Override
    public void create(T t) {
        if (data.containsKey(t.getId())) {
            throw new IllegalArgumentException("해당 값이 이미 존재합니다.");
        }

        data.put(t.getId(), t);
    }

    @Override
    public T read(UUID id) {
        check(id);
        return data.get(id);
    }

    @Override
    public void update(T t) {
        check(t.getId());

        data.put(t.getId(), t);
    }

    @Override
    public void delete(UUID id) {
        check(id);

        data.remove(id);
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(data.values());
    }


    public void check(UUID id) {
        if (!data.containsKey(id)) {
            throw new IllegalArgumentException("해당 값이 존재하지 않습니다.");
        }
    }
}
