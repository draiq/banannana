
// Fethican Karadeniz
import java.util.*;
public class Abgabe {
    public static char Textz (String text,int i) {
        char zeichen;

        zeichen = text.charAt(i);
        return zeichen;
    }

    public static char Schlüsselz (String schlüsselwort,int i){
        char zeichen;

        zeichen = schlüsselwort.charAt(i);
        return zeichen;
    }

    public static String Schlüsselvl (String schlüssel,String klartext){
        while (klartext.length()>schlüssel.length()){
            schlüssel=schlüssel+schlüssel;

        }
        return schlüssel;
    }

    public static String Verschlüsseln  (String klartext,String Schlüssel) {
        Schlüssel =Schlüsselvl(Schlüssel,klartext);
        String Verschlüsseltertext="";
        char zeichen='F';
        char Schlüsselzeichen='F';
        int Textstelle=0;
        int Schlüsselstelle=0;
        int neueZahl=0;
        char neuesZeichen='F';
        String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<klartext.length(); i=i+1) {
            zeichen=Textz(klartext,i);
            Schlüsselzeichen = Schlüsselz(Schlüssel,i);
            Textstelle=abcStelle(zeichen);
            Schlüsselstelle=abcStelle(Schlüsselzeichen);
            neueZahl=Textstelle+Schlüsselstelle;
            if (neueZahl>25){
                neueZahl=neueZahl-26;
            }
            System.out.println(neueZahl);
            neuesZeichen=abc.charAt(neueZahl);
            Verschlüsseltertext=Verschlüsseltertext+neuesZeichen;
            
        }
        return Verschlüsseltertext;
    }

    public static int abcStelle (char zeichen){
        String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int Stelle = abc.indexOf(zeichen);
        return Stelle;
    }

    public static String bereinigterText(String wortalt) {

        char zeichen = 'F';
        int zeichenNeu;
        String wort = "";
        for (int i = 0; i < wortalt.length() ; i = i+1){
            zeichen = wortalt.charAt(i);
            if ( (int) zeichen >= (int) 'a' && (int) zeichen <= (int) 'z' ) {
                zeichenNeu = (int) zeichen - 32;
                wort = wort + (char) zeichenNeu;
            }
            else {
                wort = wort + zeichen;             
            }
        }
        wort = brText(wort, 'Ü', "UE");  
        wort = brText(wort, 'ü', "UE");  
        wort = brText(wort, 'Ö', "OE");
        wort = brText(wort, 'ö', "OE");
        wort = brText(wort, 'Ä', "AE");
        wort = brText(wort, 'ä', "AE");
        wort = brText(wort, 'ß', "SS");
        return wort;
    }

    public static String brText(String wort, char zeichen, String ersatz) {

        String reintext = "";
        int zeichenNeu;
        for (int i = 0; i < wort.length() ; i = i+1){
            char stelle = wort.charAt(i);
            if ( (int) zeichen == stelle) {
                reintext = reintext + ersatz;
            }
            else {
                reintext = reintext + stelle;
            }
        }
        return reintext;
    }

    public static String wählen(char Buchstabe) {

        String Wahltext="";
        if (Buchstabe == 'V' || Buchstabe =='v')  {
            Wahltext="Bitte das Wort zum Verschlüsseln eingeben:";
        }
        else {
            if(Buchstabe == 'E' || Buchstabe =='e'){
                Wahltext="Bitte das Wort zum Entschlüsseln eingeben:";

            }
            else {
                Wahltext="Eingabe nicht gültig";

            }
        }
        return Wahltext;
    }

    public static void main(String[] args){
        System.out.println("Möchten Sie Verschlüsseln (V) oder Entschlüsseln (E) ?");
        Scanner sc= new Scanner(System.in);
        char Wahl=sc.next().charAt(0);
        String Ausgabe=wählen(Wahl);
        System.out.println(Ausgabe);
        Scanner sc2= new Scanner(System.in);
        String klartext= sc.next();
    }
}