package com.yexuejc.util.kotlin.utils

import org.springframework.web.multipart.MultipartFile
import java.io.File

/**
 *
 * @PackageName: com.yexuejc.util.kotlin.utils
 * @Description:
 * @author: maxf
 * @date: 2018/1/15 23:29
 */
fun MultipartFile.isNotEmpty(): Boolean = this != null && !this.isEmpty
