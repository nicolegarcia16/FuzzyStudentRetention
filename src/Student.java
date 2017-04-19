/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class Student {
    public double GPA;
    public int numberOfActivities;
    
    public GPA fuzzyGPA; 
    public Involvement fuzzyActivities;
    
    public double verylikelyToRemain;
    public double likelyToRemain;
    public double tossUp;
    public double unlikelyToRemain;
    public double veryUnlikelyToRemain;
    
    public double likelihoodOfRetention;
    public double likelihoodOfRetentionPercentage;
    public String actionToTake;
    
    public Student(double gpa, int numActivities)
    {
        this.GPA = gpa;
        this.numberOfActivities = numActivities;
    }
    
    public void setFuzzyValues()
    {
        fuzzyGPA = new GPA(GPA);
        fuzzyActivities = new Involvement(numberOfActivities);
    }
    
    public void setHedges()
    {
        fuzzyGPA.addHedge();
        fuzzyActivities.addHedge();
    }
    public void setLikelihoodOfRetention(double likelihood)
    {
        this.likelihoodOfRetention = likelihood;
        this.likelihoodOfRetentionPercentage = likelihood*100.0;
    }
    
    public void setActionToTake(String action)
    {
        this.actionToTake = action;
    }
    
    public void calculateRetentionProbability()
    {
        verylikelyToRemain = (fuzzyGPA.highGPA + fuzzyActivities.involved)/2.0;
        likelyToRemain = (fuzzyGPA.veryHighGPA + fuzzyActivities.uninvolved)/2.0;
        tossUp = (fuzzyGPA.lowGPA + fuzzyActivities.veryInvolved)/2.0;
        unlikelyToRemain = (fuzzyGPA.highGPA + fuzzyActivities.uninvolved)/2.0;
        veryUnlikelyToRemain = (fuzzyGPA.lowGPA + fuzzyActivities.uninvolved)/2.0;
        
        double max = findMax();
        double centroid;
       if(max == verylikelyToRemain)
       {
           double topIntegral = 0.0;
           double bottomIntegral = 0.0;
           for(int i = 80; i < 90; i++)
           {
            topIntegral += ((((1.0/10)*(i+1) - 8)*(i+1)) + (((1.0/10)*i - 8)*i))/2;
            bottomIntegral += (((1.0/10)*(i+1) - 8) + ((1.0/10)*i - 8))/2;            
           }
           for(int i = 90; i <= 100; i++)
           {
               topIntegral += (1.0*i);
               bottomIntegral += 1.0;
           }
           centroid = topIntegral/bottomIntegral;
       }
       else if(max == likelyToRemain)
           centroid = (45.0 + 15.0)/2.0;
       else if(max == tossUp)
           centroid = (65.0 + 35.0)/2.0;
       else if(max == unlikelyToRemain)
           centroid = (85.0 + 55.5)/2.0;
       else
       {
           double topIntegral = 0.0;
           double bottomIntegral = 0.0;
           for(int i = 0; i <= 10; i++)
           {
               topIntegral += 1.0*i;
               bottomIntegral += 1.0;
           }
           for(int i = 11; i <= 20; i++)
           {
                topIntegral += ((((-1.0/10)*(i+1) + 2)*(i+1)) + (((-1.0/10)*i + 2)*i))/2;
                bottomIntegral += (((-1.0/10)*(i+1) + 2) + ((-1/10)*i + 2))/2;
           }
           centroid = topIntegral/bottomIntegral;
       }
        setLikelihoodOfRetention(centroid/100.0);
    }
    
    public double findMax()
    {
        double max;
        max = Math.max(verylikelyToRemain, likelyToRemain);
        max = Math.max(max, tossUp);
        max = Math.max(max, unlikelyToRemain);
        max = Math.max(max, veryUnlikelyToRemain);
        return max;
    }
    
    public void recommendAction()
    {
        if(likelihoodOfRetentionPercentage < 50.0)
        {
            setActionToTake("Immediate Action Required! Intervene now!");
        }
        else if(likelihoodOfRetentionPercentage < 75.0)
        {
            setActionToTake("Some action recommended. Speak with student before the end of the semester.");
        }
        else
        {
            setActionToTake("No action required. Student is likely to remain.");
        }
    }
}
