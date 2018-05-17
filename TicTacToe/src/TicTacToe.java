import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe extends JFrame
{
    private JFrame mainFrame;

    private JButton b[][] = {
                                {new JButton("A1"),new JButton("A2"),new JButton("A3")},
                                {new JButton("B1"),new JButton("B2"),new JButton("B3")},
                                {new JButton("C1"),new JButton("C2"),new JButton("C3")},
                            };

    Random rand = new Random();
    private int randomOneOrZero = rand.nextInt(2);
    private int xo = randomOneOrZero;

    public TicTacToe() //constructor
    {
        mainFrame = new JFrame("Tic Tac Toe");

        Container c = mainFrame.getContentPane();
        c.setLayout(new GridLayout(3,3));

        for(int i = 0; i<3; i++)
        {
            for(int j= 0; j<3; j++)
            { c.add(b[i][j]);  }
        }

        mainFrame.setSize(600,600);

        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        ButtonsHandler bhandler = new ButtonsHandler();
        for(int i = 0; i<3; i++)
        {
            for(int j= 0; j<3; j++)
            {
                b[i][j].addActionListener(bhandler);
            }
        }
        mainFrame.setVisible(true);
    }

    class ButtonsHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e )
        {
           int counteri=0;
           int counterj=0;

           for(int i=0; i<3; i++)
           {
               for (int j=0; j<3; j++)
               {
                   if (e.getSource() == b[i][j])
                   {
                       counteri=i;
                       counterj=j;
                   }
               }
           }

           if (xo == 1)
           {
               if (b[counteri][counterj].getIcon() == null || b[counteri][counterj].getIcon().toString() != "o.png")
               {
                   b[counteri][counterj].setIcon(new ImageIcon("x.png"));
                   b[counteri][counterj].setText("");
                   xo = 0;
                   b[counteri][counterj].setEnabled(false);
               }
           }
           else if(xo == 0)
           {
               if (b[counteri][counterj].getIcon() == null || b[counteri][counterj].getIcon().toString() != "x.png")
               {
                   b[counteri][counterj].setIcon(new ImageIcon("o.png"));
                   b[counteri][counterj].setText("");
                   xo = 1;
                   b[counteri][counterj].setEnabled(false);

               }
           }
            //checking winner
            for(int i=0; i<3; i++) // rows
            {
                if (b[i][0].getIcon() != null && b[i][1].getIcon() != null && b[i][2].getIcon() != null)
                {
                    if (b[i][0].getIcon().toString() == b[i][1].getIcon().toString() &&
                            b[i][1].getIcon().toString() == b[i][2].getIcon().toString())
                    {
                        System.out.print("We have a winner...");
                        if(b[i][2].getIcon().toString() == "x.png")
                        {
                            System.out.println("X Wins");
                            System.exit(0);
                        }
                        if(b[i][2].getIcon().toString() == "o.png")
                        {
                            System.out.println("O Wins");
                            System.exit(0);
                        }
                    }
                }
            }
            for(int i=0; i<3; i++) // columns
            {
                if (b[0][i].getIcon() != null && b[1][i].getIcon() != null && b[2][i].getIcon() != null)
                {
                    if (b[0][i].getIcon().toString() == b[1][i].getIcon().toString() &&
                            b[1][i].getIcon().toString() == b[2][i].getIcon().toString())
                    {
                        System.out.print("We have a winner...");
                        if(b[2][i].getIcon().toString() == "x.png")
                        {
                            System.out.println("X Wins");
                            System.exit(0);
                        }

                        if(b[2][i].getIcon().toString() == "o.png")
                        {
                            System.out.println("O Wins");
                            System.exit(0);
                        }
                    }
                }
            }
            for(int i=0; i<3; i++) //  back slash diag
            {
                if (b[1][1].getIcon() != null && b[0][0].getIcon() != null && b[2][2].getIcon() != null)
                {
                    if (b[0][0].getIcon().toString() == b[1][1].getIcon().toString() &&
                            b[1][1].getIcon().toString() == b[2][2].getIcon().toString())
                    {
                        System.out.print("We have a winner...");
                        if(b[1][1].getIcon().toString() == "x.png")
                        {
                            System.out.println("X Wins");
                           // System.exit(0);
                        }
                        else
                        {
                            System.out.println("O Wins");
                            System.exit(0);
                        }
                    }
                }
            }/** broken code/fix later */
            for(int i=0; i<3; i++) //  forward slash diag
            {
                if (b[1][1].getIcon() != null && b[0][2].getIcon() != null && b[2][0].getIcon() != null)
                {
                    if (b[0][2].getIcon().toString() == b[2][0].getIcon().toString() &&
                            b[2][0].getIcon().toString() == b[1][1].getIcon().toString())
                    {
                        System.out.print("We have a winner...");
                        if(b[1][1].getIcon().toString() == "x.png")
                        {
                            System.out.println("X Wins");
                            System.exit(0);
                        }
                        else
                        {
                            System.out.println("O Wins");
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }//end of ButtonsHandler inner class
    public static void main(String [] args)
    {
        TicTacToe game = new TicTacToe();
        System.out.println(game);
    }
}

