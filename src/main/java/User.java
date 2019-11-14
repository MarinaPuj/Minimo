import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private List<Pedido> pedidoList;

    public List<Pedido> getListaPedidos() {
        return this.pedidoList;
    }

    public void addPedido(Pedido pedido) {
        this.pedidoList.add(pedido);
    }

    public User(String n,String s){
        this.name = n;
        this.surname = s;
        pedidoList = new LinkedList<Pedido>();
    }
}
