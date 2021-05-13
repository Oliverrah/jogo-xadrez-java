package xadrez;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrex.pecas.Rei;
import xadrex.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void setupInicial() {
		tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(2,1));
		tabuleiro.colocaPeca(new Rei(tabuleiro,Cor.PRETA), new Posicao(0,4));
		tabuleiro.colocaPeca(new Rei(tabuleiro,Cor.PRETA), new Posicao(7,4));
	}

}
