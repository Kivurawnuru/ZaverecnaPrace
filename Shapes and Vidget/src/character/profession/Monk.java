package character.profession;

import character.IRace;
import character.Character;

public class Monk extends Character {

    public Monk(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint, int zplacenoZDluhu) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy , rasa, zivoty,skillpoint,zplacenoZDluhu);
    }

    @Override
    public int getTrida() {
        return 4;
    }

    @Override
    public double utociNa(Character obrance) {
        return (getSilaR() + (getObratnostR()*2))* rasa.stesti() - getObrana(obrance);

    }
    @Override
    public String getPovolani() {
        return "Mnich";
    }

    @Override
    public double getVlastnost(Character obrance) {
        return (obrance.getSila())/3 + ((obrance.getObratnost())/3)*2;
    }
}
