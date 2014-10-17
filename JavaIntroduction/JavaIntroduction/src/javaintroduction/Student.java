/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroduction;

/**
 *
 * @author smith
 */
public class Student extends Man implements Educated {
    
    String vuz;
    
    public void readDocumentation() {
        System.out.println("Студент читает доку и ничего не понимает");
    }
    
    public void writeDocumentation() {
        System.out.println("Студент пишет доку и сам не знает о чем");
    }
}
