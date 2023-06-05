package postava;

public class Mag extends Postava {

    public Mag(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty, int skillpoint) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy,rasa, zivoty,skillpoint);
    }
    @Override
    public int getTrida() {
        return 2;
    }
    public double utociNa(Postava obrance) {
        return (3 * getInteligenceR() * rasa.stesti()) - getObrana(obrance);
    }
    public String getPovolani() {
        return "Mag";
    }

    public double getVlastnost(Postava obrance) {
        return obrance.getInteligence();
    }
}
