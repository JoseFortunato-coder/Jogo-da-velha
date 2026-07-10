import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
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
               if (Jogo.VezDoJogador) {
                   Jogo.Jogar(linha, coluna);
                   Jogo.repaint();
               }
           }
       });
            }
    }
class Painel extends JPanel {
    Random random = new Random();
    char[][] tabuleiro = new char[2][2];
    public Painel() {
        XouO();
    }
    char jogador ;
    char ia  ;

    boolean VezDoJogador = true;
    public boolean venceu(char simbolo) {
        if (venceu(tabuleiro[0][0])) {
            return tabuleiro[0][0] == simbolo &&
            tabuleiro[0][2] = 'X';
            System.out.println("Jogador venceu!");
        }

        if (venceu(ia)) {

            System.out.println("IA venceu!");
        }
        return venceu;
    }

    public void XouO (){
        if (random.nextInt(2) == 0) {
        jogador = 'X';
        ia = 'O';
        } else {
            jogador = 'O';
            ia = 'X';
        }
    }
    public void Jogar(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == '\0') {
            tabuleiro[linha][coluna] = jogador;
            VezDoJogador = false;
        }
    }
    public void JogadaDaIa(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == '\0') {
            tabuleiro[linha][coluna] = ia;
            VezDoJogador = true;
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tamanho = Math.min( getWidth(), getHeight());
        int casas = tamanho / 3;
        g.drawLine( casas , 0,  casas , tamanho);
        g.drawLine( casas  * 2, 0,  casas  * 2, tamanho);

        g.drawLine(0,  casas , tamanho, casas);
        g.drawLine(0,  casas  * 2, tamanho, casas * 2);
        g.setFont(new Font("Arial", Font.BOLD, 80));

        for(int linha = 0; linha < 3; linha++) {

            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == 'X') {
                    int x = coluna * 200 + 80;
                    int y = linha * 200 + 120;
                    g.drawString("X", x, y);
                }

                    if (tabuleiro[linha][coluna] == 'O') {
                        int x = coluna * 200 + 80;
                        int y = linha * 200 + 120;
                        g.drawString("O", x, y);
                    }
            }
        }
    }
}






