# SB_CRM_EX


#使用的技术
    后端以Spring技术棧，前端采用SPA页面风格设计，使用bootstrap工具包。

## 后端
|框架名|作用 |版本 |
|---|---|---|
|SpringBoot|基础脚手架|魂牵梦萦|
|SpringSecurity|认证授权|
|Mybatis|操作数据库||
|druid|数据源||
|Mysqlconnector|数据库连接驱动|
|pagehelper|分页助手|
|lombok|简化setter,getter等代码|
|logback|日志处理||
|redis|缓存|
|fastjson|对象JSON序列化|
|dubbo|服务管理||
|zookeeper|注册中心|
|swagger|接口文档管理|


## 前端
 |名称|作用|
 |---|---|
 |html|网页骨架|
 |CSS|网页修饰|
 |js|网页动作处理|
 |bootstrap|前端框架|
 |bootstrapTable|显示表格数据
 |JQYERY|js框架|
 |thymeleaf|动态模板
 
## 数据存储
|名称|作用|
|---|---|
|mysql|持久化数据|
|redis|缓存数据|

# 项目模块

|模板名|作用|运行方式|通信协议|端口号|
|---|---|---|---|---|
|sbcrmex_api|接口定义||
|sbcrmex_commons|公共模块||
|sbcrmex_domain|实体定义||
|sbcrmex_authorization|认证模块||
|sbcrmex_customer|客户模块|微服务|dubbo://|20880|
|sbcrmex_report|报表模块|微服务|dubbo://|20881|
|sbcrmex_sale|销售模块|微服务|dubbo://|20882|
|sbcrmex_service|服务模块|微服务|dubbo://|20883|
|sbcrmex_system|系统模块|微服务|dubbo://|20884|
|sbcrmex_user|用户模块|微服务|dubbo://|20885|
|sbcrmex_web|操作界面|web服务|http|8080|


# 项目管理
|名称|作用|
|---|---|
|MAVEN|依赖管理|
|GIT|版本控制|
|JENKINS|CI/CD|

# 接口API
内置了swagger，打开http://localhost/swagger-ui.html就能访问

hewlh163.com