# spring-dubbo
通过dubbo中间件技术，集成Spring实现分布式服务框架。

代码结构说明：
spring-dubbo-api，远程调用的接口定义。
spring-dubbo-module：用于远程调用的消息实体，可序列化与反序列化。
spring-dubbo-ds：数据源操作工具包
spring-dubbo-server：Dubbo的服务端（WEB服务），发布服务。
spring-dubbo-client：dubbo服务的消费端（WEB）。

