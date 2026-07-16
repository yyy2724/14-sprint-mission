package com.sprint.mission.entity;

public class Message extends BaseEntity{

    private String message;
    private User user;
    private Channel channel;

    public Message(String message, User user, Channel channel) {
        super();
        this.message = message;
        this.user = user;
        this.channel =channel;
    }

    public String getMessage(){
        return message;
    }

    public void updateMessage(String message){
        this.message = message;
        this.updateUpdatedAt(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", channel=" + channel +
                '}';
    }
}
