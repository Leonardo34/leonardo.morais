
package br.com.crescer2017.tema01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {
    private final StringUtils stringUtils = new StringUtils();

    
    @Test
    public void isEmptyDeveRetornarTrueComStringVazia() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isEmpty(""));
    }
    
    @Test
    public void isEmptyDeveRetornarTrueSeReceberStringNull() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isEmpty(null));
    }
    
    @Test
    public void isEmptyDeveRetornarFalseParaStringComInformacao() {
        StringUtils utils = new StringUtils();
        assertFalse(utils.isEmpty("talvez testar"));
    }
    
    @Test
    public void inverterString() {
        StringUtils utils = new StringUtils();
        assertEquals("odranoel", utils.inverter("leonardo"));
    }
    
    @Test
    public void inverterPalindromoNaoModificaString() {
        StringUtils utils = new StringUtils();
        assertEquals("ame a ema", utils.inverter("ame a ema"));
    }
    
    @Test
    public void contarVogaisSemAcentos() {
        StringUtils utils = new StringUtils();
        assertEquals(5, utils.contaVogais("ame a ema"));
    }
    
    @Test
    public void contarVogaisComAcentos() {
        StringUtils utils = new StringUtils();
        assertEquals(5, utils.contaVogais("ámã à êma"));
    }
    
    @Test
    public void testarPalindromos() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindromo("ovo"));
        assertTrue(utils.isPalindromo("Ame a ema"));
        assertTrue(utils.isPalindromo("A sogra má e amargosa"));
        assertFalse(utils.isPalindromo("Casa"));
        assertFalse(utils.isPalindromo("leonardo"));
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertTrue(stringUtils.isEmpty(" "));
        assertFalse(stringUtils.isEmpty("a"));
        assertFalse(stringUtils.isEmpty(" a "));
    }

    /**
     * Test of inverter method, of class StringUtils.
     */
    @Test
    public void testInverter() {
        assertEquals("solrac", stringUtils.inverter("carlos"));
    }

    /**
     * Test of contaVogais method, of class StringUtils.
     */
    @Test
    public void testContaVogais() {
        assertEquals(2, stringUtils.contaVogais("carlos"));
    }

    /**
     * Test of isPalindromo method, of class StringUtils.
     */
    @Test
    public void testIsPalindromo() {
        assertTrue(stringUtils.isPalindromo("ovo"));
        assertTrue(stringUtils.isPalindromo("Ame a Ema"));
        assertTrue(stringUtils.isPalindromo("A sogra má e amargosa"));
        assertFalse(stringUtils.isPalindromo("uva"));
        assertFalse(stringUtils.isPalindromo("Ame a Emo"));
    }

}
