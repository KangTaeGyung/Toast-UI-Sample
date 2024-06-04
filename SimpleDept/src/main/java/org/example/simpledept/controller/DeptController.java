package org.example.simpledept.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.simpledept.model.entity.basic.Dept;
import org.example.simpledept.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * fileName : DeptController
 * author : GGG
 * date : 2024-04-02
 * description : 부서 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/basic")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    //    상세 조회 함수
    @GetMapping("/dept/{dno}")
    public ResponseEntity<?> findById(
            @PathVariable int dno
    ) {
        Optional<Dept> optionalDept = deptService.findById(dno);

        if (optionalDept.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(optionalDept.get()
                , HttpStatus.OK);
    }

//    수정 함수
    @PutMapping("/dept/{dno}")
    public ResponseEntity<?> update(
            @PathVariable int dno,
            @RequestBody Dept dept
    ) {
        deptService.save(dept);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
