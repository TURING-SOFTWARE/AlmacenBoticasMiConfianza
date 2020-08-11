package entidades;

public class Laboratorio {
    int id_laboratorio;
    String nombre_laboratorio;

    public Laboratorio(int id_laboratorio, String nombre_laboratorio) {
        this.id_laboratorio = id_laboratorio;
        this.nombre_laboratorio = nombre_laboratorio;
    }


    public int getId_laboratorio() {
        return this.id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombre_laboratorio() {
        return this.nombre_laboratorio;
    }

    public void setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
    }

    @Override
    public String toString(){
        return nombre_laboratorio.toString();
    }

}
