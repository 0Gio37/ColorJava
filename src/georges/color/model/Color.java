package georges.color.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    private final static char[] VALUES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };
    private char[] tabChar;

    public int rouge;
    public int vert;
    public int bleu;
    public String hexa;


    public Color(int rouge, int vert, int bleu){
        setRed(rouge);
        setGreen(vert);
        setBlue(bleu);
        convertRGBInHexa(rouge,vert,bleu);
    }

    public Color(String hexa){
        setHexValue(hexa);
    }

    public String convertRGBInHexa(int rouge, int vert, int bleu){
        tabChar = new char[6];
        tabChar[0] = VALUES[rouge / 16];
        tabChar[1] = VALUES[rouge % 16];
        tabChar[2] = VALUES[vert / 16];
        tabChar[3] = VALUES[vert % 16];
        tabChar[4] = VALUES[bleu / 16];
        tabChar[5] = VALUES[bleu % 16];

        this.hexa = "#"+tabChar[0]+tabChar[1]+tabChar[2]+tabChar[3]+tabChar[4]+tabChar[5];
        return this.hexa;
    }

    public void convertHexaInRGB(String hexa){
        tabChar = new char[6];
        tabChar[0] = hexa.charAt(1);
        tabChar[1] = hexa.charAt(2);
        tabChar[2] = hexa.charAt(3);
        tabChar[3] = hexa.charAt(4);
        tabChar[4] = hexa.charAt(5);
        tabChar[5] = hexa.charAt(6);
        upDatehexaInRGBforRed(tabChar[0], tabChar[1]);
        upDatehexaInRGBforGreen(tabChar[2],tabChar[3]);
        upDatehexaInRGBforBlue(tabChar[4],tabChar[5]);
    }

    private int indexOf(char charValue) {
        for (int i = 0; i < VALUES.length; i++)
            if (VALUES[i] == charValue)
                return i;
        throw new IllegalArgumentException();
    }

    public int upDatehexaInRGBforRed(char red1, char red2){
        this.rouge = indexOf(red1) * 16 + indexOf(red2);
        return this.rouge;
    }
    public int upDatehexaInRGBforGreen(char green3, char green4){
        this.vert = indexOf(green3) * 16 + indexOf(green4);
        return this.vert;
    }
    public int upDatehexaInRGBforBlue(char blue5, char blue6){
        this.bleu = indexOf(blue5) * 16 + indexOf(blue6);
        return this.bleu;
    }

    public boolean validRangeColor(String nameColor,int color){
        if (color < 0 || color > 255) {
            throw new IllegalArgumentException("la couleur "+ nameColor +" n'est pas un chiffre compris entre 0 et 255");
        }
        return true;
    }

    public boolean validFormatHexaValue(String hexaValue){
        Pattern p;
        Matcher m;
        p = Pattern.compile("^#[0-9A-F]{6}");
        m = p.matcher(hexaValue);
        if(!m.matches()){
            throw new IllegalArgumentException("le format hexa n'est pas le bon");
        }
        return true;
    }



    public int getRed(){
        return rouge;
    }
    public void setRed(int newColor){
        if(validRangeColor("rouge", newColor)){
            this.rouge = newColor;
            convertRGBInHexa(rouge,vert,bleu);

        }
    }

    public int getGreen(){
        return vert;
    }
    public void setGreen(int newColor){
        if(validRangeColor("vert", newColor)){
            this.vert = newColor;
            convertRGBInHexa(rouge,vert,bleu);
        }
    }

    public int getBlue(){
        return bleu;
    }
    public void setBlue(int newColor){
        if(validRangeColor("bleu", newColor)){
            this.bleu = newColor;
            convertRGBInHexa(rouge,vert,bleu);

        }
    }

  public String getHexValue(){
        return hexa;
  }
  public void setHexValue(String newValue){
    if(validFormatHexaValue(newValue)) {
        this.hexa = newValue;
        convertHexaInRGB(newValue);
    }
  }

    @Override
    public String toString() {
        return "[value="
                + hexa
                +", r=" + rouge
                +", g=" + vert
                +", b=" + bleu +
                "]";
    }
}
