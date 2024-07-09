/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - dynamic_flat_file.java
Goals...........: Flat file example, use CRUD functions over dynamic length data
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/

import java.io.*;

public class dynamic_flat_file {
    //--------------------------------
    //Create a local variables.
    //--------------------------------
    String Direc = System.getProperty("user.dir")+"\\data\\dynamic_flat_File.csv";
    static functions funcs = new functions();

    public static void main(String args[]){
        //Self instance local
        dynamic_flat_file exec = new dynamic_flat_file();

        //Call createFile function and create 5000 records
        exec.createFile(5000,false);
        //exec.print_simpleLine();
        //exec.print_formatFields();

        //Add 1000 records in flat file
        //exec.createFile(1000,true);

        //exec.Seek_x_Cedula(108390802);
    }//End main function

    //Create flat file and populate it with data
    private void createFile(int totalRows, boolean append){
        PrintWriter pw = null;
        String Expre = "";
        try{
            //Open file to write static length record
            pw = new PrintWriter(new FileWriter(Direc,append));

            //Create data set
            for (int i = 1; i <= totalRows; i++) {
                //Create each record
                Expre = funcs.Cedula()   + ";" +
                        funcs.Nombre()   + ";" +
                        funcs.Apellido() + ";" +
                        funcs.Apellido() + ";" +
                        funcs.Sexo()     + ";" +
                        funcs.estCivil() + ";" +
                        funcs.fecNac();

                //Write record
                pw.println(Expre);

                //Clean local variable
                Expre = "";
            }
            //Close flat file
            pw.close();
        } catch (Exception e) {
            //Print stack errors
            e.printStackTrace();
        }
    }//End createFile function

    //Create print all data function, without format
    private void print_simpleLine(){
        String Expre;
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                System.out.println(Expre);
            }

            //Close buffer
            br.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }
    }//End print_simpleLine function

    //Create print all data function field by field, with format
    private void print_formatFields(){
        String datos[], Expre;
        int regi = 0;
        System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
        funcs.impLinea(95,'=');
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                datos = Expre.split(";");

                System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                regi++;
            }

            funcs.impLinea(95,'-');
            System.out.println("Registros impresos: "+regi);

            //Close buffer
            br.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }
    }//End print_formatFields function

    //Create print all data function field by field, with format
    private void Seek_x_Cedula(int id){
        String Expre, datos[];
        int regi = 0;

        System.out.println("Inicio: " + funcs.getTime());
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                regi++;
                datos = Expre.split(";");
                if(Integer.parseInt(datos[0])==id){
                    System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
                    funcs.impLinea(95,'=');
                    System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                    funcs.impLinea(95,'-');
                    break;
                }//End of if
            }//End of while
            //Close buffer
            br.close();

            System.out.println("Registros leÃ­dos: "+regi);

        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }

        System.out.println("Final: " + funcs.getTime());
    }//End print_formatFields function

}//End dynamic_flat_file class