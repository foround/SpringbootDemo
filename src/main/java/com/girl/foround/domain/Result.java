package com.girl.foround.domain;

import lombok.Data;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/17 0017 20:50
 * <p>
 * 类说明：
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;
}
