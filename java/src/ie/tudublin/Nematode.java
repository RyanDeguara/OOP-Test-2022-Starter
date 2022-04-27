package ie.tudublin;

import processing.data.TableRow;

public class Nematode {
    private String name;
    private Integer length;
    private Integer limbs;
    private String gender;
    private Integer eyes;
    private float y2;
    private float extent;
    private float extent2;

    public Nematode(String name, Integer length, Integer limbs, String gender, Integer eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow r) 
    {
        this(r.getString("name"), r.getInt("length"), r.getInt("limbs"), r.getString("gender"), r.getInt("eyes"));
    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLimbs() {
        return limbs;
    }

    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEyes() {
        return eyes;
    }

    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public void render( NematodeVisualiser viz)
    {
        viz.pushMatrix();
        
        float y = viz.height / 4;
        float x = viz.width / 2;
        float c = viz.map(y, 0, y2, 0, 255);
        viz.stroke(c, 255, 255);
        viz.fill(c, 255, 255);
        viz.textSize(40);
        viz.textAlign(viz.CENTER);
        viz.text(name, x, y-100);
        viz.rectMode(viz.CENTER);
        viz.noFill();
        viz.rect(x, y-110, (x/2)+(name.length()*10), y-150, 20);
        extent = 40;
        extent2 = 30;

        
        for (int i = 0; i < length; i++)
        {
            
            y2 = y + (i*extent);
            viz.circle(x, y2, extent);
            if (limbs > 0)
            {
                viz.line(x+extent, y2, x+(extent/2), y2);
                viz.line(x-extent, y2, x-(extent/2), y2);
            }

        }
        if ( eyes > 0)
        {
            viz.line(x-(extent2/2), y-(extent2/2), x-extent2, y-extent2);
            viz.line(x+(extent2/2), y-(extent2/2), x+extent2, y-extent2);
            viz.circle(x-(extent2+2), y-(extent2+2), 5);
            viz.circle(x+(extent2+2), y-(extent2+2), 5);
        }
        if (gender.contains("m"))
        {
            viz.line(x, y2+(extent/2), x, y2+extent);
            viz.circle(x, y2+(extent + 4), 5);
        }
        if (gender.contains("h"))
        {
            viz.line(x, y2+(extent/2), x, y2+extent);
            viz.circle(x, y2+(extent+4), 5);
            viz.circle(x, y2, ((extent/2)+8));
        }
        if (gender.contains("f"))
        {
            viz.circle(x, y2, ((extent/2)+8));
        }
        
        viz.popMatrix();
    }

    
}
