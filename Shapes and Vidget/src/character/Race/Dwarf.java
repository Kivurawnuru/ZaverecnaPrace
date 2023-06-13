package character.Race;

import character.IRace;

import java.util.Random;

public class Dwarf implements IRace {
    Random rnd = new Random();
    @Override
    public double bonusSila() {
        return 1.07;
    }
    @Override
    public double bonusInteligence() {
        return 1;
    }
    @Override
    public double bonusObratnosti() {
        return 1;
    }
    @Override
    public double bonusOdolnost() {
        return 1.03;
    }

    @Override
    public double stesti() {
        return (rnd.nextDouble()/2.29)+1;
    }

    @Override
    public String getRasa() {
        return "Trpaslík";
    }
    public String toString() {
        return getRasa();
    }
}
