package tabuleirojogo;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar tabuleiro: deve conter no m�nimo 1 linha e 1 column");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!existeEssaPosicao(linha, coluna)) {
			throw new TabuleiroException("N�o h� essa posi��o no tabuleiro");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!existeEssaPosicao(posicao)) {
			throw new TabuleiroException("N�o h� essa posi��o no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocaPeca(Peca peca, Posicao posicao) {
		if (temAlgumaPeca(posicao)) {
			throw new TabuleiroException("J� existe uma pe�a nessa posi��o " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

	private boolean existeEssaPosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean existeEssaPosicao(Posicao posicao) {
		return existeEssaPosicao(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temAlgumaPeca(Posicao posicao) {
		if(!existeEssaPosicao(posicao)) {
			throw new TabuleiroException("N�o h� essa posi��o no tabuleiro");
		}
		return peca(posicao) != null;
	
	}
}
