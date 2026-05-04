import java.util.HashMap;
import java.util.Map;

public abstract class Material{
    /*
    Todo material tiene: un código único (para identificarlo en el catálogo), un título, un año de
publicación y un estado de disponibilidad (si está prestado o no). Esos atributos no dependen del
tipo de material. Por eso van en la clase abstracta Material, que implementa Catalogable.
     */
    private String codigoMaterial;
    private String titulo;
    private int anio;
    private boolean disponibilidad;


    public Material() {
    }

    public Material(String codigo, String titulo, int anio, boolean disponibilidad) {
        this.codigoMaterial = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponibilidad = disponibilidad;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigo) {
        this.codigoMaterial = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public abstract String getTipo();


    public void mostrarInfo(){
        System.out.println("Tipo de material: "+ getTipo()+ "\ntitulo: " + titulo + "\nAño: "+ anio+ "\nDisponible: "+ disponibilidad);
    }


}
