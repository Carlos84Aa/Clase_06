/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - functions.java
Goals...........: Functions set to create synthetic data for an example database
Professor.......: Jorge Ruiz (york)
Student.........: Carlos Arias (Popeye)
================================================================================================*/

// Call external libraries
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class functions {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    // Refill with zeros on the left side of the expression, only if required
    public String ponCeros(String Expre, int tam){
        String local = "";
        for(int i = 0; i < (tam-Expre.length()); i++){
            local = local.concat("0");
        }
        return local.concat(Expre);
    }

    // Print horizontal line, applying length and custom character
    public void impLinea(int largo, char tipo){
        for(int i = 1; i <= largo; i++){
            System.out.print(tipo);
        }
        System.out.println();
    }

    // Returns a random single first name
    public String Nombre(){
        Random rnd = new Random();
        String nombres[] = {
                "Ana","Alvaro","Adriana","Arturo","Alfonso","Andrea","Andres","Anete","Arelys","Armando","Antonio","Andrey",
                "Alicia","Ariel","Astrid","Aurora","Aldo","Amanda","Alejandro","Ariana","Ariela","Alexander",
                "Bianka","Beverly","Bruno","Braulio","Beatriz","Bernarda","Brenda","Bryan","Boris","Berta","BartolomÃ©","Baltazar","Brandon","Braylin",
                "Cesar","Carolina","Carmen","Carlos","Cindy","Camilo","Clemencia","Cecilia","Cristina","Cristian","Catalina","Cristobal", "Cristal",
                "Diego","Dunia","David","Debora","Deisi","Diana","Danilo","Damaris","Doris","Daniel","Denis","Dulce","Dayana",
                "EfraÃ­n","Elsa","Elena","Ever","Ernesto","Eduardo","Esgardo","Emilio","Eilin","Esteban","Estiven","Elizabeth","Eneida","Edu",
                "Fabiola","Fernando","Francisco","Francini","FÃ©lix","Federico","Fabricio","Filomena","Franklin","Fernanda","Fran",
                "Gabriela","Gerardo","Giovanna","German","Grisel","Gabriel","Gustavo","Gilberto","Graciela",
                "Hector","Hellen","Huberth","Humberto","Hilda","Homero","HernÃ¡n","Hugo","Hellen",
                "Ignacio","Indira","Irma","Ingrid","IsaÃ­as","Ivania","Ileana","Isac","Isidro",
                "Jorge","Joyce","Julia","Jessica","JosÃ©","Julio","Jacinto","Jaime","Joel","Jairo","Jesenia","JÃºan","JesÃºs","Juana","Jael","Josue",
                "Karla","Karen","Katia","Kevin","Kenneth","Katerina","Keylor","Kenyi","Karina","Kamila","Katherine","Kendall","Kendry","Kendrick",
                "Lorena","Lorenzo","Lady","Luis","Laura","LucÃ­a","Lourdes","Leopoldo","Licet","Leticia",
                "Mario","Mauricio","Melania","Marianela","Mercedes","Marcos","Merlina","Morticia","Mauren","Miguel","MÃ³nica","Mauricio","Marienny",
                "Nuria","Nestor","Nazaret","Nidia","Norman","Naomi","Nora",
                "Osvaldo","Orlando","Odir","Olga","Ofelia","Omar","Olger","Oscar","Olivier",
                "Pedro","Pablo","Patricia","Priscila","Paula","Paola","Pericles","Paolo",
                "RaÃºl", "Roberto", "Rebeca","RocÃ­o","RenÃ©","Rosaura","RosalÃ­a","Rosa","Romel","Ricardo","Rigoberto",
                "Sabrina", "Sergio", "Sonia","Samuel","Sandra","Silvio","Susana","SebastÃ­an","Sandro","Silvia","SofÃ­a","Santiago","Santos","Saul",
                "SofonÃ­as","Samiel","Simey","Sharon",
                "Tatiana","TeodÃ³ro", "Tania","Teresa","TobÃ­as","Tonny",
                "Ãšrsula", "Uriel", "Ulises",
                "VerÃ³nica","Vanesa","Valeria","Victor","Vilma","Vernon","Viviana","Victoria","Valery","Valeska",
                "Walter","Wilfrido","Wendy","William","Wenceslao","Wilgem","Wilberth","Willis",
                "Xiomara", "Ximena", "Xavier",
                "Yirlania","Yolanda","Yonan","YehÃºdi","Yvone","Yurielka","Yuri","Yenori",
                "Zaida", "Zulema","Zoe","ZacarÃ­as","Zoraida","Zeidy"
        };
        return nombres[rnd.nextInt(nombres.length)];
    }

    // Returns a random last name
    public String Apellido(){
        Random rnd = new Random();
        String apellidos[] = {
                "Alvarado","Almengor","Acevedo","Abarca","Angulo","AcÃ³n","Apuy","Alfaro","Artiaga","Alvares","Arias","Aguilar","Aguero","Aguirre",
                "Aguilera","Araya","Alvarado","AragÃ³n",
                "Ballesteros","Barahona","Barboza","Blanco","BolaÃ±os","Bermudez","Barrantes","Brenes","Blandon","Bonilla",
                "Caballero","CÃ©spedes","Campos","ChavarrÃ­a","Cubero","Cernas","Cubillo","Cambronero","Cabalceta","Cortes","Con","Carranza","Cordero",
                "Cruz","Cascante","CÃ³rdoba","ChÃ¡ves","Conejo","Cerdas","Castro",
                "Duarte","DurÃ¡n","Domingues","De la O","DÃ­az",
                "Elizondo","Echandi","Escalante","Espinoza","Esquivel","EstupiÃ±an",
                "FernÃ¡ndez","Fonseca","Fournier","Fajardo","Flores","Fuentes",
                "GonzÃ¡lez","Gaitan","Galan","GambÃ³a","GarcÃ­a",
                "HernÃ¡ndez","Herrera","Hidalgo","Huertas","Hurtado",
                "Ibarra","IbanÃ©z","Iglesias","Infante","Izaguirre",
                "Jerez","JaÃ©n","JimÃ©nez","JÃ¡camo","JuÃ¡rez",
                "LÃ³pez","Lamas","Lagos","Labrador","Lara","LÃ­","LeitÃ³n",
                "Madrigal","Molina","Mendez","Manzanares","Monestel","Molinares","Matarrita","Mata","Monge","Mora","Murillo","Mena","MarÃ­n","Mendoza","Matamoros",
                "NuÃ±ez","Noguera","Naranjo","Navas","Nicolas",
                "Ocampo","ObregÃ³n","Ochoa","Ojeda","OrdoÃ±ez",
                "Pacheco","Palacios","Palma","Padilla","Paniagua","Pomares","Picado","Perez","Peraza","Pizarro","Parra",
                "QuirÃ³s","Quintero", "Quintana","Quiroga","Quintanilla","Quesada",
                "Ruiz","RamÃ­rez","Roldan","Redondo","Rivera","Rodriguez","Reyes","Rueda",
                "SaborÃ­o","Sanchez","Salas","SÃ¡enz","Sancho","SanabrÃ­a","Soto","Sequeira","Sibaja","Solano",
                "Talavera","Tenorio","Trujillo","Tijerino","Torres",
                "Ulloa","Ugalde","UreÃ±a","Urbina","Ugarte",
                "Vega","Vargas","Valencia","Vallejo","Varela","VizcaÃ­no","Valdez","Vindas","Villalobos","Villanueva","Villegas","Villagra",
                "Williams","Wright","Wong","Walker","Watson","Wells","White","Ward","Wheeler","Warren","Wade","Walters","Waltz",
                "Zamora","Zarate","Zumbado"
        };
        return apellidos[rnd.nextInt(apellidos.length)];
    }

    // Creates a cedula or identification number
    public int Cedula() {
        String ced;
        Random rnd = new Random();

        ced = String.valueOf(rnd.nextInt(7) + 1);
        ced = ced.concat(ponCeros(String.valueOf(rnd.nextInt(1000)), 4) + ponCeros(String.valueOf(rnd.nextInt(1000)), 4));

        return Integer.parseInt(ced);
    }

    // Select a random biological sex
    public char Sexo(){
        Random rnd = new Random();
        char Sx[] = {'F','M'};
        return Sx[rnd.nextInt(2)];
    }

    // Creates a civil status
    public char estCivil(){
        Random rnd = new Random();
        char Es[] = {'S','C','D','V','U'};
        return Es[rnd.nextInt(5)];
    }

    // Creates a birthdate
    public String fecNac(){
        Random rnd = new Random();
        String expre;

        //Calculate day between 1 and 31
        expre = ponCeros(String.valueOf(rnd.nextInt(31)+1),2)+"/";

        //Calculate month between 1 and 12
        expre = expre.concat(ponCeros(String.valueOf(rnd.nextInt(12)+1),2)+"/");

        //Calculate year since 1960 at today
        expre = expre.concat(String.valueOf(rnd.nextInt(59)+1960));

        return expre;
    }//End fecNac function

    //Recover time from local machine
    public String getTime() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss.SSS");
        return formateador.format(ahora);
    }

    //To use in random file access returning text data from clsPersona object
    public String pertoText(cls_Persona per){
        String exp = "";
        exp = String.valueOf(per.getCedula()) + ";" +
                per.getNombre() + ";" +
                per.getApellidoP() + ";" +
                per.getApellidoM() + ";" +
                String.valueOf(per.getSexo()) + ";" +
                String.valueOf(per.geteCivil()) + ";" +
                String.valueOf(per.getFecNac());
        return exp;
    }

    //To use in random file access returning clsPersona object
    public cls_Persona texttoPers(String Expre){
        try{
            String datos[] = Expre.split(";");
            return new cls_Persona(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4].charAt(0),datos[5].charAt(0),new Date(String.valueOf(datos[6])));
        }catch (Exception ex){
            return null;
        }

    }//To use in random file access returning text data from clsPersona object

}