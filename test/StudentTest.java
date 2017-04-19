import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest 
{

    @Test
    public void testSetLikelihoodOfRetention() {
        System.out.println("setLikelihoodOfRetention");
        double likelihood = 0.0;
        Student student = new Student(4.0, 15);
        student.setLikelihoodOfRetention(0.6);
        assertEquals(student.likelihoodOfRetention, 0.6, 0.001);
        assertEquals(student.likelihoodOfRetentionPercentage, 60.0, 0.001);
        System.out.println("setLikelihoodOfRetention passed");
    }

    @Test
    public void testSetFuzzyValues() {
        System.out.println("setFuzzyValues");
        Student student = new Student(4.0, 15);
        student.setFuzzyValues();
        assertEquals(student.fuzzyGPA.highGPA ,1.0, 0.001);
        System.out.println("setFuzzyValues passed");
    }

    @Test
    public void testSetHedges() {
        System.out.println("setHedges");
        Student student = new Student(4.0, 15);
        student.setFuzzyValues();
        student.setHedges();
        assertEquals(student.fuzzyGPA.veryHighGPA ,1.0, 0.001);
        System.out.println("setHedges passed");
    }

    @Test
    public void testSetActionToTake() {
        System.out.println("setActionToTake");
        Student student = new Student(4.0, 15);
        String action = "Act now!";
        student.setActionToTake(action);
        assertEquals(student.actionToTake, action);
        System.out.println("setActionToTake passed");
    }

    @Test
    public void testCalculateRetentionProbability() {
        System.out.println("calculateRetentionProbability");
        Student student = new Student(4.0, 15);
        student.setFuzzyValues();
        student.setHedges();
        student.calculateRetentionProbability();
        assertEquals(student.likelihoodOfRetention, 0.922, 0.5);
        assertEquals(student.likelihoodOfRetentionPercentage, 92.2, 0.5);
        System.out.println("calculateRetentionProbability passed");
    }

    @Test
    public void testRecommendAction() {
        System.out.println("recommendAction");
        Student student = new Student(4.0, 15);
        student.setFuzzyValues();
        student.setHedges();
        student.calculateRetentionProbability();
        student.recommendAction();
        assertEquals(student.actionToTake, "No action required. Student is likely to remain.");
        System.out.println("recommendAction passed");
    }
    
}
