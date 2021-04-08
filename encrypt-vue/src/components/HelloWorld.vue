<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
    <el-table-column prop="age" label="年龄" width="180"> </el-table-column>
    <el-table-column prop="email" label="邮箱"> </el-table-column>
  </el-table>
</template>
<script>
const axios = require("axios");
import RSA from "@/axios/rsa.js";
import AES from "@/axios/aes.js";
export default {
  name: "HelloWorld",
  data() {
    return {
      tableData: [],
    };
  },
  watch: {},
  computed: {},
  created() {
    this.getUserListAll();
    // let Base64 = require('js-base64').Base64
    // let orgKey = "{'id':'1'}"
    // let reptKey = encrypt.encrypt(orgKey)
    // let rdekey = encrypt.decrypt(reptKey)
    // let aeptKey = cryptoJS.encrypt(orgKey)
    // let a = Base64.encode(aeptKey)
    // let adekey = cryptoJS.decrypt(aeptKey)
    // this.$axios.get('/decryptTest', orgKey).then((res) => {
    //   debugger
    // })
    
  },
  methods: {
    getUserListAll() {
      
      this.$axios.get("/user/getUserListAll").then((response) => {
          var aesKey= RSA.decrypt(response.data.encryptKey);
          var dataStr = AES.decrypt(response.data.data,aesKey);
          this.tableData=JSON.parse(dataStr)
      });
      
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
