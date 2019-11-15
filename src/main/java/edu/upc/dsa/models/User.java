package edu.upc.dsa.models;
import java.util.LinkedList;
import java.util.List;
import java.text.CollationElementIterator;
import java.util.Collections;

public class User implements Comparable<User>{
    private String ID;
    private String name;
    private String surname;
    private List<Objecte> llistaObjectes;

    public String getID() {
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname() {
        return surname;
    }

    public List<Objecte> getListaObjectes() {

        return this.llistaObjectes;
    }

    public void addObjecte(Objecte obj) {

        this.llistaObjectes.add(obj);
    }

    public User(String num, String n,String s){
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
        return ("ID usuari: " + this.ID + " correspon a " + this.name +" " + this.surname);
    }

    public int getNumObjectes(){
        return llistaObjectes.size();
    }


    @Override
    public int compareTo(User u) {
        if (getName() == null || u.getName() == null) {
            return 0;
        }
        return getName().compareTo(u.getName());
    }

}
