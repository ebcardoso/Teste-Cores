package test.jogo.Senha;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import jogo.Senha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;

@RunWith(Parameterized.class)
public class TestGetPino {
	String cor1;
	String cor2;
	String cor3;
	String cor4;
	int pos;
	String res;
	
	public TestGetPino(String c1, String c2, String c3, String c4, int pos, String res) {
		this.cor1 = c1;
		this.cor2 = c2;
		this.cor3 = c3;
		this.cor4 = c4;
		this.pos = pos;
		this.res = res;
	}
	
	@Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
            {"azul", "vermelho", "amarelo", "verde", 0, "azul"},
            {"azul", "vermelho", "amarelo", "verde", 1, "vermelho"},
            {"cinza", "roxo", "laranja", "rosa", 2, "laranja"},
            {"cinza", "roxo", "laranja", "rosa", 3, "rosa"},
            
            //caso de exceção com posição inválida
            {"cinza", "roxo", "laranja", "rosa", -1, "rosa"},
            {"cinza", "roxo", "laranja", "rosa", 4, "rosa"},
            
            //caso de exceção com cores inválida
            {"purpura", "roxo", "laranja", "rosa", -1, "rosa"},
            {"null", "roxo", "laranja", "rosa", 4, "rosa"}
        });
    }
	
	@Test
	public void testGP() {
		Senha s = new Senha();
		
		try { 
			s.adicionarPino(cor1);
			s.adicionarPino(cor2);
			s.adicionarPino(cor3);
			s.adicionarPino(cor4);
			assertEquals(s.getPino(this.pos), this.res);
		} catch (PosicaoInvalidaException pie) {
			
		} catch (CorInvalidaException cie) {
			
		}
	}
}