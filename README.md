## iOS 通知推送服务器 (APNS) 使用 HTTP/2 协议
    苹果现在更新了通知推送传输服务的协议，简称 APNS，最新版本的协议是基于 HTTP/2 和 JSON，意味着相对于旧版二进制协议有了很大的提升。

![Image text](https://github.com/huskyv/huskyv-push/blob/master/img/675337-1b7dfc31c2f70319.jpg)
#### 新特性和功能
> 基于 JSON 的请求响应协议  
> 每个通知 APNS 会发送 200 个 成功响应 —— 不会再猜测通知是否被接收  
> 错误响应使用一个 JSON 字符串表示  
> 通知消息长度从 2048 字节提升到 4096 字节  
> 连接状态会使用 HTTP/2 PING Frame 辅助检测  
> 支持 topics  
> Universal Push Notification Certificate- 开发和生产环境都使用相同凭证
![Image text](https://github.com/huskyv/huskyv-push/blob/master/img/675337-b47174b3f5db329d.jpg)

