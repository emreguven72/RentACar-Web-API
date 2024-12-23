package com.tutorial.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	private String plate;
	private double dailyPrice;
	private int modelYear;
	private int state;
	private int modelId;
	
}
