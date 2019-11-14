import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GestorPedidosTest {
    GestorPedidos gestor;


    @Before
    public void setUp() {
        this.gestor = new GestorPedidosImp();
        gestor.addProducto("CocaCola",2.3);
        gestor.addProducto("Barra Choco", 1.2);
        gestor.addProducto("Chapata",3.5);

        gestor.addUser("Toni","Garcia");
        gestor.addUser("Marc","Vila");
        gestor.addUser("Marina","Pujol");

    }

    @Test
    public void testEncolarPedido() throws QueueFullException, QueueEmptyException{
        Pedido p_1 = new Pedido ("Toni");
        p_1.addLP(3, "CocaCola");
        p_1.addLP(1, "Barra Choco");
        p_1.addLP(1, "Chapata");

        Pedido p_2 = new Pedido("Marc");
        p_2.addLP(2,"Barra Choco");
        p_2.addLP(5, "Chapata");

        gestor.encolarPedido(p_1);
        gestor.encolarPedido(p_2);
        gestor.servirPedido();
        gestor.servirPedido();


    }




}
