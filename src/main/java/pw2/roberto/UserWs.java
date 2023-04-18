package pw2.roberto;

import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pw2.roberto.model.User;

@Path("/user")
@Transactional
public class UserWs {

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@FormParam("name") String name) {

        User user = new User();

        user.setName(name);
        user.persist();

        return user;
    }
}