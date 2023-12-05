package com.sport.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetUserInfoRequest implements Serializable {
    private String encryptedData;

    private String iv;

}
