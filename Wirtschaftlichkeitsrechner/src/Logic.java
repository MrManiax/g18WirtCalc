
public class Logic {
	private boolean gui;
	private boolean exit;
	private boolean calcExit;
	private Unternehmen u;
	private TextUI ui;
	
	public Logic(boolean gui) {
		this.gui = gui;
		this.exit = false;
		this.calcExit = false;
		this.ui= new TextUI();
		this.loop();
		
	}
	
	public boolean loop() {
		
		if (this.gui == false) {
			
			ui.title();
			
			do {
				switch(ui.mainMenu()) {
				case 1: 
					this.newCalc();
					break;
				case 2:
					this.exit = true;
					break;
				default: 
					ui.error("Bitte geben Sie eine Zahl aus der Auswahl ein.");
					break;
				}
			} while (this.exit == false);
		}
		
		return true;
	}
	
	public void newCalc() {
		this.u = new Unternehmen(
				ui.inputList("Aufwendungen"),
				ui.inputList("Erträge"),
				ui.inputList("Kosten"),
				ui.inputList("Leistungen"),
				ui.inputList("Eigenkapital"));
		
		do {
			String s = "";
			switch(ui.calcMenu()) {
			case 1: 
				s = "Wirtschaftlichkeit";
				ui.result(Calc.wirt(u.getErtrag(), u.getAufwand()), s, u);
				break;
			case 2: 
				s = "Eigenkapitalrentabilität";
				switch(ui.bOrU()) {
				case 1:
					ui.result(Calc.eige(u.getBetriebsGewinn(), u.getEigenkapital()), s, u);
					break;
				case 2:
					ui.result(Calc.eige(u.getUnternehmensGewinn(), u.getEigenkapital()), s, u);
					break;
				case 3:
					ui.result(Calc.eige(u.getBetriebsGewinn(), u.getEigenkapital()), Calc.eige(u.getUnternehmensGewinn(), u.getEigenkapital()), s, u);
					break;
				}
				break;
				
			case 3: 
				s = "Umsatzrentabilität";
				
				switch(ui.bOrU()) {
				case 1:
					ui.result(Calc.umsa(u.getBetriebsGewinn(), u.getLeistungen()), s, u);
					break;
				case 2:
					ui.result(Calc.umsa(u.getUnternehmensGewinn(), u.getLeistungen()), s, u);
					break;
				case 3:
					ui.result(Calc.umsa(u.getBetriebsGewinn(), u.getLeistungen()), Calc.umsa(u.getUnternehmensGewinn(), u.getLeistungen()), s, u);
					break;
				}
				break;
				
			case 4:
				this.calcExit = true;
				break;
			default: 
				ui.error("Bitte geben Sie eine Zahl aus der Auswahl ein.");
				break;
			}
			
			
		} while (this.calcExit == false);

		
	}
	
	
}
