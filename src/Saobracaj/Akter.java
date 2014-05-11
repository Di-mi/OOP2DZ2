package Saobracaj;
import java.awt.*;

public abstract class Akter extends Thread {
	private Label tekst;
	private boolean zaustavi;
	
	public Akter(Label t)
	{
		tekst = t;
		tekst.setText("");
	}
	public void startuj()
	{
		start();
	}
	public abstract void radnja() throws InterruptedException;
	public void run()
	{
		try{
			while (!interrupted())
			{	
				synchronized(this)
				{
					tekst.setText(toString());
				
					while(zaustavi) wait();
				
					radnja();
					tekst.setText(toString());
				}
			}
			
		}catch(InterruptedException g){}
	}
	
	
	public synchronized void zaustavi()
	{	
		zaustavi = true;
		notifyAll();
	}	
	public synchronized void pokreni()
	{	
		zaustavi = false;
		notifyAll();
	}	
	public void prekini()
	{
		interrupt();
	}
	public abstract String toString();
}
