import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class JogoDaVelha  {
    public static void main(String[] args) {

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
                if (Jogo.VezDoJogador && !Jogo.jogoAcabou) {
                    Jogo.Jogar(linha, coluna);
                    Jogo.repaint();
                }

            }

        });
    }
}
class Painel extends JPanel {
    Random random = new Random();
    char[][] tabuleiro = new char[3][3];
    Timer timerIa;
    boolean jogoAcabou = false;
    public Painel() {

        XouO();
        timerIa = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogadaDaIa();
                repaint();
                timerIa.stop();
            }
        });
        timerIa.setRepeats(false);
        if (venceu(ia)) {

        }

    }
    char jogador ;
    char ia  ;

    boolean VezDoJogador = true;
    boolean VezdaIa = true;
    public boolean venceu(char simbolo) {
        if (tabuleiro[0][0] == simbolo &&
                tabuleiro[0][1] == simbolo &&
                tabuleiro[0][2] == simbolo) {
            return true;

        }
        if (tabuleiro[1][0] == simbolo &&
                tabuleiro[1][1] == simbolo &&
                tabuleiro[1][2] == simbolo ) {
            return true;
        }
        if (tabuleiro[2][0] == simbolo &&
                tabuleiro[2][1] == simbolo &&
                tabuleiro[2][2] == simbolo ) {
            return true;
        }
        if (tabuleiro[0][0] == simbolo &&
                tabuleiro[1][0] == simbolo &&
                tabuleiro[2][0] == simbolo ) {
            return true;
        }
        if (tabuleiro[0][1] == simbolo &&
                tabuleiro[1][1] == simbolo &&
                tabuleiro[2][1] == simbolo ) {
            return true;
        }if (tabuleiro[0][2] == simbolo &&
                tabuleiro[1][2] == simbolo &&
                tabuleiro[2][2] == simbolo ) {
            return true;
        }if (tabuleiro[0][0] == simbolo &&
                tabuleiro[1][1] == simbolo &&
                tabuleiro[2][2] == simbolo ) {
            return true;
        }if (tabuleiro[0][2] == simbolo &&
                tabuleiro[1][1] == simbolo &&
                tabuleiro[2][0] == simbolo ) {
            return true;
        }


        return false;
    }
    boolean testarJogada(char simbolo, int linha, int coluna) {
        linha = random.nextInt(3);
        coluna = random.nextInt(3);
        while (tabuleiro[linha][coluna] != '\0') {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
        }
        if (tabuleiro[linha][coluna] == '\0') {
            tabuleiro[linha][coluna] = ia;

        }
        if (VezdaIa && tabuleiro[0][0] == jogador &&
                tabuleiro[0][1] == jogador) {
            tabuleiro[0][2] = ia;

        } if ( VezdaIa && tabuleiro[1][0] == jogador &&
                tabuleiro[1][1] == jogador) {
            tabuleiro[1][2] = ia;

        } if ( VezdaIa && tabuleiro[2][0] == jogador &&
                tabuleiro[2][1] == jogador ) {
            tabuleiro[2][2] = ia;

        } if ( VezdaIa && tabuleiro[0][0] == jogador &&
                tabuleiro[1][0] == jogador ) {
            tabuleiro[2][0] = ia;

        } if ( VezdaIa && tabuleiro[0][1] == jogador &&
                tabuleiro[1][1] == jogador ) {
            tabuleiro[2][1] = ia;

        } if ( VezdaIa && tabuleiro[0][2] == jogador &&
                tabuleiro[1][2] == jogador ) {
            tabuleiro[2][2] = ia;

        } if ( VezdaIa && tabuleiro[0][0] == jogador &&
                tabuleiro[1][1] == jogador ) {
            tabuleiro[2][2] = ia;

        } if ( VezdaIa && tabuleiro[0][2] == jogador &&
                tabuleiro[1][1] == jogador ) {
            tabuleiro[2][0] = ia;

        }
        return false;
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

            repaint();
            VezDoJogador = false;
            timerIa.start();
            if (venceu(jogador)) {
                System.out.println("Jogador ganhou");
                jogoAcabou = true;
                timerIa.stop();
            }

            VezdaIa = true;
        }

    }

    public void JogadaDaIa() {
        int linha = random.nextInt(3);
        int coluna = random.nextInt(3);
        if (jogoAcabou) {
            return;
        }

            testarJogada(ia, linha, coluna);
            repaint();

            VezdaIa = false;
            if (venceu(ia)) {
                System.out.println("IA ganhou");
                jogoAcabou = true;
                timerIa.stop();

            }

            VezDoJogador = true;
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
