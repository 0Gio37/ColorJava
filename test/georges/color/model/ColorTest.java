package georges.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColorTest {

    private Color color;

    @BeforeEach
    void setUp() {
        color = new Color(300,300,-1);
        color = new Color("0000FF");
    }

    @Test
    void testConstruc_3_arg(){
        assertEquals(300, color.rouge,"valeur du constructeur non identique");
        assertEquals(300, color.vert, "valeur du constructeur non identique");
        assertEquals(-1, color.bleu, "valeur du constructeur non identique");
    }

    @Test
    void testValidArg_returnIllegalAgurmentException_if_rougeNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color.validArgRouge(), "l'exception du range du rouge n'est pas levée");
    }
    @Test
    void testValidArg_returnIllegalAgurmentException_if_vertNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color.validArgVert(), "l'exception du range du vert n'est pas levée");
    }
    @Test
    void testValidArg_returnIllegalAgurmentException_if_bleuNot_between0_255(){
        assertThrows(IllegalArgumentException.class, ()->color.validArgBleu(), "l'exception du range du bleu n'est pas levée");
    }

    @Test
    void testConstruc_StrArg(){
        assertEquals("#0000FF", color.hexa, "valeur du constructeur non identique");
    }

    @Test
    void testValidStringConstruct_returnIllegalAgurmentException_if_incorrectFormat(){
        assertThrows(IllegalArgumentException.class, () -> color.validStringConstructor(), "l'exception du format de la String n'est pas levée");
    }







    @AfterEach
    void tearDown() {
    }
}