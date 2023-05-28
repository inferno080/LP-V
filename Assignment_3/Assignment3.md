# Steps to Follow :

1. Copy and Paste ```ScatterGather.java``` in a new folder Assignment 3.
2. Download the latest mpj.zip file from ```https://sourceforge.net/projects/mpjexpress/files/releases/```
3. Extract it wherever you want. eg - ```/Users/yashkale/Downloads/mpj-v0_44```
4. Open a new terminal window for Assignment 3 folder. 
5. Type the following commands to set PATH and MPJ_HOME variables
```
export MPJ_HOME="/Users/yashkale/Downloads/mpj-v0_44"
```
```
export PATH=$MPJ_HOME/bin:$PATH
```
6. Compile your code
```
javac -cp $MPJ_HOME/lib/mpj.jar Asign2.java
```
7. Exectute your code 
```
$MPJ_HOME/bin/mpjrun.sh -np 4 Asign2
```