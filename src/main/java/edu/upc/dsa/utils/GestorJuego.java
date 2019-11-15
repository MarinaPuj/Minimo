package edu.upc.dsa.utils;
import java.util.List;
import java.util.HashMap; // import the HashMap class
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Objecte;

public interface GestorJuego {
    public List<User> usuarisAlfabeticament();

    public void addUser(User c);
    public void addUserbyparameters (String id, String n, String sn);
    public void modificarUsuari(String k, String nom, String cognom) throws NoExisteixException;
    public int numUsuarisSistema ();
    public String infoUser(String key);
    public User infoUserUser(String key);

    public void addObj(String key, Objecte o);
    public List<Objecte> objecteUsuaro (String key);  //Llista objectes per key del hashmap
    public String getKKKHash(String idusuari) throws NoExisteixException; //get key hash map from id user;
    public String nomObjecteUsuaro(String key);  //Nom dels objectes per key del hashmap

    public int numObjUsuari(String key);

    public void clear();
}
