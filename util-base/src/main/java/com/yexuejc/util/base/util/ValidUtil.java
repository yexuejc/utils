package com.yexuejc.util.base.util;

import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.http.Resps;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 检查SpringMVC提交是否有数据校验错误
 *
 * @PackageName: com.yexuejc.util.base.util
 * @Description:
 * @author: maxf
 * @date: 2018/1/17 14:01
 */
public class ValidUtil {
    private ValidUtil() {
    }

    /**
     * APP用； 检查SpringMVC提交是否有数据校验错误，如果有错则直接response错误信息
     *
     * @param errors
     * @return
     * @throws IOException
     */
    public static Resps<Object> errResps(HttpServletResponse response, Errors errors) throws IOException {
        List<ObjectError> objectErrorList = errors.getAllErrors();
        String[] err = new String[objectErrorList.size()];
        for (int i = 0; i < objectErrorList.size(); i++) {
            err[i] = objectErrorList.get(i).getCode();
        }
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return Resps.error(RespsConstant.CODE_VALIDATION, err);
    }

}