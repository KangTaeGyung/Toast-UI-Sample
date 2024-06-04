package org.example.simpledept.service;

import lombok.RequiredArgsConstructor;
import org.example.simpledept.model.entity.basic.Dept;
import org.example.simpledept.repository.basic.DeptRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * fileName : DeptService
 * author : GGG
 * date : 2024-04-02
 * description : 부서 서비스 클래스
 */
@Service
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;

    // 상세조회
    public Optional<Dept> findById(int dno) {
        Optional<Dept> optionalDept = deptRepository.findById(dno);

        return optionalDept;
    }

//    저장/수정 함수
    public void save(Dept dept) {
        deptRepository.save(dept);
    }
}

