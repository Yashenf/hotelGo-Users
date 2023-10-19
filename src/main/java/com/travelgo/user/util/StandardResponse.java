package com.travelgo.user.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardResponse {
    private int status;
    private String message;
    private Object data;
}
