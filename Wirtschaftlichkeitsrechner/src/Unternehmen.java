import java.util.ArrayList;

public class Unternehmen {
	private ArrayList<Double> aufw;
	private ArrayList<Double> ertr;
	private ArrayList<Double> kapi;
	private ArrayList<Double> kost;
	private ArrayList<Double> leis;
	
	private double betrGewi;
	private double unteGewi;
	
	public Unternehmen(ArrayList<Double> aufw, ArrayList<Double> ertr, ArrayList<Double> kost, ArrayList<Double> leis, ArrayList<Double> kapi) {
		this.aufw = aufw;
		this.ertr = ertr;
		this.kapi = kapi;
		this.kost = kost;
		this.leis = leis;
		
		betrGewi = this.getLeistungen() - this.getKosten();
		unteGewi = this.getErtrag() - this.getAufwand();
	}

	public double getAufwand() {
		double aufwand = 0.0;
		for (double d : aufw) {
			aufwand += d;
		}
		return aufwand;
	}

	public double getErtrag() {
		double ertrag = 0.0;
		for (double d : ertr) {
			ertrag += d;
		}
		return ertrag;
	}

	public double getEigenkapital() {
		double kapital = 0.0;
		for (double d : kapi) {
			kapital += d;
		}
		return kapital;
	}

	public double getKosten() {
		double kosten = 0.0;
		for (double d : kost) {
			kosten += d;
		}
		return kosten;
	}

	public double getLeistungen() {
		double leistungen = 0.0;
		for (double d : leis) {
			leistungen += d;
		}
		return leistungen;
	}

	public double getBetriebsGewinn() {
		return betrGewi;
	}

	public double getUnternehmensGewinn() {
		return unteGewi;
	}
}
