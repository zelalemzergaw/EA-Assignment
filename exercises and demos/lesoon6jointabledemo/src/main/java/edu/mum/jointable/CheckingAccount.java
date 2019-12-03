package edu.mum.jointable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity

public class CheckingAccount extends Account {
	private Double overdraftLimit;

	public CheckingAccount(Long number, double balance, Double overdraftLimit) {
		super(number, balance);
		this.overdraftLimit = overdraftLimit;
	}
}
