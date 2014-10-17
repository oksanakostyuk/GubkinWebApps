/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroduction;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author smith
 */
public class JavaIntroduction {

    /**
     * @param args the command line arguments
     */
    
    
    private static Logger log = Logger.getLogger(JavaIntroduction.class.getName());  //инструмент логирования 
    
    
    public static void main(String[] args) {
        
        
        //ИСПОЛНЯЕМЫЙ БЛОК ПРОГРАММЫ
        //Здесь размещены основные тесты юнитов программы
        
        
        //////////////
        ///  BLOCK 1, Элементарные конструкции в Java
        //////////////
        System.out.println("BLOCK 1");
        System.out.print("\n");
        
        int x = 4;           //объявление и инициализация примитивов
        double y;
        y = 5;
        System.out.println("x + y = " +(x+y));  //классический вывод в консоль приложения
        
        String str = "Frederic Chopin";         //строка - в двойных ковычках
        char c = '+';                           //символ - в одинарных
        
        
        
        // c.   //  примитив не имеет методов и полей
        boolean flag = str.endsWith("Chopin");                 // строка - объект класса, а не примитив, поэтому обладает набором методов для работы с ней
        
        if(flag) {                        //типичный условный оператор в Java
            System.out.println("str ends with Chopin");
        }
        else if (str.endsWith("in")) {    //проверка дополнительных условий
            System.out.println("str ends with in");
        }
        else {
            System.out.println("else block");
        }
        
        
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));               //выводим строку посимвольно в цикле
        }
        
        System.out.print("\n");             //символ конца строки
        
        for(byte ch: str.getBytes()) {      //foreach-подобный обход массива 
            System.out.print(ch);           //обход и вывод строки побайтово
        }
        
        System.out.print("\n");
        System.out.print("\n");
                       
                
        //////////////
        ///  BLOCK 2, Основы ООП в Java
        //////////////
        
        System.out.println("BLOCK 2");
        System.out.print("\n");
                       
        Man person1 = new Man();            // создание объекта через вызов конструктора без параметров
        Date birthForPerson2 = new Date();  // создание даты с помощью конструктора класса Date без параметров
        Man person2 = new Man("Linden", "Denmark", birthForPerson2); // создание объекта с помощью конструктора с параметрами, в качестве параметра даты рождения выступает объект класса Date
        
        System.out.println(person1.homeland);  // выводим значение поля объекта
        System.out.println("person2 homeland: " + person2.homeland);  // выводим значение поля объекта
        System.out.println("person2 birthdate: " + person2.birthDate);  // выводим значение поля объекта
        
        person1.homeland = "Russia";           // переписываем объекту поле homeland
        System.out.println(person1.homeland);  // проверяем изменение
        //две строки выше демонстрируют плохой подход к работе с объектом, но это работает
        
        // более технически грамотным подходом является использование геттеров/сеттеров - методов, на которых возложено адекватное управление полями
        person1.setSurname("Rahmaninov");      //устанавливаем новое значение поля
        System.out.println("Getter of person1-surname returns: " + person1.getSurname());  //       
        // обратите внимание, открытый доступ к полю фамилии у объектов класса Man невозможен - поле private
        
        person1.makeBestFriend(person2);      // вызов метода с аргументом такого же типа
        person1.makeBestFriend(person1);      // выдаст сообщение об ошибке
        
        // обратите внимание, отсюда нельзя никак получить доступ к полю bestFriend объекта Man - инкапсуляция в действии
        
        System.out.println("Testing static field: " + Man.classID);   //обращение к статическому полю класса не требует объекта! 
        
        
        ////////////////////////////// Наследование
        
        Policeman melinda = new Policeman();           //вызовем кривоватый конструктор чтобы создать объект класса Policeman
        System.out.println("melinda info is - surname: " + melinda.getSurname());        //обращаем внимание на неявный вызов конструктора суперкласса
        
        Policeman anders = new Policeman("St leitenant", "Frimen", "Sweden");
        Policeman gosha = new Policeman("Ml leitenant", "Petrov", "Russia");
        
        System.out.println(anders.friends);   //распечатаем коллекцию друзей андерса - она пуста
        anders.addFriend(melinda);  //добавим в коллекцию друга
        System.out.println(anders.friends);   // видим, что коллекция пополнилась, только вот чем - непонятно
        anders.addFriend(gosha);
        System.out.println(anders.friends);   // в коллекции два непонятных пугала
        
        //обойдем всех друзей андерса в цикле и напечатаем их фамилии
        System.out.println("Друзья андерса: ");
        for(Policeman p: anders.friends) {
            System.out.println(p.getSurname());      //получаем фамилию геттером! ВНИМАНИЕ - геттер не определялся в классе Policeman отдельно - так как уже был определен в суперклассе Man
        }           
        
        //anders.friends.add(person1);              //В данном случае написан неработающий код, так как коллекция друзей андерса ArrayList строготипизирована, загнать туда Man не получится.
        
        anders.getMarried(person2);                 //поженили андерса на человеке
        
        // Однако, никто не говорит, что женить полицейского можно ТОЛЬКО на объекте класса Man
        
        gosha.getMarried(melinda);  //аргумент класса Policeman в подобной ситуации сойдет за аргумент класса Man, так как имеет место наследование
        
        
        System.out.println("Фамилия жены андерса: " + anders.wife.getSurname());    //вывели в консоль фамилию жены андерса
        System.out.println("Фамилия жены гоши: " + gosha.wife.getSurname());    //вывели в консоль фамилию жены Гоши ПЕтрова
        
        
        //////////////
        ///  BLOCK 3, Интерфейсы в Java
        //////////////
        
        Builder vincent = new Builder("Cavanagh", "UK", new Date(), "SkyForge INC.");
        
        vincent.printInfo();
        
        Builder danny = new Builder("Cavanagh", "UK", new Date(), "SkyForge INC."); //брат и коллега Винсента
        Student john = new Student();
        
        vincent.askHelpWithDocuments(danny);        // попросил помощи у Дэнни   
        vincent.askHelpWithDocuments(john);         // попросил помощи у Винсента
        
        
        //////////////
        ///  BLOCK 4, Работа с коллекциями
        //////////////
        
        
        //////////////
        ///  BLOCK 5, Обработка исключений
        //////////////
        
        
        
        //////////////
        ///  BLOCK 6, Работа с внешними данными, ввод
        //////////////
        
    }
}
