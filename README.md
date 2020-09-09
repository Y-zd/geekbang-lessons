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
   * 优点：集成啊/简化啊/抽象啊...等等

##### 第二章：重新认识 IoC
 - 什么是 IoC ？
   * IoC (Inversion of Control) 控制反转，类似于好莱坞原则，主要有依赖查找和依赖注入实现
   * 获得依赖对象的过程被反转了
   * `2004年，Martin Fowler探讨了同一个问题，既然IOC是控制反转，那么到底是“哪些方面的控制被反转了呢？”，经过详细地分析和论证后，
   他得出了答案：“获得依赖对象的过程被反转了”。控制被反转之后，获得依赖对象的过程由自身管理变为了由IOC容器主动注入。于是，
   他给“控制反转”取了一个更合适的名字叫做“依赖注入（Dependency Injection）”。他的这个答案，实际上给出了实现IOC的方法：注入。
   所谓依赖注入，就是由IOC容器在运行期间，动态地将某种依赖关系注入到对象之中。所以，依赖注入(DI)和控制反转(IOC)是从不同的角度的描述的同一件事情，
   就是指通过引入IOC容器，利用依赖关系注入的方式，实现对象之间的解耦。`
     
 - 依赖查找和依赖注入的区别？
   * 依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准API实现，如：容器getBean
   * 而依赖注入则是手动或自动依赖绑定的方式，无需依赖特定的容器和API，如： AutoWire
 - Spring 作为 IoC 容器有什么优势？
   * 典型的 IoC 管理，依赖查找和依赖注入
   * AOP抽象
   * 事务抽象
   * 事件机制
   * SPI扩展
   * 强大的第三方整合
   * 易测试性
   * 更好的面向对象
   
##### 第三章：Spring IoC容器概述
 - 什么是 Spring IoC 容器？
   * 控制反转(IoC)原理的Spring框架实现。IoC也称为依赖注入(DI)。
   *它是一个过程，对象通过构造函数参数、factorymethod的参数或在构造或从工厂方法返回后在对象实例上设置的属性来定义它们的依赖项(也就是说，与它们一起工作的其他对象)。容器在创建bean时注入这些依赖项
   
 - BeanFactory 与 FactoryBean？
   * BeanFactory 是 IoC 底层容器
   * FactoryBean 是 创建 Bean 的一种方式，帮助实现复杂的初始化逻辑
  
 - Spring IoC 容器启动时做了哪些准备？
   * IoC 配置元信息读取和解析、IoC 容器生命周期、Spring 事件发布、国际化等，更多答案将在后续专题章节逐一讨论

##### 第四章：Spring Bean基础
 - 什么是 BeanDefinition？
   * BeanDefinition（bean定义） 是 Spring Framework 中定义 Bean 的配置元信息接口
   * BeanDefinition 元信息
   
       | 属性（Property ）         | 说明                                           | 
       | ------------------------ | --------------------------------------------- | 
       | Class                    | Bean 全类名，必须是具体类，不能用抽象类或接口       | 
       | Name                     | Bean 的名称或者 ID                              |  
       | Scope                    | Bean 的作用域（如：singleton(默认)、prototype 等）| 
       | Constructor arguments    | Bean 构造器参数（用于依赖注入）                   | 
       | Properties               | Bean 属性设置（用于依赖注入）                     | 
       | Autowiring mode          | Bean 自动绑定模式（如：通过名称 byName）           | 
       | Lazy initialization mode | Bean 延迟初始化模式（延迟和非延迟）                | 
       | Initialization method    | Bean 初始化回调方法名称                          | 
       | Destruction method       | Bean 销毁回调方法名称                            | 
 
 - BeanDefinition 构建 [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/BeanDefinitionCreationDemo.java)
   * 通过 BeanDefinitionBuilder
   * 通过 AbstractBeanDefinition 以及派生类
  