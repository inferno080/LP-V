import CalculatorModule.CalculatorPOA;

class CalculatorImplementation extends CalculatorPOA
{
    CalculatorImplementation()
    {
        super();
        System.out.println("Calculator Object Created");

    }
    public int add(int x, int y)
    {
        return x+y;
    }
    public int sub(int x, int y)
    {
        return x-y;
    }
    public int mul(int x, int y)
    {
        return x*y;
    }
    public int div(int x, int y)
    {
        return x/y;
    }
}