package com.yexuejc.util.kotlin.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @PackageName: com.yexuejc.util.kotlin
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 18:37
 */
@RestController
class IndexCtrl {

    @Value(value = "\${application.version}")
    internal var version: String? = null

    @RequestMapping("/")
    fun index(): Any {
        return "Wellcome to yexuejc util-kotlin.version:" + version;
    }

}
