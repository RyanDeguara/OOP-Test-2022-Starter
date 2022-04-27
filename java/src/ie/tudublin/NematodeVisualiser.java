package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	// create array list of namatodes
    ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	int curNem;

	public void keyPressed()
	{		
		if(keyCode == LEFT)
		{
			curNem = curNem - 1;
			if( curNem < 0 )
			{
				curNem = nematodes.size() -1;
			}
		}	
		else if (keyCode == RIGHT)
		{
			curNem = curNem + 1;
			if( curNem > nematodes.size()-1 )
			{
				curNem = 0;
			}
		}
		else
		{
			System.out.println("Please enter a valid key (LEFT OR RIGHT KEY ARROW)");
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

		background(0);
		nematodes.get(curNem).render(this);
		
	}
}
