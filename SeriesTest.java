/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesTest {
    
    

    

    /**
     * Test of getValidAgeRestriction method, of class Series.
     */
    @Test

    public void testGetValidAgeRestriction() {
        System.out.println("getValidAgeRestriction");
        int age = 0;
        Series instance = new Series();
        boolean expResult = false;
        boolean result = instance.getValidAgeRestriction(age);
        assertEquals(expResult, result);
        
    }
    
}
