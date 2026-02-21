public class Calculator {
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    private String currentInput = "";

    public void addNumber(String number){
        if (startNewNumber){
            currentInput = number;
            startNewNumber = false;
        }else {
            currentInput += number;
        }
    }
    public void setOperator(String op){
        firstNumber = Double.parseDouble(currentInput);
        operator = op;
        startNewNumber = true;
    }
    public void calculate(){
        double secondNumber = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator){
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "x": result = firstNumber * secondNumber; break;
            case "/": result = firstNumber / secondNumber; break;
        }

        currentInput = String.valueOf(result);
        firstNumber = result;
        startNewNumber = true;
    }
    public String getDisplayValue(){
        return currentInput.isEmpty() ? "0" : currentInput;
    }
}