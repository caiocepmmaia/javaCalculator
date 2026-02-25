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

    public void addDecimal(){
        if (startNewNumber){
            currentInput = "0,";
            startNewNumber = false;
            return;
        }if(currentInput.contains(",")){
            return;
        } currentInput += ",";
    }

    public void setOperator(String op){
        firstNumber = treatmentDecimal();
        operator = op;
        startNewNumber = true;
    }
    public void calculate(){

        double secondNumber = treatmentDecimal();
        double result = 0;


        switch (operator){
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "x": result = firstNumber * secondNumber; break;
            case "/": if (secondNumber != 0){ result = firstNumber / secondNumber; break;
            }else {currentInput = "Sem divisão por Zero"; return;}
        }

        if (result == (int) result){
            currentInput = String.valueOf((int) result);
        }else {
            currentInput = String.valueOf(result);
        }

        firstNumber = result;
        startNewNumber = true;
    }

    private double treatmentDecimal(){
        String treatment = currentInput.replace(",",".");
        return Double.parseDouble(treatment);
    }

    public void clear(){
        currentInput = "0";
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }

    public void backspace(){

        if (startNewNumber){
            return;
        }

        if (currentInput == null || currentInput.length() <= 1){
            currentInput = "0";
            startNewNumber = true;
            return;
        }
        currentInput = currentInput.substring(0, currentInput.length() - 1);
    }

    public String getDisplayValue(){
        if (currentInput.isEmpty()) return "0";
        return currentInput.replace(".",",");
    }
}