package com.sport.common.pojo.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetUserInfoRequest implements Serializable {
    private String encryptedData;

    private String iv;

}
