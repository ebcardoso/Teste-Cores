package test.jogo.Senha;

import exceptions.CorInvalidaException;
import jogo.Senha;
import junit.framework.TestCase;

public class TestGetPinosInseridos extends TestCase {
	public void test0Pino() throws CorInvalidaException {
		Senha senha = new Senha();
		assertEquals(0, senha.getPinosInseridos());
	}
	
	public void test1Pino() throws CorInvalidaException {
		Senha senha = new Senha();
		senha.adicionarPino("azul");
		assertEquals(1, senha.getPinosInseridos());
	}
	
	public void test2Pino() throws CorInvalidaException {
		Senha senha = new Senha();
		senha.adicionarPino("azul");
		senha.adicionarPino("vermelho");
		assertEquals(2, senha.getPinosInseridos());
	}
	
	public void test3Pino() throws CorInvalidaException {
		Senha senha = new Senha();
		senha.adicionarPino("azul");
		senha.adicionarPino("vermelho");
		senha.adicionarPino("amarelo");
		assertEquals(3, senha.getPinosInseridos());
	}
	
	public void test4Pino() throws CorInvalidaException {
		Senha senha = new Senha();
		senha.adicionarPino("azul");
		senha.adicionarPino("vermelho");
		senha.adicionarPino("amarelo");
		senha.adicionarPino("verde");
		assertEquals(4, senha.getPinosInseridos());
	}
	
	public void testExtrapolando() throws CorInvalidaException {
		Senha senha = new Senha();
		senha.adicionarPino("azul");
		senha.adicionarPino("vermelho");
		senha.adicionarPino("amarelo");
		senha.adicionarPino("verde");
		senha.adicionarPino("laranja");
		assertEquals(4, senha.getPinosInseridos());
	}
}
