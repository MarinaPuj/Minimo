package edu.upc.dsa.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Objecte;
import java.util.*;
import java.text.CollationElementIterator;
import java.util.Collections;

public class GestorJuegoImp implements GestorJuego {
    private HashMap<String, User> mapausers;
   // private List<Objecte> ob;
    private int kkk=1;
    private static GestorJuego gj= new GestorJuegoImp();

    private Logger logger = LogManager.getLogger(GestorJuegoImp.class);

    public static GestorJuego getInstance() {
        if (gj==null) gj = new GestorJuegoImp();
        return gj;
    }

    public GestorJuegoImp() {
       this.mapausers = new HashMap<String, User>();
    //   this.ob = new LinkedList<Objecte>();
    }

    public List<User> usuarisAlfabeticament() {
        List<User> usL = new LinkedList<User>(this.mapausers.values());
        Collections.sort(usL);
        for(int i=0; i<usL.size();i++)
        logger.info(usL.get(i).getName());
        /* Collections.sort(us, new Comparator<User>() {
           // @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/
        return usL;
    }


    public void addUser(User c) {
        this.mapausers.put(String.valueOf(kkk), c);
        logger.info("Nou Usuari numero: "+ kkk +". "+ c.getInfoUser());
        kkk++;

    }

    @Override
    public void addUserbyparameters(String id, String n, String sn) {
        User c = new User(id,n,sn);
        this.mapausers.put(String.valueOf(kkk),c);
        logger.info("Nou Usuari numero: "+ kkk +". "+ c.getInfoUser());
        kkk++;
    }

    public void modificarUsuari(String k, String nom, String cognom) throws NoExisteixException{
        if(Integer.valueOf(k)>kkk){throw new NoExisteixException();}
        this.mapausers.get(k).modificarUsuari(nom, cognom);
        logger.info("Usuari numero: "+ k +" modificat. "+this.mapausers.get(k).getInfoUser());
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

    @Override
    public User infoUserUser(String key) {
        return this.mapausers.get(key);
    }

    public void addObj(String key, Objecte o) {
        logger.info("Nou objecte "+o.getNom()+" afegit al usuari numero " + key +". "+this.mapausers.get(key).getInfoUser());
        this.mapausers.get(key).addObjecte(o);

    }

    public List<Objecte> objecteUsuaro(String key) {
        logger.info(this.mapausers.get(key).getListaObjectes());
        return this.mapausers.get(key).getListaObjectes();
    }
/*
    @Override
    public List<Objecte> objecteUsuariId(String id) {
        String keyhash = this.getKeyHash(id);
        return this.mapausers.get(keyhash).getListaObjectes();
    }
    */

    public String getKKKHash(String idusuari) throws NoExisteixException
    {
        int a = 0;
        for(int i = 1; i<=this.mapausers.size();i++){
            if(this.mapausers.get(String.valueOf(i)).getID().equals(idusuari)){
                 a=i;
            }
         }

        if(a==0){
            throw new NoExisteixException();
        }
        logger.info("La key de l'ID: "+ idusuari +" es:"+String.valueOf(a));
        return String.valueOf(a);
    }

    public String nomObjecteUsuaro(String key) {
        //logger.info(this.mapausers.get(key).getListaObjectes());
        List<Objecte> lli = this.mapausers.get(key).getListaObjectes();
        String a =" ";
        int i;
        for (i=0; i < lli.size()-1; i++) {
            a += lli.get(i).getNom() + ", ";
        }
        a += lli.get(i).getNom();
        logger.info(a);
        return a;
    }



    public int numObjUsuari(String key) {
        int total=this.mapausers.get(key).getNumObjectes();
        logger.info("Usuari numero; " + key + ". " + this.mapausers.get(key).getInfoUser() + " TotalObjectes:"+total);
        return total ;
    }


    //@Override
    public void clear() {
        gj = null;
        this.mapausers.clear();
        logger.info("Closing..........");
    }

}
