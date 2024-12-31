<template>
  <div class="login-layout">
    <slot></slot> <!-- Khu vực cho nội dung cụ thể (form đăng nhập) -->
  </div>
</template>

<script>
export default {
  name: 'LoginLayout',
};
</script>

<style scoped>
.login-layout {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Chiều cao đầy đủ của viewport */
  background-color: #f7f7f7; /* Màu nền */
}

.row {
  width: 100%; /* Chiều rộng đầy đủ */
  max-width: 400px; /* Độ rộng tối đa */
  margin: auto; /* Canh giữa */
}

.form-control {
  margin-bottom: 15px; /* Khoảng cách giữa các trường */
}

.btn {
  width: 100%; /* Nút full width */
}
</style>
