

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        angestellterTest();
        firmaTest();
    }

    public static void angestellterTest(){
        System.out.println("------------------------------------------------------ANGESTELLTER------------------------------------------------------");
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        System.out.println("toString test:");
        Angestellter angestellter=new Angestellter("Martin Valentin Max Römisch", "HIF", 10000.89f);
        System.out.println(angestellter);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        System.out.print("Gleiche Abteilung Test (true erwartet): ");
        System.out.println(angestellter.gleicheAbteilung(angestellter));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        System.out.print("Gleiche Abteilung Test (false erwartet): ");
        System.out.println(angestellter.gleicheAbteilung(new Angestellter("Martin", "HI", 0.0f)));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }

    public static void firmaTest() throws InterruptedException {
        System.out.println("---------------------------------------------------------FIRMA----------------------------------------------------------");
        Firma firma=new Firma("Cisco");
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        System.out.println("Einfuegen Test: ");
        System.out.println(firma.einfuegen("Martin Römisch", "HIF", 999));
        System.out.println(firma.einfuegen("Martin Römisch", "HIF", 999));  //Error erwartet
        System.out.println(firma.einfuegen("", "", 999));  //Error erwartet
        System.out.println(firma.einfuegen("", "", 999));  //Error erwartet
        System.out.println(firma.einfuegen("Emma Römisch", "Sekretär", 9999));
        System.out.println(firma.einfuegen("Paul Römisch", "HIF", 1000));
        System.out.println(firma.einfuegen("Anastasia Römisch", "HIF", 999));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Errors (6 erwartet): ");
        Thread.sleep(10);   //Damit der Error dazwischen ausgegeben wird
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        System.err.flush();
        System.out.println("Entfernen Test: ");
        System.out.println(firma.loeschen("Martin Römisch"));
        System.out.println(firma.loeschen("")); //Error erwartet
        System.out.println(firma.loeschen(null)); //Error erwartet
        System.out.println(firma.loeschen("Jornandes Raible"));
        System.out.println(firma.loeschen(" "));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Errors (2 erwartet): ");
        Thread.sleep(10);
        System.out.println("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨");
        firma.ausgeben();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
}