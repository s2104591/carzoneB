import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Hello {


    public static void main(String[] args) {
        // This is the main method, where the execution of the program starts
        System.out.println("Hello, World Mariano Nov 13, 2023"); // Print a greeting message

        ArrayList<String> array = readFile() ;   
        developFile(array);


       System.out.println("Goodbye, World Mariano Nov 13, 2023"); // Print a greeting message

    }

    //******************************************************* 
    private static void developFile(ArrayList<String> array){
        int sz= array.size();

    
        printline("develop file, size="+sz);
        String filePath="home2.html";
        int linecount=1;
        int changecount=0;

        String  part1="",part2="", part3a=  "", part3b="", part4="",part5="", part6="  ..edited";
        part6="";


 
        // Writing to the file and handling exceptions
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write each line to the file
            for (String line : array) {

                //printline("linecount="+linecount);
                if ( line.contains("href=")  &&  !line.contains("static")   ){

                    int equalindex=line.indexOf("=") ;
                    int classindex=line.indexOf("class") ;
                    int pageindex= line.indexOf("page") ;


                    int  whyindex=line.indexOf("jpg") ;
                    
                    
                    if (whyindex==0) whyindex=line.indexOf("png") ;
                    if (whyindex==0) whyindex=line.indexOf("css") ;

                    if ( whyindex>1) {

                        printline("");
                        printline(linecount+", befoe="+line.strip() );
                        

                        int len=line.length();

                        part1= line.substring(0,equalindex+1);
                        part2= "  '{%  static  ";
                        
                        if (pageindex<1){
                            part3a=  " \"pages/";
                            part3b=  line.substring(equalindex+2, classindex);
                        }
                        else{
                            part3a=  "";
                            part3b=  line.substring(equalindex+1, classindex);

                        }


                        part4= " %}'  ";  
                        part5= line.substring(classindex+0, len);

                        line=  part1+part2 +part3a+ part3b+  part4+ part5 + part6  ;
                        printline("change="+line.strip());
                        changecount++;
                    }
                    else{
                        //printline("skipping linecount="+linecount+"  line="+line);
                    }

                
                    

                }
                 linecount++;

                writer.write(line);
                writer.newLine(); // Add a newline after each line
            }


            printline("changes="+changecount); 
            System.out.println("Data has been written to the file successfully.");
        } catch (IOException e) {
            // Handle exceptions, e.g., if there is an issue writing to the file

            printline("*********Exception Occurred linecount="+linecount);
            e.printStackTrace();
        }


    }

    private static void printline(String msg){
         System.out.println(msg );
    }


    // ****************************************************************************
    private static ArrayList<String>  readFile(){

         String filePath = "home.html";
         ArrayList<String> array = new ArrayList<>();   


        // Using BufferedReader to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                //System.out.println(line);
                array.add(line);
            }
        } catch (IOException e) {
            // Handle exceptions, e.g., if the file is not found or there is an issue reading it
            //e.printStackTrace();
            
            System.out.println("exception");
        
        }

        return array;

    }//ends funct

}