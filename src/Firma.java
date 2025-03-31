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
        if(name==null||name.isEmpty()){
            System.err.println("wrong.firma.getPosAngestellten.input.1");
            return -1;
        }
        int ret=-1;
        for(int i=0; i<anz; i++){
            if(angestellte[i].getName().equals(name)){ret=i; break;}
        }
        return ret;
    }

    public Angestellter loeschen(String name){
        int pos=getPosAngestellten(name);
        if(pos<0){
            System.err.println("wrong.firma.loeschen.input.1");
            return null;
        }
        for(int j=pos; j<anz; j++){
            if(j+1<anz)angestellte[j]=angestellte[j+1];
            else angestellte[j]=null;
        }
        anz--;
        return angestellte[pos];
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

    public void sortAlphabetisch() {
        for(int i=1; i<anz; i++){
            int highestPos=i-1;
            //Jeden Namen Vergleichen
            for(int j=i; j<anz; j++){
                boolean gleich=true; //Ob die beiden Namen gleich sind
                if(angestellte[highestPos].getAbteilung().compareTo(angestellte[j].getAbteilung())>0){
                    highestPos=j;
                    gleich=false;
                } else if (angestellte[highestPos].getAbteilung().compareTo(angestellte[j].getAbteilung())<0) {
                    gleich=false;
                }
                if(gleich){
                    if(angestellte[highestPos].getName().compareTo(angestellte[j].getName())>0){
                        highestPos=j;
                    }
                }
            }
            //Tausch von 2 Elementen (dem Höchsten & dem Ersten)
            Angestellter tausch=angestellte[i-1];
            angestellte[i-1]=angestellte[highestPos];
            angestellte[highestPos]=tausch;
        }
    }

    public void sortGehalt(){
        for(int i=0; i<anz; i++){
            for(int j=i; j<anz; j++){
                if(!(j+1>=anz)){
                    if(angestellte[j+1].getGehalt()>angestellte[j].getGehalt()) {
                        angestellte[j] = angestellte[j + 1];
                    }
                }
            }
        }
    }
}
