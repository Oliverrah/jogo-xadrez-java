package xadrez;

import tabuleirojogo.Peca;
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
	
	public PecaXadrez fazerMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validaPosicaoOrigem(origem);
		Peca pecaCapturada = fazMovimento(origem, destino);
		return (PecaXadrez) pecaCapturada;
	}
	
	private Peca fazMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.colocaPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validaPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temAlgumaPeca(posicao)) {
			throw new XadrezException("Não tem nenhuma peça na posição de origem");
		}
		if (!tabuleiro.peca(posicao).temAlgumMovimentoPossivel()) {
			throw new XadrezException("Não há nenhum movimento possível para a peça escolhida");
		}
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	private void setupInicial() {
		colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('e', 8, new Rei(tabuleiro,Cor.PRETA));
		colocarNovaPeca('e', 1, new Rei(tabuleiro,Cor.PRETA));
	}

}
