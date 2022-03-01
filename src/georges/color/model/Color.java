package georges.color.model;

import java.awt.geom.IllegalPathStateException;
import java.rmi.server.ExportException;

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
            throw new IllegalArgumentException("rouge n'est pas un chiffre compris entre 0 et 255");
        }
    }

    public void validArgBleu(){
        if(bleu < 0 || bleu > 255){
            throw new IllegalArgumentException("rouge n'est pas un chiffre compris entre 0 et 255");
        }
    }

    public void validStringConstructor(){

    }










}
