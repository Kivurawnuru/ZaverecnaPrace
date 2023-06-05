package postava;

import java.util.Random;

public class Lionin implements IRasa{

    Random rnd = new Random();

    @Override
    public double bonusSila() {
        return 1.035;
    }

    @Override
    public double bonusInteligence() {
        return 1.015;
    }

    @Override
    public double bonusObratnosti() {
        return 1.02;
    }

    @Override
    public double bonusOdolnost() {
        return 1.03;
    }

    @Override
    public double stesti() {
        return (rnd.nextDouble() / 2.05) + 1;
    }

    @Override
    public String getRasa() {
        return "Lionin";
    }

    public String toString() {
        return getRasa();
    }
}
