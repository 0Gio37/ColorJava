package georges.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColorTest {

    private Color color1;
    private Color color2;

    @BeforeEach
    void setUp() {
        color1 = new Color(300,500,-1);
        color2 = new Color("0000FF");
    }

    @Test
    void testConstruc_3_arg(){
        assertEquals(300, color1.rouge,"valeur du constructeur non identique");
        assertEquals(500, color1.vert, "valeur du constructeur non identique");
        assertEquals(-1, color1.bleu, "valeur du constructeur non identique");
    }

    @Test
    void testValidArg_returnIllegalAgurmentException_if_rougeNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color1.validArgRouge(), "l'exception du range du rouge n'est pas levée");
    }
    @Test
    void testValidArg_returnIllegalAgurmentException_if_vertNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color1.validArgVert(), "l'exception du range du vert n'est pas levée");
    }
    @Test
    void testValidArg_returnIllegalAgurmentException_if_bleuNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color1.validArgBleu(), "l'exception du range du bleu n'est pas levée");
    }

    @Test
    void testConstruc_StrArg(){
        assertEquals("0000FF", color2.hexa, "valeur du constructeur non identique");
    }

    @Test
    void testValidStringConstruct_returnIllegalAgurmentException_if_incorrectFormat(){
        assertThrows(IllegalArgumentException.class, () -> color2.validFormatConstructor(), "l'exception du format de la String n'est pas levée");
    }

    @Test
    void testGetRed(){
        assertEquals(300,color1.getRed(),"la valeur du rouge n'est pas récupérée");
    }

    @Test
    void testSetRed(){
        assertEquals(400, color1.setRed(400),"la valeur du rouge n'a pas été setée");
        assertEquals(400,color1.getRed(),"le get du rouge apres son set n'a pas la bonne valeur ");
    }

    @Test
    void testGetGreen(){
        assertEquals(500,color1.getGreen(),"la valeur du vert n'est pas récupérée");
    }

    @Test
    void testSetGreen(){
        assertEquals(100, color1.setGreen(100),"la valeur du vert n'a pas été setée");
        assertEquals(100,color1.getGreen(),"le get du vert apres son set n'a pas la bonne valeur ");
    }

    @Test
    void testGetBlue() {
        assertEquals(-1, color1.getBlue(), "la valeur du bleu n'est pas récupérée");
    }

    @Test
    void testSetBlue(){
        assertEquals(50, color1.setBlue(50),"la valeur du bleu n'a pas été setée");
        assertEquals(50,color1.getBlue(),"le get du bleu apres son set n'a pas la bonne valeur ");
    }







    @AfterEach
    void tearDown() {
    }
}