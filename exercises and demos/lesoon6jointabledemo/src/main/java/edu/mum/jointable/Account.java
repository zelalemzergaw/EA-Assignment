package edu.mum.jointable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue
    private Integer id;
    private Long number;
    private double balance;

    public Account(Long number, double balance) {
        this.number = number;
        this.balance = balance;
    }
}
