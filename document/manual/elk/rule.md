## 一、logback的介绍

Logback是由log4j创始人设计的另一个开源日志组件,它当前分为下面三个模块：
1. logback-core：其它两个模块的基础模块
2. logback-classic：它是log4j的一个改良版本，同时它完整实现了slf4j API使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging
3. logback-access：访问模块与Servlet容器集成提供通过Http来访问日志的功能


## 二、logback取代log4j的理由
1. 更快的实现：Logback的内核重写了，在一些关键执行路径上性能提升10倍以上。而且logback不仅性能提升了，初始化内存加载也更小了。
2. logback日志SpringBoot自带的，所以依赖什么的就不用引了！
3. 控制日志的最大容量和自动清理

## 三、logback.xml（logback-spring.xml）常用配置详解
logback和logback-spring.xml都可以用来配置logback，但是2者的加载顺序是不一样的。
logback.xml--->application.properties--->logback-spring.xml.

1. 根节点 `<configuration>` 。
2. 组件 `<appender>` 组件，可以理解为日志需要输出到哪个目标。
3. `<logger>` 设置一个项目路径，直接输出对应level的日志。
4. `<root>` 全局的日志输出，配合<appender>使用。

