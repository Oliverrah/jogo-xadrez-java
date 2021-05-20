package xadrex.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);
		
		if(getCor() == Cor.BRANCA) {
			p.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if(getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if(getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p) && getTabuleiro().existeEssaPosicao(p2) && !getTabuleiro().temAlgumaPeca(p2) && getContagemMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if(getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if(getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
		}
		else {
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if(getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if(getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p) && getTabuleiro().existeEssaPosicao(p2) && !getTabuleiro().temAlgumaPeca(p2) && getContagemMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if(getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if(getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
