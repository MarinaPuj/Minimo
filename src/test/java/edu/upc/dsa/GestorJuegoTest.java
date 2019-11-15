package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.utils.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GestorJuegoTest {

    GestorJuego gestor;

    @Before
    public void setUp() {
        gestor = GestorJuegoImp.getInstance();
        this.gestor = new GestorJuegoImp();
        User a = new User("M","Marina","Pujol");
        User b = new User("22","Julia","Vendrell");
        User c = new User("P","Paula","Ferrate");
        User d = new User("10","Gemma","Esteve");
        this.gestor.addUser(a);
        this.gestor.addUser(b);
        this.gestor.addUser(c);
        this.gestor.addUser(d);
        gestor.addUserbyparameters("55","David","Puig");

        Objecte m = new Objecte("hola");
        Objecte n = new Objecte("que");
        Objecte w = new Objecte("tal");

    }

    @Test
    public void testUser()  throws NoExisteixException{
        User e = new User("15","Marc","Esteve");
        gestor.addUser(e);
        gestor.modificarUsuari("2","Albert","Prius");
        int a = gestor.numUsuarisSistema();
        Assert.assertEquals("Usuari", a,6,0);
        gestor.usuarisAlfabeticament();
    }
/*
    @Test
    public void testModifyUser() throws NoExisteixException {
        gestor.modificarUsuari("2","M","P");
    }
    @Test
    public void numUsuaris() {
        int a = gestor.numUsuarisSistema();
        Assert.assertEquals("Usuari", a,4,0);
    }
    @Test
    public void infoUsu() {
        String a = gestor.infoUser("1");
    }

 */
    @Test
    public void afegirobjecte() throws NoExisteixException
    {
        Objecte m = new Objecte("hola");
        Objecte n = new Objecte("que");
        Objecte w = new Objecte("tal");

        gestor.addObj("1",m);
        gestor.addObj("1",n);
        gestor.addObj("2",w);

        gestor.objecteUsuaro("1");
        String key=gestor.getKKKHash("22");
        Assert.assertEquals("Get key de la id de l'user", Integer.valueOf("2"), Integer.valueOf(key),0);

        gestor.objecteUsuaro(key);
        gestor.nomObjecteUsuaro(key);
        gestor.nomObjecteUsuaro("1");
        gestor.numObjUsuari("1");
        Assert.assertEquals("NumObjectes", 2, gestor.numObjUsuari("1"),0);
    }

    @After
    public void tearDown(){
        this.gestor.clear();
    }

}


//Assert.assertEquals("Figuras", 72, array[3].getArea(),0.15);