import ReverseModule.ReversePOA;

public class ReverseImplementation extends ReversePOA
{
    ReverseImplementation()
    {
        super();
        System.out.println("Reverse Object Created");
    }
    public String reverse_string(String s)
    {
        StringBuffer x = new StringBuffer(s);
        x.reverse();
        return x.toString();
    }
}