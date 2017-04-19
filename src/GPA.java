
public class GPA 
{    
    public double highGPA = 0;
    public double veryHighGPA = 0;
    public double lowGPA = 0;
    
    public GPA(double gpa)
    {
        if (gpa < 2.0)
        {
            highGPA = 0;
        }
        else
        {
            highGPA = (gpa - 2.0)/2.0;
        }
    }
    public void addHedge()
    {
        veryHighGPA = Math.pow(highGPA, 2);
        lowGPA = 1.0 - highGPA;
    }
}


