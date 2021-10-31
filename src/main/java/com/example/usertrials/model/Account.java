package com.example.usertrials.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "account_name")
    private String accountName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
   // @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<Transaction> transaction;

}
