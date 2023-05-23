
package postava;

        import java.io.*;
        import java.util.ArrayList;

public class SeznamHrdinu {
    ArrayList<Postava> hrdinove = new ArrayList<>();

    public ArrayList<Postava> getHrdinove() {
        return hrdinove;
    }
    public void setHrdinove(ArrayList<Postava> hrdinove) {
        this.hrdinove = hrdinove;
    }
    public void pridejCsv(Postava o){
        hrdinove.add(o);
    }

    public void pridej(int trida, String jmeno, int level, int sila, int inteligence, int obratnost, int odolnost, int expy, IRasa rasa, int zivoty,int skillpoint){
        switch(trida){
            case 1: hrdinove.add(new Valecnik(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));
            case 2: hrdinove.add(new Mag(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));
            case 3: hrdinove.add(new Pruzkumnik(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint));

        }
    }
    public static SeznamHrdinu nacti(String jmenoSlozky) throws Exception{

        SeznamHrdinu sh = new SeznamHrdinu();

        try(BufferedReader br = new BufferedReader(new FileReader(jmenoSlozky))){
            String radek = null;
            while((radek = br.readLine())!=null){
                Postava o = Postava.zCsv(radek);
                sh.pridejCsv(o);
            }
        }catch(Exception e){
            throw e;
        }
        return sh;
    }

}