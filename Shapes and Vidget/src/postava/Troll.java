package postava;

import java.util.Random;

public class Troll implements IRasa {
    Random rnd = new Random();
    @Override
    public double bonusSila() {
        return 1.1;
    }
    @Override
    public double bonusInteligence() {
        return 0.85;
    }
    @Override
    public double bonusObratnosti() {
        return 0.75;
    }
    @Override
    public double bonusOdolnost() {
        return 1.2;
    }

    @Override
    public double stesti() {
        return (rnd.nextDouble()/2.4)+1;
    }

    @Override
    public String getRasa() {
        return "Troll";
    }

    public String toString() {
        return getRasa();
    }

}
