package com.csumb.cst438.a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of Game class
 * @author david wisneski
 * @veraion 1.0
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getState method, of class Game.
     * at start of game, state should be 1.
     * a correct guess will not change the state
     * an incorrect guess will increase state by 1
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Game instance = new Game();
        int expResult = 1;
        int result = instance.getState();
        String testWord = instance.getWord();
        assertEquals(expResult, result);
        char playChar = testWord.charAt(0);
        instance.playGame(playChar);
        result = instance.getState();
        assertEquals(expResult, result);
        int index = 0;
        playChar = 'a';
        while (index >= 0){
            index = testWord.indexOf(playChar);
            if (index >= 0){
                playChar++;
            }
        }
        instance.playGame(playChar);
        result = instance.getState();
        assertEquals(expResult+1, result);
    }

    /**
     * Test of getWord method, of class Game.
     */
    @org.junit.Test
    public void testGetWord() {
        System.out.println("getWord");
        Game instance = new Game();
        String expResult = instance.getWord();
        String result = instance.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayWord method, of class Game.
     */
    @org.junit.Test
    public void testGetDisplayWord() {
        System.out.println("getDisplayWord");
        Game instance = new Game();
        String expResult = instance.getDisplayWord();
        String result = instance.getDisplayWord();
        assertEquals(expResult, result);
        instance.playGame('r');
        result = instance.getDisplayWord();
        assertEquals(instance.getDisplayWord(), result);

    }

    /**
     * Test of startNewGame method, of class Game.
     */
    @org.junit.Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        Game instance = new Game();
        instance.startNewGame();
        instance.playGame('c');
        instance.playGame('d');
        instance.startNewGame();
        int result = instance.getState();
        assertEquals(1,result);
 
    }

    /**
     * Test of playGame method, of class Game.
     *   correct guess should return 0 , or 1 when game is won
     *   incorrect guess should return 2, or 3 when game is lost
     */
    @org.junit.Test
    public void testPlayGame() {
        System.out.println("playGame");
        Game instance = new Game();
        String testWord = instance.getWord();
        char guess = testWord.charAt(0);
        int expResult = 0;
        int result = instance.playGame(guess);
        assertEquals(expResult, result);
        char playChar = 'a';
        for (int i = 0; i < 7; i++){
            int index = 0;
            while (index >= 0){
                index = testWord.indexOf(playChar);
                if (index >= 0){
                    playChar++;
                }
            }
            result = instance.playGame(playChar);
            if (result < 3){
                assertEquals(2, result);
            } else {
                assertEquals(3,result);
            }
        }


        /*result = instance.playGame('d');
        assertEquals(2, result);
        result = instance.playGame('f');
        assertEquals(2, result);
        result = instance.playGame('g');
        assertEquals(2, result);
        result = instance.playGame('h');
        assertEquals(2,result);
        result = instance.playGame('j');
        assertEquals(2,result);
        result = instance.playGame('k');
        assertEquals(3,result);*/
 
        instance.startNewGame();
        testWord = instance.getWord();
        for (int i = 0; i < testWord.length(); i++){
            result = instance.playGame(testWord.charAt(i));
            if (result < 1) {
                assertEquals(0,result);
            } else {
                assertEquals(1,result);
            }
        }
    }
    
}
