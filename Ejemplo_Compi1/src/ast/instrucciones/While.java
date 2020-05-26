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
public class While extends Instruccion{
    Instruccion condicion;
    LinkedList<Instruccion> instrucciones;

    public While(Instruccion condicion, LinkedList<Instruccion> instrucciones, int fila, int columna) {
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        
        while((Boolean)condicion.ejecutar(tabla,arbol)){
            
            TablaSimbolos entornoLocal=new TablaSimbolos(tabla);
            for(Instruccion ins:instrucciones){
                Object retorno;
                retorno = ins.ejecutar(entornoLocal,arbol);
                if(retorno!=null){
                    if(retorno instanceof Break){
                        return null;
                    }else{
                        return retorno;
                    }
                }
            }
            
        }
        
        return null;
    }
    
           
    
    
    
}
