package Saobracaj;
import java.awt.*;

public class Vozilo extends Akter {

	private String oznaka;
	private int kap;			//kapacitet
	private int tmax, tmin;		// vreme izmedju stanica
	private int zadrzavanje; 	//zadrzavanje na svakoj stanici
	private int brPutnika; 		// koluiko putnika ima u vozilu
	private boolean voziSe;		// dal je izmedju stanica ili na stanici
	
	public Vozilo(Label l, String o, int k, int min, int max, int z)
	{
		super(l);
		tmax 		= max;
		tmin 		= min;
		kap  		= k;
		oznaka  	= o;
		zadrzavanje = z;
		
	}
	@Override
	public void radnja() throws InterruptedException
	{
		voziSe 		= true;
		sleep((long) (tmin + Math.random() * (tmax - tmin)));		// vreme put izmedju stanica
		voziSe 		= false; 
		sleep((long) zadrzavanje );									//vreme na stanici
		brPutnika  -= (int) Math.random() * (brPutnika + 1);
		uzmiPutnike();

	}

	@Override
	public String toString()
	{
		if(voziSe)
		{
			return oznaka + "ide ka" + " : " + brPutnika;  
		}
		else
		{
			return oznaka + "stoji na" + " : " + brPutnika;  
		}
	}
	public void uzmiPutnike(Stanica s)
	{
		if(kap - brPutnika <= s.br())
		{
			brPutnika+= s.br();
			s.smanji(s.br());
		}
		else
		{
			brPutnika = kap;
			s.smanji(kap - brPutnika);
		}
			
	}

}
