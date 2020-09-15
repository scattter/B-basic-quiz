package com.example.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {
    private Long userId;
    private Long year;
    @Size(min = 1, max = 256, message = "title's size between 1~256")
    private String title;
    @Size(min = 1, max = 4096, message = "description's size between 1~4096")
    private String description;
}
