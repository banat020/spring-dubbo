# spring-dubbo
通过dubbo中间件技术，整合Spring实现分布式服务框架；同时，还整合Hibernate、Mybatis3实现对数据表的操作。<br>
数据源用Druid。<br>
为什么要同时整合Hibernate与MyBatis呢？因为，对数据的增删改，Hibernate提供简单的实现，不过，对于复杂的查询，尤其是动态查询，Hibernate的实现就显得比较麻烦了，于是，再集合MyBatis3，用于处理数据查询，并且用MyBatis查询还有性能更优的好处。<br>
还有另一点，技术框架只对Hibernate的操作应用事务，MyBatis的操作不启用事务。<br>
<br><br>
<b>声明：此技术框架已在本人所负责的几个项目中验证过。</b>
<br><br>
代码结构说明：<br>
spring-dubbo-api，远程调用的接口定义。<br>
spring-dubbo-module：用于远程调用的消息实体，可序列化与反序列化。<br>
spring-dubbo-ds：数据源操作工具包。<br>
spring-dubbo-server：Dubbo的服务端（WEB服务），发布服务。<br>
spring-dubbo-client：dubbo服务的消费端（WEB）。<br>
<br><br>
应用说明：<br>
1）将spring-dubbo-ds根目录的ds.sql导入Mysql数据库中；并修改spring-dubbo-ds\src\test\resources\config\ds\ds.config.properties中的数据库连接。<br>
2）安装Zookeeper，作为Dubbo服务的注册中心；并修改spring-dubbo-server（在src\main\resources\config\server\applicationContext-server.xml）与spring-dubbo-client（在\src\main\resources\config\client\applicationContext-client.xml）中的dubbo注册中心的地址。<br>
3）分别用Maven编译上述各模块。<br>
4）将spring-dubbo-server部署在Web服务器中发布服务，如：tomcat。可以直接部署在多个tomcat中。<br>
5）运行spring-dubbo-client是dubbo服务的消费端，可以直接运行其中的测试用例。消费端可以整合MVC（如SpringMVC、Struts2等）构架实现自己的业务功能，就像普通的功能一样开发。<br>

