package postava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SeznamNepratel {

    ArrayList<Postava> nepratele = new ArrayList<>();

    public ArrayList<Postava> getNepratele() {
        return nepratele;
    }
    public void setNepratele(ArrayList<Postava> hrdinove) {
        this.nepratele = hrdinove;
    }

    public void pridejCsv(Postava o){
        nepratele.add(o);
    }

    public void pridej(int trida, String jmeno, int level, int sila, int inteligence, int obratnost, int odolnost, int expy, IRasa rasa, int zivoty,int skillpoint){
        switch(trida){
            case 1: nepratele.add(new Valecnik(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));
            case 2: nepratele.add(new Mag(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));
            case 3: nepratele.add(new Pruzkumnik(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));

        }
    }

    public static SeznamNepratel nacti(String jmenoSlozky) throws Exception{
        SeznamNepratel snp = new SeznamNepratel();
        try(BufferedReader br = new BufferedReader(new FileReader(jmenoSlozky))){
            String radek = null;
            while((radek = br.readLine())!=null){
                Postava o = Postava.zCsv(radek);
                snp.pridejCsv(o);
            }
        }catch(Exception e){
            throw e;
        }
        return snp;
    }

}

