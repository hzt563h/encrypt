import axios from 'axios'
import crypto from '@/axios/aes.js'
import encrypt from '@/axios/rsa.js'
const axiosInstance = axios.create({
  baseURL: 'http://192.168.14.79:8080',
  timeout: 10000,
  withCredentials: false
})

axiosInstance.interceptors.request.use(request => {
  if (request.method == 'post') {
    if (request.data) {
      let aesKey = crypto.generatekey(16)
      let aesData = crypto.encrypt(request.data, aesKey)
      let rsaKey = encrypt.encrypt(aesKey)
      request.data = {}
      request.data['encData'] = aesData
      request.data['encAesKey'] = rsaKey
      
    }
  }
  return request
})

export default axiosInstance