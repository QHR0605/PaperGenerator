# PaperSyatem
大三上结对编程项目
# 结对编程项目

## 大致流程
<img src="https://gitee.com/bankarian/picStorage/raw/master/20201006113153.png" style="zoom:50%;" width="80%"/>

## 前后端数据交互

> **所有数据都封装为json格式**

1. <img src="https://gitee.com/bankarian/picStorage/raw/master/20201006113050.png" style="zoom:50%;" width="40%"/>
   
   **前端**：提交用户手机号 (服务端发送验证码，并跳转到验证页面)

   ```json
   {
       phone: "手机号"
   }
   ```

   **后端**：发送验证码给用户

   

2. <img src="https://gitee.com/bankarian/picStorage/raw/master/20201006113050.png" style="zoom:50%;" width="40%"/>

   **前端**：提交验证码（服务端检查，成功则跳转到成功登入的页面）

   ```json
   {
       verification: "验证码"
   }
   ```

   **后端**：返回验证结果

   ```json
   {
       state:1为成功,2为不成功
       message:"如果不成功则返回相应的错误提示信息,成功则返回注册成功的提示信息"
   }
   ```

   

3. <img src="https://gitee.com/bankarian/picStorage/raw/master/20201006113409.png" style="zoom:50%;" width="40%"/>

   **前端**：判断两次密码是否相等，提交最终密码，

   ```json
   {
       pwd: "密码"
   }
   ```

   **后端**：返回验证结果

   ```json
   ？？？？
   ```

   

4.<img src="https://gitee.com/bankarian/picStorage/raw/master/20201006113513.png" style="zoom:50%;" width="40%"/>

   **前端**：提交用户选择题目 

   ```json
   {
       level: '小学/初中/高中', 
       number: '10~30' 
   }
   ```

   **后端**：返回题目和答案map

   ```json
   {
       "m_quesAndanswers": {
           "1+1=": "2",
           "2+2=": "4",
           ...
       }
   }
   ```
## 前端访问路径

1."http://localhost:8080/TestPaperGenerator/index.html" 访问登录界面
2."http://localhost:8080/TestPaperGenerator/sendsms" 点击发送手机号后的请求路径
3."http://localhost:8080/TestPaperGenerator/handle_reg" 输入验证码后的请求路径
4."http://localhost:8080/TestPaperGenerator/checkpassword"为输入两次密码后的请求路径
5."http://localhost:8080/TestPaperGenerator/makequestion"为输入题目难度和数量后的请求路径
