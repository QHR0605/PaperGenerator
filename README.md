# PaperSyatem
大三上结对编程项目
# 结对编程项目

<img src="https://gitee.com/bankarian/picStorage/raw/master/%F2Z{WKPUAJWQ3$DJ0XMG3R.png" style="zoom: 50%;" wdith=50%/>

### 1.服务端接口需要的数据

- 接收客户端填入的手机号，类型为String类型
- 接收客户端填入的验证码，类型为String类型
- 接收客户端填入的题目难度(String)、数量(int)
- 接收客户端的答案(String)

### 2.服务端返回的数据类型设计

- 在用户输入验证码，点击注册后，服务端进行判断，返回一个状态值。(用json对象封装)

```json
{
    state:1为成功,2为不成功
    message:"如果不成功则返回相应的错误提示信息,成功则返回注册成功的提示信息"

}
```
- 在用户输入题目数量和难度之后，服务端返回一个json对象，

```json
{
    m_quesAndanswers:'map<题号,题目描述>'
}
```

- 返回分数

```json
{
score:"分数"
}
```

### 3. 前端给后端的数据类型

> **所有数据都封装为json格式**

1. 用户手机号 (服务端发送验证码，并跳转到验证页面)

   ```json
   {
       phone: "手机号"
   }
   ```

2. 验证码（服务端检查，成功则跳转到成功登入的页面）

   ```json
   {
       verification: "验证码"
   }
   ```

3. 用户设置/重置密码 （服务端存储密码，跳转到成功登入的页面）

   ```json
   {
       pwd: "密码"
   }
   ```

4. 用户选择题目 （服务端跳转到对应级别的页面，带有试题数据）

   ```json
   {
       level: '小学/初中/高中', 
       number: '10~30' 
   }
   ```

5. 用户答题结果 (跳转到显示分数的页面)

   ```json
   {
       0: "题目0结果",
       1: "题目1结果",
       ...
   }
   ```

