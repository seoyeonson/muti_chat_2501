package com.ll.mutiChat.domain.chat.ChatMessage.service;

import com.ll.mutiChat.domain.chat.ChatMessage.entity.ChatMessage;
import com.ll.mutiChat.domain.chat.ChatMessage.repository.ChatMessageRepository;
import com.ll.mutiChat.domain.chat.ChatRoom.entity.ChatRoom;
import com.ll.mutiChat.domain.chat.ChatRoom.repository.ChatRoomRepository;
import com.ll.mutiChat.domain.chat.ChatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    // afterId 이후 채팅 조회
    // IdAfter : id가 주어진 값보다 큰 데이터를 찾는다.
    public List<ChatMessage> findByChatRoomIdAndIdAfter(long roomId, long afterId){
        return chatMessageRepository.findByChatRoomIdAndIdAfter(roomId, afterId);
    };
}
