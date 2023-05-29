import ConcatModule.ConcatPOA;

public class ConcatImplementation extends ConcatPOA
{
    ConcatImplementation()
    {
        super();
        System.out.println("Concat Object Created");
    }
    
    public String concat_strings(String s1, String s2)
    {
        return s1.concat(s2);
    }
}