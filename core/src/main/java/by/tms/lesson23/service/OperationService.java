package by.tms.lesson23.service;

import by.tms.lesson23.model.Operation;

public class OperationService {

	public Operation calculate(Operation operation) {
		double result;
		switch (operation.getType()) {
			case "+":
				result = operation.getNum1() + operation.getNum2();
				operation.setResult(result);
				return operation;
			case "-":
				result = operation.getNum1() - operation.getNum2();
				operation.setResult(result);
				return operation;
			case "*":
				result = operation.getNum1() * operation.getNum2();
				operation.setResult(result);
				return operation;
			case "/":
				if (operation.getNum2() == 0) {
					throw new IllegalArgumentException("Can't divide by zero");
				} else {
					result = operation.getNum1() / operation.getNum2();
					operation.setResult(result);
					return operation;
				}
		}
		throw new IllegalArgumentException("Unsupported operation");
	}
}
