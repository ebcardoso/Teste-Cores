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
public class TestAdicionarPino {
	String cor1;
	int pos;
	String res;
	
	public TestAdicionarPino(String c1, int pos, String res) {
		this.cor1 = c1;
		this.pos = pos;
		this.res = res;
	}
	
	@Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
            {"azul", 0, "azul"},
            {"vermelho", 1, "vermelho"},
            {"laranja", 2, "laranja"},
            {"rosa", 3, "rosa"},
            
            //caso de exceção com posição inválida
            {"cinza", -1, "cinza"},
            {"rosa", 4, "srosa"},
            
            //caso de exceção com cores inválida
            {"purpura", 2, "purpura"},
            {null, 2, null}
        });
    }
	
	@Test
	public void testGP() {
		Tentativa t = new Tentativa();
		
		try { 
			t.adicionarPino(this.pos, cor1);
			assertEquals(t.getPino(this.pos), this.res);
		} catch (PosicaoInvalidaException pie) {
			
		} catch (CorInvalidaException cie) {
			
		}
	}
}