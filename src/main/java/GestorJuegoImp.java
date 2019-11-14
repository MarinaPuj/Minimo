import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;


public class GestorJuegoImp implements GestorJuego {
    private HashMap<String, User> mapausers;
   // private List<Objecte> ob;
    private int kkk=1;

    private Logger logger = LogManager.getLogger(GestorJuegoImp.class);

    public GestorJuegoImp() {
       this.mapausers = new HashMap<String, User>();
    //   this.ob = new LinkedList<Objecte>();
    }

    public List<User> usuarisAlfabeticament() {
        List<User> us = new ArrayList<User>();
        for (int i = 0; i <= this.mapausers.size(); i++)
            us.add(this.mapausers.get(i));
        us.sort(Comparator.comparing(User::getName));
        // Collections.sort(us, (o1, o2) -> o1.getName().compareTo(o2.getName()));
      /*  Collections.sort(us, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/
        return us;
    }
    /*
    Iterator itList=us.iterator();

    //imprime la lista sin ordenar
        while (itList.hasNext()) {
        User elementoLista=(User) itList.next();
       // System.out.println(elementoLista.getNombre()+" "+elementoLista.getEdad()+" "+elementoLista.getDomicilio());
    }
    class UserComparator implements Comparator<User> {
        private boolean asc;
        UserComparator(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(User o1, User o2) {
            int ret;
            if (asc) {
                ret = o1.getName().compareTo(o2.getName());
            } else {
                ret = o2.getName().compareTo(o1.getName());
            }
            return ret;
        }
    }

     */


    public void addUser(User c) {
        this.mapausers.put(String.valueOf(kkk), c);
        logger.info("Nou Usuari numero: "+ kkk );
        kkk++;

    }

    public void modificarUsuari(String k, String nom, String cognom) throws NoExisteixException{
        if(Integer.valueOf(k)>kkk){throw new NoExisteixException();}
        this.mapausers.get(k).modificarUsuari(nom, cognom);
        logger.info("Usuari numero: "+ k +" modificat. Nom: " + nom + "Cognom: "+ cognom);
    }

    public int numUsuarisSistema() {
        int numTot=this.mapausers.size();
        logger.info("Numero total usuaris: "+ numTot) ;
        return numTot;
    }

    public String infoUser(String key) {
        String info= this.mapausers.get(key).getInfoUser();
        logger.info(info) ;
        return info;
    }

    public void addObj(String key, Objecte o) {
        logger.info("Nou objecte afegit al usuari numero " + key);
        this.mapausers.get(key).addObjecte(o);
    }

    public List<Objecte> objecteUsuaro(String key) {
        logger.info(this.mapausers.get(key).getListaObjectes());

        return this.mapausers.get(key).getListaObjectes();
    }

    public String nomObjecteUsuaro(String key) {
        logger.info(this.mapausers.get(key).getListaObjectes());
        List<Objecte> lli = this.mapausers.get(key).getListaObjectes();
        String a =" ";
        int i;
        for (i=0; i < lli.size(); i++) {
            a += lli.get(i).getNom() + ", ";
        }
   //     a.substring(0,i-1);
        logger.info(a);
        return a;
    }

    public int numObjUsuari(String key) {
        int total=this.mapausers.get(key).getNumObjectes();
        logger.info("Usuari numero; " + key + " TotalObjectes:"+total);
        return total ;
    }

}
