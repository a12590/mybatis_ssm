# mybatis_ssm
## 关于Spring部分的各层，这个已经在spring部分说明了

## Xml部分已经注解得很好了
      1，原始dao使用映射文件，没使用逆向工程
      <!-- 根据用户id查询一条记录（返回单条记录） -->
        <!-- 
        select标签表示sql查询，内容会封装到Mapped Statement中。
        可以将这个select标签称为一个Statement
        id：Statement的id，用于标识select中定义的 sql，id是在同一个命名空间中不允许重复
        #{}：表示一个占位符，避免sql注入
        parameterType：表示输入参数的类型
        resultType：表示输出 结果集单条记录映射的java对象类型，select查询的字段名和resultType中属性名一致，才能映射成功。
        #{value}：value表示parameter输入参数的变量，如果输入参数是简单类型，使用#{}占位符，变量名可以使用value或其它的名称 

         -->
        <select id="findUserById" parameterType="int" resultType="user" >

          SELECT * FROM USER WHERE id = #{id}

        </select>


        <!-- 添加用户
        parameterType：如果parameterType指定 是pojo，在#{}中指定 pojo的属性名获取该pojo的属性值 
         -->
        <insert id="insertUser" parameterType="cn.itcast.ssm.po.User" >
以前没注意，原来这里就有！！！
<!-- 
keyProperty：将主键设置到pojo中哪个属性中
order：selectKey中sql执行的时机
resultType:selectKey中sql执行的结果类型
LAST_INSERT_ID:是insert后获取自增主键值 
 -->
<selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
     select LAST_INSERT_ID()
</selectKey>
        insert into user(username,birthday,sex,address,detail,score)
         values(#{username},#{birthday},#{sex},#{address},#{detail},#{score})
        </insert>


        <!-- 根据主键用户更新
        更新传入输入参数见容：id和更新的信息
         -->
        <update id="updateUser" parameterType="cn.itcast.ssm.po.User" >
           update user set username=#{username},birthday=#{birthday},sex=#{sex}  where id=#{id}
        </update>
## sqlSession也还没有整合到配置文件中 这里old部分

## dao xml
<!-- 配置SqlSessionFactory -->

              ## 批量mapper扫描
                <!-- 使用mapper批量扫描器扫描mapper接口
                规则：mapper.xml和mapper.java在一个目录 且同名即可 
                扫描出来mapper，自动让spring容器注册，bean的id就是mapper类名(首字母小写)
                 -->
            <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
              <!-- 会话工厂 -->
              <property name="sqlSessionFactoryBeanName" value="sqlSessionFactoryBean"/>
              <!-- 扫描包路径 
              多个包中间用半角逗号分隔
               -->
              <property name="basePackage" value="cn.itcast.ssm.dao.mapper"/>
            </bean>

            如此，这里可以去除
            <!-- 配置userDao -->时 注入会话工厂
            <!-- mapper动态代理 -->

## service xml
            这个以后可以直接包扫描了吧？
      <!--  用户管理 -->
      <bean id="userService" class="cn.itcast.ssm.service.impl.UserServiceImpl"/>
      </beans>

## applicationContext.xml 容器，上下文 
<!-- 加载配置文件 -->
properties
<!-- 使用第三方的数据库连接池dbcp -->
<!-- 事务管理 -->
<!-- 通知 -->
<!-- aop配置 -->
## 定义AOP术语
      通知（Advice）：
      在AOP中，切面的工作被称为通知。通知定义了切面“是什么”以及“何时”使用。除了描述切面要完成的工作，通知还解决了何时执行这个工作的问题。
      Spring切面可以应用5种类型的通知：
      前置通知（Before）：在目标方法被调用之前调用通知功能
      后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么
      返回通知（After-returning）：在目标方法成功执行之后调用通知
      异常通知（After-throwing）：在目标方法抛出异常后调用通知
      环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为
      连接点（Join point）：
      连接点是在应用执行过程中能够插入切面的一个点。这个点可以是调用方法时、抛出异常时、甚至修改一个字段时。切面代码可以利用这些点插入到应用的正常流程之中，并添加行为。
      切点（Pointcut）:
      如果说通知定义了切面“是什么”和“何时”的话，那么切点就定义了“何处”。比如我想把日志引入到某个具体的方法中，这个方法就是所谓的切点。
      切面（Aspect）：
      切面是通知和切点的结合。通知和切点共同定义了切面的全部内容———他是什么，在何时和何处完成其功能。
      引入（Introduction）：
      引入允许我们向现有的类添加新的方法和属性(Spring提供了一个方法注入的功能）。
      织入(Weaving)：
      把切面应用到目标对象来创建新的代理对象的过程，织入一般发生在如下几个时机:
      编译时：当一个类文件被编译时进行织入，这需要特殊的编译器才可以做的到，例如AspectJ的织入编译器
      类加载时：使用特殊的ClassLoader在目标类被加载到程序之前增强类的字节代码
      运行时：切面在运行的某个时刻被织入,SpringAOP就是以这种方式织入切面的，原理应该是使用了JDK的动态代理技术
      
      Spring对AOP的支持
        基于注解的方式
        基于XML配置的方式
## Spring.xml

<!-- 组件扫描 只扫描action -->
<!-- 使用<mvc:annotation-driven />替换上边定义的处理器映射器和适配器 -->
	<mvc:annotation-driven />

	<!-- 视图解析器 解析jsp视图，默认使用jstl，要求classpath下有jstl的jar包 -->
