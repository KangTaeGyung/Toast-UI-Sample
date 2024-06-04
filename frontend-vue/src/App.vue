<template>
  <!-- 머리말 -->
  <HeaderCom />

  <div class="container mt-5">
    <router-view />
  </div>
</template>

<script>
import HeaderCom from "@/components/common/HeaderCom.vue";

export default {
    components : {
        HeaderCom    // 컴포넌트 등록
    }
}
</script>