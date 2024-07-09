/*================================================================================================
Study Center....: Universidad TÃ©cnica Nacional
Campus..........: PacÃ­fico (JRMP)
College career..: IngenierÃ­a en TecnologÃ­as de InformaciÃ³n
Period..........: 2C-2024
Course..........: ITI-221 - ProgramaciÃ³n I
Document........: class_06 - cls_Idxper.java
Goals...........: Structure that contains the specifications to create index file
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/

// Call external libraries
import java.io.Serializable;


public class cls_Idxper implements Serializable {
    //Declare local properties
    int cedula, posicion;

    //Create default constructor
    public cls_Idxper() {
    }

    //Create parametrized constructor
    public cls_Idxper(int cedula, int posicion) {
        this.cedula = cedula;
        this.posicion = posicion;
    }

    //Create all getter and setter functions
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}