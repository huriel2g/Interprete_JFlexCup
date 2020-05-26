/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.instrucciones;

import ast.AST;
import ast.Instruccion;
import ast.entorno.TablaSimbolos;

/**
 *
 * @author Huriel
 */
public class Print extends Instruccion{
 
    Instruccion expresion;
    int fila;

    public Print(Instruccion expresion, int fila) {
        this.expresion = expresion;
        this.fila = fila;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        
        Object texto = expresion.ejecutar(tabla, arbol);
        
        if(texto == null){
            return null;
        }
        arbol.getConsola().append(texto.toString()+"\n");
        return null;
    }
    
    
}
