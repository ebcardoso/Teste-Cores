package test.jogo.Tentativa;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import jogo.Tentativa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;

@RunWith(Parameterized.class)
public class TestGetPino {
	int pos;
	String res;
	
	public TestGetPino(int pos, String res) {
		this.pos = pos;
		this.res = res;
	}
	
	@Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
            {0, "azul"},
            {1, "vermelho"},
            {2, "laranja"},
            {3, "rosa"},
            
            //caso de exceção com posição inválida
            {-1, "cinza"},
            {4, "rosa"}
        });
    }
	
	@Test
	public void testGP() throws CorInvalidaException {
		Tentativa t = new Tentativa();
		
		try { 
			t.adicionarPino(0, "azul");
			t.adicionarPino(1, "vermelho");
			t.adicionarPino(2, "laranja");
			t.adicionarPino(3, "rosa");
			assertEquals(t.getPino(this.pos), this.res);
		} catch (PosicaoInvalidaException pie) {
			
		} 
	}
}