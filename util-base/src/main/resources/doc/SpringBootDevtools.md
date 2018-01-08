### SpringBoot热部署
利用SpringBoot为我们提供了一个非常方便的工具spring-boot-devtools

**pom.xml**

```
    <dependency>  
       <groupId>org.springframework.boot</groupId>  
       <artifactId>spring-boot-devtools</artifactId>  
       <optional>true</optional><!-- optional=true,依赖不会传递，该项目依赖devtools；之后依赖myboot项目的项目如果想要使用devtools，需要重新引入 -->  
   </dependency>
```
   
**重新编译类文件**

<p>当我们修改了一个java类的时候，我们只需要重新编译一下，SpringBoot的就会重启了。
因为devtools会监听classpath下的文件变动，所以当java类重新编译的时候，devtools会监听到这个变化，
然后就会重新启动SpringBoot。
这个重启是非常快的一个过程。因为在SpringBoot中有两个类加载器，一个是加载工程外部资源的，如jar包，
还有一个类加载器是用来加载本工程的class的。所以在重启SpringBoot的时候只加载本工程的class文件。
</p>

**监听文件夹的变化**

让devtools监听文件夹的变化,不重新编译java类的。
比如我们想让main下的文件改变的时候，springboot重新启动

>配置 application.properties

```
// util-simple从项目开始 加“/”绝对路径
spring.devtools.restart.additional-paths=util-simple/src/main
```
</p>

**页面热部署**

使用thymeleaf模板时，devtools可以实现页面热部署，即页面修改后会立即生效。<br/>
>配置 application.properties
```
spring.thymeleaf.cache=false
```