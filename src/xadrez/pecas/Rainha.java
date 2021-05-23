package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez {

	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// acima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// diagonal esquerda cima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() - 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// diagonal direita cima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() + 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// diagonal esquerda baixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() - 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// diagonal direita baixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().existeEssaPosicao(p) && !getTabuleiro().temAlgumaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() + 1);
		}
		if (getTabuleiro().existeEssaPosicao(p) && temAlgumaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}
}
