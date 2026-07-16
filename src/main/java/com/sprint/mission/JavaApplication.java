package com.sprint.mission;


import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;
import com.sprint.mission.entity.User;
import com.sprint.mission.service.ChannelService;
import com.sprint.mission.service.MessageService;
import com.sprint.mission.service.UserService;
import com.sprint.mission.service.jcf.JCFChannelService;
import com.sprint.mission.service.jcf.JCFMessageService;
import com.sprint.mission.service.jcf.JCFUserService;

public class JavaApplication {
    public static void main(String[] args) {
        ChannelService channelService = new JCFChannelService();
        MessageService messageService = new JCFMessageService();
        UserService userService = new JCFUserService();
        Channel channel = new Channel("LGU+");
        User user = new User("김양현");
        Message message = new Message("메세지 내용입니다.", user, channel);

        channelService.create(channel);
        messageService.create(message);
        userService.create(user);

        System.out.println(channelService.read(channel.getId()));
        System.out.println(messageService.read(message.getId()));
        System.out.println(userService.read(user.getId()));

        channel.updateChannelName("KT");
        user.updateUserName("aaron");
        message.updateMessage("솔직히 내가 생각해도 진짜 못짰다.");

        channelService.update(channel);
        userService.update(user);
        messageService.update(message);

        channelService.delete(channel.getId());

        System.out.println(channelService.readAll());
        System.out.println(userService.readAll());
        System.out.println(messageService.readAll());

        System.out.println();

    }
}
