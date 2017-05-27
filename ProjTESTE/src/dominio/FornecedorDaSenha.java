package dominio;

import java.util.LinkedList;
import java.util.Random;

import jogo.Senha;
import jogo.Tentativa;

/**
 * Essa classe representa o fornecedor da senha do jogo. Ele quem cria a senha
 * que o Adivinho ter� de adivinhar. Ele tamb�m � quem verifica a tentativa do
 * adivinho atrav�s da Jogada(objeto que o Fornecedor e o Adivinho compartilham)
 * e cria o retorno correspondente ao quanto o adivinho acertou na sua tentativa
 * mais recente.
 *
 */
public class FornecedorDaSenha implements Jogador {
	/**
	 * jogada � o atributo que Adivinho e FornecedorDaSenha compartilham para
	 * que o Fornecedor consiga acessar a tentativa realizada pelo Adivinho.
	 */
	private Jogada jogada;

	/**
	 * senha � um atributo que representa a senha do jogo. Ela � gerada apenas
	 * no come�o do jogo e o Adivinho deve tentar adivinh�-la
	 */
	private Senha senha;

	public FornecedorDaSenha() {
		jogada = null;
		senha = new Senha();
	}

	public void setJogada(Jogada jog) {
		jogada = jog;

	}

	public Jogada getJogada() {
		return jogada;
	}

	/**
	 * Fun��o que cria a senha que ser� utilizada no jogo. Essa fun��o s� ser�
	 * executada uma �nica vez que � quando o jogo come�a. Quem manda essa
	 * fun��o ser executada � a mesma classe que cria uma inst�ncia de
	 * FornecedorDaSenha: "Jogo". A fun��o segue os seguintes passos: 1 -
	 * armazenar em uma LinkedList v�rias Strings. Cada String ser� uma cor
	 * v�lida usada pelo sistema (vermelho, azul, rosa, amarelo, roxo, verde,
	 * cinza ou laranja). 2 - retirar 4 cores aleat�rias da lista, sem
	 * repeti��o. 3 - ir adicionando na "senha"(atributo do FornecedorDaSenha)
	 * essas 4 cores.
	 */
	public void criarSenha() {
		while (senha.ehSenhaValida() == false) {
			// primeiro temos uma lista de cores
			LinkedList<String> cores = new LinkedList<String>();
			cores.add("vermelho");
			cores.add("azul");
			cores.add("rosa");
			cores.add("amarelo");
			cores.add("roxo");
			cores.add("verde");
			cores.add("cinza");
			cores.add("laranja");

			// agora vamos retirar quatro cores randomicas dessa lista

			for (int i = 0; i < 4; i++) {
				Random geradorNumRandomico = new Random();
				String corDaSenha = cores.remove(geradorNumRandomico.nextInt(cores.size()));
				try {
					senha.adicionarPino(corDaSenha);
				} catch (Exception exc) {
					System.out.println("erro ao setar pinos para senha");
				}
			}
		}

	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha s) {
		senha = s;
	}

	/**
	 * A fun��o "jogar()" do FornecedorDaSenha realiza os seguintes passos: 1 -
	 * Pegar a tentativa do Adivinho. A tentativa pode ser obtida atrav�s do
	 * objeto "jogada" que o Fornecedor e o Adivinho compartilham. 2 - Para cada
	 * pino da tentativa, ser� checado se ele � da mesma cor que um pino da
	 * "senha" e se ele est� na mesma posi��o que a senha. 2.1 - Caso um pino da
	 * tentativa seja da mesma cor e esteja na mesma posi��o que um pino da
	 * senha, um novo pino preto � adicionado ao "retorno" (resultado da
	 * compara��o entre a Senha e a Tentativa) gerado pelo Fornecedor. 2.2 -
	 * Caso um pino da tentativa seja da mesma cor que algum pino da senha mas
	 * os dois n�o est�o na mesma posi��o, um novo pino branco � adicionado ao
	 * "retorno" 2.3 - Se o pino presente na tentativa do Adivinho n�o est�
	 * presente na senha gerada pelo Fornecedor, nenhum novo pino � adicionado
	 * ao "retorno". 3 - O passo 2 ser� repetido para cada pino da tentativa e
	 * no final o retorno poder� ser acessado por qualquer um que tenha acesso �
	 * Jogada(objeto compartilhado entre Adivinho e Fornecedor e criado pel
	 * classe "Jogo").
	 */
	public void jogar() {
		Retorno respostaFornecedor = new Retorno();
		Tentativa tentativaAdivinho = null;
		tentativaAdivinho = jogada.getTentativa();
		for (int j = 0; j < 4; j++) {
			try {
				String pinoTentativa = tentativaAdivinho.getPino(j);
				for (int k = 0; k < 4; k++) {
					String pinoSenha = senha.getPino(k);
					if (pinoSenha.compareTo(pinoTentativa) == 0 && k != j) {
						respostaFornecedor.adicionarPino("branco");
					} else if (pinoSenha.compareTo(pinoTentativa) == 0 && k == j) {
						respostaFornecedor.adicionarPino("preto");
					}
				}

			} catch (Exception exc) {
				System.out.println("erro ao setar pinos brancos ou pretos no retorno");
			}

		}

		jogada.setRetorno(respostaFornecedor);
	}
}
