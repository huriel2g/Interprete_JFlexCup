/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import ast.entorno.TablaSimbolos;

/**
 *
 * @author Huriel
 */
public abstract class Instruccion {
    
    public int fila;
    public int columna;
    
    public Object ejecutar(TablaSimbolos tabla, AST arbol){
        
        return null;
    } 
    
    
}
