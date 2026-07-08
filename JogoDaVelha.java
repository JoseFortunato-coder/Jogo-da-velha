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
        Jogo.setPreferredSize(new Dimension(600, 600));
        Janela.setResizable(false);
        Janela.setSize(600,600);
        Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);
        Jogo.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int tamanho = Math.min(Jogo.getWidth(), Jogo.getHeight());

               int casa = tamanho / 3;

               int linha = e.getY() / casa;
               int coluna = e.getX() / casa;
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
        int tamanho = Math.min( getWidth(), getHeight());
        int casas = tamanho / 3;
        g.drawLine( casas , 0,  casas , tamanho);
        g.drawLine( casas  * 2, 0,  casas  * 2, tamanho);

        // linhas horizontais
        g.drawLine(0,  casas , tamanho, casas);
        g.drawLine(0,  casas  * 2, tamanho, casas * 2);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("X", 70, 140);
        g.drawString("O", 70, 140);
    }
}






