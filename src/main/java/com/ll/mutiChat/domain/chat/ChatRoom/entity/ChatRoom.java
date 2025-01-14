package com.ll.mutiChat.domain.chat.ChatRoom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.mutiChat.domain.chat.ChatMessage.entity.ChatMessage;
import com.ll.mutiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter
@Getter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {
    private String name;

    // orphanRemoval
    // true: 부모 엔티티와의 관계가 끊어진 자식 엔티티를 데이터베이스에서 자동으로 삭제, false (default)

    // casecade
    // 부모 엔티티에 대해 특정 작업을 수행할 때 해당 작업이 자식 엔티티에도 자동으로 전달되는 것

    // CascadeType.ALL: 모든 작업을 자식 엔티티에 전파합니다.
    // CaseCadeType.PERSIST: 영속성 컨텍스트에 저장할 때 자식 엔티티도 함께 저장합니다.
    // CaseCadeType.REMOVE: 부모 엔티티를 삭제할 때 자식 엔티티도 함께 삭제합니다.
    // CaseCadeType.MERGE: 병합할 때 자식 엔티티도 함께 병합합니다.
    // CaseCadeType.REFRESH: REFRESH할 때 자식 엔티티도 함께 REFRESH합니다.
    // CaseCadeType.DETACH: DETACH할 때 자식 엔티티도 함께 DETACH합니다.

    // @ToString.Exclude
    // 해당 필드를 toString()에서 제외합니다.

    // @JsonIgnore
    // 해당 필드를 JSON으로 변환하지 않습니다.
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @OrderBy("id DESC")
    @JsonIgnore
    private List<ChatMessage> chatMessages;

    public ChatMessage writeMessage(String writerName, String content) {
        ChatMessage chatMessage = ChatMessage
                .builder()
                .chatRoom(this)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessages.add(chatMessage);

        return chatMessage;
    }
}
