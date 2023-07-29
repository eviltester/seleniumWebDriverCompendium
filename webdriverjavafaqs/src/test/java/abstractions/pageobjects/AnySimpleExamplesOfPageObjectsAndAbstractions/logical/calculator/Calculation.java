package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.logical.calculator;

public class Calculation {


    private int number1;
    private String operator;
    private int number2;

    public Calculation(int number1, String operator, int number2) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }
}