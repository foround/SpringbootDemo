package com.girl.foround.properties;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/2 0002 19:20
 * <p>
 * 类说明：
 */
@Data
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private Integer age;
    private String cupSize;
}
