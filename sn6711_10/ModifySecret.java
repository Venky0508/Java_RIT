/*
* ModifySecret.java
*
* Version:
*     $Id$: 10.0.1
*
* Revisions:
*     $Log$: 10.0.5
*/

import java.io.*;

/**
* The ModifySecret.java file de-serialises the object, modifies 
* the message and serializes it again. 
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class ModifySecret {

    /**
     * The main method.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SecretClass sec1 = null;
        
        // De-serialize the object present in the "secret.s" file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("secret.s"))) {
            sec1 = (SecretClass)in.readObject();
            System.out.println("Object has been De-serialized");
        }
        catch (IOException e) {
            System.out.println("IOException is caught");
        }

        // Modify the original message
        sec1.setMsg("Modifying the Original Message.");

        // Serialize the object again
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("secret.s"))){
            out.writeObject(sec1);
            System.out.println("Object has been serialized");
        }
        catch (IOException e){
            System.out.println("IOException is caught");
        }
    }
} // ModifySecret.java
