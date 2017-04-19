
public class Homesickness {
    public double homesick;
    public double somewhatHomesick;
    public double seldomHomesick;
    public double veryHomesick;
    
    
    public Homesickness(int numberOfWeekendsAtHome)
    {
        homesick = ((double)numberOfWeekendsAtHome/30.0);
    }
    
    public void addHedges()
    {
        somewhatHomesick = Math.pow(homesick, 0.5);
        veryHomesick = Math.pow(homesick, 2);
        seldomHomesick = 1 - veryHomesick;
    }
}


