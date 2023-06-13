
package character;

        import character.profession.Mage;
        import character.profession.Monk;
        import character.profession.Scout;
        import character.profession.Warrior;

        import java.io.*;
        import java.util.ArrayList;

public class HeroArrayList {
    ArrayList<Character> hrdinove = new ArrayList<>();


    public ArrayList<Character> getHrdinove() {
        return hrdinove;
    }
    public void setHrdinove(ArrayList<Character> hrdinove) {
        this.hrdinove = hrdinove;
    }
    public void pridejCsv(Character o){
        hrdinove.add(o);
    }

    public void pridej(int trida, String jmeno, int level, int sila, int inteligence, int obratnost, int odolnost, int expy, IRace rasa, int zivoty, int skillpoint, int zplacenoZDluhu){
        switch(trida){
            case 1: hrdinove.add(new Warrior(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint,zplacenoZDluhu));
            case 2: hrdinove.add(new Mage(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint,zplacenoZDluhu));
            case 3: hrdinove.add(new Scout(jmeno,1, sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint,zplacenoZDluhu));
            case 4: hrdinove.add(new Monk(jmeno,1,sila,inteligence,obratnost,odolnost,expy,rasa,zivoty,skillpoint,zplacenoZDluhu));
        }
    }
    public static HeroArrayList nacti(String jmenoSlozky) throws Exception{

        HeroArrayList sh = new HeroArrayList();

        try(BufferedReader br = new BufferedReader(new FileReader(jmenoSlozky))){
            String radek = null;
            while((radek = br.readLine())!=null){
                Character o = Character.zCsv(radek);
                sh.pridejCsv(o);
            }
        }catch(Exception e){
            throw e;
        }
        return sh;
    }

}