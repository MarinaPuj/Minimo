import java.util.LinkedList;
import java.util.List;


public class Pedido {
    String usuario;
    List<LP> lps; //Lista con las unidades por productos
    double precioT;

    public double getPrecioT() {
        return precioT;
    }

    public List<LP> getListaProductos() {
        return lps;
    }

    public String getUsuario() {
        return usuario;
    }

    public Pedido(String nombre){

        this.lps = new LinkedList<LP>();
        this.precioT = 0;
        this.usuario = nombre;
    }

    public void updateLP(int cantidad, double precio){
        this.precioT +=cantidad*precio;
    }

    public void addLP(int q,String p){
        LP lp = new LP(q, p);
        lps.add(lp);
    }



    public class LP {
        private int q;
        private String producte; // Producte p;

        public String getProducto() {
            return this.producte;
        }

        public int getCantidad() {
            return this.q;
        }

        public  LP(int qu, String pro){
            this.q = qu;
            this.producte = pro;
        }
    }
}
