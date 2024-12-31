<template>
  <div class="card" align="left">
    <div class="card-header">Register Form</div>
    <div class="card-body">
      <form @submit.prevent="saveData">
        <label>Employee Name</label>
        <input type="text" v-model="employee.employeename" name="employeename" id="employeename" class="form-control">

        <label>Email</label>
        <input type="email" v-model="employee.email" name="email" id="email" class="form-control">

        <label>Password</label>
        <input type="password" v-model="employee.password" name="password" id="password" class="form-control">

        <input type="submit" value="Save" class="btn btn-success">
      </form>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
  export default {
    name: 'RegisterComponent',
    data(){
      return {
        employee:{
          employeename: '',
          email: '',
          password: ''
        }
      }
    },
    created() {
    },
    mounted() {
      console.log("mounted() called.........");
    },
    methods:{
      saveData(){
        axios.post("http://localhost:8090/api/v1/employee/save", this.employee)
            .then(
                ({data})=>{
                  console.log(data);
                  try{
                    alert("saveddd");
                  }catch (err){
                    alert("failed");
                  }
                }
            )
      }
    }
  }
</script>
<style scoped>

</style>

<!--<div class="row">-->
<!--<div class="col-sm-4">-->
<!--  <h2 align="center">Login</h2>-->
<!--  <form @submit.prevent="LoginData">-->
<!--    <div class="form-control" align="left">-->
<!--      <label>Email</label>-->
<!--      <input type="email" v-model="student.email" class="form-control" placeholder="Email">-->
<!--    </div>-->
<!--    <div class="form-control" align="left">-->
<!--      <label>Password</label>-->
<!--      <input type="password" v-model="student.password" class="form-control" placeholder="PassWord">-->
<!--    </div>-->
<!--    <br/>-->
<!--    <button type="submit" class="btn btn-primary">Login</button>-->
<!--  </form>-->
<!--</div>-->
<!--</div>-->