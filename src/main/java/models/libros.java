
package models;

/**
 *
 * @author LUIS CARLOS LABORIN ALVAREZ
 */
public class libros {
   String name;
    int id;
    int precio; 

    public libros(String name, int id, int precio) {
        this.name = name;
        this.id = id;
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrecio() {
        return precio;
    }
    
    
}
