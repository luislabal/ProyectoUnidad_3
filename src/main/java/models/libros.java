
package models;

/**
 *
 * @author LUIS CARLOS LABORIN ALVAREZ
 */
public class libros {
    String name;
    int id;
    int precio;
    String foto;

    public libros(String name, int id, int precio, String foto) {
        this.name = name;
        this.id = id;
        this.precio = precio;
        this.foto = foto;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getPrecio() { return precio; }
    public String getFoto() { return foto; }
}
