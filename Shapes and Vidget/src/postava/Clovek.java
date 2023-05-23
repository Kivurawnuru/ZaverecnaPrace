package postava;

import java.util.Random;

public class Clovek implements IRasa {
    Random rnd = new Random();
    @Override
    public double bonusSila() {
        return 1.03;
    }
    @Override
    public double bonusInteligence() {
        return 1.03;
    }
    @Override
    public double bonusObratnosti() {
        return 1.04;
    }
    @Override
    public double bonusOdolnost() {
        return 1;
    }

    @Override
    public double stesti() {
        return (rnd.nextDouble()/2.3)+1;
    }

    @Override
    public String getRasa() {
        return "Clovek";
    }

    public String toString() {
        return getRasa();
    }
}
