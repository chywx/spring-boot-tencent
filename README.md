# spring-boot-tencent
部署到腾讯服务器的接口服务

## 省市联动
#### sql地址
./doc/sql/region.sql


## 分享第三方
https://www.cnblogs.com/chywx/p/13265845.html

## swagger集成文档
访问根目录即可自动跳转


## ajax cookie跨域处理

### 前端
ajax请求添加该参数即可
```js
xhrFields: {
    withCredentials: true
},
```
注意，修改cookie值直接document修改即可，请求的时候浏览器会自动携带的。
不需要在header中添加cookie头，这样做是没有任何意义的。比如
```js
headers: {
    'Cookie': 'JSESSIONID=6FA9E27092EC212E439851D4831AADE6'
}
```


### 服务端
首先需要允许跨域
```java
// * 表示允许所有网站
responses.setHeader("Access-Control-Allow-Origin", "*");
// 设置允许跨域的方法
responses.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
```
之后需要设置允许cookie跨域
```java
response.setHeader("Access-Control-Allow-Credentials", "true");
```


## 服务端设置跨域的几种方式
方式一
