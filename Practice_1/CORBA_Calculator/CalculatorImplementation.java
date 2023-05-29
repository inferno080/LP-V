import CalculatorModule.CalculatorPOA;

public class CalculatorImplementation extends CalculatorPOA
{
    CalculatorImplementation()
    {
        super();
        System.out.println("Calculator Object Created");
    }
    public int add(int x, int y)
    {
        return x + y;
    }
}