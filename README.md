###SpringBoot 项目整理###

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
        <version>0.0.4</version>
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


