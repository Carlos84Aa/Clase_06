import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class random_file {
    //--------------------------------
    //Create a local variables.
    //--------------------------------
    String Direc = System.getProperty("user.dir")+"\\data\\random_binary_File.dat";
    String Index = System.getProperty("user.dir")+"\\data\\index_Persona.idx";
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    static functions funcs = new functions();
    static int numRecords;
    static int sizeRecord = 75; //100 bytes for each record.

    static public void main(String[] args){
        random_file exec = new random_file();
        numRecords = exec.totalRecords();
        exec.createFile(500);
        //exec.print_formatFields();
        //exec.createIndex();
        //exec.Sequential_Seek_x_Cedula(406840928);

        System.out.println("\n\n");

        //exec.Index_Seek_x_Cedula(406840928);

    }//

    //Create random access file with any records
    private void createFile(int numRows){
        try{
            //Create random access file object
            RandomAccessFile raf = new RandomAccessFile(Direc,"rw");

            //Create data set to store
            for(int i = 1; i <= numRows; i++){
                //Recover the last position to write a new data record
                raf.seek(numRecords * sizeRecord);
                try {
                    //Store a single string applying csv format
                    raf.writeUTF(funcs.pertoText(new cls_Persona(funcs.Cedula(),
                            funcs.Nombre(),
                            funcs.Apellido(),
                            funcs.Apellido(),
                            funcs.Sexo(),
                            funcs.estCivil(),
                            new Date(String.valueOf(formatoFecha.parse(funcs.fecNac()))))));

                    //Increment numRecords variable
                    numRecords++;
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    i-=1;
                }
            }

            //Close random file
            raf.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }//End createFile function (main data set)
    }

    //Create print all data function field by field, with format
    private void print_formatFields(){
        String Expre;
        cls_Persona datPer;
        int regi = 0;
        System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
        funcs.impLinea(95,'=');
        try {
            //Create random file object to read
            RandomAccessFile raf = new RandomAccessFile(Direc,"r");

            //Print each record from buffer
            for(int i = 0; i < numRecords; i++){
                raf.seek(i*sizeRecord);
                Expre = raf.readUTF();
                datPer = funcs.texttoPers(Expre);
                System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n",datPer.getCedula(),datPer.getNombre(),datPer.getApellidoP(),datPer.getApellidoM(),datPer.getSexo(),datPer.geteCivil(),formatoFecha.format(datPer.getFecNac()));
                regi++;
            }

            funcs.impLinea(95,'-');
            System.out.println("Registros impresos: "+regi);

            //Close random file
            raf.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }
    }//End print_formatFields function

    //Calculate the quantity of records stored in file
    private int totalRecords(){
        int total;
        try{
            RandomAccessFile raf = new RandomAccessFile(Direc,"rw");
            total = (int) Math.ceil((double) raf.length() / (double) sizeRecord );
        }catch (IOException ex){
            total = 0;
        }
        return total;
    }//End totalRecords function

    //Create index
    private void createIndex(){
        String Expre;
        List<cls_Idxper> idxPer = new ArrayList<>();

        //Step 1
        //Open file and create arrayList in memory
        try {
            //Create random file object to read
            RandomAccessFile raf = new RandomAccessFile(Direc,"r");

            //Create index list applying cedula and real position in file
            for(int i = 0; i < numRecords; i++){
                raf.seek(i*sizeRecord);
                Expre = raf.readUTF();
                cls_Persona datPer = funcs.texttoPers(Expre);
                idxPer.add(new cls_Idxper(datPer.getCedula(),i));
            }
            //Close random file
            raf.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }

        //Step 2
        //Sort arrayList using cedula value
        Collections.sort(idxPer, new Comparator<cls_Idxper>() {
            @Override
            public int compare(cls_Idxper o1, cls_Idxper o2) {
                return String.valueOf(o1.getCedula()).compareTo(String.valueOf(o2.getCedula()));
            }
        });

        //Step 3
        //Create index file
        try {
            //Create a new ObjectOutputStream file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Index,false));

            //Create data set
            for (cls_Idxper reg: idxPer) {
                try {
                    oos.writeObject(reg);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            oos.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }//End createIndex function

    //Create search function, in sequential access file
    private void Sequential_Seek_x_Cedula(int id){
        String Expre;
        cls_Persona datPer;
        int regi = 0;
        System.out.println("Inicio: " + funcs.getTime());
        System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
        funcs.impLinea(95,'=');
        try {
            //Create random file object to read
            RandomAccessFile raf = new RandomAccessFile(Direc,"r");

            //Print each record from buffer
            for(int i = 0; i < numRecords; i++){
                raf.seek(i*sizeRecord);
                Expre = raf.readUTF();
                datPer = funcs.texttoPers(Expre);
                if(datPer.getCedula()==id) {
                    System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n", datPer.getCedula(), datPer.getNombre(), datPer.getApellidoP(), datPer.getApellidoM(), datPer.getSexo(), datPer.geteCivil(), formatoFecha.format(datPer.getFecNac()));
                    break;
                }
                regi++;
            }

            funcs.impLinea(95,'-');
            System.out.println("Registros evaluados: "+regi);

            //Close random file
            raf.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }

        System.out.println("Final: " + funcs.getTime());
    }//End Sequential_Seek_x_Cedula function

    //Retrieve the data real position with index file
    private void Index_Seek_x_Cedula(int id){
        cls_Idxper datIdxPer;
        String Expre;
        cls_Persona datPer;
        int canti = 0;
        int posi = -1;

        //Display data control
        System.out.println("Inicia proceso lectura indice: " + funcs.getTime());

        try {
            //Create a new ObjectOutputStream file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Index));

            //Recover records, one by one, sequential access
            while((datIdxPer = (cls_Idxper) ois.readObject())!=null){
                canti++;
                if(datIdxPer.getCedula()== id){
                    posi = datIdxPer.getPosicion();
                    break;
                }
            }//End while

            //Close index file
            ois.close();
        }catch (EOFException ex){
            //ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        //Display data control
        System.out.println("Finaliza proceso lectura indice: " + funcs.getTime());
        System.out.println("Se recorrieron " + canti + " registros secunciales");

        try{
            //Only id exist
            if(posi >= 0){
                //Display data control
                System.out.println("\n\nInicia proceso lectura archivo aleatorio: " + funcs.getTime());

                //Read full data set from random access file, Random access
                RandomAccessFile raf = new RandomAccessFile(Direc,"r");

                //Recover data in real position
                raf.seek(posi*sizeRecord);
                Expre = raf.readUTF();
                datPer = funcs.texttoPers(Expre);

                raf.close();

                //Display on screen the required data
                System.out.printf("%-9s â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n","CÃ©dula","Nombre","Apellido P","Apellido M","Sexo","E. Civil","Nacido el");
                funcs.impLinea(95,'=');
                System.out.printf("%d â”‚ %-15s â”‚ %-15s â”‚ %-15s â”‚ %-4s â”‚ %-8s â”‚ %-10s\n", datPer.getCedula(), datPer.getNombre(), datPer.getApellidoP(), datPer.getApellidoM(), datPer.getSexo(), datPer.geteCivil(), formatoFecha.format(datPer.getFecNac()));
                funcs.impLinea(95,'-');

                //Display data control
                System.out.println("\n\nFin del proceso lectura archivo aleatorio: " + funcs.getTime());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }//End Index_Seek_x_Cedula function
}