package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo {
    private Long id;
    @Size(min = 1, max = 128, message = "name's size between 1~128")
    private String name;
    @Min(value = 17, message = "age must bigger than 16")
    private Long age;
    @Size(min = 8, max = 512, message = "avatar's size between 8~512")
    private String avatar;
    @Size(min = 0, max = 1024, message = "description's size between 0~1024")
    private String description;
}
