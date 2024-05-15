import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainForm extends  JFrame{
    private JTable table1;
    private JTextField tfPocetParu;
    private JCheckBox checkBox1;
    private JPanel panoelMain;
    private List<SoutezniPar> sezanamParu = new ArrayList<>();
    private File slectedFile;

    public MainForm(){
        setContentPane(panoelMain);
        setTitle("Taneční soutěž Doležal Václav");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);

        initMenu();
        display();

        TabulkaModel tabulkaModel = new TabulkaModel();
        table1.setModel(tabulkaModel);

    }

    public void initMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu soutez = new JMenu("Soutěž");
        menuBar.add(soutez);

        JMenuItem nacti =  new JMenuItem("Načti");
        soutez.add(nacti);
        nacti.addActionListener(e ->{vyberSoubor();});

        JMenuItem ukonci = new JMenuItem("Ukonči");
        soutez.add(ukonci);

        JMenuItem statistika = new JMenuItem("Statistiky");
        soutez.add(statistika);
        statistika.addActionListener(e->{vytvorStatistika();});
    }

    public void display(){
        tfPocetParu.setText(String.valueOf(sezanamParu.size()));
        //checkBox1.setSelected();

    }
    public void vyberSoubor(){
        JFileChooser fc = new JFileChooser(".");
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            slectedFile = fc.getSelectedFile();
            nactiSoubor(slectedFile);
        }
    }

    public void nactiSoubor(File slectedFile){
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(slectedFile)))){
            while(sc.hasNextLine()){
                String radek = sc.nextLine();
                String[] rozdelovac = radek.split(":");
                Integer startovaciCislo = Integer.parseInt(rozdelovac[0]);
                String jmeno = rozdelovac[1];
                BigDecimal startovne = BigDecimal.valueOf(Long.parseLong(rozdelovac[2]));
                LocalDate datum = LocalDate.parse(rozdelovac[3]);
                Boolean divokaKarta = Boolean.parseBoolean(rozdelovac[4]);

                if(divokaKarta == true){
                    divokaKarta = equals("x");
                } else {
                    divokaKarta = false;
                }

                SoutezniPar soutezniPar = new SoutezniPar(startovaciCislo,jmeno,startovne,datum,divokaKarta);
                sezanamParu.add(soutezniPar);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor: " + slectedFile + "nebyl nalezen" + e.getLocalizedMessage());
        }
    }
    public void vytvorStatistika(){
        JOptionPane.showMessageDialog(this,"1. Stravovné celkem: "  + "\n" +
        "2. Počet divokých karet: " );
    }
}
