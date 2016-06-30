package br.com.faculdade.bo;

/**
 * Created by cardoso on 02/05/16.
 */
public class UtilBO {

    public static String ReturnEmptity(String valor){
        if (valor == null){
            valor = "";
        }
        return valor;
    }

    public static String ReturnZero(String valor){
        if(valor == null || valor.isEmpty()){
            valor = "0";
        }
        return valor;
    }
}
