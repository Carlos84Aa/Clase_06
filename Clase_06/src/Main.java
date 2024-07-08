public class corrida_05 {
    public static void main(String[] args){
        // Creates a new object of the cls_Profesor class
        cls_Profesor profesor = new cls_Profesor(123456, "Jorge Ruiz", "Bases de Datos", "Master");

        cls_Estudiante [] pupilos = new cls_Estudiante[3];
        pupilos[0] = new cls_Estudiante();
        pupilos[0].setCedula(123);
        pupilos[0].setNombre("Morticia Addams");
        pupilos[0].setBeca(0);
        pupilos[0].setCorreoEs("maddams@est.utn.ac.cr");

        pupilos[1] = new cls_Estudiante();
        pupilos[1].setCedula(231);
        pupilos[1].setNombre("Merlina Addams");
        pupilos[1].setBeca(5);
        pupilos[1].setCorreoEs("meraddams@est.utn.ac.cr");

        pupilos[2] = new cls_Estudiante();
        pupilos[2].setCedula(345);
        pupilos[2].setNombre("Pericles Addams");
        pupilos[2].setBeca(0);
        pupilos[2].setCorreoEs("peraddams@est.utn.ac.cr");

        cls_Grupo grp01 = new cls_Grupo(profesor,pupilos, "ProgramaciÃ³n 1");

        System.out.println("Grupo.....: " + grp01.getNombre());
        System.out.println("Profesor..: " + grp01.getProfe().getNombre());

        for(int i = 0; i < grp01.getAlumnos().length; i++){
            System.out.println("Alumno [" + i + "] :"+ grp01.getAlumnos()[i].getNombre());
        }


    }
}