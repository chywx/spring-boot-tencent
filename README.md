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

### 客户端
ajax请求添加该参数即可
```js
xhrFields: {
    withCredentials: true
},
```
同理axios也是如此
```js
axios.defaults.withCredentials = true
```
注意，修改cookie值直接document修改即可，请求的时候浏览器会自动携带的。
不需要在header中添加cookie头，这样做是没有任何意义的。比如
```js
headers: {
    'Cookie': 'JSESSIONID=6FA9E27092EC212E439851D4831AADE6'
}
```


### 服务端
添加允许跨域操作，此处表示Spring框架，直接用@CrossOrigin处理即可(最为简单)
```java
@CrossOrigin(value = "*", allowCredentials = "true")
```


## 服务端设置跨域的几种方式
### 方式一 重写addCorsMappings方法
```java
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
            .maxAge(3600)
            .allowCredentials(true);
    }
}
```
### 方式二 对单个接口处理
```java
// 需要设置前端请求的url。不支持*
responses.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
// 设置允许跨域的方法
responses.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
// 之后需要设置允许cookie跨域
response.setHeader("Access-Control-Allow-Credentials", "true");
```
### 方式三 @CrossOrigin注解
```java
@CrossOrigin(value = "*", allowCredentials = "true")
```
### 方式四 nginx配置添加允许跨域请求
```bash
server {
    listen 5566;
    server_name localhost;
        # 指定客户端的请求地址
        add_header 'Access-Control-Allow-Origin' 'http://localhost:63342';
        add_header 'Access-Control-Allow-Credentials' true;
        add_header Access-Control-Allow-Headers "Origin, X-Requested-With, Content-Type, Accept, Authorization,token,r,sign,time";

    location /  {

      if ($request_method = OPTIONS ) {
                   return 200;
         }

           proxy_method get;

           proxy_set_header X-real-IP $remote_addr;
           proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

           proxy_pass  http://127.0.0.1:5005;
           proxy_set_header Host $host;
       }

}
```