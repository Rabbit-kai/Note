![clipboard1](E:\Note\Java\spring\spring.pic\clipboard1.png)))

# 1、注入bean：

## 第一种：

​	xml文件的方式，则需要在xml中配置bean，并在调用的时候通过获取xml文件返回的上下文对象进行getBean操作。

## 第二种：

通过配置类的形式：	

​	1.必须给配置类加上@Configuration注解（配置类，代替xml）

​	2.形式：

​		①三层组件加入IOC容器： 给个各类加	注解 、 扫描器识别注解所在包

​			a.给三层组件下 分别加注解（@Controller、@Service、@Repository -> @Component）

​			b.将注解所在包 纳入ioc扫描器（ComponentScan），只对三层负责，其他模式该注解无效

​				纳入ioc扫描器:  ①xml配置文件 :    <context:component-scan base-package="com.yanqun.controller"  ></context:component-scan>逻辑： 在三层类上加注解  ，让ioc识别，扫描器

​					        			   ②注解扫描器 component-scan：只对三层组件负责

若使用第二种带注解的类配置，则需要在配置类中增加@bean注解来实现xml中的配置操作，如下：

![img](E:\Note\Java\spring\spring.pic\clipboard.png)

该带有@Bean标签的方法，会将返回值通过标签放入IOC容器中，供调用。

1.定义一个类。

2.在带有@configuration的类中，定义一个方法，在该方法中对类进行初始化赋值，并返回这个类对象。并使用@Bean对方法进行修饰，将该初始化类的方法放入容器，供容器调用。



取bean：

![img](E:\Note\Java\spring\spring.pic\clipboard-16298153804043.png)

1、通过

@Component注解在一个类上面使用，作用相当于标签(万能的)

@Controller用在表现层

@Service用在业务层

@Reposity(‘名称’)用在持久层  

此类标签将类或者接口放入到IOC容器中。(如果注解中含有名称，那在注入的时候可以通过@Qualifie('名称')   byname的方式进行注入)

2、通@Service('name')给bean增加id

3、使用@Autowire(通过Bytype的方式来进行注入)、@Qualifie('名称')(通过Byname的方式进行注入)，从IOC中获取前面放入的类。//通过类型装配只需要@Autowire；通过名称装配需要@Autowire、@Qualifie('名称')

**回顾给IoC加入Bean的方法**
	注解 ：全部在@Congiration配置类中设置：	
		三层组件： 扫描器 + @Controller、@Service、@Repository、@Component来注入
		非三层组件：  ① @Bean+返回值(Bean的ID是方法名)
			     ②@import
			    ③FactoryBean(工厂Bean)

@import使用：
	①直接编写到@Import中，并且id值 是全类名
	②自定义ImportSelector接口的实现类，通过selectimports方法实现（方法的返回值 就是要纳入IoC容器的Bean） 。 并且 告知程序 自己编写的实现类。 @Import({Orange.class,MyImportSelector.class})
	③编写ImportBeanDefinitionRegistrar接口的实现类，重写方法
@Import({Orange.class,MyImportSelector.class，ImportBeanDefinitionRegistrar.class})

--FactoryBean(工厂Bean)
	①准备bean。实现类接口和重写方法 。

​    ②注册bean。注册到@Bean中
​	注意：需要通过&区分 获取的对象是哪一个 ： 不加&,获取的是最内部真实的Apple；
​		如果加了&，获取的 是FacotryBean



**自动装配**

一、@Autowired   不是通过set方法进行注入的

这个可以加在属性前也可以加在set方法前，如果加在set方法前会调用set。

1、默认通过类型进行注入，此方式适用于容器中Bean类型不重复的情况，否则会报错。当然可以通过在在Bean上面增加@Primary标签在有多个相同类型Bean时来指定默认的Bean，这样再通过类型调用时就不会报错了。

2、也可以通过在@Autowired后增加@Qualifier("Bean名称")指定ID名字来进行装配。



二、JSR规范中的@Resource

默认根据名字匹配，如果根据名字没有找到，再根据类型进行匹配。也可通过name或者type属性来指定方式。







# 2、Bean的作用域

​	

在类

![](E:\Note\Java\spring\springbatch.pic\image-20210805221010017.png)

![](E:\Note\Java\spring\springbatch.pic\image-20210805221041549.png)





#  3、Bean的生命周期

​		初始化时，IOC容器会自动创建对象 -> 执行init将Bean放入容器(先创建对象在生成Bean) -> 业务。。。。 -> 销毁。

## 方法一：

​		在@Bean(value='Bean的名称，默认为方法名',initMethod='初始化方法',destoryMethod='结束时销毁方法')中定义初始化和销毁对应的方法。(可以进入Bean的注解中查看Bean的参数)

## 方法二：

 **只适用于三层注解时使用** （功能性注解、MyIntToStringConverter.java）：@Controller、@Service、@Repository、@Component；使用其他注解如Bean时，不能使用该方法。 

-->三层注解（功能性注解【三层、功能性类】）
	三层组件： 扫描器 + 三层注解（4个）

	JAVA规范 ：JSR250
	
	1.将响应组件 加入 @Component注解、 给初始化方法加@PostConstruct、给销毁方法加@PreDestroy
	@PostConstruct：相当于方法一的initm,在init方法上面加上该注解
	@PreDestroy：相当于方法一的destroy,在destroy方法上面加上该注解
	不需要再@Bean中再指定init和destory方法。
	如果要获取@Component注解中的bean，那么该Bean的名字就是@Component（value="xxx"）的value值

->如果是注解形式 ， 随便写一个方法 ，然后加上相应注解即可

## 方法三：两个接口

​	接口：适用于三层组件（扫描器+三层组件）
​	实现InitializingBean为初始化方法
​	实现DisposableBean 为销毁方法

	初始化：只需要 实现InitializingBean中的afterPropertiesSet()方法
	销毁：实现DisposableBean 中的destroy()方法

问题：要在SPring IOC容器中操作：操作方式 对象：Bean+返回  ，三层组件
->如果是接口形式，必须 实现接口中规定的方法

## 方法四：（给容器中的所有Bean加初始化、销毁）一个接口

​	接口：适用于三层组件  
​	接口BeanPostProcessor：拦截了所有中容器的Bean (容器中的所有Bean创建时都会调用该接口的实现类中的方法)；

​	该方式中可以对容器中生成的Bean进行处理后，return修改后的Bean。如：Bean生成时初始化了A=1；可以在该类中进行A=2，再Return Bean；此时A=2.





# 4、利用Spring底层进行开发

如：application，自己开发的组件自动调用application。

1、能够用来使用的都是Aware的子接口或者子类：xxxxxAware。



-- 可以用来区分环境

@profile("环境名")使用时，需要在参数中进行激活，激活哪个，哪个就生效：

![image-20210814164824758](E:\Note\Java\spring\springbatch.pic\image-20210814164824758.png)



2、接口：BeanPostProcess

​	拦截容器中的所有Bean，可以进行bean的初始化和销毁。该拦截器是在实例化之后对bean进行操作。



![image-20210814170540319](E:\Note\Java\spring\springbatch.pic\image-20210814170540319.png)











