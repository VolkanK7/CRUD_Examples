package com.example.usertrials.dto;

import com.example.usertrials.model.MainEntitiy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String name;
    private String email;
    private int age;
}
