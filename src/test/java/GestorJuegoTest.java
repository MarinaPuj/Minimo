import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GestorJuegoTest {

    GestorJuego gestor;


    @Before
    public void setUp() {
        this.gestor = new GestorJuegoImp();
        User a = new User(34,"Marina","Pujol");
        User b = new User(22,"Julia","Vendrell");
        User c = new User(4,"Paula","Ferrate");
        User d = new User(10,"Gemma","Esteve");
        gestor.addUser(a);
        gestor.addUser(b);
        gestor.addUser(c);
        gestor.addUser(d);

        Objecte m = new Objecte("hola");
        Objecte n = new Objecte("que");
        Objecte w = new Objecte("tal");

    }

    @Test
    public void testUser()  throws NoExisteixException{
        User e = new User(15,"Marc","Esteve");
        gestor.addUser(e);
        gestor.modificarUsuari("2","M","P");
        int a = gestor.numUsuarisSistema();
        Assert.assertEquals("Usuari", a,5,0);
    //    gestor.usuarisAlfabeticament();
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
    public void afegirobjecte() {
        Objecte m = new Objecte("hola");
        Objecte n = new Objecte("que");
        Objecte w = new Objecte("tal");

        gestor.addObj("1",m);
        gestor.addObj("1",n);
        gestor.addObj("1",w);

        gestor.objecteUsuaro("1");
        gestor.nomObjecteUsuaro("1");
        gestor.numObjUsuari("1");

    }

}


//Assert.assertEquals("Figuras", 72, array[3].getArea(),0.15);