package postava;

import java.util.ArrayList;
import java.util.Random;

public abstract class Postava {
    protected String jmeno;
    protected int level;
    protected double sila;
    protected double inteligence;
    protected double obratnost;
    protected double odolnost;
    protected int expy;
    protected IRasa rasa;
    protected double zivoty;
    protected int skillpoint;

    public double getSilaR(){
        return sila * rasa.bonusSila();
    }
    public double getInteligenceR(){
        return inteligence * rasa.bonusInteligence();
    }
    public double getObratnostR(){
        return obratnost * rasa.bonusObratnosti();
    }
    public double getOdolnostR(){
        return odolnost * rasa.bonusOdolnost();
    }

    public double getSila(){
        return sila;
    }
    public double getInteligence(){
        return inteligence;
    }
    public double getObratnost(){
        return obratnost;
    }
    public double getOdolnost(){
        return odolnost;
    }
    public String getJmeno() {
        return jmeno;
    }
    public double getZivoty() {
        return zivoty;
    }
    public int getLevel() {
        return level;
    }
    public IRasa getRasa() {
        return rasa;
    }
    public int getSkillpoint() {
        return skillpoint;
    }
    public int getExpy() {
        return expy;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSila(double sila) {
        this.sila = sila;
    }

    public void setInteligence(double inteligence) {
        this.inteligence = inteligence;
    }

    public void setObratnost(double obratnost) {
        this.obratnost = obratnost;
    }

    public void setOdolnost(double odolnost) {
        this.odolnost = odolnost;
    }

    public void setRasa(IRasa rasa){
        this.rasa = rasa;
    }
    public void setZivoty(double zivoty) {
        this.zivoty = zivoty;
    }

    public void setSkillpoint(int skillpoint) {
        this.skillpoint = skillpoint;
    }


    public Postava(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, double zivoty, int skillpoint) {
        this.jmeno = jmeno;
        this.level = level;
        this.sila = sila;
        this.inteligence = inteligence;
        this.obratnost = obratnost;
        this.odolnost = odolnost;
        this.expy = expy;
        this.zivoty = level * 10;
        this.skillpoint = skillpoint;

    }

    public Postava(String jmeno, int level,double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty, int skillpoint) {
        this.jmeno = jmeno;
        this.level = level;
        this.sila = sila;
        this.inteligence = inteligence;
        this.obratnost = obratnost;
        this.odolnost = odolnost;
        this.expy = expy;
        this.rasa = rasa;
        this.zivoty = level * 10;
        this.skillpoint = skillpoint;
    }


    public abstract int getTrida();
    public abstract double utociNa(Postava naKoho);
    public abstract String getPovolani();
    public abstract double getVlastnost(Postava obrance);


    public static Postava vytvorPostavu(int trida, String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRasa rasa, double zivoty,int skillpoint){
        switch(trida){
            case 1: return new Valecnik(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty,skillpoint);
            case 2: return new Mag(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty,skillpoint);
            case 3: return new Pruzkumnik(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty,skillpoint);
            case 4: return new Mnich(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty,skillpoint);
        }
        return null;
    }

   public static Postava vytvorNahodnehoNepritele(int levelHrdiny) throws Exception {
        Random rnd = new Random();
        int trida = rnd.nextInt(4)+1;
        ArrayList<Postava> nepratele = SeznamNepratel.nacti("nepratele.txt").getNepratele();
        String jmeno = nepratele.get(rnd.nextInt(8)).getJmeno();

       int zaklad = levelHrdiny;

        int level = rnd.nextInt(zaklad+3)+1;
        double  sila;
        double inteligence;
        double obratnost;
        double odolnost;
        int expy;
        int skillpoint = 0;
        String Srasa = nepratele.get(rnd.nextInt(8)).rasa.getRasa();
        Srasa = Srasa.trim();
        //System.out.println("Srasa: " + Srasa);
        IRasa rasa = getRasa(Srasa);
        double zivoty;


        switch(trida){
            case 1:
                sila = rnd.nextInt(zaklad+4)+2;
                inteligence = rnd.nextInt(zaklad+2)+1;
                obratnost = rnd.nextInt(zaklad+3)+1;
                odolnost = rnd.nextInt(zaklad+3)+1;
                expy = rnd.nextInt(35)*10;
                zivoty = 1;
                return new Valecnik(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint);

            case 2:
                sila = rnd.nextInt(zaklad+2)+1;
                inteligence = rnd.nextInt(zaklad+4)+2;
                obratnost = rnd.nextInt(zaklad+3)+1;
                odolnost = rnd.nextInt(zaklad+1)+1;
                expy = rnd.nextInt(35)*10;
                zivoty = 1;
                return new Mag(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint);

            case 3:
                sila = rnd.nextInt(zaklad+1)+1;
                inteligence = rnd.nextInt(zaklad+2)+1;
                obratnost = rnd.nextInt(zaklad+4)+2;
                odolnost = rnd.nextInt(zaklad+3)+1;
                expy = rnd.nextInt(35)*10;
                zivoty = 1;
                return new Pruzkumnik(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint);

            case 4:
                sila = rnd.nextInt(zaklad+2)+1;
                inteligence = rnd.nextInt(zaklad+2)+1;
                obratnost = rnd.nextInt(zaklad+4)+2;
                odolnost = rnd.nextInt(zaklad+3)+1;
                expy = rnd.nextInt(35)*10;
                zivoty = 1;
                return new Mnich(jmeno,level,sila,inteligence,obratnost,odolnost,expy, rasa, zivoty, skillpoint);
        }
        return null;
    }


    public double getObrana(Postava protivnik){
        return getOdolnost() + protivnik.getVlastnost(this);
    }

    public void vyhra(int levelNepritele, int levelHrdiny){
        if(levelNepritele > levelHrdiny) {
           int bonus = levelNepritele - levelHrdiny;
            expy = 10 * bonus * levelNepritele;
        }else{
            expy += 20 * levelNepritele;
        }
    }
    public void vyhraCHM(int levelNepritele, int levelHrdiny){
        if(levelNepritele > levelHrdiny) {
            int bonus = levelNepritele - levelHrdiny;
            expy = 20 * bonus * levelNepritele;
        }else{
            expy += 30 * levelNepritele;
        }
    }

    public void levelUp(){
        while(expy >= 100*level){
            level++;
            expy -= 100*level;
            zivoty = level * 10;
            skillpoint = skillpoint + 2;
        }
    }

    public static IRasa getRasa(String rasa) {
        switch(rasa){
            case "Troll": return new Troll();
            case "Trpaslík" : return new Trpaslik();
            case "Nemrtvý": return new Nemrtvy();
            case "Temný Elf": return new TemnyElf();
            case "Clovek": return new Clovek();
            case "Elf": return new Elf();
            case "Lionin": return new Lionin();

        }
        return null;
    }

    public static Postava zCsv(String csv)throws Exception{
        try{
            csv = csv.trim();
            String[] radek = csv.split(";");
            Postava hrdina = Postava.vytvorPostavu(Integer.parseInt(radek[0]),
                    radek[1],
                    Integer.parseInt(radek[2]),
                    Double.parseDouble(radek[3]),
                    Double.parseDouble(radek[4]),
                    Double.parseDouble(radek[5]),
                    Double.parseDouble(radek[6]),
                    Integer.parseInt(radek[7]),
                    getRasa(radek[8]),
                    Double.parseDouble(radek[9]),
                    Integer.parseInt(radek[10]));
            return hrdina;
        }catch (Exception e){
            throw new Exception();
    }
    }

    public String doCsv() {
        return getTrida()+";"+jmeno+";"+level+";"+sila+";"+inteligence+";"+obratnost+";"+odolnost+";"+expy+";"+rasa.toString()+";"+zivoty+";"+skillpoint;
    }

    @Override
    public String toString() {
        return "Postava: " + getPovolani().toString() +" "+ jmeno +  " s " + zivoty + " zivoty a levelem " + level + ", silou " + sila + ", inteligencí " + inteligence + ", obratnosí " + obratnost + ", odolností " + odolnost + ", expy " + expy + " a rasou: " + rasa;
    }


}
