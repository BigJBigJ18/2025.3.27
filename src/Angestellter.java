public class Angestellter {
    private String name;
    private String abteilung;
    private float gehalt;

    public void setGehalt(float gehalt) {
        if(gehalt < 0){
            System.err.println("wrong.angestellter.setname.input.1");
            gehalt=10000;
        }
        this.gehalt = gehalt;
    }

    public void setAbteilung(String abteilung){
        if(abteilung.isEmpty()){
            System.err.println("wrong.angestellter.setname.input.1");
            abteilung="HIF";
        }
        this.abteilung = abteilung;
    }

    private void setName(String name){
        if(name.isEmpty()){
            System.err.println("wrong.angestellter.setname.input.1");
            name="Martin";
        }
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public float getGehalt() {
        return gehalt;
    }

    public Angestellter(String name, String abteilung, float gehalt){
        setName(name);
        setAbteilung(abteilung);
        setGehalt(gehalt);
    }

    public boolean gleicheAbteilung(Angestellter ang){
        if(this.abteilung.equals(ang.getAbteilung())){
            return true;
        }
        return false;
    }

    public String toString(){
        String[] namen = this.name.split(" ");
        StringBuilder vorname=new StringBuilder();
        String nachname=namen[namen.length-1];
        for(int i =0; i<namen.length; i++){
            if(namen.length==1) {
                vorname.append(namen[i]);
                nachname = "[nicht angegeben]";
            }
            if(i+1<namen.length) vorname.append(namen[i]);
        }
        return "-----------------------------------------------"+"\nVorname: "+vorname+"\nNachname: "+nachname+"\nAbteilung: "+this.abteilung+"\nGehalt: "+this.gehalt+"\n-----------------------------------------------";
    }
}
