package postava;

public class Pruzkumnik extends Postava {
    public Pruzkumnik(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty, int skillpoint) {
        super(jmeno, level, sila, inteligence, obratnost, odolnost, expy,rasa, zivoty,skillpoint);
    }
    @Override
    public int getTrida() {
        return 3;
    }
    public double utociNa(Postava obrance){
        return ( 3* getObratnostR() * rasa.stesti()) - getObrana(obrance);
    }
    public String getPovolani(){
        return "Valecnik";
    }
    public double getVlastnost(Postava obrance) {
        return obrance.getObratnost();
    }
}
