import java.math.BigDecimal;
import java.time.LocalDate;

public class SoutezniPar {
    private String jmeno;
    private Integer startovniCislo;
    private BigDecimal cennovyUdaj;
    private LocalDate datum;
    private Boolean divokaKarta;

    public SoutezniPar(Integer startovniCislo, String jmeno, BigDecimal cennovyUdaj, LocalDate datum,Boolean divokaKarta) {
        this.jmeno = jmeno;
        this.startovniCislo = startovniCislo;
        this.cennovyUdaj = cennovyUdaj;
        this.datum = datum;
        this.divokaKarta = divokaKarta;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Integer getStartovniCislo() {
        return startovniCislo;
    }

    public BigDecimal getCennovyUdaj() {
        return cennovyUdaj;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Boolean getDivokaKarta() {
        return divokaKarta;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setStartovniCislo(Integer startovniCislo) {
        this.startovniCislo = startovniCislo;
    }

    public void setCennovyUdaj(BigDecimal cennovyUdaj) {
        this.cennovyUdaj = cennovyUdaj;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setDivokaKarta(Boolean divokaKarta) {
        this.divokaKarta = divokaKarta;
    }
}
