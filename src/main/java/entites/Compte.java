package entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Compte {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  double solde;
    private  String datecreation ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public typecompte getType() {
        return type;
    }

    public void setType(typecompte type) {
        this.type = type;
    }

    public etatCompte getEtat() {
        return etat;
    }

    public void setEtat(etatCompte etat) {
        this.etat = etat;
    }

    private  typecompte type;
    private etatCompte etat;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", datecreation='" + datecreation + '\'' +
                ", type=" + type +
                ", etat=" + etat +
                '}';
    }


}
