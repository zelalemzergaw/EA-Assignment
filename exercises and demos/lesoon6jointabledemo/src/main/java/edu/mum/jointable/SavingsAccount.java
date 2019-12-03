package edu.mum.jointable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity

public class SavingsAccount extends Account {
	private Double APY;

    public SavingsAccount(Long number, double balance, Double APY) {
        super(number, balance);
        this.APY = APY;
    }
}
