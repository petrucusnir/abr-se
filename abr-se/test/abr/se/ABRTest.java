/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.se;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petrucusnir
 */
public class ABRTest {
    
    public ABRTest() {
    }
    
    @Test
    public void testArbreVide(){
        ABR t = new ABR();
        assertTrue(t.isEmpty());
    }
    
    @Test
    public void testInsert(){
        ABR t = new ABR();
        t.insert(8);
        t.insert(10);
        t.insert(9);
        assertEquals(t.root.valeur, 8);
        assertEquals(t.root.child_right_.valeur, 10);
        assertEquals(t.root.child_right_.child_left_.valeur, 9);
    }
    
    @Test
    public void testnbElement(){
        ABR t = new ABR();
        t.insert(8);
        t.insert(10);
        t.insert(9);
        System.out.println(t.root.valeur);
        assertEquals(t.nbElement(), 3);
    }
    
    
}
