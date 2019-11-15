package edu.upc.dsa.services;

import edu.upc.dsa.models.Objecte;
import edu.upc.dsa.models.User;
import edu.upc.dsa.utils.GestorJuego;
import edu.upc.dsa.utils.GestorJuegoImp;
import edu.upc.dsa.utils.NoExisteixException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;


@Api(value = "/user", description = "Endpoint to Students Service")
@Path("/")
public class GameService{

    private GestorJuego gestor;

    public GameService(){
        this.gestor = GestorJuegoImp.getInstance();
        if(this.gestor.numUsuarisSistema() == 0){
            User a = new User("M","Marina","Pujol");
            User b = new User("22","Julia","Vendrell");
            User c = new User("4","Paula","Ferrate");
            User d = new User("10","Gemma","Esteve");
            this.gestor.addUser(a);
            this.gestor.addUser(b);
            this.gestor.addUser(c);
            this.gestor.addUser(d);
            gestor.addUserbyparameters("55","David","Puig");

            Objecte m = new Objecte("hola");
            Objecte n = new Objecte("que");
            Objecte w = new Objecte("tal");

            this.gestor.addObj("1",m);
            this.gestor.addObj("1",n);
            this.gestor.addObj("2",w);
        }
    }
    //User list sorted by name
    @GET
    @ApiOperation( value = "get all users", notes = "List of all users sorted by name")
    @ApiResponses({@ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List")})
    @Path("/User")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> usL = this.gestor.usuarisAlfabeticament();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(usL) {
        };
        return Response.status(201).entity(entity).build();
    }
//Add user by parameters or by an object user

    @POST //Add new user by parameters
    @ApiOperation(value = "add new user  by parameters", notes = "New user has been added")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/User/{id}/{name}/{surname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(@PathParam("id") String id, @PathParam("name") String name, @PathParam("surname") String surname) {

        if(id == null || name == null || surname == null){
            return Response.status(500).build();
        }
        else {
            this.gestor.addUserbyparameters(id,name,surname);
            User usuari = new User(id,name,surname);
            return Response.status(201).entity(usuari).build();
        }
    }

    @POST //Add new user
    @ApiOperation(value = "add new user", notes = "Yay! New user has been added")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/User")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUserP(User user) {

        if(user.getID() == null || user.getName() == null || user.getSurname() == null){
            return Response.status(500).build();
        }
        else {
            this.gestor.addUser(user);
            return Response.status(201).entity(user).build();
        }
    }



    //get info user from their id
    @GET //Get info of the user
    @ApiOperation(value = "get the info of the user", notes = "Getting the info of a user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objecte.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(@PathParam("id") String id) throws NoExisteixException {
        String key =this.gestor.getKKKHash("id");
        if(key==null){
            return Response.status(404).build();
        }
        else {
            User u = this.gestor.infoUserUser(key);
            return Response.status(201).entity(u).build();
        }
    }

    @GET //Get objects of the user
    @ApiOperation(value = "get the objects of the user", notes = "Get objects from user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objecte.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/Objectes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectsUser(@PathParam("id") String id) throws NoExisteixException {
            String key =this.gestor.getKKKHash("id");
            if(key==null){
                return Response.status(404).build();
            }
            else {
                List<Objecte> objectes = this.gestor.objecteUsuaro(key);
                GenericEntity<List<Objecte>> entity = new GenericEntity<List<Objecte>>(objectes) {
                };
                return Response.status(201).entity(entity).build();
            }
    }

    @PUT //add object to a user
    @ApiOperation(value = "add object to a user", notes = "Object added ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Objecte.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/Objectes")

    public Response addObj(@PathParam("id") String id,  Objecte obj) throws NoExisteixException {
        String key =this.gestor.getKKKHash("id");
        if(key==null){
            return Response.status(404).build();
        }
        else {
            User u =this.gestor.infoUserUser(key);
            gestor.addObj(key,obj);
            return Response.status(201).entity(u).build();
        }
    }

    //modify User
    @PUT
    @ApiOperation(value = "modify user information except their ID", notes = "user successfully updated")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/User/{id}/{name}/{surname}")

    public Response updateUser(@PathParam("id") String id, @PathParam("name") String name, @PathParam("surname") String surname) throws NoExisteixException {
        String key =this.gestor.getKKKHash("id");
        if(key==null){
            return Response.status(404).build();
        }
        else {
        User user = this.gestor.infoUserUser(key);
        //String i = user.getID();
        user.modificarUsuari(name,surname);
            return Response.status(201).entity(user).build();
        }
    }
}


