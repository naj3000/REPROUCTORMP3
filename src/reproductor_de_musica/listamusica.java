package reproductor_de_musica;

public class listamusica {//para crear y manipular una lista enlazada de canciones de música

    nodo first;//Esta variable se utiliza para almacenar el primer nodo de la lista enlazada.
    nodo last;//Esta variable se utiliza para almacenar el último nodo de la lista enlazada.
    int tam;//utiliza para almacenar el tamaño actual de la lista enlazada

    public listamusica() {
        first = last = null;//las ponemos nulas
        tam = 0;
    }

    public boolean IsEmpety() {//que se utiliza para verificar si la lista enlazada está vacía
        return first == null;///devuelve null si esta vacia
    }

    public void clear() {//ue se utiliza para borrar todos los nodos de la lista enlazada
        while (!IsEmpety()) {
            borrar(first);
        }
    }

    public void insertar(String nom, String dir) {//Declaración del método "insertar" que se utiliza para insertar un nuevo nodo en la lista enlazada
        nodo nuevo = new nodo(nom, dir);//Crea un nuevo nodo utilizando el constructor de la clase "nodo" y asigna el nombre y la dirección de la canción al nodo
        if (IsEmpety()) {//siempre confirma si esta vacia
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.anterior = last;//Asigna el nuevo nodo como el primer nodo de la lista enlazada
            last.siguiente = nuevo;//Asigna el nuevo nodo como el ultimo nodo de la lista enlazada
            last = nuevo;
        }
        tam++;
    }

    public int index(nodo b) {// es un método que recibe un nodo como argumento y devuelve el índice de ese nodo dentro de la lista
        nodo aux = first;//comenzando comparando desde el primer nodo
        int con = 0;

        while (aux != null) {//recorre todos los nodos, comparando cada nodo con el nodo de entrada. Si encuentra el nodo de entrada, devuelve el índice de ese nodo en la lista. Si no encuentra el nodo, devuelve -1.
            if (aux == b) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }
    
    public nodo get_cancion(int index){//un método que recibe un índice como argumento y devuelve el nodo correspondiente a ese índice
        if (index < 0 || index >= tam) {//si esta dentro del rango
            return null;
        }
        
        int n = 0;
        nodo aux = first;//Si el índice es válido, comienza desde el primer nodo de la lista y recorre los nodos hasta llegar al índice deseado, y devuelve ese nodo
        while (n != index) {            
            aux = aux.siguiente;
            n++;
        }
        
        return aux;
    }

    public void borrar(nodo b) {
        if (b == first) {
            if (tam == 1) {
                first = null;
                tam--;
                return;
            }
            first.siguiente.anterior = null;
            first = first.siguiente;
            tam--;
            return;
        }
        tam--;
        if (b == last) {
            last.anterior.siguiente = null;
            last = last.anterior;
            return;
        }
        b.siguiente.anterior = b.anterior;
        b.siguiente.anterior.siguiente = b.siguiente;
    }
    
    public boolean buscar(String nombre, String ruta){//esta parte busca la ruta del archivo o el tipo de documento
        nodo aux = first;

        while (aux != null) {
            if (aux.nombre.equals(nombre) && aux.direccion.equals(ruta)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
        //Comienza desde el primer nodo de la lista y recorre todos los nodos, 
        //comparando cada nodo con los valores dados. Si encuentra un nodo que coincide con los valores, devuelve true. Si no encuentra un nodo que coincida, devuelve false
    }
}
