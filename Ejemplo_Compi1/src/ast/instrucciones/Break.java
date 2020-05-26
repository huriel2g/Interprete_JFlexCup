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
 * @author huriel
 */
public class Break extends Instruccion{

    public Break(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        return this;
    }
    
    
    
    
}
