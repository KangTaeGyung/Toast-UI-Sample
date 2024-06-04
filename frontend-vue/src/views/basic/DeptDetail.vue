<template>
  <div>
    <div>
      <label for="loc" class="col-form-label"> 부서위치 </label>
    </div>
    <!-- TOAST UI 에디터 -->
    <div id="editor"></div>

    <div class="row g-3 mt-3 mb-3">
      <button
        type="submit"
        class="btn btn-success ms-2 col"
        @click="updateDept"
      >
        수정
      </button>
    </div>
  </div>
</template>

<script>
import Editor from "@toast-ui/editor";
import "@toast-ui/editor/dist/toastui-editor.css"; // Editor's Style
import DeptService from "@/services/basic/DeptService";

export default {
  data() {
    return {
      dept: null,
      toastEditor: null,
    };
  },
  methods: {
    // 상세조회요청 함수
    async getDept(dno) {
      try {
        let response = await DeptService.get(dno);
        this.dept = response.data;

        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // toast ui 에디터 생성
    createEditer(loc) {
      this.toastEditor = new Editor({
        el: document.querySelector("#editor"),
        initialEditType: "wysiwyg",
        initialValue: loc,                // TODO: 중요 : 여기 loc 넣기 , 에디터에 loc 보임
      });
    },
    // 수정요청 함수
    async updateDept() {
      try {
        let temp = {
          dno: this.dept.dno,
          dname: this.dept.dname,
          loc: this.toastEditor.getHTML(),   // TODO: 중요 : 에디터의 글 loc 가져오기
        };
        console.log(temp);
        let response = await DeptService.update(this.dept.dno, temp);
        console.log(response.data);

        alert("수정이 성공했습니다.");

        // 다시 상세조회
        this.getDept(this.dept.dno);
      } catch (e) {
        console.log(e);
      }
    },
  },
  async mounted() {
    await this.getDept(this.$route.params.dno); // 상세조회 함수 실행

    this.createEditer(this.dept.loc); // TODO: 에디터에 loc 넣기
  },
};
</script>
