/*
* CreateSecret.java
*
* Version:
*     $Id$: 10.0.1
*
* Revisions:
*     $Log$: 10.0.5
*/

import java.io.*;

/**
* The CreateSecret.java is a class that contains another class
* called SecretClass that contains the Secret key and the message
* to be transmitted. The object of the SecretClass is serialized 
* in this program.
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

class SecretClass implements Serializable{

    private String msg;

    // Secret key shared by the sender and the receiver
    public String secretKey = "Rochester";
    public final int stringHash;

    // Constructor SecretClass
    public SecretClass(String msg){
        this.msg = msg + secretKey;
        this.stringHash = this.msg.hashCode();
    }

    // Getter method for msg
    public String getMsg() {
        return msg;
    }

    // Setter method for msg
    public void setMsg(String newMsg){
        this.msg = newMsg;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return msg;
    }
}

// Class for serializing the object
public class CreateSecret {

    /**
     * The main method.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        String myMsg = "";
        // Accepting the message from the terminal
        for (int index = 0; index < args.length; index ++){
            myMsg += args[index] + " ";
        }
        SecretClass sec = new SecretClass(myMsg);
        String fileName = "secret.s";

        // Opening the file "secret.s" and storing the serialized object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(sec);
            System.out.println("Object has been serialized");
        }
        catch (IOException e){
            System.out.println("IOException is caught");
        }
    }
} // CreateSecret.java
