import java.util.List;
import java.util.HashMap; // import the HashMap class

public interface GestorJuego {
    public List<User> usuarisAlfabeticament();
    public void addUser(User c);
    public void modificarUsuari(String k, String nom, String cognom) throws NoExisteixException;
    public int numUsuarisSistema ();
    public String infoUser(String key);
    public void addObj(String key, Objecte o);
    public List<Objecte> objecteUsuaro (String key);
    public String nomObjecteUsuaro(String key);
    public int numObjUsuari(String key);


}


       // HashMap<String, String> capitalCities = new HashMap<String, String>();
/*
    Map<String, Usuario> mapaDeUsuarios = new HashMap<>();
    mapaDeUsuarios.put("1", new Usuario("maljonas", "1234"));
            mapaDeUsuarios.put("2", new Usuario("lopez", "12345"));

            Usuario usuario2 = mapaDeUsuarios.get("2");
            System.out.println(usuario2.getUsuario());

 */