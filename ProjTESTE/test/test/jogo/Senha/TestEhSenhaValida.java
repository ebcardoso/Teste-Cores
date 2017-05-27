package test.jogo.Senha;

import static org.junit.Assert.assertEquals;

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
public class TestEhSenhaValida {
	String cor1;
	String cor2;
	String cor3;
	String cor4;
	boolean res;
	
	public TestEhSenhaValida(String c1, String c2, String c3, String c4, boolean res) {
		this.cor1 = c1;
		this.cor2 = c2;
		this.cor3 = c3;
		this.cor4 = c4;
		this.res = res;
	}
	
	@Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
            {"azul", "vermelho", "amarelo", "verde", true},
            {"cinza", "roxo", "laranja", "rosa", true},
            
            //casos falsos
            {"azul", "azul", "amarelo", "verde", false},   //1ª = 2ª
            {"amarelo", "azul", "amarelo", "verde", false}, //1ª = 3ª
            {"cinza", "roxo", "laranja", "cinza", false}, //1ª = 4ª
            {"cinza", "roxo", "roxo", "rosa", false}, //2ª = 3ª
            {"azul", "verde", "amarelo", "verde", false}, //2ª = 4ª
            {"cinza", "roxo", "rosa", "rosa", false}, ///3ª = 4ª
            
            //caso de exceção
            {"cinza", "roxo", "rosa", "nenhum", false}, ///3ª = 4ª
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
			assertEquals(this.res, s.ehSenhaValida());
		} catch (CorInvalidaException cie) {
			
		}
	}
}
