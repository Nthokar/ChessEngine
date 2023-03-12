import Chess.Desk.*;
import Chess.Parser.ConsoleMoveReader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Desk desk = new Desk(Desk.setDefault());
//        desk.print();
//        Scanner myObj = new Scanner(System.in);
        GameManager gm = new GameManager(System.in);
        gm.startGame();

        for(;;){
//            Cell cell = null;
//            Cell cellTo = null;
//            try {
//                var input = myObj.nextLine();
//                var move = ConsoleMoveReader.readMove(input);
//                cell = move.from;
//                cellTo = move.to;
//                cell = desk.cells[cell.x][cell.y - 1];
//                cellTo = desk.cells[cellTo.x][cellTo.y - 1];
//                if (cell.getFigure() == null){
//                    System.out.println("choose possible move!");
//                    continue;
//                }
//                System.out.println(desk.moveChecker.isUnderAttack(cell));
//                var path = desk.moveChecker.pathTo(cell, cellTo);
//                cell.getFigure().move(path);
//                desk.print();
//            }
//            catch (Exception e){
//                System.out.println("failed while reading move o_O");
//            }
        }
    }
}