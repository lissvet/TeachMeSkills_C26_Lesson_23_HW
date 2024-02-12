package by.tms.lesson23.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

	@RequiredArgsConstructor
	@NoArgsConstructor(force = true)
	@Getter
	@Setter
public class Operation {
	private final double num1;
	private final double num2;
	private final String type;
	private double result;
}
