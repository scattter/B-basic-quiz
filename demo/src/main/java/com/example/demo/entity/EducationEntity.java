package com.example.demo.entity;


import com.example.demo.serializer.UserIdSerial;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "education")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long year;
    @Size(min = 1, max = 256, message = "title's size between 1~256")
    private String title;
    @Size(min = 1, max = 4096, message = "description's size between 1~4096")
    private String description;

    @JsonSerialize(using = UserIdSerial.class)
    @JsonProperty(value = "userId")
    @ManyToOne @JoinColumn(name = "user_id") private PersonEntity personEntity;
}
