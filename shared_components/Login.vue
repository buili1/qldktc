<template>
  <LoginLayout>
    <div class="row">

      <form @submit.prevent="LoginData">
        <div class="form-control">
          <label>MÃ SV</label>
          <input type="text" v-model="employee.masv" class="form-control" required>
        </div>
        <div class="form-control">
          <label>Password</label>
          <input type="password" v-model="employee.password" class="form-control" required>
        </div>
        <button type="submit" class="btn">Login</button>
      </form>
    </div>
  </LoginLayout>
</template>

<script>
import axios from 'axios';
import LoginLayout from "./LoginLayout.vue";

export default {
  name: 'LoginComponent',
  components: {LoginLayout},
  data() {
    return {
      employee: {
        masv: '',
        password: ''
      }
    }
  },
  created() {
  },
  mounted() {
    console.log("mounted() called.........");
  },

//   methods: {
//
//     async LoginData() {
//       try {
//         const response = await axios.post("http://localhost:8090/api/v1/user/login",
//           this.employee
//         );
//         // if (response.data.valid) {
//         //   next();
//         // } else {
//         //   throw new Error("Token không hợp lệ");
//         // }
//         const { message, token, role } = response.data;
//
//         if (message === "Login Success") {
//           localStorage.setItem("token", token);
//           localStorage.setItem("role", role);
//           console.log("Token:", localStorage.getItem("token"));
//           console.log("Role:", localStorage.getItem("role"));
//           //this.login(); // Gọi action login để cập nhật trạng thái
//           // Chuyển hướng dựa trên vai trò
//           if (role === "admin") {
//             window.location.href = "http://localhost:8081";
//           } else if (role === "user") {
//             window.location.href = "http://localhost:8085";
//           }
//         } else {
//           alert(message);
//         }
//       } catch (error) {
//         alert("Đăng nhập thất bại. Vui lòng thử lại!");
//         console.error(error);
//       }
//     },
//   }
//
// }
  methods: {
    async LoginData() {
      try {
        const response = await axios.post("http://localhost:8090/api/v1/user/login", this.employee);
        const {message, token, role} = response.data;

        if (message === "Login Success") {
          // Lưu token và role vào cookie
          document.cookie = `token=${token}; path=/; domain=localhost; secure`;
          document.cookie = `role=${role}; path=/; domain=localhost; secure`;

          console.log("Token và Role được lưu vào cookie");

          // Chuyển hướng dựa trên vai trò
          if (role === "admin") {
            window.location.href = "http://localhost:8086";
          } else if (role === "user") {
            window.location.href = "http://localhost:8085";
          }
        } else {
          alert(message);
        }
      } catch (error) {
        alert("Đăng nhập thất bại. Vui lòng thử lại!");
        console.error(error);
      }
    }
  }
}

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
  padding: 20px; /* Khoảng cách trong */
  border-radius: 8px; /* Bo góc */
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Đổ bóng */
  background-color: white; /* Màu nền trắng cho form */
}

h2 {
  text-align: center; /* Căn giữa tiêu đề */
  margin-bottom: 20px; /* Khoảng cách dưới tiêu đề */
  color: #333; /* Màu chữ tối */
}

.form-control {
  margin-bottom: 15px; /* Khoảng cách giữa các trường */
}

label {
  font-weight: bold; /* Chữ in đậm cho label */
  display: block; /* Hiển thị label dưới dạng khối */
  margin-bottom: 5px; /* Khoảng cách dưới label */
  color: #555; /* Màu chữ cho label */
}

input[type="text"],
input[type="password"] {
  width: 100%; /* Nút full width */
  padding: 10px; /* Khoảng cách trong */
  border: 1px solid #ccc; /* Đường viền nhẹ */
  border-radius: 4px; /* Bo góc */
  transition: border-color 0.3s; /* Hiệu ứng chuyển màu viền */
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-color: #007bff; /* Màu viền khi focus */
  outline: none; /* Xóa viền ngoài khi focus */
}

.btn {
  width: 100%; /* Nút full width */
  padding: 10px; /* Khoảng cách trong */
  border: none; /* Không có đường viền */
  border-radius: 4px; /* Bo góc */
  background-color: #007bff; /* Màu nền nút */
  color: white; /* Màu chữ nút */
  font-weight: bold; /* Chữ in đậm cho nút */
  cursor: pointer; /* Con trỏ chuột khi hover */
  transition: background-color 0.3s; /* Hiệu ứng chuyển màu nền */
}

.btn:hover {
  background-color: #0056b3; /* Màu nền khi hover */
}
</style>

