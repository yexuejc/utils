package com.yexuejc.util.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class UtilKotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(UtilKotlinApplication::class.java, *args)
        }
    }
}
