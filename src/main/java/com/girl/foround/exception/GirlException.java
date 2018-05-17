package com.girl.foround.exception;

import com.girl.foround.domain.Girl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/17 0017 21:28
 * <p>
 * 类说明：
 */
public class GirlException extends RuntimeException{
    @Getter
    @Setter
    private Integer code;
    public GirlException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
}
