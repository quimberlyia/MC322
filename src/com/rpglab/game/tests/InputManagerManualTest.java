package com.rpglab.game.tests;

import com.rpglab.game.utils.InputManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class InputManagerManualTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        // Preparar para cada teste
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalOut);
        InputManager.resetScanner(); // Resetar scanner após cada teste
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        InputManager.resetScanner(); // Resetar scanner para usar novo System.in
    }

    private String normalizeOutput(String output) {
        return output.replaceAll("\\s+", " ").trim();
    }

    @Test
    void testReadString_ValidInput() {
        provideInput("Quimberly\n");
        String result = InputManager.readString("Digite seu nome: ");
        assertEquals("Quimberly", result);
    }

    @Test
    void testReadString_InvalidInput() {
        System.setOut(new PrintStream(outContent));

        provideInput("\n");
        String result = InputManager.readString("Digite algo: ");
        assertEquals("", result);

        // Verifica se a mensagem de entrada errada foi exibida
        assertEquals(normalizeOutput("Digite algo: \n"), normalizeOutput(outContent.toString()));
    }

    @Test
    void testReadYesNo_ValidInput() {
        provideInput("y\n");
        boolean result = InputManager.readYesNo("Confirma?");
        assertTrue(result);

        provideInput("n\n");
        result = InputManager.readYesNo("Confirma?");
        assertFalse(result);
    }

    @Test
    void testReadYesNo_InvalidInput() {
        System.setOut(new PrintStream(outContent));

        provideInput("talvez\ny\n");
        boolean result = InputManager.readYesNo("Confirma?");
        assertTrue(result);

        // Verifica se a mensagem de entrada errada foi exibida
        assertEquals(normalizeOutput("Confirma? (y/n): Invalid input. Please enter only 'y' or 'n'.\nConfirma? (y/n): \n"), normalizeOutput(outContent.toString()));
    }
}