package postava;

public class Valecnik extends Postava{
    public Valecnik(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty, int skillpoint) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint);
    }
    @Override
    public int getTrida() {
        return 1;
    }
    public double utociNa(Postava obrance){
        return (3* getSila() * rasa.stesti()) - getObrana(obrance);
    }
    public String getPovolani(){
        return "Valecnik";
    }
    public double getVlastnost(Postava obrance) {
        return obrance.getSila();
    }
}
