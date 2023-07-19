import java.io.*;
import java.util.Scanner;
public class LineR extends BufferedReader {
    private  int counter = 0;
    public LineR(Reader in) {
        super(in);
    }

    public LineR(Reader in, int sz) {
        super(in, sz);
    }

    public int getLineNumber() {
        return this.counter;
    }

    public void setLineNumber(int lineNumber){
        this.counter = lineNumber;
    }
    public void mark(int readAheadLimit) throws IOException {
        super.mark(readAheadLimit);
    }
    public void reset() throws IOException {
        super.reset();
    }


    public static void main(String[] args) throws Exception {

        LineR input;
        String line1;
        int line2;

        
        if (args.length == 1){
            input =  new LineR( new BufferedReader (new LineNumberReader (new InputStreamReader ( new FileInputStream(args[0]) ) )));
        }
        else if(args.length == 2){
            input =  new LineR( new BufferedReader ( new InputStreamReader ( new FileInputStream(args[0]) ) ),Integer.parseInt(args[1]));
            }
        else{
            input = new LineR(new BufferedReader(new InputStreamReader(System.in)));
        }
        
        System.out.println(" 1. Get Line Number \n 2. Set Line Number \n 3. Skip \n 4. Mark and Reset \n 5. Read \n 6. Exit \n YOUR INPUT: ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        switch(i){
            case 1: 
                while ((line1 = input.readLine()) != null) {
                    System.out.println("--" + line1 + "---");
                    input.counter ++;
                    System.out.println("GetlineNumber: " + input.getLineNumber());
                }
                break;
            case 2:
                while ((line1 = input.readLine()) != null) {
                    System.out.println("--" + line1 + "---");
                    input.counter ++;
                    if (input.counter == 2) {
                    input.setLineNumber(4);
                    }
                    System.out.println("GetlineNumber: " + input.getLineNumber());
                }
                break;
            case 3:
                while ((line1 = input.readLine()) != null){
                    input.counter ++;
                    input.skip(2);
                    System.out.println("Line: " + line1);
                   
                }
                break;
            case 4:
                while ((line1 = input.readLine()) != null){
                    input.counter ++;
            
                    System.out.println("Characters: " + (char)input.read());
                    System.out.println("Characters: " + (char)input.read());
                    
                    input.mark(0);
                    System.out.println("--------------------");
                    System.out.println("Mark Invoked: ");
                    System.out.println("Characters: " + (char) input.read());
                    System.out.println("Characters: " + (char)input.read());
                    System.out.println("--------------------");
                    
                    input.reset();
                    System.out.println("Reset Invoked: ");
                    System.out.println("Characters: " + (char)input.read());
                    System.out.println("Characters: " + (char)input.read());
                    System.out.println("--------------------");
                    if (input.counter == 3){
                        break;
                    }
                    
                }
                break;
            case 5:
                while((line2 = input.read()) != -1){
                    System.out.println("--" + (char)line2 + "---");
                    if (line2 == 10){
                        input.counter ++;
                    }
                    System.out.println("GetlineNumber: " + input.getLineNumber());
                }
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid Input");


        }
        sc.close();
        
    }
}