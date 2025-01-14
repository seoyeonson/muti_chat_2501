package com.ll.mutiChat.global.initData;

import com.ll.mutiChat.domain.chat.ChatRoom.entity.ChatRoom;
import com.ll.mutiChat.domain.chat.ChatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile(("!prod"))
public class NotProd {

    @Bean
    public ApplicationRunner applicationRunner(ChatRoomService chatRoomService) {
        return args -> {
            ChatRoom chatRoom1 = chatRoomService.createChatRoom("공부");
            ChatRoom chatRoom2 = chatRoomService.createChatRoom("식사");
            ChatRoom chatRoom3 = chatRoomService.createChatRoom("휴식");

            IntStream.rangeClosed(1, 100).forEach(num -> {
                chatRoomService.write(chatRoom1.getId(), "홍길동", "message" + num);
            });
        };
    }
}
