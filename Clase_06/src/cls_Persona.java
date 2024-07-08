/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - cls_Persona.java
Goals...........: Structure that contains the person specification, used to create binary files
Professor.......: Jorge Ruiz (york)
Student.........: Carlos Arias (Popeye)
================================================================================================*/

// Call external libraries
import java.io.Serializable;
import java.util.Date;

public class cls_Persona implements Serializable {
    //Class properties, use some kind of types of values
    private int cedula;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private char sexo;
    private char eCivil;
    private Date fecNac;

    //Default constructor
    public cls_Persona() {
    }

    //Parametrized constructor, all required
    public cls_Persona(int cedula, String nombre, String apellidoP, String apellidoM, char sexo, char eCivil, Date fecNac) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.sexo = sexo;
        this.eCivil = eCivil;
        this.fecNac = fecNac;
    }

    //------------------------------------------------------
    //Create Getter and Setter functions for all properties
    //------------------------------------------------------
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char geteCivil() {
        return eCivil;
    }

    public void seteCivil(char eCivil) {
        this.eCivil = eCivil;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }
}