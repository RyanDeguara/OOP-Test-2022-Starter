package ie.tudublin;

import processing.data.TableRow;

public class Nematode {
    public String name;
    public Integer length;
    public Integer limbs;
    public String gender;
    public Integer eyes;

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
        viz.text(name, x-10, y - 100);
        viz.stroke(255);
        viz.noFill();
        for (int i = 0; i < length; i++)
        {
            viz.circle(x, y+(i*40), 40);
        }
        viz.popMatrix();
    }

    
}
