package connect4;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/*
 * Author Ian McMullen
 */

public class Controller implements PlayingTheGame{
    
    ArrayList<PlayerPiece> playerBoard = new ArrayList<>();
    ArrayList<PlayerPiece> winCheck = new ArrayList<>();
    
    public void Controller(){
        //determines turn order
        Random rand = new Random();
        int turn = rand.nextInt(2);
        boolean winner = false;
        
        //creates gameloop
        while(winner == false){
            while(turn == 0){
                player1turn();
                if(checkSpace()){
                    turn = 1;
                    displayBoard();
                    checkwin();
                    if (checkwin() == 1){
                        winner = true;
                        //display a gui saying player 1 wins
                    }
                }
            }
            
            while(turn == 1){
                player2turn();
                if(checkSpace()){
                    turn = 0;
                    displayBoard();
                    checkwin();
                    if (checkwin() == 2){
                        winner = true;
                        //display a gui saying player 2 wins
                    }
                }
            }
        }   
    }

    public void player1turn() {
        //player 1 turn method, will create a player 1 piece in xcoord and ycoord clicked on WIP
    }
    
    public void player2turn() {
        //player 2 turn method, will create a player 2 piece in xcoord and ycoord clicked on WIP
    }
    
    public void displayBoard() {
        //method to display the board after each turn WIP
    }
    
    public boolean checkSpace(){
        //method to check to see if space is open WIP
        boolean open = true;
        return open;
    }
    
    //Adds a player 1 piece to the board in the x and y coords clicked on WIP
    public void addPiece1(){
        int x = 0;
        int y = 0;
        playerBoard.add(new PlayerPiece(x, y, false, Color.BLACK, 1));
    }
    
    //Adds a player 2 piece to the board in the x and y coords clicked on WIP
    public void addPiece2(){
        int x = 0;
        int y = 0;
        playerBoard.add(new PlayerPiece(x, y, false, Color.RED, 1));
    }

    @Override
    public int checkwin() {
        //method to check to see if a player has won
        int winner = 0;
        
        /*The following win checks are a rough estimate of the algorithms needed
          I will test this extensively once the game is completed
          Feedback and suggestions here would be helpful*/
        
            //Vertical win check
            for(int i = 0; i < playerBoard.size(); i++){
                for(int j = i + 2; j < playerBoard.size(); j++){ //These two for loops iterate through each item in the list,compares it to all others, searches for matching coords
                    if (playerBoard.get(i).getXCoord() == playerBoard.get(j).getXCoord()) { //Not sure if this if statement works properly
                        winCheck.add(playerBoard.get(i)); //Adds the matching coords to a list to further check coords
                        if(winCheck.size() > 4){
                            for(int k = 0; k < winCheck.size(); k++){ //checks the final coords to see if a win has occured
                                if(winCheck.get(k).getYCoord() == winCheck.get(k+1).getYCoord() - 1 && winCheck.get(k).getYCoord() == winCheck.get(k+2).getYCoord() - 2 && winCheck.get(k).getYCoord() == winCheck.get(k+3).getYCoord() - 3){
                                    winner = winCheck.get(1).getPlayerNum();
                                    return winner;
                                }
                            }
                        }
                    }
                }
            }
            
            //Horizontal win check
            for(int i = 0; i < playerBoard.size(); i++){ 
                for(int j = i + 2; j < playerBoard.size(); j++){ //These two for loops iterate through each item in the list,compares it to all others, searches for matching coords
                    if (playerBoard.get(i).getYCoord() == playerBoard.get(j).getYCoord()) { //Not sure if this if statement works properly
                        winCheck.add(playerBoard.get(i)); //Adds the matching coords to a list to further check coords
                        if(winCheck.size() > 4){
                            for(int k = 0; k < winCheck.size(); k++){ //checks the final coords to see if a win has occured
                                if(winCheck.get(k).getXCoord() == winCheck.get(k+1).getXCoord() - 1 && winCheck.get(k).getXCoord() == winCheck.get(k+2).getXCoord() - 2 && winCheck.get(k).getXCoord() == winCheck.get(k+3).getXCoord() - 3){
                                    winner = winCheck.get(1).getPlayerNum();
                                    return winner;
                                }
                            }
                        }
                    }
                }
            }
     
            //Diagonal Right Up win check
            for(int i = 0; i < playerBoard.size(); i++){
                for(int j = i + 2; j < playerBoard.size(); j++){ //These two for loops iterate through each item in the list,compares it to all others, searches for matching coords
                    if (playerBoard.get(i).getXCoord() == playerBoard.get(j).getXCoord() - i + 1) { //Not sure if this if statement works properly
                        winCheck.add(playerBoard.get(i)); //Adds the matching coords to a list to further check coords
                        if(winCheck.size() > 4){
                            for(int k = 0; k < winCheck.size(); k++){ //checks the final coords to see if a win has occured
                                if(winCheck.get(k).getYCoord() == winCheck.get(k+1).getYCoord() - 1 && winCheck.get(k).getYCoord() == winCheck.get(k+2).getYCoord() - 2 && winCheck.get(k).getYCoord() == winCheck.get(k+3).getYCoord() - 3){
                                    winner = winCheck.get(1).getPlayerNum();
                                    return winner;
                                }
                            }
                        }
                    }
                }
            }
            
            //Diagonal Right Up win check
            for(int i = 0; i < playerBoard.size(); i++){
                for(int j = i + 2; j < playerBoard.size(); j++){ //These two for loops iterate through each item in the list,compares it to all others, searches for matching coords
                    if (playerBoard.get(i).getXCoord() == playerBoard.get(j).getXCoord() - i + 1) { //Not sure if this if statement works properly
                        winCheck.add(playerBoard.get(i)); //Adds the matching coords to a list to further check coords
                        if(winCheck.size() > 4){
                            for(int k = 0; k < winCheck.size(); k++){ //checks the final coords to see if a win has occured
                                if(winCheck.get(k).getYCoord() == winCheck.get(k+1).getYCoord() + 1 && winCheck.get(k).getYCoord() == winCheck.get(k+2).getYCoord() + 2 && winCheck.get(k).getYCoord() == winCheck.get(k+3).getYCoord() + 3){
                                    winner = winCheck.get(1).getPlayerNum();
                                    return winner;
                                }
                            }
                        }
                    }
                }
            }
        return winner; //Returns if there is no winner yet
    }
         
}
           
    
