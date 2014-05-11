package Saobracaj;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends Frame{
	
	private static Button dgmKreni = new Button("Kreni");
	private static Button dgmStani = new Button("Dosta Brus Li");
	private Linija linija;
	private Panel centar, dole;
	
	private static final String s[] = {"Stan1","Stan2","Stan3","Stan4","MIRIJEVO"};
	private static final String v[] = {"23","43"};
	
	
	
	private Program()
	{
		super("saobrcaj");
		setSize(600,480);
		setVisible(true);
		Panel natpisi = new Panel(new GridLayout(1,2)); 	//deli se ploca na 1 kolonu i 2 reda
		natpisi.setBackground(Color.GRAY);
	 	add(natpisi,"North");
	 	
	 	natpisi.add(new Label("Stanice: "));
	 	natpisi.add(new Label("Vozila: "));
	 	Panel leva 	= new Panel(new GridLayout(5,1));
	 	Panel desna = new Panel(new GridLayout(5,1));
	 	linija 		= new Linija(s, 500,1000,v,40,1000,2000,4000,leva,desna);
	 	add(centar	= new Panel(new GridLayout(1,2)),"Center");
	 	
	 	centar.add(leva);
	 	centar.add(desna);
	 	
	 	add(dole = new Panel(),"South");
	 	dole.setBackground(Color.GRAY);
	 	dgmKreni.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {
				linija.pokreni();
				
			}
		});
	 	dgmStani.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {
				linija.zaustavi();
				
			}
		});
	 	
	 	
	 	dole.add(dgmKreni);
	 	dole.add(dgmStani);
	 	linija.startuj();
	 	
	 	
	 	
	}
	public static void main(String [] argv)
	{
		new Program();
	}
}
