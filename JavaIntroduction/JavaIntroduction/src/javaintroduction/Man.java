/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroduction;

import java.util.Date;

/**
 *
 * @author smith
 */
public class Man {
    
    //Поля класса 
    private String surname;
    public String homeland;
    public Date birthDate;
    private Man bestFriend;
    
    static int classID = 3;      //пример статического поля
    
    //Конструктор класса без параметров
    public Man() {               //если новому инстансу явно не указали значения полей, то он установит их сам
        System.out.println("Вызван человечий конструктор ^_^");
        this.surname = "Snow";
        this.homeland = "North";
    }
    
    //Конструктор с параметрами
    public Man(String surname, String homeland, Date birthdate) {   //новый инстанс класса создается с явно заданными значениями полей
        System.out.println("Вызван умный человечий конструктор ^_^");
        this.surname = surname;
        this.homeland = homeland;
        this.birthDate = birthdate;
    }
    
    //методы класса
    public String getSurname() {                     //типичный геттер
        return this.surname;
    }
    
    public void setSurname(String surname) {         //типичный сеттер
        this.surname = surname;
    }
    
    public void makeBestFriend(Man friend) {
        if(friend != this) {
            this.bestFriend = friend;
            System.out.println(this.surname + " is in friendship with" + friend.surname);
        }
        else
            System.out.println("Wrong argument");
        
    }
}
