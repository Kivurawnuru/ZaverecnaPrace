package character;

import character.profession.Mage;
import character.profession.Monk;
import character.profession.Scout;
import character.profession.Warrior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EnemyArrayList {

    ArrayList<Character> nepratele = new ArrayList<>();

    public ArrayList<Character> getNepratele() {
        return nepratele;
    }
    public void setNepratele(ArrayList<Character> hrdinove) {
        this.nepratele = hrdinove;
    }

    public void pridejCsv(Character o){
        nepratele.add(o);
    }

    public void pridej(int trida, String jmeno, int level, int sila, int inteligence, int obratnost, int odolnost, int expy, IRace rasa, int zivoty, int skillpoint, int zplacenoZDluhu){
        switch(trida){
            case 1: nepratele.add(new Warrior(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint, zplacenoZDluhu));
            case 2: nepratele.add(new Mage(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint, zplacenoZDluhu));
            case 3: nepratele.add(new Scout(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint, zplacenoZDluhu));
            case 4: nepratele.add(new Monk(jmeno,1,sila,inteligence,obratnost,odolnost,expy,rasa,zivoty,skillpoint,zplacenoZDluhu));
        }
    }

    public static EnemyArrayList nacti(String jmenoSlozky) throws Exception{
        EnemyArrayList snp = new EnemyArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(jmenoSlozky))){
            String radek = null;
            while((radek = br.readLine())!=null){
                Character o = Character.zCsv(radek);
                snp.pridejCsv(o);
            }
        }catch(Exception e){
            throw e;
        }
        return snp;
    }

}

