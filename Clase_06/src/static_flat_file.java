/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - static_flat_file.java
Goals...........: Flat file example, use CRUD functions over static length data
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/
import java.io.*;

public class static_flat_file {
    //--------------------------------
    //Create a local variables.
    //--------------------------------
    String Direc = System.getProperty("user.dir")+"\\data\\static_flat_File.txt";
    static functions funcs = new functions();

    public static void main(String args[]){
        //Self instance local
        static_flat_file exec = new static_flat_file();

        exec.createFile(5000,false);
        //exec.print_simpleLine();
        //exec.print_simpleFields();
        //exec.print_formatFields();
        //exec.Seek_x_Cedula(403160178);
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
                Expre = funcs.ponCeros(String.valueOf(funcs.Cedula()),15) +
                        funcs.ponCeros(funcs.Nombre() + " " +
                                funcs.Apellido() + " " +
                                funcs.Apellido(),40) +
                        funcs.Sexo() +
                        funcs.estCivil() +
                        funcs.ponCeros(funcs.fecNac(),10);

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

    //Create print all data function field by field, without format
    private void print_simpleFields(){
        String Expre,ced,nom,sex,civ,fna;
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                ced = Expre.substring(0,15);
                nom = Expre.substring(15,55);
                sex = Expre.substring(55,56);
                civ = Expre.substring(56,57);
                fna = Expre.substring(57,67);

                System.out.println(ced + "\t\t" +
                        nom + "\t\t" +
                        sex + "\t\t" +
                        civ + "\t\t" +
                        fna);
            }

            //Close buffer
            br.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }
    }//End print_simpleFields function

    //Create print all data function field by field, with format
    private void print_formatFields(){
        String Expre,ced,nom,sex,civ,fna;
        int regi = 0;
        System.out.printf("%-9s â”‚ %-35s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Sexo","E. Civil","Nacido el");
        funcs.impLinea(80,'=');
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                ced = String.valueOf(Integer.parseInt(Expre.substring(0,15)));
                nom = Expre.substring(15,55).replace("0","");
                sex = Expre.substring(55,56);
                civ = Expre.substring(56,57);
                fna = Expre.substring(57,67);

                System.out.printf("%d â”‚ %-35s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",Integer.parseInt(ced),nom,sex,civ,fna);
                regi++;
            }

            funcs.impLinea(80,'-');
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
        String Expre,ced,nom,sex,civ,fna;
        int regi = 0;

        System.out.println("Inicio: " + funcs.getTime());
        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                regi++;
                ced = String.valueOf(Integer.parseInt(Expre.substring(0,15)));
                if(Integer.parseInt(ced)==id){
                    System.out.printf("%-9s â”‚ %-35s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Sexo","E. Civil","Nacido el");
                    funcs.impLinea(80,'=');
                    nom = Expre.substring(15,55).replace("0","");
                    sex = Expre.substring(55,56);
                    civ = Expre.substring(56,57);
                    fna = Expre.substring(57,67);

                    System.out.printf("%d â”‚ %-35s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",Integer.parseInt(ced),nom,sex,civ,fna);
                    funcs.impLinea(80,'-');
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

}//End static_flat_file class
