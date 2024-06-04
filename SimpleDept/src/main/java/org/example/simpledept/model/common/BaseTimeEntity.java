package org.example.simpledept.model.common;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : GGG
 * @fileName : BaseTimeEntity
 * @since : 2024-04-02
 * description : 공통 클래스 , 생성일시/수정일시 자동 생성
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @Column(updatable = false)
    private String insertTime;

    private String updateTime;

    @PrePersist
    void OnPrePersist() {
        this.insertTime = getCurrentTime();
    }

    @PreUpdate
    void OnPreUpdate() {
        this.updateTime = getCurrentTime();
    }

    private String getCurrentTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

