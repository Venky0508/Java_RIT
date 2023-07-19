/*
* ReadSecret.java
*
* Version:
*     $Id$: 10.0.1
*
* Revisions:
*     $Log$: 10.0.5
*/

import java.io.*;

/**
* The object of the SecretClass is serialized in this program.
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class ReadSecret {

    /**
     * The main method.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        SecretClass sec;

        // Reading and de-serializing the object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("secret.s"))){
            sec = (SecretClass) in.readObject();
            System.out.println("Object has been De-serialized");

            // Checking if the message has been modified
            if (sec.getMsg().hashCode() != sec.stringHash) {
                System.out.println(" CAUTION: MESSAGE HAS BEEN MODIFIED!!!");
            }
            else {
                System.out.println(sec);
            }

            // Check if the message contains the secret key
            if (sec.getMsg().contains("Rochester")) {
                System.out.println("Secret Key Found!");
            }
            else {
                System.out.println("Secret Key not Found");
            }
        }
        catch (IOException e){
            System.out.println("IOException is caught");
            sec = null;
        }
    }
} //ReadSecret.java
