# spring-dubbo
通过dubbo中间件技术，整合Spring实现分布式服务框架；同时，还整合Hibernate、Mybatis3实现对数据表的操作。<br>
为什么要同时整合Hibernate与MyBatis呢？因为，对数据的增删改，Hibernate提供简单的实现，不过，对于复杂的查询，尤其是动态查询，Hibernate的实现就显得比较麻烦了，于是，再集合MyBatis3，用于处理数据查询，并且用MyBatis查询还有性能更优的好处。<br>
还有另一点，技术框架只对Hibernate的操作应用事务，MyBatis的操作不启用事务。<br>
<br><br>
<b>声明：此技术框架已在本人所负责的几个项目验证过。</b>
<br><br>
代码结构说明：<br>
spring-dubbo-api，远程调用的接口定义。<br>
spring-dubbo-module：用于远程调用的消息实体，可序列化与反序列化。<br>
spring-dubbo-ds：数据源操作工具包。<br>
spring-dubbo-server：Dubbo的服务端（WEB服务），发布服务。<br>
spring-dubbo-client：dubbo服务的消费端（WEB）。<br>
<br><br>
