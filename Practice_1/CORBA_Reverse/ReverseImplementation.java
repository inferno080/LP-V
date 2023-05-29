import ReverseModule.ReversePOA;

class ReverseImplementation extends ReversePOA
{
    ReverseImplementation()
    {
        super();
        System.out.println("Reverse Object Created");
    }
    public String reverse_string(String s)
    {
        StringBuffer str = new StringBuffer(s);
        str.reverse();
        return ("Server Sent : " + str);
    }
}