package web;

import entites.Compte;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.CompteRepository;

@Component
@Path("/comptes")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;

    public CompteRestJaxRSAPI() {
    }

    @GET
    @Produces({"application/json"})
    public List<Compte> compteList() {
        return this.compteRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Compte getOne(@PathParam("id") Long id) {
        return (Compte)this.compteRepository.findById(id).orElse(null);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response save(Compte compte) {
        Compte createdCompte = (Compte)this.compteRepository.save(compte);
        return Response.status(Status.CREATED).entity(createdCompte).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(Compte compte, @PathParam("id") Long id) {
        Compte existingCompte = (Compte)this.compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDatecreation(compte.getDatecreation());
            existingCompte.setEtat(compte.getEtat());
            existingCompte.setType(compte.getType());
            this.compteRepository.save(existingCompte);
            return Response.ok(existingCompte).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces({"application/json"})
    public Response delete(@PathParam("id") Long id) {
        Compte existingCompte = (Compte)this.compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            this.compteRepository.deleteById(id);
            return Response.ok(existingCompte).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
