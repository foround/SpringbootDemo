package com.girl.foround.handle;

import com.girl.foround.domain.Girl;
import com.girl.foround.domain.Result;
import com.girl.foround.exception.GirlException;
import com.girl.foround.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/17 0017 21:21
 * <p>
 * 类说明：
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.fail(girlException.getCode(), girlException.getMessage());
        }else if(e instanceof NullPointerException){
            NullPointerException nullPointerException = (NullPointerException) e;
            return ResultUtil.fail(-10, "No Message Avaliable");
        }{
            return ResultUtil.fail(-1, "Unknown Error");
        }
    }
}
