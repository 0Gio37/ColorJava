package georges.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// MA CLASSE  DE TESTS : 100% réussi
/*
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
        assertThrows(IllegalArgumentException.class, () -> color.validRangeColor("test", 400),"Exception range non levée");
        assertThrows(IllegalArgumentException.class, () -> color.validRangeColor("test", -10),"Exception range non levée");
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
    void testGetHexavalue(){
        assertEquals("#3264C8", color.getHexValue(), "la valeur de l'hexa n'est pas récupérée");
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
    void test_IllegalException_if_wrong_format_hexaValue(){
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("193264"));
    }

    @Test
    void test_set_hexaValue(){
        color.setHexValue("#C8C8C8");
        assertAll("object non conforme",
                ()-> assertEquals("#C8C8C8", color.getHexValue(),"le setter de l'hexa n'a pas fonctionné "),
                () -> assertEquals(200,color.getRed(),"Le setter du rouge n'a pas fonctionné"),
                () -> assertEquals(200,color.getGreen(),"la valeur du rouge n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du rouge n'est pas récupérée")
                );
    }

    @Test
    void test_setColor_Red(){
        color.setRed(10);
        assertAll("object non conforme",
                ()-> assertEquals("#0A64C8", color.getHexValue(),"la valeur de l'hexa n'a pas fonctionné "),
                () -> assertEquals(10,color.getRed(),"la valeur du rouge n'a pas fonctionné"),
                () -> assertEquals(100,color.getGreen(),"la valeur du vert n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du bleu n'est pas récupérée")
        );
    }

    @Test
    void test_setColor_Green(){
        color.setGreen(10);
        assertAll("object non conforme",
                ()-> assertEquals("#320AC8", color.getHexValue(),"la valeur de l'hexa n'a pas fonctionné "),
                () -> assertEquals(50,color.getRed(),"la valeur du rouge n'a pas fonctionné"),
                () -> assertEquals(10,color.getGreen(),"la valeur du vert n'est pas récupérée"),
                () -> assertEquals(200,color.getBlue(),"la valeur du bleu n'est pas récupérée")
        );
    }

    @Test
    void test_setColor_Blue(){
        color.setBlue(10);
        assertAll("object non conforme",
                ()-> assertEquals("#32640A", color.getHexValue(),"la valeur de l'hexa n'a pas fonctionné "),
                () -> assertEquals(50,color.getRed(),"la valeur du rouge n'a pas fonctionné"),
                () -> assertEquals(100,color.getGreen(),"la valeur du vert n'est pas récupérée"),
                () -> assertEquals(10,color.getBlue(),"la valeur du bleu n'est pas récupérée")
        );
    }

    @Test
    void test_toString_Methode(){
        assertEquals("[value=#3264C8, r=50, g=100, b=200]", color.toString(),"le message de sortie n'est pas correct");
    }

}


 */



// CLASS DE TESTS DE PETER : 100% réussi

class ColorTest {

    // [value=#D58D35, r=213, g=141, b=53]
    private Color color;

    @BeforeEach
    public void setUp() {
        color = new Color(213, 141, 53);
    }

    @AfterEach
    public void tearDown() {
        color = null;
    }

    // -----------------------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------------------

    // -------------------------------------
    // Constructor Color(r, g, b)
    @Test
    public void test_constructor_RGB() {
        assertAll("Color object non conformes",
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void test_constructor_RGB_with_red_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(-3, 141, 53));
    }

    @Test
    public void test_constructor_RGB_with_red_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(264, 141, 53));
    }

    @Test
    public void test_constructor_RGB_with_green_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, -31, 53));
    }

    @Test
    public void test_constructor_RGB_with_green_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, 421, 53));
    }

    @Test
    public void test_constructor_RGB_with_blue_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, 141, -132));
    }

    @Test
    public void test_constructor_RGB_with_blue_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () ->  color = new Color(213, 141, 533));
    }

    // -------------------------------------
    // Constructor Color(hexValue)
    @Test
    public void test_constructor_HexValue() {
        color = new Color("#D58D35");
        assertAll("Color object non conformes",
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void test_constructor_HexValue_with_null_value_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(null));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("A26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_2_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#a26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_3_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#G26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_4_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#A26F7"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_5_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#A26F71E"));
    }

    // -----------------------------------------------------------------------------
    // Override methods
    // -----------------------------------------------------------------------------
    @Test
    public void testToString_not_null() {
        assertNotNull(color.toString(), "toString() est null");
    }

    @Test
    public void testToString() {
        assertEquals("[value=#D58D35, r=213, g=141, b=53]", color.toString(),"toString() est incorrect");
    }

    // -----------------------------------------------------------------------------
    // Getters
    @Test
    public void testGetRed() {
        assertAll("Color object non conformes",
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetGreen() {
        assertAll("Color object non conformes",
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetBlue() {
        assertAll("Color object non conformes",
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetHexValue() {
        assertAll("Color object non conformes",
                ()-> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"),
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"));

    }

    // -----------------------------------------------------------------------------
    // Setters
    // -----------------------------------------------------------------------------

    // -------------------------------------
    // RED
    @Test
    public void testSetRed() {
        color.setRed(25);
        assertAll("Color object non conformes",
                ()-> assertEquals(25, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals("#198D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetRed_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setRed(425));
    }

    @Test
    public void testSetRed_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setRed(-12));
    }

    // -------------------------------------
    // GREEN
    @Test
    public void testSetGreen() {
        color.setGreen(215);
        assertAll("Color object non conformes",
                ()-> assertEquals(215, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals("#D5D735", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetGreen_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setGreen(615));
    }

    @Test
    public void testSetGreen_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setGreen(-132));
    }

    // -------------------------------------
    // BLUE
    @Test
    public void testSetBlue() {
        color.setBlue(134);
        assertAll("Color object non conformes",
                ()-> assertEquals(134, color.getBlue(), "getBlue() est incorrect"),
                ()-> assertEquals(141, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(213, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals("#D58D86", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetBlue_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setBlue(731));
    }

    @Test
    public void testSetBlue_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setBlue(-1));
    }

    // -------------------------------------
    // HEX VALUE
    @Test
    public void testSetHexValue() {
        color.setHexValue("#A26F76");
        assertAll("Color object non conformes",
                ()-> assertEquals("#A26F76", color.getHexValue(), "getHexValue() est incorrect"),
                ()-> assertEquals(162, color.getRed(),"getRed() est incorrect"),
                ()-> assertEquals(111, color.getGreen(),"getGreen() est incorrect"),
                ()-> assertEquals(118, color.getBlue(), "getBlue() est incorrect"));
    }

    @Test
    public void testSetHexValue_with_null_value_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue(null));
    }

    @Test
    public void testSetHexValue_with_wrong_value_1_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setHexValue("A26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_2_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setHexValue("#a26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_3_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setHexValue("#G26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_4_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setHexValue("#A26F7"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_5_Exception() {
        assertThrows(IllegalArgumentException.class, () ->color.setHexValue("#A26F71E"));
    }
}


