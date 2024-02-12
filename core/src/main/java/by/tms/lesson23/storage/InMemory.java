package by.tms.lesson23.storage;

import by.tms.lesson23.model.Operation;

import java.util.ArrayList;

public class InMemory {
    public static final ArrayList<Operation> operationArray = new ArrayList<>();

    public void addOperation(Operation e){
        operationArray.add(e);
    }

    public ArrayList<Operation> returnAllOperation(){
        return operationArray;
    }
}
