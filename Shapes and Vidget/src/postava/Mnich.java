package postava;

public class Mnich extends Postava {

    public Mnich(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty, int skillpoint) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy , rasa, zivoty,skillpoint);
    }

    @Override
    public int getTrida() {
        return 4;
    }

    @Override
    public double utociNa(Postava obrance) {
        return (getSilaR() + (getObratnostR()*2))* rasa.stesti() - getObrana(obrance);

    }
    @Override
    public String getPovolani() {
        return "Mnich";
    }

    @Override
    public double getVlastnost(Postava obrance) {
        return (obrance.sila)/3 + ((obrance.obratnost)/3)*2;
    }
}
