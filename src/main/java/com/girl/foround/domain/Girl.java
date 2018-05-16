package com.girl.foround.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/2 0002 21:11
 * <p>
 * 类说明：
 */
@Data
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;
    @Min(value = 18,message = "未成年人禁止过门")
    private Integer age;

    public Girl(){

    }
}
