package com.anbangke.wy.response.baseError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangerxiao
 * @date  2020/5/23 16:58
 * @email 784665813@qq.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Error implements Serializable {

    protected String code;

    protected String message;

}
