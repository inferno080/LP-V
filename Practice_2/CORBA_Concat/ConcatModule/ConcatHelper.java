package ConcatModule;


/**
* ConcatModule/ConcatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ConcatModule.idl
* Monday, 29 May, 2023 11:42:34 AM IST
*/

abstract public class ConcatHelper
{
  private static String  _id = "IDL:ConcatModule/Concat:1.0";

  public static void insert (org.omg.CORBA.Any a, ConcatModule.Concat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ConcatModule.Concat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ConcatModule.ConcatHelper.id (), "Concat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ConcatModule.Concat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConcatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ConcatModule.Concat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ConcatModule.Concat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ConcatModule.Concat)
      return (ConcatModule.Concat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ConcatModule._ConcatStub stub = new ConcatModule._ConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ConcatModule.Concat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ConcatModule.Concat)
      return (ConcatModule.Concat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ConcatModule._ConcatStub stub = new ConcatModule._ConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
