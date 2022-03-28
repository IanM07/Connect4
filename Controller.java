package connect4;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Author Ian McMullen
 */

public class Controller extends JFrame implements PlayingTheGame{
    
    ArrayList<PlayerPiece> playerBoardOne = new ArrayList<>();
    ArrayList<PlayerPiece> playerBoardTwo = new ArrayList<>();    
    ArrayList<PlayerPiece> winCheck = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    
    //Initialize Global Variables
    // <editor-fold>
    int c = 35;
    int d = 36;
    int f = 37;
    int l = 38;
    int m = 39;
    int n = 40;
    int o = 41;
    int c1X = 1;
    int c1Y = 1;
    int c2X = 2;
    int c2Y = 1;
    int c3X = 3;
    int c3Y = 1;    
    int c4X = 4;
    int c4Y = 1;    
    int c5X = 5;
    int c5Y = 1;    
    int c6X = 6;
    int c6Y = 1;    
    int c7X = 7;
    int c7Y = 1;    
    int turn = 0;
    int counter = 0;
    long total = 0;
    int winner = 2;
    // </editor-fold>
    
    public void Controller(){
        
        //GUI Frame Creation
        setVisible(true);
        setLayout(new FlowLayout());
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6,7,5,5));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        
        ImageIcon redPiece = new ImageIcon("images/RedPiece.png");
        ImageIcon blackPiece = new ImageIcon("images/BlackPiece.png");
        ImageIcon grayPiece = new ImageIcon("images/GrayPiece.png");
        
        //GUI grid creation
        for (int a = 1; a < 7; a++){
            for(int b = 1; b < 8; b++){
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(40,40));
                label.setIcon(grayPiece);
                labels.add(label);
                panel2.add(label);
            }
        }
        
        panel2.setBackground(Color.BLUE);
        
        //Button Creation and panel addition
        JButton dropColOne = new JButton("↓");
        panel1.add(dropColOne);
        buttons.add(dropColOne);
        JButton dropColTwo = new JButton("↓");
        panel1.add(dropColTwo);
        buttons.add(dropColTwo);
        JButton dropColThree = new JButton("↓");
        panel1.add(dropColThree);
        buttons.add(dropColThree);
        JButton dropColFour = new JButton("↓");
        panel1.add(dropColFour);
        buttons.add(dropColFour);
        JButton dropColFive = new JButton("↓");
        panel1.add(dropColFive);
        buttons.add(dropColFive);        
        JButton dropColSix = new JButton("↓");
        panel1.add(dropColSix);
        buttons.add(dropColSix);        
        JButton dropColSeven = new JButton("↓");
        panel1.add(dropColSeven);
        buttons.add(dropColSeven);        

        JLabel turnDisplay = new JLabel("Player One Turn");
        panel3.add(turnDisplay);
        
        JButton reset = new JButton("Reset Game");
        JButton close = new JButton("Close Game");
        
        //Column One Button
        // <editor-fold>
        dropColOne.addActionListener(ev ->{
            if(labels.get(c).getBackground() != Color.RED || labels.get(c).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(c).setIcon(redPiece); 
                    c = c - 7;
                }else{
                    labels.get(c).setIcon(blackPiece);
                    c = c -7;
                }
                if(c < 0){
                    dropColOne.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c1X,c1Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c1X,c1Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c1X,c1Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();                
                c1Y++;
                turnUpdate();
                turnDisplay.setText(turnString());        
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }
            }
        });
        // </editor-fold>
        
        //Column Two Button
        // <editor-fold>
        dropColTwo.addActionListener((ActionEvent e) -> {
            if(labels.get(d).getBackground() != Color.RED || labels.get(d).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(d).setIcon(redPiece);
                    d = d - 7;
                }else{
                    labels.get(d).setIcon(blackPiece);
                    d = d -7;
                }
                if(d < 0){
                    dropColTwo.setEnabled(false);
                }                
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c2X,c2Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c2X,c2Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c2X,c2Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }
                checkwin();
                c2Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }                
            }            
        });
        // </editor-fold>
        
        //Column Three Button
        // <editor-fold>
        dropColThree.addActionListener((ActionEvent e) -> {
            if(labels.get(f).getBackground() != Color.RED || labels.get(f).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(f).setIcon(redPiece);
                    f = f - 7;
                }else{
                    labels.get(f).setIcon(blackPiece);
                    f = f -7;
                }
                if(f < 0){
                    dropColThree.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c3X,c3Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c3X,c3Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c3X,c3Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();
                c3Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }                
            }    
        });   
        // </editor-fold>
        
        //Column Four Button
        // <editor-fold>
        dropColFour.addActionListener((ActionEvent e) -> {
            if(labels.get(l).getBackground() != Color.RED || labels.get(l).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(l).setIcon(redPiece);
                    l = l - 7;
                }else{
                    labels.get(l).setIcon(blackPiece);
                    l = l -7;
                }
                if(l < 0){
                    dropColFour.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c4X,c4Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c4X,c4Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c4X,c4Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();
                c4Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }                
            }
        });
        // </editor-fold>
        
        //Column Five Button
        // <editor-fold>
        dropColFive.addActionListener((ActionEvent e) -> {
            if(labels.get(m).getBackground() != Color.RED || labels.get(m).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(m).setIcon(redPiece);
                    m = m - 7;
                }else{
                    labels.get(m).setIcon(blackPiece);
                    m = m -7;
                }
                if(m < 0){
                    dropColFive.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c5X,c5Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c5X,c5Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c5X,c5Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();
                c5Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }                
            }
        });      
        // </editor-fold>
    
        //Column Six Button
        // <editor-fold>
        dropColSix.addActionListener((ActionEvent e) -> {
            if(labels.get(n).getBackground() != Color.RED || labels.get(n).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(n).setIcon(redPiece);
                    n = n - 7;
                }else{
                    labels.get(n).setIcon(blackPiece);
                    n = n -7;
                }
                if(n < 0){
                    dropColSix.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c6X,c6Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c6X,c6Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c6X,c6Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();
                c6Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }
            }
        });  
        // </editor-fold>
        
        //Column Seven Button 
        // <editor-fold>
        dropColSeven.addActionListener((ActionEvent e) -> {
            if(labels.get(o).getBackground() != Color.RED || labels.get(o).getBackground() != Color.BLACK){
                if(turn == 0){
                    labels.get(o).setIcon(redPiece);
                    o = o - 7;
                }else{
                    labels.get(o).setIcon(blackPiece);
                    o = o -7;
                }
                if(o < 0){
                    dropColSeven.setEnabled(false);
                }
            }
            panel2.revalidate();
            
            if(!playerBoardOne.contains(new PlayerPiece(c7X,c7Y,false,Color.RED,0)) && !playerBoardTwo.contains(new PlayerPiece(c7X,c7Y,false,Color.RED,1))){
                PlayerPiece newPiece = new PlayerPiece(c7X,c7Y,false,Color.RED,turn);
                if(turn == 0){
                    playerBoardOne.add(newPiece);
                }else{
                    playerBoardTwo.add(newPiece);
                }                
                checkwin();
                c7Y++;
                turnUpdate();
                turnDisplay.setText(turnString());
                if(winner == 0 || winner == 1){
                    panel4.add(reset);
                    panel4.add(close);
                }
            }
        });        
        // </editor-fold>
        
        //Reset Button
        reset.addActionListener((ActionEvent e) -> {
            Controller gameController = new Controller();
            gameController.Controller();
            this.dispose();
        });
        
        //Close Button
        close.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Finalization of GUI
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        pack();
        setSize(335,450);   
        setResizable(false);
    }
 
    @Override
    public int checkwin() {
        
            //Player One Vertical Win Check
            // <editor-fold>
            if(turn == 0){
                counter = 0;
                playerBoardOne.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardOne.size(); i++){
                    if(i+1 != playerBoardOne.size()){
                        if(playerBoardOne.get(i).getXCoord() == playerBoardOne.get(i+1).getXCoord() && playerBoardOne.get(i).getYCoord() == playerBoardOne.get(i+1).getYCoord()-1){
                            counter++;
                            if(counter == 3){
                                winner = 0;
                                return winner;
                            }
                        }else{
                            counter = 0;
                        }
                    }    
                }
            }// </editor-fold>
            
            //Player Two Vertical Win Check
            // <editor-fold>
            if(turn == 1){
                counter = 0;
                playerBoardTwo.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardTwo.size(); i++){
                    if(i+1 != playerBoardTwo.size()){
                        if(playerBoardTwo.get(i).getXCoord() == playerBoardTwo.get(i+1).getXCoord() && playerBoardTwo.get(i).getYCoord() == playerBoardTwo.get(i+1).getYCoord()-1){
                            counter++;
                            if(counter == 3){
                                winner = 1;
                                return winner;
                            }
                        }else{
                            counter = 0;
                        }
                    }    
                }               
            }// </editor-fold>
            
            //Player One Horizontal Win Check
            // <editor-fold>            
            if(turn == 0){
                counter = 0;
                playerBoardOne.sort(Comparator.comparing(PlayerPiece::getYCoord).thenComparing(Comparator.comparing(PlayerPiece::getXCoord)));
                for(int i = 0; i < playerBoardOne.size(); i++){
                    if(i+1 != playerBoardOne.size()){
                        if(playerBoardOne.get(i).getYCoord() == playerBoardOne.get(i+1).getYCoord() && playerBoardOne.get(i).getXCoord() == playerBoardOne.get(i+1).getXCoord()-1){
                            counter++;
                            if(counter == 3){
                                winner = 0;
                                return winner;
                            }
                        }else{
                            counter = 0;
                        }
                    }    
                }
            }// </editor-fold>
            
            //Player Two Horizontal Win Check
            // <editor-fold>
            if(turn == 1){
                counter = 0;
                playerBoardTwo.sort(Comparator.comparing(PlayerPiece::getYCoord).thenComparing(Comparator.comparing(PlayerPiece::getXCoord)));
                for(int i = 0; i < playerBoardTwo.size(); i++){
                    if(i+1 != playerBoardTwo.size()){
                        if(playerBoardTwo.get(i).getYCoord() == playerBoardTwo.get(i+1).getYCoord() && playerBoardTwo.get(i).getXCoord() == playerBoardTwo.get(i+1).getXCoord()-1){
                            counter++;
                            if(counter == 3){
                                winner = 1;
                                return winner;
                            }
                        }else{
                            counter = 0;
                        }
                    }    
                }               
            }// </editor-fold>
     
            //Player One Diagonal Up Win Check
            // <editor-fold>
            if(turn == 0){
                playerBoardOne.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardOne.size(); i++){
                    PlayerPiece piece1 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 1,playerBoardOne.get(i).getYCoord() + 1,false,Color.RED,0);
                    PlayerPiece piece2 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 2,playerBoardOne.get(i).getYCoord() + 2,false,Color.RED,0);
                    PlayerPiece piece3 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 3,playerBoardOne.get(i).getYCoord() + 3,false,Color.RED,0);
                    
                    long count1 = playerBoardOne
                    .stream()
                    .filter(s -> s.getXCoord() == piece1.getXCoord() && s.getYCoord() == piece1.getYCoord()).count();
                            
                    long count2 = playerBoardOne
                    .stream()
                    .filter(q -> q.getXCoord() == piece2.getXCoord() && q.getYCoord() == piece2.getYCoord()).count();
                                        
                    long count3 = playerBoardOne
                    .stream()
                    .filter(r -> r.getXCoord() == piece3.getXCoord() && r.getYCoord() == piece3.getYCoord()).count();
                    
                    total = count1 + count2 + count3;
                    if(total == 3){
                        winner = 0;
                        return winner;
                    }
                }
                total = 0;
            }    
            // </editor-fold>
            
            //Player Two Diagonal Up Win Check
            // <editor-fold>
            if(turn == 1){
                playerBoardTwo.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardTwo.size(); i++){
                    PlayerPiece piece1 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 1,playerBoardTwo.get(i).getYCoord() + 1,false,Color.BLACK,1);
                    PlayerPiece piece2 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 2,playerBoardTwo.get(i).getYCoord() + 2,false,Color.BLACK,1);
                    PlayerPiece piece3 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 3,playerBoardTwo.get(i).getYCoord() + 3,false,Color.BLACK,1);
                    
                    long count1 = playerBoardTwo
                    .stream()
                    .filter(s -> s.getXCoord() == piece1.getXCoord() && s.getYCoord() == piece1.getYCoord()).count();
                            
                    long count2 = playerBoardTwo
                    .stream()
                    .filter(q -> q.getXCoord() == piece2.getXCoord() && q.getYCoord() == piece2.getYCoord()).count();
                                        
                    long count3 = playerBoardTwo
                    .stream()
                    .filter(r -> r.getXCoord() == piece3.getXCoord() && r.getYCoord() == piece3.getYCoord()).count();
                    
                    total = count1 + count2 + count3;
                    if(total == 3){
                        winner = 1;
                        return winner;
                    }
                }
                total = 0;
            }    
            // </editor-fold>
            
            //Player One Diagonal Down Win Check
            // <editor-fold>
            if(turn == 0){
                playerBoardOne.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardOne.size(); i++){
                    PlayerPiece piece1 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 1,playerBoardOne.get(i).getYCoord() - 1,false,Color.RED,0);
                    PlayerPiece piece2 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 2,playerBoardOne.get(i).getYCoord() - 2,false,Color.RED,0);
                    PlayerPiece piece3 = new PlayerPiece(playerBoardOne.get(i).getXCoord() + 3,playerBoardOne.get(i).getYCoord() - 3,false,Color.RED,0);
                    
                    long count1 = playerBoardOne
                    .stream()
                    .filter(s -> s.getXCoord() == piece1.getXCoord() && s.getYCoord() == piece1.getYCoord()).count();
                            
                    long count2 = playerBoardOne
                    .stream()
                    .filter(q -> q.getXCoord() == piece2.getXCoord() && q.getYCoord() == piece2.getYCoord()).count();
                                        
                    long count3 = playerBoardOne
                    .stream()
                    .filter(r -> r.getXCoord() == piece3.getXCoord() && r.getYCoord() == piece3.getYCoord()).count();
                    
                    total = count1 + count2 + count3;
                    if(total == 3){
                        winner = 0;
                        return winner;
                    }
                }
                total = 0;
            }    
            // </editor-fold>           
            
            //Player Two Diagonal Down Win Check
            // <editor-fold>
            if(turn == 1){
                playerBoardTwo.sort(Comparator.comparing(PlayerPiece::getXCoord).thenComparing(Comparator.comparing(PlayerPiece::getYCoord)));
                for(int i = 0; i < playerBoardTwo.size(); i++){
                    PlayerPiece piece1 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 1,playerBoardTwo.get(i).getYCoord() - 1,false,Color.BLACK,1);
                    PlayerPiece piece2 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 2,playerBoardTwo.get(i).getYCoord() - 2,false,Color.BLACK,1);
                    PlayerPiece piece3 = new PlayerPiece(playerBoardTwo.get(i).getXCoord() + 3,playerBoardTwo.get(i).getYCoord() - 3,false,Color.BLACK,1);
                    
                    long count1 = playerBoardTwo
                    .stream()
                    .filter(s -> s.getXCoord() == piece1.getXCoord() && s.getYCoord() == piece1.getYCoord()).count();
                            
                    long count2 = playerBoardTwo
                    .stream()
                    .filter(q -> q.getXCoord() == piece2.getXCoord() && q.getYCoord() == piece2.getYCoord()).count();
                                        
                    long count3 = playerBoardTwo
                    .stream()
                    .filter(r -> r.getXCoord() == piece3.getXCoord() && r.getYCoord() == piece3.getYCoord()).count();
                    
                    total = count1 + count2 + count3;
                    if(total == 3){
                        winner = 1;
                        return winner;
                    }
                }
                total = 0;
            }    
            // </editor-fold>
            
        
        return winner; //Returns if there is no winner yet   
    }
    
    //Updates the turn display
    public String turnString(){
        String turnDisplay = ("");        
        if(turn == 0 && winner != 0){
            turnDisplay = ("Player One Turn");
        }else if(turn == 1 && winner != 1){
            turnDisplay = ("Player Two Turn");
        }else if(winner == 0){
            for(JButton b : buttons){
                b.setEnabled(false);
            }
            turnDisplay = ("Player One Wins");
        }else if(winner == 1){
            for(JButton b : buttons){
                b.setEnabled(false);
            }
            turnDisplay = ("Player Two Wins");
        }                
        return turnDisplay;
    }
    
    //Update turn order
    public int turnUpdate(){
        if (turn == 0 && winner != 0) {
            turn = 1;
        } else if (turn == 1 && winner != 1) {
            turn = 0;
        }       
        return turn; 
    }
    
}          