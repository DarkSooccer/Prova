import javax.swing.*;
import java.util.ArrayList;
// import java.extentionlead
class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos = getVotos() + 1;
    }
}
public class ProvadoBBBGUI {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        inicializarJogadores(jogadores);

        String voto;

        JOptionPane.showMessageDialog(null, "Votação iniciada. Digite o nome do participante que você quer eliminar (ou 'sair' para encerrar a votação):");

        do {
            voto = JOptionPane.showInputDialog(null, "Em quem você vota para sair da casa?");
            if (!voto.equalsIgnoreCase("sair")) {
                contabilizarVoto(jogadores, voto);
            }
        } while (!voto.equalsIgnoreCase("sair"));

        exibirEliminacao(jogadores);
    }

    private static void inicializarJogadores(ArrayList<Jogador> jogadores) {
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin", "Lucas Henrique",
                "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral", "Maycon Cosmer", "MC Bin Laden",
                "Michel Nogueira", "Nizam", "Raquele Cardozo", "Rodriguinho", "Thalyta Alves", "Vanessa Lopes",
                "Vinicius Rodrigues", "Wanessa Camargo", "Yasmin Brunet"};
        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }
    }

    private static void contabilizarVoto(ArrayList<Jogador> jogadores, String voto) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto registrado para " + jogador.getNome());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Nome inválido. Voto não registrado.");
    }

    private static void exibirEliminacao(ArrayList<Jogador> jogadores) {
        Jogador eliminado = jogadores.get(0);

        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > eliminado.getVotos()) {
                eliminado = jogador;
            }
        }
        JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
    }
}
