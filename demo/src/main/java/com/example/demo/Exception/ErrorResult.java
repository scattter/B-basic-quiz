package com.example.demo.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
