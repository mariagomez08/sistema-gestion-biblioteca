import java.sql.SQLOutput;

public class Revista extends Material implements Catalogable{
    private int edicion;
    private String tematica;

    public Revista() {
    }

    public Revista(int edicion, String tematica) {
        this.edicion = edicion;
        this.tematica = tematica;
    }

    public Revista(String codigo, String titulo, int anio, boolean disponibilidad, int edicion, String tematica) {
        super(codigo, titulo, anio, disponibilidad);
        this.edicion = edicion;
        this.tematica = tematica;
    }

    public Revista(String codigo, String titulo, int anio, boolean disponibilidad) {
        super(codigo, titulo, anio, disponibilidad);
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String getCodigo(){
        if(isDisponibilidad()){
            return getCodigoMaterial();
        }else{
            return "El material no existe";
        }
    }





    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.print("Edicion: "+ edicion + "\nTematica: "+ tematica+"\n");
    }
}
