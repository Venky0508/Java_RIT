Homework 10.3 README:

This is a program wherein the presidents of 2 countries 
X and Y exchange a message in private. The secret key is
Rochester. The message is serialized in the CreateSecret.java 
file and de-serialized in the ReadSecret.java file. A 
ModifySecret.java file is created to change the contents of 
the original message.

If the contents have been modified, a warning message is displayed 
to the receiver, else, the transmitted message is printed.

Usage:
1. Run the CreateSecret.java file through the terminal
	javac CreateSecret.java
	java CreateSecret Your private message

2. (OPTIONAL) Run the ModifySecret.java file to change the contents 
of the message.
	
3. Run the ReadSecret.java file to check if the contents have
been modified and print the original message.