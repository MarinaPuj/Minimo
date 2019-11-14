import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;


public class GestorPedidosImp implements GestorPedidos{
    private Queue<Pedido> pedidos;
    private HashMap<String, User> users;
    private List<Producto> productos;

    private Logger logger = LogManager.getLogger(GestorPedidosImp.class);

    public GestorPedidosImp() {
       this.users = new HashMap<String, User>();
       this.productos = new LinkedList<Producto>();
       this.pedidos = new QueuesImpl<Pedido>(50);
    }

    public void encolarPedido(Pedido c) throws QueueFullException{
        pedidos.push(c); //Simplemente añadimos a la cola el pedido que realiza un usuarlio
        logger.info("Pedido de " + c.getUsuario() + " añadido");
    }

    public List<Pedido> pedidosUsuario(String iduser){
         User user =  users.get(iduser);
        return (user!=null? user.getListaPedidos(): null);
    }

    public List<Producto> productosordenadosventas(){
        return null;
    }

    public void servirPedido() throws QueueEmptyException {

        Pedido pedido = this.pedidos.pull();
        Producto p;

        for (Pedido.LP lp: pedido.getListaProductos()) {
            p = consultaProducto(lp.getProducto());
            if (p==null) logger.warn("Producte"+lp.getProducto()+" no exiteix");
            p.updateVenta(lp.getCantidad());
            pedido.updateLP(lp.getCantidad(),p.getPrecio());
        }

        User u = this.users.get(pedido.getUsuario());
        u.addPedido(pedido);
    }

    private Producto consultaProducto(String producto) {
        Producto p  = null;
        int i = 0;
        while ( i < this.productos.size()){

            if(this.productos.get(i).getID().equals(producto)){
                p = this.productos.get(i);
            }
            i++;
        }
        return p;
    }

    public List<Producto> productosordenadosPrecio(){
        return null;
    }

    public void addProducto(String n, double price){
        Producto newp = new Producto(n,price);
        this.productos.add(newp);
        logger.info("Nuevo Producto: " + n + " ($"+ price + ")");
    }

    public void addUser(String Nombre,String Apellido) {
        this.users.put(Nombre,new User(Nombre,Apellido));
        logger.info("Nuevo Usuario: "+ Nombre + " " + Apellido);

    }

    public List<Producto> getListaProductos(){
        return this.productos;
    }
}
