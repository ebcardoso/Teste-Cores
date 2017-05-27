package test.jogo.Tentativa;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Tentativa;
import junit.framework.TestCase;

public class TestQuantosPinosJaForamAdicionados extends TestCase {
	public void testETI0() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		int res = t.quantosPinosJaForamAdicionados();
		assertEquals(0, res);
	}
	
	public void testETI1() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		int res = t.quantosPinosJaForamAdicionados();
		assertEquals(1, res);
	}
	
	public void testETI2() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		int res = t.quantosPinosJaForamAdicionados();
		assertEquals(2, res);
	}
	
	public void testETI3() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		t.adicionarPino(2, "amarelo");
		int res = t.quantosPinosJaForamAdicionados();
		assertEquals(3, res);
	}
	
	public void testETI4() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "azul");
		t.adicionarPino(1, "vermelho");
		t.adicionarPino(2, "amarelo");
		t.adicionarPino(3, "rosa");
		int res = t.quantosPinosJaForamAdicionados();
		assertEquals(4, res);
	}
}