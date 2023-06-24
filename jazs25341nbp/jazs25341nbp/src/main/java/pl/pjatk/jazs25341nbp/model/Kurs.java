package pl.pjatk.jazs25341nbp.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@NamedQuery(name = "Kurs.findByName", query = "SELECT m FROM Kurs m WHERE m.kurs = :kurs")
@NamedQuery(name = "Kurs.findByWaluta", query = "SELECT m FROM Kurs m WHERE m.waluta = :waluta")
public class Kurs {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kurs;

    @Enumerated(EnumType.STRING)
    private Waluta waluta;

    public Kurs() {
    }

    public Kurs(Long id, String kurs, Waluta waluta) {
        this.id = id;
        this.kurs = kurs;
        this.waluta = waluta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public Waluta getWaluta() {
        return waluta;
    }

    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }
}
