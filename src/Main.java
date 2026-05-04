

public class Main {
    static void main(String[] args) {
        Material libro1 = new Libro("L01", "Orgullo y prejuicio",1800,true, "Jane Austen", "9788484284888");
        System.out.println(libro1.getTipo());
        libro1.mostrarInfo();

        Material revista = new Revista("R01", "Semana",2026,true, 3, "Social");
        System.out.println(revista.getTipo());
        revista.mostrarInfo();

        SistemaBiblioteca sistema = new SistemaBiblioteca();
        sistema.registrarMaterial(libro1);
        sistema.registrarMaterial(revista);
        System.out.println(sistema.buscarMaterial("L02"));

        sistema.mostrarCatalogo();

        sistema.agregarEspera("L01", "Maria");
        sistema.agregarEspera("L01", "Pablo");
        sistema.agregarEspera("R01", "Jorge");

        sistema.siguienteEnEspera("L01");


        /*
        En SistemaBiblioteca crea: Map catalogo = new HashMap<>(). Agrega un método
registrarMaterial(Material m) que use put() con el codigo como clave. Agrega
buscarMaterial(String codigo) que use get() y retorne el material o null.
         */

    }
}
