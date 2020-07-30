##### 第一章：Spring Framework总览（Overview）
 - 什么是Spring Framework？
   * Spring使创建Java企业应用程序变得容易。它提供了在企业环境中使用Java语言所需的一切。
   * 支持Groovy和Kotlin作为JVM上的替代语言，并根据应用程序的需要灵活地创建多种体系结构。
 - Spring Framework 有哪些核心模块？
   * spring-core：Spring 基础 API 模块，如资源管理，泛型处理
   * spring-beans：Spring Bean 相关，如依赖查找，依赖注入
   * spring-aop：Spring AOP 处理，如动态代理，AOP 字节码提升
   * spring-context：事件驱动、注解驱动，模块驱动等
   * spring-expression：Spring 表达式语言模块
 - Spring Framework 的优势和不足是什么?

##### 第二章：重新认识 IoC
 - 什么是 IoC ？
   * IoC 是反转控制，类似于好莱坞原则，主要有依赖查找和依赖注入实现
 - 依赖查找和依赖注入的区别？
   * 依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准 API 实现
   * 而依赖注入则是手动或自动依赖绑定的方式，无需依赖特定的容器和API
 - Spring 作为 IoC 容器有什么优势？
   * 典型的 IoC 管理，依赖查找和依赖注入
   * AOP 抽象
   * 事务抽象
   * 事件机制
   * SPI 扩展
   * 强大的第三方整合
   * 易测试性
   * 更好的面向对象