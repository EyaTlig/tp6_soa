package repositories;

import entites.Compte;
import entites.etatCompte;
import entites.typecompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

// Example:
@SpringBootApplication
@EntityScan(basePackages = "entites")
public class SpringBoot {
    //

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot.class, args);
    }

    @Bean
    public CommandLineRunner demo(CompteRepository compteRepository) {
        return (args) -> {
            Compte compte1 = new Compte();
            compte1.setSolde(1000.0);
            compte1.setDatecreation("20/11/1997");
            compte1.setType(typecompte.Epargne);
            compte1.setEtat(etatCompte.ACTIVE);

            Compte compte2 = new Compte();
            compte2.setSolde(1500.0);
            compte2.setDatecreation("23/11/2021");
            compte2.setType(typecompte.Epargne);
            compte2.setEtat(etatCompte.ACTIVE);

            Compte compte3 = new Compte();
            compte3.setSolde(2000.0);
            compte3.setDatecreation("06/12/2010");
            compte3.setType(typecompte.Courant);
            compte3.setEtat(etatCompte.BLOQUE);
            compteRepository.saveAll(Arrays.asList(compte1, compte2, compte3));


            Iterable<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Solde du compte " + compte.getId() + ": " + compte.getSolde());
            }
        };
    }
}
