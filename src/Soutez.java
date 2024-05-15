import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Soutez {
    private String nazev;
    private Boolean dokocena;
    private static List<SoutezniPar> sezanamParu = new ArrayList<>();

    public Soutez(String nazev,List<SoutezniPar> sezanamParu){
        this.nazev = nazev;
        this.sezanamParu =sezanamParu;
        this.dokocena = null;
    }

    public Integer getStartovnoCelkem(){
        int starCelkem = 0;
        for(SoutezniPar soutezniPar : sezanamParu){
            starCelkem += soutezniPar.getStartovniCislo();
        }
        return starCelkem;
    }

    public Integer getSoucetDivokychKaret(){
        int soucetKaret = 0;
        soucetKaret += sezanamParu.size();
        return soucetKaret;
    }
}

