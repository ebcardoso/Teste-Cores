package test.jogo.Tentativa;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Tentativa;
import junit.framework.TestCase;

public class TestEhTentativaIncompleta extends TestCase {
	public void testETI0() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		boolean res = t.ehTentativaIncompleta();
		assertEquals(true, res);
	}
	
	public void testETI1() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		boolean res = t.ehTentativaIncompleta();
		assertEquals(true, res);
	}
	
	public void testETI2() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		boolean res = t.ehTentativaIncompleta();
		assertEquals(true, res);
	}
	
	public void testETI3() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		t.adicionarPino(2, "amarelo");
		boolean res = t.ehTentativaIncompleta();
		assertEquals(true, res);
	}
	
	public void testETI4() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		t.adicionarPino(2, "amarelo");
		t.adicionarPino(3, "rosa");
		boolean res = t.ehTentativaIncompleta();
		assertEquals(false, res);
	}
}