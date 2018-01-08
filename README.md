### SpringBoot 项目整理

[目录](meun.md)

>基础引用
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://www.jitpack.io</url>
    </repository>
</repositories>
```

**module**

1.**util-parent** 父module 
```
    <parent>
        <groupId>com.github.yexuebm.utils</groupId>
        <artifactId>util-parent</artifactId>
        <version>0.0.6</version>
    </parent>

```


2.**util-base** 基础module

```
...
<dependencies>
...
        <dependency>
            <groupId>com.github.yexuebm.utils</groupId>
            <artifactId>util-base</artifactId>
            <version>${parent.version}</version>
        </dependency>
...    	
	</dependencies>
```

3.**util-simple** demo,springboot web项目

可分环境,放开pom.xml中如下注释，不放开注释*com.yexuejc.util.simple.UtilSimpleApplication*
无法直接运行。测试可运行*com.yexuejc.util.simple.ApplicationRun*
```
<!--多环境配置-->
<!--<filters>-->
    <!--<filter>src/main/filters/filter-${env}.properties</filter>-->
<!--</filters>-->

```
> 原因说明：test运行环境基于.../util-simple/src/test/resources/application.properties
正式运行基于环境util-simple/src/main/resources/pplication.properties
两者不相冲突


[关于多环境env配置](util-simple/evn.md)



4.**util-exp** 记录 Exception 相关 module

```
...
<dependencies>
...
        <dependency>
            <groupId>com.github.yexuebm.utils</groupId>
            <artifactId>util-exp</artifactId>
            <version>${parent.version}</version>
        </dependency>
...    	
	</dependencies>
```

5.**util-redis** redis 相关 module

```
...
<dependencies>
...
        <dependency>
            <groupId>com.github.yexuebm.utils</groupId>
            <artifactId>util-redis</artifactId>
            <version>0.0.6</version>
        </dependency>
...    	
	</dependencies>
```

