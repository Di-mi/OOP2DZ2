package Saobracaj;
import java.awt.*;

public class Linija {
	
	private Stanica stanice[];
	private Vozilo vozila[];
	
	public Linija(String[] i, int min1, int max1 , String [] oznake, int k, int time, int min2, int max2,
			Panel p1, Panel p2)
	{
		stanice = new Stanica[i.length];
		for (int j = 0;j < i.length; j++)
		{
			Label tmp;
			stanice[j] = new Stanica(tmp = new Label(),min1,max1, i[j]);
			p1.add(tmp);
		}
		
		vozila = new Vozilo[oznake.length];		
		for (int j = 0;j < oznake.length; j++)
		{
			Label tmp;
			vozila[j] = new Vozilo(tmp = new Label(),oznake[j],k,min2,max2,time, this);
			p2.add(tmp);
		}
		
	}
	public int brojStanica()
	{
		return stanice.length;
	}
	public Stanica uzmi(int rb)
	{
		if(rb < 0 || rb >stanice.length)
		{
			return null;
		}
		return stanice[rb];
	}
	public void pokreni()
	{
		for (Stanica s: stanice)
		{
			s.pokreni();
		}
		for (Vozilo s: vozila)
		{
			s.pokreni();
		}
		
	}
	public void zaustavi()
	{
		for (Stanica s: stanice)
		{
			s.zaustavi();
		}
		for (Vozilo s: vozila)
		{
			s.zaustavi();
		}
		
	}
	public void prekini()
	{
		for (Stanica s: stanice)
		{
			s.prekini();
		}
		for (Vozilo s: vozila)
		{
			s.prekini();
		}
	}
	public void startuj()
	{
		for (Stanica s: stanice)
		{
			s.startuj();
		}
		for (Vozilo s: vozila)
		{
			s.startuj();
		}
		
	}
}
