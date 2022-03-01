package georges.color.model;

import java.awt.geom.IllegalPathStateException;
import java.rmi.server.ExportException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    public int rouge;
    public int vert;
    public int bleu;
    public String hexa;

    public Color(int rouge, int vert, int bleu){
        this.rouge = rouge;
        this.vert =  vert;
        this.bleu = bleu;
    }

    public Color(String hexa){
        this.hexa = hexa;
    }

    public void validArgRouge() {
        if (rouge < 0 || rouge > 255) {
            throw new IllegalArgumentException("rouge n'est pas un chiffre compris entre 0 et 255");
        }
    }

    public void validArgVert(){
        if(vert < 0 || vert > 255){
            throw new IllegalArgumentException("vert n'est pas un chiffre compris entre 0 et 255");
        }
    }

    public void validArgBleu(){
        if(bleu < 0 || bleu > 255){
            throw new IllegalArgumentException("bleu n'est pas un chiffre compris entre 0 et 255");
        }
    }

    public void validFormatConstructor(){
        Pattern p;
        Matcher m;
        p = Pattern.compile("^#[0-9A-F]{6}");
        m = p.matcher(hexa);
        if(!m.matches()){
            throw new IllegalArgumentException("le format n'est pas le bon");
        }
    }

    public int getRed(){
        return rouge;
    }
    public void setRed(int newColor){
        this.rouge = newColor;
    }
    
    public int getGreen(){
        return vert;
    }
    public void setGreen(int newColor){
        this.vert = newColor;
    }

    public int getBlue(){
        return bleu;
    }

    public void setBlue(int newColor){
        this.bleu = newColor;
    }

  public String getHexaValue(){
        return hexa;
  }

  public String setHexaValue(String newValue){
        this.hexa = newValue;
        return hexa;
  }













}
