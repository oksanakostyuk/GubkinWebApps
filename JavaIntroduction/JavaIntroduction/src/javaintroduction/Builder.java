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
public class Builder extends Man implements Educated {           //наследник класса Man и подписчик интерфейса Educated
    
    String companyName;
    
    public Builder(String surname, String homeland, Date birthdate, String companyName) {
        super(surname, homeland, birthdate);
        System.out.println("Вызван конструктор строителя");
        this.companyName = companyName;
    }
    
    public void printInfo() {
        System.out.println("Выдаем информацию о строителе");
        System.out.println("surname: " + this.getSurname());
        System.out.println("homeland: " + this.homeland);
        System.out.println("birthdate: " + this.birthDate);
        System.out.println("companyName: " + this.companyName);
    }
    
    
    //методы, наличие которых требует интерфейс
    public void readDocumentation() {                    
        System.out.println("Строитель читает доку");
    }
    
    public void writeDocumentation() {
        System.out.println("Строитель пишет доку");
    }
    
    public void askHelpWithDocuments(Educated educated) {          //строитель может попросить помощи у кого угодно, имплементирующего интерфейс "образованный", конкретный класс неважен
        educated.readDocumentation();       //так как объект в любом случае обладает этими методами (из-за требований интерфейса), можно их вызывать
        educated.writeDocumentation();
    }
    
    
}
