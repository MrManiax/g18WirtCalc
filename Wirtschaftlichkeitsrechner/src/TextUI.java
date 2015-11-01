import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TextUI {
	Scanner in;
	DecimalFormat factor;
	DecimalFormat percent;
	DecimalFormat currency;
	
	public TextUI() {
		this.in = new Scanner(System.in);
		in.useLocale(Locale.GERMANY);
		factor = new DecimalFormat("#.##");
		factor.setRoundingMode(RoundingMode.HALF_UP);
		percent = new DecimalFormat("#.##%");
		percent.setRoundingMode(RoundingMode.HALF_UP);
		currency = new DecimalFormat("¤#.##");
		currency.setRoundingMode(RoundingMode.HALF_UP);
	}
	
	public int mainMenu() {
		
		System.out.printf("Hauptmenü\n"
				+ "1. Neue Berechnung durchfüren\n"
				+ "2. Beenden\n\n"
				+ "Bitte wählen Sie: ");
				
		return in.nextInt();
	}
	
	public int calcMenu() {
		System.out.printf("Welche Berechnung soll durchgefürt werden?\n"
				+ "1. Wirtschaftlichkeit berechnen\n"
				+ "2. Eigenkapitalrentabilität berechnen\n"
				+ "3. Umsatzrentabilität berechnen\n"
				+ "4. Beenden\n\n"
				+ "Bitte wählen Sie: ");
				
		return in.nextInt();
	}
	
	public ArrayList<Double> inputList(String s) {
		
		ArrayList<Double> tmp = new ArrayList<Double>();
	
		System.out.printf("Bitte geben Sie alle %s als einzelne Positionen ein.\nWenn Sie fertig können Sie mit 'fertig' fortfahren.", s);
		while (true) {
			System.out.printf("\nBitte geben Sie ihre %s ein: ", s);
			
			if (in.hasNextDouble()) {
				tmp.add(in.nextDouble());
			} else if (in.hasNext("fertig")) {
				in.next();
				return tmp;
			}else {
				this.error("Bitte geben Sie eine Zahl oder das Wort 'fertig' ein um die Eingabe zu beenden");
				in.next();
			}
		}
	}

	public void result(double a, String s, Unternehmen u) {
		System.out.println();
		System.out.printf(Locale.GERMANY, "Aufwändungen Gesamt: %s\n", currency.format(u.getAufwand()));
		System.out.printf(Locale.GERMANY, "Erträge Gesamt: %s\n", currency.format(u.getErtrag()));
		System.out.printf(Locale.GERMANY, "Kosten Gesamt: %s\n", currency.format(u.getKosten()));
		System.out.printf(Locale.GERMANY, "Leistungen Gesamt: %s\n", currency.format(u.getLeistungen()));
		System.out.printf(Locale.GERMANY, "Eigenkapital: %s\n", currency.format(u.getEigenkapital()));
		System.out.printf(Locale.GERMANY, "Betriebliche Ergebnis: %s\n", currency.format(u.getBetriebsGewinn()));
		System.out.printf(Locale.GERMANY, "Unternehmerische Ergebnis: %s\n", currency.format(u.getUnternehmensGewinn()));
		System.out.println();
		System.out.printf(Locale.GERMANY, "%s: %s\n\n", s, factor.format(a));
	}
	
	public void result(double a, double b, String s, Unternehmen u) {
		System.out.println();
		System.out.printf(Locale.GERMANY, "Aufwändungen Gesamt: %s\n", currency.format(u.getAufwand()));
		System.out.printf(Locale.GERMANY, "Erträge Gesamt: %s\n", currency.format(u.getErtrag()));
		System.out.printf(Locale.GERMANY, "Kosten Gesamt: %s\n", currency.format(u.getKosten()));
		System.out.printf(Locale.GERMANY, "Leistungen Gesamt: %s\n", currency.format(u.getLeistungen()));
		System.out.printf(Locale.GERMANY, "Eigenkapital: %s\n\n", currency.format(u.getEigenkapital()));
		System.out.printf(Locale.GERMANY, "Betriebliches Ergebnis: %s\n", currency.format(u.getBetriebsGewinn()));
		System.out.printf(Locale.GERMANY, "Unternehmerisches Ergebnis: %s\n", currency.format(u.getUnternehmensGewinn()));
		System.out.println();
		System.out.printf(Locale.GERMANY, "Betriebliche %s: %s\n", s, percent.format(a));
		System.out.printf(Locale.GERMANY, "Unternehmerische %s: %s\n", s, percent.format(a));
	}

	public void error(String s) {
		System.out.printf("Es ist ein Fehler aufgetreten: %s\n\n", s);
		
	}

	public void title() {
		System.out.printf("Willkommen zum Wirtschaftlichkeitsrechner\nErstellt von Maik Busse und Johannes Weinreben\n\n");
	}

	public int bOrU() {
		System.out.printf("Möchten Sie das Betriebs-, oder das Unternehmensergebnis berechnen?\n1. Betriebsergebnis\n2. Unternehmensergebnis\n3. Beides\n\nBitte wählen Sie: ");
		return in.nextInt();
	}
		
}
