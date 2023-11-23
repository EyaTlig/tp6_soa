package repositories;

import entites.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// Annotation indicating that this class is a RestController, meaning it handles HTTP requests and returns JSON responses
@RestController
// Base mapping for all the endpoints in this controller. All endpoints in this class will start with "/api/comptes".
@RequestMapping("/api/comptes")
public class CompteController {
    // Auto-wired annotation to inject the CompteRepository dependency
    @Autowired
    private CompteRepository compteRepository;
    // GET all comptes
    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }
    // GET compte by ID
    // HTTP GET mapping to retrieve a compte by its ID.
    // Path variable {id} is used to extract the ID from the URL.
    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable Long id) {
        // Call the findById() method of CompteRepository to find a compte by its ID.
        // The orElse(null) returns null if the compte is not found.
        return compteRepository.findById(id).orElse(null);
    }
    // POST create new compte
    // HTTP POST mapping to create a new compte.
    // The @RequestBody annotation is used to deserialize the request body into a Compte object.
    @PostMapping
    public Compte createCompte(@RequestBody Compte compte) {
        // Call the save() method of CompteRepository to save the new compte to the database.
        return compteRepository.save(compte);
    }
    // PUT update existing compte
    // HTTP PUT mapping to update an existing compte by its ID.
    // The @RequestBody annotation is used to deserialize the request body into a Compte object.
    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte updatedCompte) {
        // Check if the compte with the given ID exists
        if (compteRepository.existsById(id)) {
            updatedCompte.setId(id);
            return compteRepository.save(updatedCompte);
        } else {
            return null; // Or handle the case where the compte doesn't exist
        }
    }
    // DELETE compte by ID
    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}