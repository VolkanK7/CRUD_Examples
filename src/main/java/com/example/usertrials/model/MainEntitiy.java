package com.example.usertrials.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class MainEntitiy implements Serializable {
    private Date createAt;
    private String createBy;
    private Date uptadeAt;
    private String updateBy;
}
