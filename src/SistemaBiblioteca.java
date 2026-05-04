import java.util.*;

public class SistemaBiblioteca {

    private Map<String, Material> catalogo = new HashMap<>();
    private Map<String, List<String>> listaEspera = new HashMap<>();
    private Set<String> miembros = new HashSet<>();
    /*
En SistemaBiblioteca crea: Map catalogo = new HashMap<>(). Agrega un método
registrarMaterial(Material m) que use put() con el codigo como clave. Agrega
buscarMaterial(String codigo) que use get() y retorne el material o null.
     */
    public void registrarMaterial(Material m){
        catalogo.put(m.getCodigoMaterial(), m);
        System.out.println("Material registrado exitosamente!"+ m.getCodigoMaterial());
    }
    public Material buscarMaterial(String codigo){
        return catalogo.get(codigo);
    }

    /*
    Agrega un método mostrarCatalogo() que recorra el Map con entrySet() e imprima la info de
cada material.
     */
    public void mostrarCatalogo(){
        System.out.println("=========CATALOGO BIBLIOTECA============");
        for (Material material : catalogo.values()) {
            material.mostrarInfo();
            System.out.println("_________________________________");
        }
    }

    /*
    En SistemaBiblioteca crea: Map> listaEspera = new HashMap<>(). Agrega agregarEspera(String
codigoMaterial, String usuario): si el material no tiene lista aún, créala. Si ya existe, agrega el
usuario al final.
     */
    public void agregarEspera(String codigoMaterial, String usuario){

        if (!existeMaterial(codigoMaterial)){
            System.out.println("El material con codigo "+ codigoMaterial+ " no se encuentra disponible.");
        }else{
            if(listaEspera.containsKey(codigoMaterial)){
                listaEspera.get(codigoMaterial).add(usuario);
                System.out.println("Se agrega a la lista de espera.");
                mostrarLista(listaEspera.get(codigoMaterial));
            }else{
                listaEspera.put(codigoMaterial, new ArrayList<>(List.of(usuario)));
                System.out.println("lista creada para el codigo "+ codigoMaterial);
            }
        }
    }
    private void mostrarLista(List<String> t){
        System.out.println("===imprimiendo lista de espera===");
        for(String lista : t){
            System.out.println(lista);
        }
    }

    /*
    siguienteEnEspera(String codigoMaterial): retorna y elimina el primero
de la lista*/

    public void  siguienteEnEspera(String codigoMaterial){
        if (existeMaterial(codigoMaterial)){
            String primero = listaEspera.get(codigoMaterial).get(0);
            listaEspera.get(codigoMaterial).remove(0);
            System.out.println(" El usuario "+ primero+ " ha sido removido de la lista de espera.");
            System.out.println(listaEspera);
        }else{
            System.out.println("El codigo proporcionado no existe en el sistema.");
        }

    }

    /*
    En SistemaBiblioteca crea: Set miembros = new HashSet<>(). Agrega registrarMiembro(String
usuario): usa add() y retorna el boolean — true si era nuevo, false si ya existía. Agrega
tieneMembresía(String usuario): usa contains()
     */
    public boolean registrarMiembro(String usuario){
        if(miembros.contains(usuario)){
            return false;
        }else{
            return miembros.add(usuario);
        }
    }
    public String tieneMembresia(String usuario){
        if(miembros.contains(usuario)){
            return "El usuario " + usuario + " ya cuenta con membresia.";
        }else{
            return "El usuario " + usuario+ " no tiene membresia. ";
        }
    }

    //Metodo para conocer si un material está disponilble por codigo.
    private boolean existeMaterial(String codigo){
        boolean existeMaterial = catalogo.containsKey(codigo);
        return existeMaterial;
    }


}
