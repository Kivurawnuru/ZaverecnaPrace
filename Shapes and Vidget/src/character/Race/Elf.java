package character.Race;

import character.IRace;

import java.util.Random;

public class Elf implements IRace {
    Random rnd = new Random();

    @Override
    public double bonusSila() {
        return 1;
    }

    @Override
    public double bonusInteligence() {
        return 1.06;
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
        return (rnd.nextDouble() / 2.1) + 1;
    }

    @Override
    public String getRasa() {
        return "Elf";
    }

    public String toString() {
        return getRasa();
    }
}
