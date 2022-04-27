package ie.tudublin;

import processing.data.TableRow;

public class Nematode {
    public String name;
    public Integer length;
    public Integer limbs;
    public String gender;
    public Integer eyes;
    private float y2;

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
        viz.text(name, x-(name.length()), y - 100);
        
        viz.noFill();
        for (int i = 0; i < length; i++)
        {
            
            y2 = y + (i*40);
            viz.circle(x, y2, 40);
            if (limbs > 0)
            {
                viz.line(x+40, y2, x+20, y2);
                viz.line(x-40, y2, x-20, y2);
            }

        }
        if ( eyes > 0)
        {
            viz.line(x-15, y-15, x-30, y-30);
            viz.line(x+15, y-15, x+30, y-30);
            viz.circle(x-32, y-32, 5);
            viz.circle(x+32, y-32, 5);
        }
        if (gender.contains("m"))
        {
            viz.line(x, y2+20, x, y2+40);
            viz.circle(x, y2+44, 5);
        }
        if (gender.contains("h"))
        {
            viz.line(x, y2+20, x, y2+40);
            viz.circle(x, y2+44, 5);
            viz.circle(x, y2, 28);
        }
        if (gender.contains("f"))
        {
            viz.circle(x, y2, 28);
        }
        
        viz.popMatrix();
    }

    
}
