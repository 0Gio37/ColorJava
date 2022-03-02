package georges.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColorTest {

    private Color color;

    @BeforeEach
    void setUp() {
        color = new Color(50,100,200);
        //color = new Color("#3264C8");
    }
    @AfterEach
    void tearDown() {
        color = null;
    }


    @Test
    void test_Construc_3_arg(){
        assertAll("object non conforme",
                () -> assertEquals(50, color.rouge, "valeur du constructeur non identique"),
                () -> assertEquals(100, color.vert,"valeur du constructeur non identique"),
                () -> assertEquals(200, color.bleu, "valeur du constructeur non identique"),
                () -> assertEquals("#3264C8", color.hexa, "conversion hexa du constructeur non correspondant")
                );
    }

    @Test
    void testConstruc_1_arg(){
        assertAll("object non conforme",
                () -> assertEquals("#3264C8", color.hexa, "valeur du constructeur non identique"),
                () -> assertEquals(50, color.rouge, "conversion RGB du constructeur non correspondant"),
                () -> assertEquals(100, color.vert,"conversion RGB du constructeur non correspondant"),
                () -> assertEquals(200, color.bleu, "conversion RGB du constructeur non correspondant")
        );
    }

    @Test
    void test_Method_illegalExcep_for_color_outOfRange(){
        assertThrows(IllegalArgumentException.class, () -> color.validRangeColor(400),"Exception range non levée");
        assertThrows(IllegalArgumentException.class, () -> color.validRangeColor(-10),"Exception range non levée");
    }

    @Test
    void testGetRed(){
        assertEquals(50,color.getRed(),"la valeur du rouge n'est pas récupérée");
    }
    @Test
    void testGetGreen(){
        assertEquals(100,color.getGreen(),"la valeur du vert n'est pas récupérée");
    }
    @Test
    void testGetBlue(){
        assertEquals(200,color.getBlue(),"la valeur du bleu n'est pas récupérée");
    }

    @Test
    void test_illegalException_if_setRedColor_out(){
        assertAll("object non conforme",
                () -> assertThrows(IllegalArgumentException.class, () -> color.setRed(-10),"exception non levée"),
                () -> assertEquals(50,color.getRed(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(100,color.getGreen(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals("#3264C8",color.getHexValue(),"la valeur du rouge n'est pas récupérée")
                );
    }

    @Test
    void test_illegalException_if_setGreenColor_out(){
        assertAll("object non conforme",
                () -> assertThrows(IllegalArgumentException.class, () -> color.setGreen(-10),"exception non levée"),
                () -> assertEquals(50,color.getRed(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(100,color.getGreen(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals("#3264C8",color.getHexValue(),"la valeur du rouge n'est pas récupérée")
        );
    }

    @Test
    void test_illegalException_if_setBlueColor_out(){
        assertAll("object non conforme",
                () -> assertThrows(IllegalArgumentException.class, () -> color.setBlue(400),"exception non levée"),
                () -> assertEquals(50,color.getRed(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(100,color.getGreen(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals("#3264C8",color.getHexValue(),"la valeur du rouge n'est pas récupérée")
        );
    }

    @Test
    void testSetRed_with_wrong_value_range_bigger_than_255(){
        assertThrows(IllegalArgumentException.class, () -> color.setRed(400));
    }
    @Test
    void testSetRed_with_wrong_value_range_smaller_than_0(){
        assertThrows(IllegalArgumentException.class, () -> color.setRed(-1));
    }
    @Test
    void testSetGreen_with_wrong_value_range_bigger_than_255(){
        assertThrows(IllegalArgumentException.class, () -> color.setGreen(400));
    }
    @Test
    void testSetGreen_with_wrong_value_range_smaller_than_0(){
        assertThrows(IllegalArgumentException.class, () -> color.setGreen(-1));
    }
    @Test
    void testSetBlue_with_wrong_value_range_bigger_than_255(){
        assertThrows(IllegalArgumentException.class, () -> color.setBlue(400));
    }
    @Test
    void testSetBlue_with_wrong_value_range_smaller_than_0(){
        assertThrows(IllegalArgumentException.class, () -> color.setBlue(-1));
    }

    @Test
    void test_setRed_update_Redvalue_and_hexaValue() {
        color.setRed(75);
        assertAll("object non conforme",
                () -> assertThrows(IllegalArgumentException.class, () -> color.setBlue(400),"exception non levée"),
                () -> assertEquals(75,color.getRed(),"Le setter du rouge n'a pas fonctionné"),
                () -> assertEquals(100,color.getGreen(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals("#3264C8",color.getHexValue(),"la valeur du rouge n'est pas récupérée")
        );
    }





    @Test
    void testGetHexavalue(){
        assertEquals("0000FF", color.getHexValue(), "la valeur de l'hexa n'est pas récupérée");
    }

    @Test
    void testSetHexaValue(){
        assertEquals("#00FF00", color.setHexValue("#00FF00"),"le get de l'hexa apres son set n'a pas la bonne valeur ");
    }

    @Test
    void test_toString_Methode(){
        assertEquals("value=#0000FF", color.toString(),"le message de sortie n'est pas correct");
    }





}