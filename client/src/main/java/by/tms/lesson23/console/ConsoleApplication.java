package by.tms.lesson23.console;

import by.tms.lesson23.model.Operation;
import by.tms.lesson23.service.OperationService;

public class ConsoleApplication {

	private final OperationService operationService = new OperationService();
	private final ConsoleReader consoleReader = new ConsoleReader();
	private final ConsoleWriter consoleWriter = new ConsoleWriter();

	public Operation createOperation() {
		Operation operation = new Operation();
		try{
				consoleWriter.write("Enter num 1");
				double num1 = consoleReader.readNum();
				consoleWriter.write("Enter num 2");
				double num2 = consoleReader.readNum();
				consoleWriter.write("Enter operation");
				String type = consoleReader.readOperationType();

				operation = new Operation(num1, num2, type);
			} catch (Exception e) {
				consoleWriter.write(e.getMessage());
			}
		return operation;
	}

	public boolean checkDoOperation(){
		consoleWriter.write("Do you want to perform a calculation operation?");
		String stringDecision = consoleReader.readOperationType();

		if (stringDecision.matches("(?i)yes")){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkShowHistory(){
		consoleWriter.write("Do you want to view your transaction history?");
		String stringDecision = consoleReader.readOperationType();

		if (stringDecision.matches("(?i)yes")){
			return true;
		}
		else{
			return false;
		}
	}
}
