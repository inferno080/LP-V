package ConcatModule;


/**
* ConcatModule/_ConcatStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ConcatModule.idl
* Monday, 29 May, 2023 11:42:34 AM IST
*/

public class _ConcatStub extends org.omg.CORBA.portable.ObjectImpl implements ConcatModule.Concat
{

  public String concat_strings (String s1, String s2)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("concat_strings", true);
                $out.write_string (s1);
                $out.write_string (s2);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return concat_strings (s1, s2        );
            } finally {
                _releaseReply ($in);
            }
  } // concat_strings

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ConcatModule/Concat:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ConcatStub
