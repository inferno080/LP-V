import ReverseModule.ReversePOA;

public class ReverseImplementation extends ReversePOA
{
    ReverseImplementation()
    {
        super();
        System.out.println("Reverse Object Created");
    }
    public String reverse_string(String s1)
    {
        StringBuffer bf = new StringBuffer(s1);
        bf.reverse();
        return ""+bf;
    }
}
