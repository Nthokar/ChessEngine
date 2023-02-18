package Chess.Parser;

import Chess.Desk.Cell;
import Chess.Desk.Move;

import java.util.Scanner;

public class ConsoleMoveReader {
    public static Move readMove(String str){
        try {
            return new Move(readCell(str.substring(0,2)), readCell(str.substring(2)));
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException("wrong input");
        }
    }

    public static Cell readCell(String str) throws IllegalAccessException {
        if (str.length() != 2)
            throw new IllegalAccessException();
        return new Cell((int)str.charAt(0) - (int)'a', Character.getNumericValue(str.charAt(1)));
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        for(;;){
            var input = myObj.nextLine();
            var move = readMove(input);
            System.out.println(move);
        }
    }
}