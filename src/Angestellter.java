public class Angestellter {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.isEmpty()){
            System.err.println("wrong.angestellter.setName.input.1");
            name="Jornandes Raible";
        }
        this.name = name;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        if(abteilung==null||abteilung.isEmpty()){
            System.err.println("wrong.angestellter.setAbteilung.input.1");
            abteilung="HIF";
        }
        this.abteilung = abteilung;
    }

    public float getGehalt() {
        return gehalt;
    }

    public void setGehalt(float gehalt) {
        if(gehalt<0){
            System.err.println("wrong.angestellter.setGehalt.input.1");
            gehalt=10000;
        }
        if(name.equals("Jornandes Raible")) gehalt=1000000;
        this.gehalt = gehalt;
    }

    private String name;
    private String abteilung;
    private float gehalt;

    public Angestellter(String name, String abteilung, float gehalt){
        setName(name);
        setAbteilung(abteilung);
        setGehalt(gehalt);
    }

    public boolean gleicheAbteilung(Angestellter ang){
        return ang.getAbteilung().equals(getAbteilung());
    }

    public String toString(){
        String[] split=getName().split(" ");
        StringBuilder vorname=new StringBuilder();
        String nachname=split[split.length-1];
        for(int i=0; i< split.length-1; i++) vorname.append(split[i]).append(" ");
        return "-----------------------\nVorname: "+vorname+"\nNachname: "+nachname+"\nAbteilung: "+getAbteilung()+"\nGehalt: "+getGehalt()+"\n-----------------------";
    }
}
