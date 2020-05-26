/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.expresiones;

import ast.AST;
import ast.Instruccion;
import ast.entorno.TablaSimbolos;

/**
 *
 * @author huriel
 */
public class Primitivo extends Instruccion{
    
    Object valor;

    public Primitivo(Object valor) {
        this.valor = valor;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        return valor;
    }
    
    
    
    
}
