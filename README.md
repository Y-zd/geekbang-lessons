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

##### 第四章：Spring Bean基础 [demo](/thinking-in-spring/spring-bean)
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
 
 - Bean 的名称
   * 每个 Bean 拥有一个或多个标识符（identifiers），这些标识符在 Bean 所在的容器必须是唯一的。
   * 一个 Bean 仅有一个标识符，如果需要额外的，可考虑使用别名（Alias）来扩充。
   * 在基于 XML 的配置元信息中，开发人员可用 id 或者 name 属性来规定 Bean 的 标识符。
   * 通常 Bean 的 标识符由字母组成，允许出现特殊字符。如果要想引入 Bean 的别名的话，可在name 属性使用半角逗号（“,”）或分号（“;”) 来间隔。
   * Bean 的 id 或 name 属性并非必须制定，如果留空的话，容器会为 Bean 自动生成一个唯一的名称。
   * Bean 的命名尽管没有限制，不过官方建议采用驼峰的方式，更符合 Java 的命名约定。 
   * Bean 名称生成器(BeanNameGenerator)
     1. DefaultBeanNameGenerator：默认通用 BeanNameGenerator 实现
     2. AnnotationBeanNameGenerator：基于注解扫描的 BeanNameGenerator 实现
  
 - Bean 别名（Alias）的价值 [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/BeanAliasDemo.java)
   * 复用现有的 BeanDefinition
   * 更具有场景化的命名方法，比如：<br>
       `<alias name="myApp-dataSource" alias="subsystemA-dataSource"/>`<br>
       `<alias name="myApp-dataSource" alias="subsystemB-dataSource"/>`  
 
  - BeanDefinition 注册 [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/AnnotationBeanDefinitionDemo.java)
    1. XML 配置元信息
       * <bean name=”...” ... />
    2. Java 注解配置元信息
       * @Bean
       * @Component 等
       * @Import
    3. Java API 配置元信息
       * 命名方式：BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
       * 非命名方式：BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition,BeanDefinitionRegistry)
       * 配置类方式：AnnotatedBeanDefinitionReader#register(Class...) 
  
  - Bean 实例化（Instantiation）
    1. 常规方式 [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/BeanInstantiationDemo.java)
       * 通过构造器（配置元信息：XML、Java 注解和 Java API ）
       * 通过静态工厂方法（配置元信息：XML 和 Java API ）
       * 通过 Bean 工厂方法（配置元信息：XML和 Java API ）
       * 通过 FactoryBean（配置元信息：XML、Java 注解和 Java API ）
    2 特殊方式 [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/SpecialBeanInstantiationDemo.java) 
       * 通过 ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和 Java API ）
       * 通过 AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)
       * 通过 BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)          
       
  - Bean 初始化（Initialization） [demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/BeanInitializationDemo.java)  
    1. @PostConstruct 标注方法
    2. 实现 InitializingBean 接口的 afterPropertiesSet() 方法
    3. 自定义初始化方法
       * XML 配置：<bean init-method=”init” ... />
       * Java 注解：@Bean(initMethod=”init”)
       * Java API：AbstractBeanDefinition#setInitMethodName(String)
    4. 思考：假设以上三种方式均在同一 Bean 中定义，那么这些方法的执行顺序是怎样？    
       * postconstruct 构造后置 afterpropertiesset 属性填充后  initmethod bean初始化(可以认为是功能初始化)
       * spring bean初始化顺序：PostContruct->afterPropertiesSet->自定义init方法
   
  - Bean 延迟初始化 （Lazy Initialization）Spring默认非延迟
    1. XML 配置：<bean lazy-init=”true” ... />
    2. Java 注解：@Lazy(true)       
       
  - Bean 销毁（Destroy）
    1. @PreDestroy 标注方法
    2. 实现 DisposableBean 接口的 destroy() 方法
    3. 自定义销毁方法
       * XML 配置：<bean destroy=”destroy” ... />
       * Java 注解：@Bean(destroy=”destroy”)
       * Java API：AbstractBeanDefinition#setDestroyMethodName(String)
    4. 思考：假设以上三种方式均在同一 Bean 中定义，那么这些方法的执行顺序是怎样？
       * @PreDestroy>实现 DisposableBean 接口>自定义销毁方法
       
  - Bean 垃圾回收（GC）[demo](/thinking-in-spring/spring-bean/src/main/java/org/geekbang/thinking/in/spring/bean/definition/BeanGarbageCollectionDemo.java)  
    1. 关闭 Spring 容器（应用上下文）
    2. 执行 GC
    3. Spring Bean 覆盖的 finalize() 方法被回调
       
  - 如何注册一个 Spring Bean？
     * 回顾“定义 Spring Bean” 和 “BeanDefinition 元信息”
  
  - 什么是 Spring BeanDefinition？
     
  - Spring 容器是怎样管理注册 Bean?
     * 答案将在后续专题章节详细讨论，如：IoC 配置元信息读取和解析、依赖查找和注入以及 Bean 生命周期等。
 
 
 ##### 第五章：Spring IoC 依赖查找 [demo](/thinking-in-spring/dependency-lookup)     
 
  - 单一类型依赖查找接口 - BeanFactory
    1. 根据 Bean 名称查找
       * getBean(String)
       * Spring 2.5 覆盖默认参数：getBean(String,Object...)
    2. 根据 Bean 类型查找
       * Bean 实时查找
         * Spring 3.0 getBean(Class)
         * Spring 4.1 覆盖默认参数：getBean(Class,Object...)
       * Spring 5.1 Bean 延迟查找 
         * getBeanProvider(Class)
       * getBeanProvider(ResolvableType)
    3. 根据 Bean 名称 + 类型查找：getBean(String,Class)
       
  - 集合类型依赖查找接口 - ListableBeanFactory
   1. 根据 Bean 类型查找
      * 获取同类型 Bean 名称列表
        * getBeanNamesForType(Class)
        * Spring 4.2 getBeanNamesForType(ResolvableType)
      * 获取同类型 Bean 实例列表
        * getBeansOfType(Class) 以及重载方法
   2. 通过注解类型查找
      * Spring 3.0 获取标注类型 Bean 名称列表
        * getBeanNamesForAnnotation(Class<? extends Annotation>)
      * Spring 3.0 获取标注类型 Bean 实例列表
        * getBeansWithAnnotation(Class<? extends Annotation>)
      * Spring 3.0 获取指定名称 + 标注类型 Bean 实例
        * findAnnotationOnBean(String,Class<? extends Annotation>) 
      
  - 层次性依赖查找接口 - HierarchicalBeanFactory  [demo](/thinking-in-spring/dependency-lookup/src/main/java/org/geekbang/thinking/in/spring/dependency/lookup/HierarchicalDependencyLookupDemo.java)  
     1. 双亲 BeanFactory：getParentBeanFactory() 双亲查找是先在子容器查找没有再查找父容器
     2. 层次性查找
       * 根据 Bean 名称查找
         * 基于 containsLocalBean 方法实现
       * 根据 Bean 类型查找实例列表
         * 单一类型：BeanFactoryUtils#beanOfType
         * 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
       * 根据 Java 注解查找名称列表
         * BeanFactoryUtils#beanNamesForTypeIncludingAncestors     
   
  - Bean 延迟依赖查找接口
    1. org.springframework.beans.factory.ObjectFactory
    2. org.springframework.beans.factory.ObjectProvider
       * Spring 5 对 Java 8 特性扩展
         * 函数式接口
           * getIfAvailable(Supplier)
           * ifAvailable(Consumer)
         * Stream 扩展 - stream()      
         
   - 依赖查找安全性对比(异常安全,是否抛异常) [demo](/thinking-in-spring/dependency-lookup/src/main/java/org/geekbang/thinking/in/spring/dependency/lookup/TypeSafetyDependencyLookupDemo.java)
   
      |依赖查找类型  | 代表实现                            | 是否安全 | 
      | -----------| ---------------------------------- | --------| 
      | 单一类型查找 | BeanFactory#getBean                |  否     |
      |            | ObjectFactory#getObject            |  否     |
      |            | ObjectProvider#getIfAvailable      |  是     |
      |            |                                    |         |
      | 集合类型查找 | ListableBeanFactory#getBeansOfType |  是     |
      |            | ObjectProvider#stream              |  是     |          
      * 注意：层次性依赖查找的安全性取决于其扩展的单一或集合类型的 BeanFactory 接口
      
   - AbstractApplicationContext 内建可查找的依赖 
   
      | Bean 名称                    | Bean 实例                       | 使用场景                | 
      | ----------------------------| ------------------------------- | ----------------------| 
      | environment                 | Environment 对象                 | 外部化配置以及 Profiles |
      | systemProperties            | java.util.Properties 对象        |  Java 系统属性         |
      | systemEnvironment           | java.util.Map 对象               | 操作系统环境变量        |
      | messageSource               | MessageSource 对象               | 国际化文案              |
      | lifecycleProcessor          | LifecycleProcessor 对象          | Lifecycle Bean 处理器  |
      | applicationEventMulticaster | ApplicationEventMulticaster 对象 | Spring 事件广播器       |          
      
  - ObjectFactory 与 BeanFactory 的区别？
    * ObjectFactory 与 BeanFactory 均提供依赖查找的能力。
    * 不过 ObjectFactory 仅关注一个或一种类型的 Bean 依赖查找，并且自身不具备依赖查找的能力，能力则由 BeanFactory 输出。
    * BeanFactory 则提供了单一类型、集合类型以及层次性等多种依赖查找方式。
  
  - BeanFactory.getBean 操作是否线程安全？
    * BeanFactory.getBean 方法的执行是线程安全的，超过过程中会增加互斥锁 
  
  - Spring 依赖查找与注入在来源上的区别?  
    * 答案将《Spring IoC依赖注入》以及《Spring IoC依赖来源》章节中继续讨论。
     
 ##### 第六章：Spring IoC 注入 [demo](/thinking-in-spring/dependency-injection)
  - 有多少种依赖注入的方式？
    * 构造器注入 Setter 注入 字段注入 方法注入 接口回调注入
   
  - 你偏好构造器注入还是 Setter 注入？
    * 两种依赖注入的方式均可使用，如果是必须依赖的话，那么推荐使用构造器注入，Setter 注入用于可选依赖  
   
  - Spring 依赖注入的来源有哪些？
    * 答案将《Spring IoC依赖来源》章节中继续讨论。 
    `终于理解之前第24讲里提到的Spring IOC的三种依赖来源，自定义注册的Spring bean、内建的Spring bean以及内建的可注入的依赖，其中自定义注册的Spring bean基本上是通过xml、注解或者api注册BeanDefination创建的，内建的Spring bean是通过registerSingleton()创建的，内建的可注入的依赖是通过registerResolveDependency()创建的，后续如果我们需要往Spring容器里放入一些非Spring托管的bean但又可以被依赖注入的, 可以通过registerResolveDependency() API实现`

 ##### 第七章：Spring IoC 依赖来源 [demo](/thinking-in-spring/dependency-source)
  - 注入和查找的依赖来源是否相同？
    * 否，依赖查找的来源仅限于 Spring BeanDefinition 以及单例对象，而依赖注入的来源还包括 Resolvable Dependency 以及@Value 所标注的外部化配置
  
  - 单例对象能在 IoC 容器启动后注册吗？
    * 可以的，单例对象的注册与 BeanDefinition 不同，BeanDefinition 会被 ConfigurableListableBeanFactory#freezeConfiguration() 方法影响，从而冻结注册，单例对象则没有这个限制。  
    
  - Spring 依赖注入的来源有哪些？
    * Spring BeanDefinition , 单例对象 ,Resolvable Dependency(内置的对象) ,@Value 外部化配置  
    
 ##### 第八章：Spring Bean 作用域 [demo](/thinking-in-spring/bean-scope)    
  - 作用域
   
   |来源          | 说明                                                  | 
   | ------------| ------------------------------------------------------|
   | singleton   | 默认 Spring Bean 作用域，一个 BeanFactory 有且仅有一个实例 |  
   | prototype   | 原型作用域，每次依赖查找和依赖注入生成新 Bean 对象           | 
   | request     | 将 Spring Bean 存储在 ServletRequest 上下文中            | 
   | session     | 将 Spring Bean 存储在 HttpSession 中                    |
   | application | 将 Spring Bean 存储在 ServletContext 中                 | 
   
   * `Spring 容器没有办法管理 prototype Bean 的完整生命周期，也没有办法记录示例的存
     在。销毁回调方法将不会执行，可以利用 BeanPostProcessor 进行清扫工作。`
     
  - Spring 內建的 Bean 作用域有几种？  
    * singleton、prototype、request、session、application 以及websocket
  
  - singleton Bean 是否在一个应用是唯一的？  
    * 否，singleton bean 仅在当前 Spring IoC 容器（BeanFactory）中是单例对象。
    
  - “application”Bean 是否被其他方案替代?
    * 可以的，实际上，“application” Bean 与“singleton” Bean 没有本质区别
 
 
 ##### 第九章：Spring Bean 生命周期 [demo](/thinking-in-spring/bean-lifecycle)    
  - BeanPostProcessor 的使用场景有哪些？
    * BeanPostProcessor 提供 Spring Bean 初始化前和初始化后的生
      命周期回调，分别对应 postProcessBeforeInitialization 以及
      postProcessAfterInitialization 方法，允许对关心的 Bean 进行扩展
      ，甚至是替换。
    * 加分项：其中，ApplicationContext 相关的 Aware 回调也是基于
      BeanPostProcessor 实现，即 ApplicationContextAwareProcessor
  
  - BeanFactoryPostProcessor 与BeanPostProcessor 的区别?
    * BeanFactoryPostProcessor 是 Spring BeanFactory（实际为
      ConfigurableListableBeanFactory） 的后置处理器，用于扩展
      BeanFactory，或通过 BeanFactory 进行依赖查找和依赖注入。
    * 加分项：BeanFactoryPostProcessor 必须有 Spring ApplicationContext
      执行，BeanFactory 无法与其直接交互。
    * 而 BeanPostProcessor 则直接与BeanFactory 关联，属于 N 对 1 的关系。
    
  - BeanFactory 是怎样处理 Bean 生命周期？
    * BeanFactory 的默认实现为 DefaultListableBeanFactory，其中 Bean生命周期与方法映射如下： <br>
      1.BeanDefinition 注册阶段 - registerBeanDefinition <br>
      2.BeanDefinition 合并阶段 - getMergedBeanDefinition <br>
      3.Bean 实例化前阶段 - resolveBeforeInstantiation <br>
      4.Bean 实例化阶段 - createBeanInstance <br>
      5.Bean 实例化后阶段 - populateBean <br>
      6.Bean 属性赋值前阶段 - populateBean <br>
      7.Bean 属性赋值阶段 - populateBean <br>
      8.Bean Aware 接口回调阶段 - initializeBean <br>
      9.Bean 初始化前阶段 - initializeBean <br>
     10.Bean 初始化阶段 - initializeBean <br>
     11.Bean 初始化后阶段 - initializeBean <br>
     12.Bean 初始化完成阶段 - preInstantiateSingletons <br>
     13.Bean 销毁前阶段 - destroyBean <br>
     14.Bean 销毁阶段 - destroyBean <br>