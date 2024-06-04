// 부서 CRUD 공통 함수들 정의 하는 js
import axiosDefault from "@/utils/axiosDefaultConfig";

// 상세조회
const get = (dno) => {
  return axiosDefault.get(`/basic/dept/${dno}`);
};

// 수정함수
const update = (dno, data) => {
  return axiosDefault.put(`/basic/dept/${dno}`, data);
};

const DeptService = {
  get,
  update
};

export default DeptService;
