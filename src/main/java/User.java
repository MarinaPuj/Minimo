import java.util.LinkedList;
import java.util.List;

public class User{
    private int ID;
    private String name;
    private String surname;
    private List<Objecte> llistaObjectes;

    public List<Objecte> getListaObjectes() {

        return this.llistaObjectes;
    }

    public void addObjecte(Objecte obj) {

        this.llistaObjectes.add(obj);
    }

    public User(int num, String n,String s){
        this.ID=num;
        this.name = n;
        this.surname = s;
        llistaObjectes = new LinkedList<Objecte>();
    }
    public void modificarUsuari(String nom, String cognom){
        this.name=nom;
        this.surname=cognom;
    }

    public String getInfoUser (){
        return ("ID usuari: " + this.ID + "correspon a " + this.name +" " + this.surname);
    }

    public int getNumObjectes(){
        return llistaObjectes.size();
    }
    public String getName(){
        return this.name;
    }


}
