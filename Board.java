/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author under
 */
public class Board {
        
    //Main Method
    public static void  main(String[] args){
        Board board1 = new Board();
        board1.initBoard();
    }
    
    ArrayList<Spaces> emptyBoard = new ArrayList<>();

    //Creates the empty board spaces
    public void initBoard(){
        for (int x = 1; x < 8; x++){
            for(int y = 1; y < 7; y++){
                emptyBoard.add(new Spaces(x,y,true,Color.GRAY));
            }
        }
        
        //verifying x and y coordinates
        System.out.println(emptyBoard);
        
        Controller controller = new Controller();
        controller.Controller();
    }
}
