package pl.pjatk.lightingservice.model;

public class Kurs {

    private Long id;
    private String kurs;

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