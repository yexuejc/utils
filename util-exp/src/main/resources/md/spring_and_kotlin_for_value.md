### Kotlin 与 Spring boot整合，@Value的问题

**Java与Spring boot集成<font color=#DC143C>@Value</font>的用法**
*************************************
```
...
@Value(value = "${application.version}")
private String version;
...
```
**kotlin这样使用时会报错，因为"${xxx}"在kotlin里面会被编译器解析**
******************************************
我们来看下kotlin的语法

```
companion object {
    var a: Int = 1
    var b: Int = 2
    var c: String = "this is String"
    @JvmStatic
    fun main(args: Array<String>) {
        print("$a + $b = " + (a + b))//输出 1 + 2 = 3
        print("c的长度: ${c.length}")//输出 c的长度: 14
    }
}
```
##### 解决方案

1、  加上转义标识
```
@Value(value = "\${application.version}")
private String version;
```
2、修改@Value中的标识符$修改为其他
```
@Bean
fun kotlinPropertyConfigurer() = PropertySourcesPlaceholderConfigurer().apply {
    setPlaceholderPrefix("%{")
    setIgnoreUnresolvablePlaceholders(true)
}

@Bean
fun defaultPropertyConfigurer() = PropertySourcesPlaceholderConfigurer()
```
3、使用@ConfigurationProperties
```
@Component
@ConfigurationProperties("foo")
class Properties() {
   lateinit var a: String
   lateinit var b: String
}

@SpringBootApplication
@EnableConfigurationProperties(Properties::class)
class Application

fun main(args: Array<String>) {
   SpringApplication.run(Application::class.java, *args)
}
```

>感谢大佬[@骑驴上塔楼](https://segmentfault.com/u/qilvshangtalou),参考链接[https://segmentfault.com/u/qilvshangtalou](https://segmentfault.com/u/qilvshangtalou)
