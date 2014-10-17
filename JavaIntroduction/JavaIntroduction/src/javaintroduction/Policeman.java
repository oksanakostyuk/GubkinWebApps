/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroduction;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author smith
 */
public class Policeman extends Man {
    
    String rank;
    ArrayList<Policeman> friends; 
    Man wife;

    public Policeman() {               //конструктор повышенной бессмысленности
        System.out.println("Вызван кривоватый полицейский конструктор :(");    //обратите внимание, сначала будет вызва конструктор суперкласса - неявно и без параметров 
    }
    
    public Policeman(String rank, String surname, String homeland) {       //более умный конструктор
        super(surname, homeland, new Date()); //вызов конструктора суперкласса (с параметрами!)
        System.out.println("Вызван умный полицейский конструктор :)");
        this.rank = rank;
        friends = new ArrayList<Policeman>(); 
    }
    
    public void addFriend(Policeman collega) {
        this.friends.add(collega);
    }
    
    public void getMarried(Man wife) {
        this.wife = wife;
    }
    
}
