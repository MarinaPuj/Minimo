import java.util.List;

public interface GestorPedidos {
    public List<Producto> productosordenadosPrecio();
    public void encolarPedido(Pedido c) throws QueueFullException;
    public void servirPedido() throws QueueEmptyException;
    public List<Pedido> pedidosUsuario(String iduser);
    public List<Producto> productosordenadosventas();
    public void addProducto(String nombre, double price);
    public void addUser(String iduser,String Apellidos);
}
