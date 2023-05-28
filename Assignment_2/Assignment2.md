# Steps to Follow :

1. Copy and Paste the four files ```ReverseModule.idl```, ```ReverseClient.java```,```ReverseServer.java```, and```ReverseImplementation.java``` in a new folder called Assignment 2.
2. Run the following command in a new terminal window to start the server :
```
idlj -fall ReverseModule.idl

javac *.java ReverseModule/*.java  

orbd -ORBInitialPort 1050&   
```
3. These commands will create two new directories called ```ReverseModule```and ```ORB.db``` with lots of generated files.
4. Next, in the same terminal window run to start the server :
```
java ReverseServer -ORBInitialPort 1050& -ORBInitialHost localhost&
```
5. To run the client, open up a new terminal window and run :
```
java ReverseClient -ORBInitialPort 1050 -ORBInitialHost localhost
```
6. The Output should be like : 
```
Enter String = Yash is Inferno080
Server Send  = 080onrefnI si hsaY
```