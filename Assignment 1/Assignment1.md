# Steps to Follow :

1. Create a New Folder called Assignment 1 and paste these four files in it - ```AddClient.java```, ```AddServer.java```, ```AddServerImplementation.java```,  ```AddServerInterface.java```.
2. Run the command :
``` 
javac *.java
```
3. This will create four new files - ```AddClient.class```, ```AddServer.class```, ```AddServerImplementation.class```,  ```AddServerInterface.class```
4. Run the command :
```
rmic AddServerImplementation
```
5. This will create a new file - ```AddServerImplementation_Stub.class```.
6. Run the command :
```
rmiregistry
```
7. Leave the first terminal window open and create a new folder called 'server'.
8. Copy and Paste - ```AddServer.java```, ```AddServerImplementation.java```,  ```AddServerInterface.java```, ```AddServerImplementation_Stub.class``` in that folder.
9. Open the 'server' folder in a new terminal window.
10. Run the command :
```
java AddServer
```
11. Leave the second terminal window open and create a new folder called 'client'.
12. Copy and Paste - ```AddClient.java```,  ```AddServerInterface.java```, ```AddServerImplementation_Stub.class``` in that folder.
13. Open the 'client' folder in a new terminal window.
14. Run the command :
```
java AddClient 127.0.0.1 8 9
```
15. The output should be :
```
8.0 + 9.0 = 17.0 
``` 
