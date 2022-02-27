package connect4;
import java.awt.Color;

/*
 * @author Ian McMullen
 */

public class Spaces {
    int xCoord;
    int yCoord;
    boolean isOpen;
    Color color;
    
    public Spaces(int xcoord, int ycoord,boolean isOpen, Color color){
        this.isOpen = isOpen;
        this.xCoord = xcoord;
        this.yCoord = ycoord;
    }

    
    //Here to verify that the board is being created properly
    @Override
    public String toString() {
        String info = "";
        info += "X-Coord: " + this.xCoord + " Y-Coord: "+ this.yCoord + "\n";
        return info;
    }
        
}
