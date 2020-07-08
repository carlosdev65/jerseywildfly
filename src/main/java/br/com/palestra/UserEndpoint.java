package br.com.palestra;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("user")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class UserEndpoint {

    @Inject UserRepository userRepository;

    @GET
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GET
    public User getUser(@QueryParam("id") Long id) {
        return userRepository.findUserById(id);
    }    

    @POST
    public Response create(User user) {
        userRepository.createUser(user);
        return Response.status(201).build();
    }

    @PUT
    public Response update(@QueryParam("id") Long id, @QueryParam("nome") String nome, @QueryParam("email") String email) {
        userRepository.updateUser(id,nome,email);
        return Response.status(204).build();
    }
    @DELETE
    public Response delete(@QueryParam("id") Long userId) {
        userRepository.deleteUser(userId);
        return Response.status(204).build();
    }    


}