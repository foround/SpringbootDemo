package com.girl.foround.utils;

import com.girl.foround.domain.Result;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/17 0017 20:49
 * <p>
 * 类说明：
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("Success");
        result.setData(object);
        return result;
    };

    public static Result success(){
        return success(null);
    }

    public static Result fail(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
