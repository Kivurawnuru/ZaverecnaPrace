package character.profession;

import character.IRace;
import character.Character;

public class Warrior extends Character {
    public Warrior(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint, int zplacenoZDluhu) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint,zplacenoZDluhu);
    }
    @Override
    public int getTrida() {
        return 1;
    }
    public double utociNa(Character obrance){
        return (3* getSilaR() * rasa.stesti()) - getObrana(obrance);
    }
    public String getPovolani(){
        return "Valecnik";
    }
    public double getVlastnost(Character obrance) {
        return obrance.getSila();
    }
}
