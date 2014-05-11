package Saobracaj;
import java.awt.*;

public class Vozilo extends Akter {

	private String oznaka;
	private int kap;	//kapacitet
	private Label la;
	private int tmax, tmin;		// vreme izmedju stanica
	private int zadrzavanje; 	//zadrzavanje na svakoj stanici
	private int brPutnika; 		// koluiko putnika ima u vozilu
	private boolean voziSe= true;		// dal je izmedju stanica ili na stanici
	private int rbStanice=0;
	private Linija linija;
	private boolean smer = true;
	
	public Vozilo(Label l, String o, int k, int min, int max, int z,Linija li)
	{
		super(l);
		tmax 		= max;
		tmin 		= min;
		kap  		= k;
		oznaka  	= o;
		zadrzavanje = z;
		linija 		= li;
		la 			= l;
		
	}
	@Override
	public void radnja() throws InterruptedException
	{
		
		
		voziSe 		= true;
		Thread.sleep((long) (tmin + Math.random() * (tmax - tmin)));		// vreme put izmedju stanica
		voziSe 		= false; 
		la.setText(toString());
		Thread.sleep((long) zadrzavanje );	//vreme na stanici
		
		brPutnika   = brPutnika - (((int) Math.random() * brPutnika) );
		uzmiPutnike(linija.uzmi(rbStanice));	
		voziSe 		= true;
		if(smer) rbStanice++;
		else rbStanice--;
	
		if(rbStanice  == linija.brojStanica() - 1) smer = false;
		if (rbStanice == 0) smer = true;

	}

	@Override
	public String toString()
	{
		if(voziSe)
		{
			return oznaka + " ide ka " + (linija.uzmi(rbStanice)).ime() + " : " + brPutnika;  
		}
		else
		{
			return oznaka + " stoji na " + (linija.uzmi(rbStanice)).ime() +  " : " + brPutnika;  
		}
	}
	public void uzmiPutnike(Stanica s)
	{
		if(kap - brPutnika >= s.br())
		{
			brPutnika+= s.br();
			linija.uzmi(rbStanice).smanji(s.br());
		}
		else
		{
			brPutnika = kap;
			linija.uzmi(rbStanice).smanji(kap - brPutnika);
		}
			
	}

}
