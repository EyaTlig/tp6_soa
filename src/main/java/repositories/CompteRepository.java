package repositories;

import entites.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// CompteRepository.java
@EnableJpaRepositories("repositories.package")

public interface CompteRepository extends JpaRepository<Compte, Long> {
}