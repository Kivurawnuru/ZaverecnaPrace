package postava;

import java.util.Random;

    public class Nemrtvy implements IRasa {
        Random rnd = new Random();
        @Override
        public double bonusSila() {
            return 1;
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
            return 1.1;
        }

        @Override
        public double stesti() {
            return (rnd.nextDouble()/2.5)+1;
        }

        @Override
        public String getRasa() {
            return "Nemrtvý";
        }

        public String toString() {
            return getRasa();
        }
    }