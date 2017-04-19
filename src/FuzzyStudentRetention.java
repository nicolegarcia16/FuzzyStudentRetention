
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuzzyStudentRetention {

    public static void main(String[] args) throws FileNotFoundException {
        StudentRetention theseStudents = new StudentRetention();
        ArrayList<Student> students = theseStudents.readFileAndGetStudents();
        Scanner consoleIn = new Scanner(System.in);
        consoleIn.nextLine();
        theseStudents.getProbabilities();
        theseStudents.getActionsToTake();
        printResults(students);
    }
    
    public static void printResults(ArrayList<Student> students)
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student currentStudent = students.get(i);
            System.out.format("GPA:\t\t\t\t\t %.2f \n", currentStudent.GPA);
            System.out.println("Number of extracurricular activities:\t " 
                    + currentStudent.numberOfActivities);
            System.out.format("Likelihood of retaining student:\t %.2f \n", 
                    currentStudent.likelihoodOfRetentionPercentage);
            System.out.println("Recommendation: " + currentStudent.actionToTake);
            System.out.println();
            
        }
    }
}

