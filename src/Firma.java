public class Firma {
    private String name;
    private final Angestellter[] angestellte=new Angestellter[10];
    private int anz=0;

    public Firma(String name){
        setName(name);
    }

    public void setName(String name) {
        if(name.isEmpty()){
            System.err.println("wrong.firma.setName.input.1");
            name="Amazon";
        }
        this.name = name;
    }

    public Angestellter einfuegen(String name, String abteilung, float gehalt){
        boolean schonVorhanden=false;
        for(int i=0; i<anz; i++) if(angestellte[i].getName().equals(name)){ schonVorhanden=true; break;}

        if(anz>=10||schonVorhanden){
            System.err.println("wrong.firma.einfuegen.full||same");
            return null;
        }
        angestellte[anz]=new Angestellter(name, abteilung, gehalt);
        anz++;
        return angestellte[anz-1];
    }

    public int getPosAngestellten(String name){
        if(name==null||name.isEmpty()){
            System.err.println("wrong.firma.getPosAngestellten.input.1");
            return -1;
        }
        for(int i = 0; i < anz; i++){
            if(angestellte[i].getName().equals(name)) return i;
        }
        return -1;
    }

    public Angestellter loeschen(String name){
        int pos = getPosAngestellten(name);
        Angestellter ret=null;

        if(pos>=0){
            ret=angestellte[pos];
            for(int i = pos-1; i< anz; i++){
                if(i++ < anz){
                    angestellte[pos] = angestellte[pos+1];
                }else{
                    angestellte[pos] = null;
                }
                pos++;
            }
        }
        anz--;
        return ret;
    }

    public void ausgeben(){
        System.out.println("----------------------------------AUSGABE----------------------------------");
        System.out.println("Firma: "+this.name);
        for(int i=0; i<anz; i++){
            System.out.println(angestellte[i].toString());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public Angestellter getAngestellten(int pos){
        if(pos<0||pos > anz){
            System.err.println("wrong.firma.ausgeben.input.1");
            return null;
        }
        return angestellte[pos];
    }

    public void inAbteilungMit(Angestellter ang){

    }
}
