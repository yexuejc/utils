package com.yexuejc.util.kotlin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@MapperScan("com.yexuejc.util.kotlin.mapper")
open class UtilKotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(UtilKotlinApplication::class.java, *args)
        }
    }

}
