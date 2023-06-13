package character.profession;

import character.IRace;
import character.Character;

public class Mage extends Character {

    public Mage(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint, int zplacenoZDluhu) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy,rasa, zivoty,skillpoint,zplacenoZDluhu);
    }
    @Override
    public int getTrida() {
        return 2;
    }
    public double utociNa(Character obrance) {
        return (3 * getInteligenceR() * rasa.stesti()) - getObrana(obrance);
    }
    public String getPovolani() {
        return "Mag";
    }

    public double getVlastnost(Character obrance) {
        return obrance.getInteligence();
    }
}
