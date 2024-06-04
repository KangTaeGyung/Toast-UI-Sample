package org.example.simpledept.model.entity.basic;

import jakarta.persistence.*;
import lombok.*;
import org.example.simpledept.model.common.BaseTimeEntity;

/**
 * fileName : Dept
 * author : GGG
 * date : 2024-04-02
 * description : 부서 엔티티 : 테이블과 연결되는 자바클래스, 테이블과 동일하게 정의함
 */
@Entity
@Table(name = "TB_DEPT")
@SequenceGenerator(
        name = "SQ_DEPT_GENERATOR"
        , sequenceName = "SQ_DEPT"
        , initialValue = 1
        , allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_DEPT_GENERATOR"
    )
    private Integer dno;   // 부서번호(기본키)
    private String  dname; // 부서명
    private String  loc;   // 부서위치
}

