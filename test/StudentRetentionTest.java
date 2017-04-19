/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicol
 */
public class StudentRetentionTest {
    
    @Test
    public void testReadFileAndGetStudents() throws Exception {
        System.out.println("readFileAndGetStudents");
        StudentRetention students = new StudentRetention();
        ArrayList<Student> studentsList = students.readFileAndGetStudents();
        assertEquals(2.0948843659942935, studentsList.get(0).GPA, 0.001);
        System.out.println("readFileAndGetStudents Passed");
    }

    @Test
    public void testGetStudent() {
        System.out.println("getStudent");
        double gpa = 4.0;
        int numActivities = 0;
        StudentRetention retention = new StudentRetention();
        Student student = retention.getStudent(gpa, numActivities);
        assertEquals(1.0, student.fuzzyGPA.highGPA, 0.001);
    }

    @Test
    public void testGetProbabilities() throws Exception {
        System.out.println("getProbabilities");
        StudentRetention retention = new StudentRetention();
        ArrayList<Student> students = retention.readFileAndGetStudents();
        retention.getProbabilities();
        assertTrue(students.get(0).likelihoodOfRetentionPercentage >= 0.0);
    }

    @Test
    public void testGetActionsToTake() throws Exception
    {
        System.out.println("getActionsToTake");
        StudentRetention retention = new StudentRetention();
        ArrayList<Student> students = retention.readFileAndGetStudents();
        retention.getProbabilities();
        retention.getActionsToTake();
        assertTrue(students.get(0).actionToTake.equals("Immediate Action Required! Intervene now!"));
    }
    
}
