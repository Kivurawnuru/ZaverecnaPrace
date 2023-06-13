package character;

import character.Race.*;
import character.profession.Mage;
import character.profession.Monk;
import character.profession.Scout;
import character.profession.Warrior;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character {
    protected String jmeno;
    protected int level;
    protected double sila;
    protected double inteligence;
    protected double obratnost;
    protected double odolnost;
    protected int expy;
    protected IRace rasa;
    protected double zivoty;
    private int skillpoint;
    private int zplacenoZDluhu;

    /**
     * Just Getters and Setters
     */
    public double getSilaR() {
        return sila * rasa.bonusSila();
    }

    public double getInteligenceR() {
        return inteligence * rasa.bonusInteligence();
    }

    public double getObratnostR() {
        return obratnost * rasa.bonusObratnosti();
    }

    public double getOdolnostR() {
        return odolnost * rasa.bonusOdolnost();
    }

    public double getSila() {
        return sila;
    }

    public double getInteligence() {
        return inteligence;
    }

    public double getObratnost() {
        return obratnost;
    }

    public double getOdolnost() {
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

    public IRace getRasa() {
        return rasa;
    }

    public int getSkillpoint() {
        return skillpoint;
    }

    public int getExpy() {
        return expy;
    }

    public int getZplacenoZDluhu() {
        return zplacenoZDluhu;
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

    public void setRasa(IRace rasa) {
        this.rasa = rasa;
    }

    public void setZivoty(double zivoty) {
        this.zivoty = zivoty;
    }

    public void setSkillpoint(int skillpoint) {
        this.skillpoint = skillpoint;
    }

    public void setZplacenoZDluhu(int zplacenoZDluhu) {
        this.zplacenoZDluhu = zplacenoZDluhu;
    }

    /**
     * Constructor with parameters:
     * @param jmeno
     * @param level
     * @param sila
     * @param inteligence
     * @param obratnost
     * @param odolnost
     * @param expy
     * @param rasa
     * @param zivoty
     * @param skillpoint
     */
    public Character(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint) {
        this.jmeno = jmeno;
        this.level = level;
        this.sila = sila;
        this.inteligence = inteligence;
        this.obratnost = obratnost;
        this.odolnost = odolnost;
        this.expy = expy;
        this.zivoty = level * 10;
        this.skillpoint = skillpoint;
        this.zplacenoZDluhu = zplacenoZDluhu;
    }

    /**
     * Another constructor with parameters:
     * @param jmeno
     * @param level
     * @param sila
     * @param inteligence
     * @param obratnost
     * @param odolnost
     * @param expy
     * @param rasa
     * @param zivoty
     * @param skillpoint
     */
    public Character(String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint, int zplacenoZDluhu) {
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
        this.zplacenoZDluhu = zplacenoZDluhu;
    }

    /**
     * Abstrct parameters essential for character profession
     */
    public abstract int getTrida();

    public abstract double utociNa(Character naKoho);

    public abstract String getPovolani();

    public abstract double getVlastnost(Character obrance);

    /**
     * Method for correct set profession
     * Method takes Integer of class declared in txt file, and set character profession in ArrayList
     */
    public static Character vytvorPostavu(int trida, String jmeno, int level, double sila, double inteligence, double obratnost, double odolnost, int expy, IRace rasa, double zivoty, int skillpoint, int zplacenoZDluhu) {
        switch (trida) {
            case 1:
                return new Warrior(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
            case 2:
                return new Mage(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
            case 3:
                return new Scout(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
            case 4:
                return new Monk(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
        }
        return null;
    }

    /**
     * vytvorNahodnehoNepritel is method for Random generating enemy
     * Only thing it need is take name of enemy from text file, all other parameters will be generated by hero level
     * This static method is used in Challenge Mode for generating enemy
     * @param levelHrdiny
     * @return
     * @throws Exception
     */
    public static Character enemyForChallengeMode(int levelHrdiny) throws Exception {
        Random rnd = new Random();
        int trida = rnd.nextInt(4) + 1;
        ArrayList<Character> nepratele = EnemyArrayList.nacti("nepratele.txt").getNepratele();
        String jmeno = nepratele.get(rnd.nextInt(8)).getJmeno();

        int zaklad = levelHrdiny;
        int level = rnd.nextInt(zaklad + 3) + 1;
        double sila;
        double inteligence;
        double obratnost;
        double odolnost;
        int expy = 0;
        int skillpoint = 0;
        String Srasa = nepratele.get(rnd.nextInt(8)).rasa.getRasa();
        Srasa = Srasa.trim();
        IRace rasa = getRasa(Srasa);
        double zivoty;
        int zplacenoZDluhu = 0;

        switch (trida) {
            case 1:
                sila = rnd.nextInt(zaklad + 4) + 2;
                inteligence = rnd.nextInt(zaklad + 2) + 1;
                obratnost = rnd.nextInt(zaklad + 3) + 1;
                odolnost = rnd.nextInt(zaklad + 3) + 1;
                zivoty = 1;
                return new Warrior(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 2:
                sila = rnd.nextInt(zaklad + 2) + 1;
                inteligence = rnd.nextInt(zaklad + 4) + 2;
                obratnost = rnd.nextInt(zaklad + 3) + 1;
                odolnost = rnd.nextInt(zaklad + 1) + 1;
                zivoty = 1;
                return new Mage(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 3:
                sila = rnd.nextInt(zaklad + 1) + 1;
                inteligence = rnd.nextInt(zaklad + 2) + 1;
                obratnost = rnd.nextInt(zaklad + 4) + 2;
                odolnost = rnd.nextInt(zaklad + 3) + 1;
                zivoty = 1;
                return new Scout(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 4:
                sila = rnd.nextInt(zaklad + 2) + 1;
                inteligence = rnd.nextInt(zaklad + 2) + 1;
                obratnost = rnd.nextInt(zaklad + 4) + 2;
                odolnost = rnd.nextInt(zaklad + 3) + 1;
                zivoty = 1;
                return new Monk(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
        }
        return null;
    }

    /**
     * enemyForExtremeMode is method for Random generating enemy
     * Only thing it need is take name of enemy from text file, all other parameters will be generated by hero level
     * This static method is used in Extreme Mode for generating enemy
     * @param levelHrdiny
     * @return
     * @throws Exception
     */
    public static Character enemyForExtremeMode(int levelHrdiny) throws Exception {
        Random rnd = new Random();
        int trida = rnd.nextInt(4) + 1;
        ArrayList<Character> nepratele = EnemyArrayList.nacti("nepratele.txt").getNepratele();
        String jmeno = nepratele.get(rnd.nextInt(8)).getJmeno();

        int zaklad = levelHrdiny;
        int level = rnd.nextInt(zaklad + 6) + 5;
        double sila;
        double inteligence;
        double obratnost;
        double odolnost;
        int expy = 0;
        int skillpoint = 0;
        String Srasa = nepratele.get(rnd.nextInt(8)).rasa.getRasa();
        Srasa = Srasa.trim();
        IRace rasa = getRasa(Srasa);
        double zivoty;
        int zplacenoZDluhu = 0;

        switch (trida) {
            case 1:
                sila = rnd.nextInt(zaklad + 7) + 6;
                inteligence = rnd.nextInt(zaklad + 5) + 5;
                obratnost = rnd.nextInt(zaklad + 6) + 5;
                odolnost = rnd.nextInt(zaklad + 6) + 5;
                zivoty = 1;
                return new Warrior(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 2:
                sila = rnd.nextInt(zaklad + 5) + 5;
                inteligence = rnd.nextInt(zaklad + 7) + 6;
                obratnost = rnd.nextInt(zaklad + 6) + 5;
                odolnost = rnd.nextInt(zaklad + 4) + 5;
                zivoty = 1;
                return new Mage(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 3:
                sila = rnd.nextInt(zaklad + 4) + 5;
                inteligence = rnd.nextInt(zaklad + 5) + 5;
                obratnost = rnd.nextInt(zaklad + 7) + 6;
                odolnost = rnd.nextInt(zaklad + 6) + 5;
                zivoty = 1;
                return new Scout(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);

            case 4:
                sila = rnd.nextInt(zaklad + 5) + 5;
                inteligence = rnd.nextInt(zaklad + 5) + 5;
                obratnost = rnd.nextInt(zaklad + 7) + 6;
                odolnost = rnd.nextInt(zaklad + 6) + 5;
                zivoty = 1;
                return new Monk(jmeno, level, sila, inteligence, obratnost, odolnost, expy, rasa, zivoty, skillpoint, zplacenoZDluhu);
        }
        return null;
    }

    /**
     * getObrana is method that say us enemy defence against out champion
     * @param protivnik
     * @return enemy defence
     */
    public double getObrana(Character protivnik) {
        return getOdolnostR() + protivnik.getVlastnost(this);
    }

    /**
     * vyhra is method that give hero experience after win fight against enemy
     * this method is used in boj class
     * @param levelNepritele
     * @param levelHrdiny
     */
    public void vyhra(int levelNepritele, int levelHrdiny) {
        if (levelNepritele > levelHrdiny) {
            int bonus = levelNepritele - levelHrdiny;
            expy = 10 * bonus * levelNepritele;
        } else {
            expy += 20 * levelNepritele;
        }
    }

    /**
     * vyhraCHM is method specialy made for challenge mode
     * because it is challenge mode it gives hero more experience for winning fight
     * @param levelNepritele
     * @param levelHrdiny
     */
    public void vyhraCHM(int levelNepritele, int levelHrdiny) {
        if (levelNepritele > levelHrdiny) {
            int bonus = levelNepritele - levelHrdiny;
            expy = 20 * bonus * levelNepritele;
        } else {
            expy += 30 * levelNepritele;
        }
    }
    /**
     * vyhraCHM is method specialy made for Extreme Mode
     * because it is challenge mode it gives hero more experience for winning fight
     * @param levelNepritele
     * @param levelHrdiny
     */

    public void vyhraExM(int levelNepritele, int levelHrdiny) {
        if (levelNepritele > levelHrdiny) {
            int bonus = levelNepritele - levelHrdiny;
            expy = 20 * bonus * levelNepritele * 2;
        } else {
            expy += 30 * levelNepritele * 2;
        }
    }

    /**
     * this method can level up heroes level and give him more lives
     */
    public void levelUp() {
        while (expy >= 100 * level) {
            expy -= 100 * level;
            level++;
            zivoty = level * 10;
            skillpoint = skillpoint + 2;
        }
    }

    /**
     * Method that count money reward for hero from won fight
     * @param levelNepritele
     * @param levelHrdiny
     */

    public void vyhrouSiZískal(int levelNepritele, int levelHrdiny){
        if (levelNepritele > levelHrdiny){
            int rozdiLevelu = levelNepritele - levelHrdiny;
            zplacenoZDluhu += rozdiLevelu * 20 * getRasa().stesti();
        } else {
            zplacenoZDluhu += levelNepritele * 10;
        }
    }
    /**
     * Method that count money reward for hero from won Challenge Mode
     * @param levelNepritele
     * @param levelHrdiny
     */

    public void vyhrouSiZískalCHM(int levelNepritele, int levelHrdiny){
        if (levelNepritele > levelHrdiny){
            int rozdiLevelu = levelNepritele - levelHrdiny;
            zplacenoZDluhu += rozdiLevelu+rozdiLevelu * 20 * getRasa().stesti();
        } else {
            zplacenoZDluhu += levelNepritele * 15;
        }
    }

    /**
     * Method that count money reward for hero from won Extreme Fight
     * @param levelNepritele
     * @param levelHrdiny
     */
    public void vyhrouSiZískalEXF(int levelNepritele, int levelHrdiny){
        if (levelNepritele > levelHrdiny){
            int rozdiLevelu = levelNepritele - levelHrdiny;
            zplacenoZDluhu += rozdiLevelu+rozdiLevelu * 30 * getRasa().stesti();
        } else {
            zplacenoZDluhu += levelNepritele * 20;
        }
    }

    /**
     * method used for recognize heroes or enemy race
     * @param rasa
     * @return rasa
     */
    public static IRace getRasa(String rasa) {
        switch (rasa) {
            case "Troll":
                return new Troll();
            case "Trpaslík":
                return new Dwarf();
            case "Nemrtvý":
                return new Undead();
            case "Temný Elf":
                return new DarkElf();
            case "Clovek":
                return new Human();
            case "Elf":
                return new Elf();
            case "Lionin":
                return new Lionin();

        }
        return null;
    }

    /**
     * method needed for loading characters from txt files
     * @param csv
     * @return
     * @throws Exception
     */
    public static Character zCsv(String csv) throws Exception {
        try {
            csv = csv.trim();
            String[] radek = csv.split(";");
            Character hrdina = Character.vytvorPostavu(Integer.parseInt(radek[0]),
                    radek[1],
                    Integer.parseInt(radek[2]),
                    Double.parseDouble(radek[3]),
                    Double.parseDouble(radek[4]),
                    Double.parseDouble(radek[5]),
                    Double.parseDouble(radek[6]),
                    Integer.parseInt(radek[7]),
                    getRasa(radek[8]),
                    Double.parseDouble(radek[9]),
                    Integer.parseInt(radek[10]),
                    Integer.parseInt(radek[11]));
            return hrdina;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    /**
     * method needed for write characters in txt files
     * @return
     */
    public String doCsv() {
        return getTrida() + ";" + jmeno + ";" + level + ";" + sila + ";" + inteligence + ";" + obratnost + ";" + odolnost + ";" + expy + ";" + rasa.toString() + ";" + zivoty + ";" + skillpoint+";" + zplacenoZDluhu;
    }

    @Override
    public String toString() {
        return "Postava: " + getPovolani().toString() + " " + jmeno + " s " + zivoty + " zivoty a levelem " + level + ", silou " + sila + ", inteligencí " + inteligence + ", obratnosí " + obratnost + ", odolností " + odolnost + ", expy " + expy + " a rasou: " + rasa;
    }
}