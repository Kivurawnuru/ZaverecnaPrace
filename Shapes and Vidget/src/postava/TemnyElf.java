package postava;

import java.util.Random;

public class TemnyElf implements IRasa {
    Random rnd = new Random();
    @Override
    public double bonusSila() {
        return 0.95;
    }
    @Override
    public double bonusInteligence() {
        return 1.04;
    }
    @Override
    public double bonusObratnosti() {
        return 1.06;
    }
    @Override
    public double bonusOdolnost() {
        return 0.8;
    }
    @Override
    public double stesti() {
        return (rnd.nextDouble()/2.25)+1;
    }

    @Override
    public String getRasa() {
                                    return "Temný Elf";
    }

    public String toString() {
        return getRasa();
    }
}
