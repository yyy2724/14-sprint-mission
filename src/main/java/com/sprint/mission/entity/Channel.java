package com.sprint.mission.entity;

public class Channel extends BaseEntity{

    private String channelName;

    public Channel(String channelName) {
        super();
        this.channelName = channelName;
    }

    public String getChannelName(){
        return channelName;
    }

    public void updateChannelName(String channelName){
        this.channelName = channelName;
        this.updateUpdatedAt(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelName='" + channelName + '\'' +
                '}';
    }
}
