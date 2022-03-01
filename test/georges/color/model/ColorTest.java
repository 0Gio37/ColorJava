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
        color1 = new Color(100,100,45);
        //color2 = new Color("0000FF");
    }


    @AfterEach
    void tearDown() {
        color1 = null;
        color2 = null;
    }

    @Test
    void testConstruc_3_arg(){
        assertAll("object non conforme",
                () -> assertEquals(100, color1.rouge, "valeur du constructeur non identique"),
                () -> assertEquals(100, color1.vert,"valeur du constructeur non identique"),
                () -> assertEquals(45, color1.bleu, "valeur du constructeur non identique")
                );
    }

    @Test
    void testConstruc_rangeColors(){
        assertThrows(IllegalArgumentException.class, () -> color1 = new Color(-1,200,50));
    }

    @Test
    void testConstruc_hexa(){
        assertThrows(IllegalArgumentException.class, () -> color2 = new Color("0000PP"));
    }




    @Test
    void testGetRed(){
        assertEquals(300,color1.getRed(),"la valeur du rouge n'est pas récupérée");
    }

    @Test
    void testSetRed() {
        color1.setRed(400);
        assertAll("objet non conforme",
                () -> assertEquals(400, color1.getRed(), "le get du rouge apres son set n'a pas la bonne valeur "));
        //assertEquals(400, color1.setRed(400), "la valeur du rouge n'a pas été setée");
    }

    @Test
    void testGetGreen(){
        assertEquals(500,color1.getGreen(),"la valeur du vert n'est pas récupérée");
    }

    @Test
    void testSetGreen(){
        color1.setGreen(100);
        assertAll("objet non conforome",
                () -> assertEquals(100,color1.getGreen(),"le get du vert apres son set n'a pas la bonne valeur "));
        //assertEquals(100, color1.setGreen(100),"la valeur du vert n'a pas été setée");
    }

    @Test
    void testGetBlue() {
        assertEquals(-1, color1.getBlue(), "la valeur du bleu n'est pas récupérée");
    }

    @Test
    void testSetBlue(){
        color1.setBlue(20);
        assertAll("object non conforme",
               // () -> assertEquals(50, color1.setBlue(50),"la valeur du bleu n'a pas été setée"),
                () -> assertEquals(20,color1.getBlue(),"le get du bleu apres son set n'a pas la bonne valeur "));
    }

    @Test
    void testGetHexavalue(){
        assertEquals("0000FF", color2.getHexaValue(), "la valeur de l'hexa n'est pas récupérée");
    }

    @Test
    void testSetHexaValue(){
        assertEquals("#00FF00", color2.setHexaValue("#00FF00"),"le get de l'hexa apres son set n'a pas la bonne valeur ");
    }

    @Test
    void test_toString_Methode(){
        assertEquals("value=#0000FF", color2.toString(),"le message de sortie n'est pas correct");
    }





}