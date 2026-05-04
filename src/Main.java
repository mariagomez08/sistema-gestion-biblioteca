import java.sql.SQLOutput;

public class Main {
    static void main(String[] args) {

        //1.  HashMap — catálogo
        //Crea al menos 2 libros y 2 revistas. Regístralos en el catálogo. Busca uno por código y muestra su info.
        //Intenta buscar un código inexistente — verifica que no explota.

        Material libro1 = new Libro("L01", "Orgullo y prejuicio",1800,true, "Jane Austen", "9788484284888");
        Material libro2 = new Libro("L02", "El tunel",1950,true, "Ernesto sabato", "9788484284889");
        Material libro3 = new Libro("L02", "El tunel",1980,true, "Ernesto sabato", "9788484284889");

        Material revista1 = new Revista("R01", "Semana",2026,true, 3, "Social");
        Material revista2 = new Revista("R02", "Tv novelas",2026,true, 4, "chismes");

        SistemaBiblioteca sistema = new SistemaBiblioteca();

        System.out.println("====== MATERIALES REGISTRADOS=========");
        sistema.registrarMaterial(libro1);
        sistema.registrarMaterial(libro2);
        sistema.registrarMaterial(libro3);
        sistema.registrarMaterial(revista1);
        sistema.registrarMaterial(revista2);
        System.out.println();
        System.out.println("====== INFORMACION MATERIALES REGISTRADOS=========");
        libro1.mostrarInfo();
        libro2.mostrarInfo();
        revista1.mostrarInfo();
        revista2.mostrarInfo();

        System.out.println("=========CODIGO INEXISTENTE==========");
        //Codigo inexistente
        System.out.println("El codigo no existe en el sistema: " +sistema.buscarMaterial("L03"));

        /*
        ArrayList — lista de espera
        Marca un material como no disponible (prestado). Agrega 3 usuarios a su lista de espera en orden.
        Llama siguienteEnEspera() dos veces — verifica que salen en el orden correcto.*/
        System.out.println("===========MATERIAL NO DISPONIBLE=======");
        libro1.setDisponibilidad(false);
        sistema.agregarEspera("L01", "Maria");
        sistema.agregarEspera("L01", "Pablo");
        sistema.agregarEspera("L01", "Jorge");

        sistema.siguienteEnEspera("L01");
        sistema.siguienteEnEspera("L01");


        /*
        HashSet — membresías
Registra 3 usuarios como miembros. Intenta registrar el mismo usuario dos veces — verifica que
registrarMiembro() retorna false. Verifica la membresía de un usuario registrado y de uno que no existe.
         */
        System.out.println(sistema.registrarMiembro("Julian"));
        System.out.println(sistema.registrarMiembro("Julian"));
        System.out.println(sistema.registrarMiembro("Marta"));

        System.out.println(sistema.tieneMembresia("Julian"));
        System.out.println(sistema.tieneMembresia("Marcela"));

        /*
        Polimorfismo
Llama mostrarCatalogo() — verifica que cada material muestra su tipo correcto (Libro o Revista) sin un if
en el código de mostrarCatalogo().
■ ¿Qué acaba de pasar en mostrarCatalogo()?
Recorriste un Map donde los objetos son Libro y Revista. Llamaste mostrarInfo() sobre cada uno.
mostrarInfo() llama getTipo() — que es abstracto en Material. En runtime, Java supo que este objeto es
un Libro y llamó su ge
         */


        sistema.mostrarCatalogo();

    }
}
