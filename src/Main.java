//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main.test();
    }

    public static void test(){
        Firma firma=new Firma("ÖBB");
        firma.einfuegen("Martin Römisch", "CEO", 9999999);
        firma.einfuegen("Martin Römisch", "Fahrer", 100000);
        firma.einfuegen("Alexander Müller", "Fahrer", 100000);
        firma.einfuegen("Jonas Müller", "Fahrer", 100000);
        firma.einfuegen("Emma Römisch", "Fahrer", 100000);
        firma.ausgeben();
        System.out.println(firma.loeschen("Martin Römisch"));
        firma.ausgeben();
        System.out.println(firma.einfuegen("Martin Römisch", "Homeless", 0.001f));
        firma.ausgeben();
        System.out.println(firma.getAngestellten(0));
    }
}