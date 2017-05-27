package test.jogo.Tentativa;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import jogo.Tentativa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCorValida {
	String cor;
	boolean res;
	
	public TestCorValida(String c, boolean r) {
		this.cor = c;
		this.res = r;
	}
	
	@Parameters
    public static Collection<Object[]> param() {
        return Arrays.asList(new Object[][]{
            {"vermelho", true},
            {"azul", true},
            {"rosa", true},
            {"amarelo", true},
            {"roxo", true},
            {"verde", true},
            {"cinza", true},
            {"laranja", true},
            {null, false},
            {"purpura", false}
        });
    }
	
	@Test
	public void testCorEhValida() {
		Tentativa t = new Tentativa();
		assertEquals(this.res, t.CorEhValida(this.cor));
	}
}
