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

    public int getAnz(){
        return anz;
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

    public void inAbteilungMit(Angestellter ang){
        if(ang==null){
            System.err.println("wrong.firma.inAbteilungMit.input.1");
        }else {
            for (int i = 0; i < anz; i++) {
                if (ang.getAbteilung().equals(angestellte[i].getAbteilung())) System.out.println(angestellte[i]);
            }
        }
    }

    public Angestellter[] getAngestellte(char c){
        Angestellter[] array=new Angestellter[0];
        for(int i=0; i<anz; i++){
            char[] split=angestellte[i].getName().toCharArray();
            if(split[0]==c){
                array=new Angestellter[array.length+1];
                array[array.length-1]=angestellte[i];
            }
        }
        return array;
    }

    public void ausgeben(){
        System.out.println("#################################");
        System.out.println("Name: "+getName());
        System.out.println("Anzahl d. Angestellten: "+getAnz());
        for(int i=0; i<anz; i++){
            System.out.println(angestellte[i]);
        }
        System.out.println("#################################");
    }

    public void meistVerdiener(){
        if(anz<=0){
            System.err.println("wrong.firma.meistVerdiener.notExist");
        }else{
            float high=0;
            for(int i=0; i<anz; i++){
                if(angestellte[i].getGehalt()>high) high=angestellte[i].getGehalt();
            }
            for(int i=0; i<anz; i++){
                if(angestellte[i].getGehalt()>=high){
                    System.out.println(angestellte[i]);
                }
            }
        }
    }

    public void sortAlphabetisch(){
        if(anz<=0){
            System.err.println("wrong.firma.sortAlphabetisch.notExist");
        }else{
            char[] high=angestellte[0].getName().toCharArray();
            int highPos=0;
            char[] comp;
            boolean gleich;
            for(int i=0; i<anz; i++){
                comp=angestellte[i].getName().toCharArray();
                int ret=vergleich(high, comp);
                if(ret<0){
                    char[] highAbteil=angestellte[highPos].getAbteilung().toCharArray();
                    char[] compAbteil=angestellte[i].getAbteilung().toCharArray();
                    int ret2=vergleich(highAbteil, compAbteil);
                }
            }
        }
    }
    private static int vergleich(char[] high, char[] comp){
        for(int j=0; j<comp.length&&j<high.length; j++){
            if(comp[j]>high[j]){
                high=comp;
                highPos=i;
                gleich=false;
                break;
            }else if(comp[j]<high[j]){
                gleich=false;
                break;
            }else if(high.length>comp.length){
                gleich=false;
                break;
            }else if(comp.length>high.length){
                high=comp;
                highPos=i;
                gleich=false;
                break;
            }
        }
    }
}
