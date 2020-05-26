/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.entorno;

/**
 *
 * @author Huriel
 */
public class Simbolo {
    
    public static enum Tipo{
        INTEGER,
        DOUBLE,
        STRING,
        BOOLEAN,
        VOID    //PARA FUNCIONES DE TIPO VOID
    }
    
    private Tipo tipo;
    private String id;
    private Object valor;
    private boolean esFuncion;
    //Funcion valorFuncion; cuerpo Funcion

    //  Constructor para una variable con una expresion asignada
    public Simbolo(Tipo tipo, String id, Object valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.esFuncion = false;
    }
    
    //  Constructor unicamente para una declaracion de variable
    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
        this.esFuncion = false;
        //Asignacion de valor por defecto
        if(tipo == tipo.INTEGER){
            this.valor = 0;
        }else if(tipo == tipo.DOUBLE){
            this.valor = 0.0;
        }else if(tipo == tipo.STRING){
            this.valor = "";
        }else if(tipo == tipo.BOOLEAN){
            this.valor = false;
        }
    }
    
    /*
    public Simbolo(Tipo tipo, String id, Funcion valorFuncion ) {
        this.tipo = tipo;
        this.id = id;
        this.valorFuncion = valorFuncion;
        this.esFuncion = true;
    }
    */
    
    
    public static Tipo getTipoObjeto(Object v){
        if(v instanceof Integer){
            return Tipo.INTEGER;
        } else if(v instanceof Double){
            return Tipo.DOUBLE;
        } else if(v instanceof Boolean){
            return Tipo.BOOLEAN;
        } else if(v instanceof String){
            return  Tipo.STRING;
        } else {
            return Tipo.VOID;
        }
    }
    
    
    
    //Setters y Getters
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    
    public Tipo getTipo(){
        return this.tipo;
    }
    
    
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
    public void setValor (Object valor){
        this.valor = valor;
    }
    public Object getValor (){
        return valor;
    }
    
    
       
    
    
    
}
