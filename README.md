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
       "名字？？？": {
           "1+1=": "2",
           "2+2=": "4",
           ...
       }
   }
   ```

   
