import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.*;

public class JogoDaVelha  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JFrame Janela = new JFrame("Jogo da velha");
        Painel Jogo = new Painel();
        Janela.add(Jogo);
        Jogo.setPreferredSize(new Dimension(600, 700));
        Janela.setSize(700,800);
        Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);
        Jogo.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int linha = e.getY() / 200 ;
               int coluna = e.getX() / 200;
               Jogo.Jogar(linha, coluna);
               Jogo.repaint();
           }
       });
            }
    }
class Painel extends JPanel {

    char[][] tabuleiro = new char[3][3];
    char jogador = 'X';
    char ia = 'O';

    public void Jogar(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == '\0') {
            tabuleiro[linha][coluna] = jogador;

        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine();
        g.drawString();
    }
}
