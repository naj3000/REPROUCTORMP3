package reproductor_de_musica;

public class nodo {
    
    String nombre, direccion;//Se definen dos variables de tipo String para almacenar el nombre y la dirección de la canción.
    nodo siguiente, anterior;//para almacenar los punteros al siguiente y al anterior nodo en la lista

    public nodo(String nombre, String direccion) {//aca el constructor recibe los dos parametos
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
