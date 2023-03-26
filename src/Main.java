import Chess.Desk.*;
import Chess.Parser.ConsoleMoveReader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Desk desk = new Desk(Desk.setDefault());
//        desk.print();
//        Scanner myObj = new Scanner(System.in)
        A a = new B();
        a.print();

        GameManager gm = new GameManager(System.in);
        gm.startGame();

    }
}
class A {
    public void print(){
        System.out.println(this.getClass());
    }
}

class B extends A{
    public void print(){
        System.out.println(this.getClass());
    }
}