package connect4;
import java.awt.Color;

/*
 * @author Ian McMullen
 */

public class PlayerPiece extends Spaces{

    //playerNum = 1 refers to player 1, playerNum = 2 refers to player 2
    int playerNum;
    
    public PlayerPiece(int xCoord, int yCoord,boolean isOpen, Color color, int playerNum) {
        super(xCoord, yCoord, isOpen, color);
        this.playerNum = playerNum;
    }
    
    public int getXCoord(){
        return xCoord;
    }
    
    public int getYCoord(){
        return yCoord;
    }
    
    public void setXCoord(int newCoord){
        this.xCoord = newCoord;
    }
    
    public void setYCoord(int newCoord){
        this.yCoord = newCoord;
    }
    
    public int getPlayerNum(){
        return playerNum;
    }
    
}
