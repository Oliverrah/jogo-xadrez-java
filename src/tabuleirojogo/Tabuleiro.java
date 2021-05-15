package tabuleirojogo;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar tabuleiro: deve conter no mínimo 1 linha e 1 coluna");
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
			throw new TabuleiroException("Não há essa posição no tabuleiro");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!existeEssaPosicao(posicao)) {
			throw new TabuleiroException("Não há essa posição no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocaPeca(Peca peca, Posicao posicao) {
		if (temAlgumaPeca(posicao)) {
			throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!existeEssaPosicao(posicao)) {
			throw new TabuleiroException("Não há essa posição no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	private boolean existeEssaPosicao(int linha, int coluna) {
		
		/*retorna true ou false levando em conta se a linha e coluna são maiores 
		que zero e menor que que a linha e coluna do tabuleiro*/
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean existeEssaPosicao(Posicao posicao) {
		return existeEssaPosicao(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temAlgumaPeca(Posicao posicao) {
		if(!existeEssaPosicao(posicao)) {
			throw new TabuleiroException("Não há essa posição no tabuleiro");
		}
		return peca(posicao) != null;
	
	}
}
