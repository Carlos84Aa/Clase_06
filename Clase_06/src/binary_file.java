/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - binary_file.java
Goals...........: Binary file example, use CRUD functions (read and write) over binary data.
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class binary_file {
    //--------------------------------
    //Create a local variables.
    //--------------------------------
    String Direc = System.getProperty("user.dir")+"\\data\\binary_File.dat";
    static functions funcs = new functions();

    // Create an instance of the SimpleDateFormat class to format the date
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String args[]){
        //Self instance local
        binary_file exec = new binary_file();
        exec.createFile(50,false);
        //exec.print_formatFields();

    }//End main function

    private void createFile(int totalRows, boolean append){
        try {
            //Create a new ObjectOutputStream file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Direc,append));

            //Create data set
            for (int i = 1; i <= totalRows; i++) {
                try {
                    oos.writeObject(new cls_Persona(funcs.Cedula(),
                            funcs.Nombre(),
                            funcs.Apellido(),
                            funcs.Apellido(),
                            funcs.Sexo(),
                            funcs.estCivil(),
                            new Date(String.valueOf(formatoFecha.parse(funcs.fecNac())))));
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    i-=1;
                }
            }
            oos.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }//End createFile function

    //Create print all data function field by field, with format
    private void print_formatFields(){
        cls_Persona datPer;
        int regi = 0;
        System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
        funcs.impLinea(100,'=');
        try {
            //Create reader object from file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Direc));

            //Print each record from buffer
            while((datPer = (cls_Persona) ois.readObject())!=null) {
                System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",
                        datPer.getCedula(),
                        datPer.getNombre(),
                        datPer.getApellidoP(),
                        datPer.getApellidoM(),
                        datPer.getSexo(),
                        datPer.geteCivil(),
                        formatoFecha.format(datPer.getFecNac()));
                regi++;
            }
            //Close buffer
            ois.close();
        }catch (ClassNotFoundException ex){
            //Print stack errors
            ex.printStackTrace();
        }catch (EOFException ex){
            //Print stack errors
            //ex.printStackTrace();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }

        funcs.impLinea(100,'-');
        System.out.println("Registros impresos: "+regi);
    }//End print_formatFields function

}//End class binary_file