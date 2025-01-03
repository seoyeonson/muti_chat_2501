package com.ll.mutiChat.domain.chat.ChatRoom.service;

import com.ll.mutiChat.domain.chat.ChatMessage.entity.ChatMessage;
import com.ll.mutiChat.domain.chat.ChatRoom.entity.ChatRoom;
import com.ll.mutiChat.domain.chat.ChatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    // 채팅방 목록 조회
    public List<ChatRoom> showAllChatRoom() {
            return chatRoomRepository.findAll();
    }

    // 채팅방 생성
    @Transactional
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.builder().name(name).build();
        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

    // 채팅 작성
    @Transactional
    public ChatMessage write(long roomId, String writerName, String content) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).get();
        ChatMessage chatMessage = chatRoom.writeMessage(writerName, content);

        return chatMessage;
    }

    // 채팅방 상세 조회
    public Optional<ChatRoom> findById(long id) {
        return chatRoomRepository.findById(id);
    }


}
