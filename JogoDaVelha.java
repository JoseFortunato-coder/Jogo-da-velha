import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Dimension;

public class JogoDaVelha  {
    public static void main(String[] args) {
        JFrame Janela = new JFrame("Jogo da velha");
        JPanel Jogo = new JPanel();
        Janela.add(Jogo);
        Jogo.setPreferredSize(new Dimension(700, 800)));
        Janela.setSize(700,800);
        Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);

        Jogo.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               System.out.print("x");
           }
       });
            }
        }



