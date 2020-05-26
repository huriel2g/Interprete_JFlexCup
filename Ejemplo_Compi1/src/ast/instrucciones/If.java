/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.instrucciones;

import ast.AST;
import ast.Instruccion;
import ast.entorno.TablaSimbolos;
import java.util.LinkedList;

/**
 *
 * @author huriel
 */
public class If extends Instruccion{
    Instruccion condicion;
    LinkedList<Instruccion> instruccionesIf;
    LinkedList<Instruccion> instruccionesElse;
    boolean existeElse;

    //Constructor para un if(COND){ SENT }
    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, int fila, int columna) {
        this.condicion = condicion;
        this.instruccionesIf = instrucciones;
        this.fila = fila;
        this.columna = columna;
        this.existeElse = false;
    }
    //Constructor para un if(COND){ SENT } else { SENT }
    public If(Instruccion condicion, LinkedList<Instruccion> instruccionesIf, LinkedList<Instruccion> instruccionesElse, int fila, int columna) {
        this.condicion = condicion;
        this.instruccionesIf = instruccionesIf;
        this.fila = fila;
        this.columna = columna;
        this.existeElse = true;
        this.instruccionesElse = instruccionesElse;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        //id(5,5,5)
        //creamos tabla simbolos local
        //validaciones de parametro
        //insertamos en la tabla locas
        //ejecutamos sentencias
        
        boolean cond = (Boolean)condicion.ejecutar(tabla,arbol);
        //Si se cumple la condicion del if
        if(cond){
        
            TablaSimbolos entornoLocal = new TablaSimbolos(tabla);
            
            for(Instruccion ins:instruccionesIf){
                Object retorno;
                retorno = ins.ejecutar(entornoLocal,arbol);
                
                if(retorno!=null){
                    return retorno;
                }
            }
        }
        
        //Si no se cumplio la condicion del if y si existe un else
        if(!cond && existeElse){
            
            TablaSimbolos entornoLocal=new TablaSimbolos(tabla);
            for(Instruccion ins:instruccionesElse){
                Object retorno;
                retorno = ins.ejecutar(entornoLocal,arbol);
                if(retorno!=null){
                    return retorno;
                }
            }
        }
        
        
        return null;
    }
    
           
    
    
    
}
