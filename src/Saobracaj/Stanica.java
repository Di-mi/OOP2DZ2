package Saobracaj;
import java.awt.*;

public class Stanica extends Akter {
	private int mint, maxt;
	private String ime;
	private int brojPutnika=0;
	
	public Stanica (Label l, int min, int max, String i)
	{
		super (l);
		mint = min;
		maxt = max;
		ime  = i;	
	}
	
	public void radnja() throws InterruptedException
	{
		sleep((long)(mint + Math.random() * (maxt-mint)));
		 brojPutnika++;
	}
	public String toString()
	{
		return ime + " : " + brojPutnika; 
	}
	
	public void smanji(int s)
	{
		brojPutnika-=s;
	}
	public String ime()
	{
		return ime;	
	}
	
	public int br()
	{
		return brojPutnika;
	}
	
	
}
