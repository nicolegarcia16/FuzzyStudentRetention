
public class Involvement {
    
    public double involved = 0;
    public double veryInvolved = 0;
    public double uninvolved = 0;
    
    public Involvement(int numActivities)
    {
        if(numActivities > 10)
        {
            involved = 1.0;
        }
        else
        {
            involved = (double)numActivities / 10.0;
        }
    }
    public void addHedge()
    {
        veryInvolved = Math.pow(involved,2); 
        uninvolved = 1 - involved;
    }
}


