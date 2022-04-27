package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	// create array list of namatodes
    ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();		
		loadNematodes();		
		printNematodes();

	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode s = new Nematode(r);
            nematodes.add(s);
        }
	}

	void printNematodes()
    {
        for(Nematode s:nematodes)
        {
            System.out.println(s);
        }
    }



	public void draw()
	{	
		for(int i = 0 ; i < nematodes.size() ; i ++)
		{
			float y = map(i, 0, nematodes.size(), 100, height - 100);
			nematodes.get(i).render(width / 2, y, this);
		}
	}
}
