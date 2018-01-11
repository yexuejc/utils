package com.yexuejc.util.kotlin.mapper

import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

/**
 * 文件持久化层
 * @PackageName: com.yexuejc.util.kotlin
 * @Description:
 * @author: maxf
 * @date: 2018/1/11 16:44
 */
@Mapper
interface IFileMapper {
    /**
     * 保存
     */
    @Insert("INSERT INTO tb_update (update_id, update_type, update_version, update_min_version, update_code, update_note, update_ismust, update_url,update_crt_time,update_filesize)"
            + " VALUES (#{id}, #{type}, #{version}, #{minVersion}, #{code}, #{note}, #{ismust}, #{fileUrl},now(),#{fileSize})")
    fun save(model: UploadFileModel): Int
}