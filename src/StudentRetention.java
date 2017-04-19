
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
public class StudentRetention {
    ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Student> readFileAndGetStudents() throws FileNotFoundException
    {
        FileReader in = new FileReader("C:\\Users\\nicol\\Documents\\Graduate Classes\\SSE 635\\Project 2\\Students.txt");
        BufferedReader thisReader = new BufferedReader(in);
        Object[] lines = thisReader.lines().toArray();
        for(int i = 0; i < lines.length; i+=2)
        {
            String studentInfo = lines[i].toString();
            int commaIndex1 = studentInfo.indexOf(",");
            int commaIndex2 = studentInfo.indexOf(",", commaIndex1+1);
            
            String gpaString = studentInfo.substring(0, commaIndex1);
            String numActivitiesString = studentInfo.substring(commaIndex1+1, commaIndex2);
            
            double gpa = Double.parseDouble(gpaString);
            int numActivities = Integer.parseInt(numActivitiesString);
            
            Student thisStudent = getStudent(gpa, numActivities);
            students.add(thisStudent);
        }
        return students;
    }
    
    public Student getStudent(double gpa, int numActivities)
    {
        Student thisStudent = new Student(gpa, numActivities);
        thisStudent.setFuzzyValues();
        thisStudent.setHedges();
        return thisStudent;
    }
    
    public void getProbabilities()
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student currentStudent = students.get(i);currentStudent.calculateRetentionProbability();
            students.set(i, currentStudent);
        }
    }
    
    public void getActionsToTake()
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student currentStudent = students.get(i);
            currentStudent.recommendAction();
            students.set(i, currentStudent);
        }
    }
    
    
}
