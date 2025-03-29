public class Firma {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.isEmpty()){
            System.err.println("wrong.firma.setName.input.1");
            name="Amazon";
        }
        this.name = name;
    }

    private String name;
    private final Angestellter[] angestellte=new Angestellter[10];
    private int anz;

    public Firma(String name){
        setName(name);
    }

    public Angestellter einfuegen(String name, String abteilung, float gehalt){
        boolean existiert=false;
        Angestellter angestellter=new Angestellter(name, abteilung, gehalt);

        for(int i=0; i<anz; i++){
            if(angestellte[i].getName().equals(angestellter.getName())){existiert=true; break;}
        }
        if(anz>10||existiert){
            System.err.println("wrong.firma.einfuegen.input.1");
            return null;
        }
        angestellte[anz]=angestellter;
        anz++;
        return angestellte[anz-1];
    }

    private int getPosAngestellten(String name){
        int ret=-1;
        for(int i=0; i<anz; i++){
            if(angestellte[i].getName().equals(name)){ret=i; break;}
        }
        return ret;
    }

    public Angestellter loeschen(String name){
        if(name==null||name.isEmpty()){
            System.err.println("wrong.firma.loeschen.input.1");
            return null;
        }
        Angestellter ang=null;
        for(int i=0; i<anz; i++){
            if(angestellte[i].getName().equals(name)){
                ang=angestellte[i];
                for(int j=i; j<anz; j++){
                    if(j+1<anz)angestellte[j]=angestellte[j+1];
                    else angestellte[j]=null;
                }
                anz--;
            }
        }
        return ang;
    }

    public void ausgeben(){
        System.out.println(getName()+getPosAngestellten("Jornandes")+getPosAngestellten("Martin"));
    }
}
