public class Libro extends Material implements Catalogable {
    private String autor;
    private String ISBN;

    public Libro() {
    }

    public Libro(String autor, String ISBN) {
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public Libro(String codigo, String titulo, int anio, boolean disponibilidad, String autor, String ISBN) {
        super(codigo, titulo, anio, disponibilidad);
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String getTipo() {
        return "Libro";
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
        System.out.print("Autor: "+ autor + "\nISBN: "+ ISBN+"\n");
    }
}
