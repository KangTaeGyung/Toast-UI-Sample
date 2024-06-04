package org.example.simpledept.repository.basic;

import org.example.simpledept.model.entity.basic.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * fileName : DeptRepository
 * author : GGG
 * date : 2024-04-02
 * description : 부서 SQL 작성하는 인터페이스
 */
@Repository
public interface DeptRepository extends JpaRepository<Dept,Integer> {
}