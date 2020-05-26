/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.expresiones;

import ast.AST;
import ast.Instruccion;
import ast.entorno.Simbolo;
import ast.entorno.TablaSimbolos;

/**
 *
 * @author huriel
 */
public class Identificador extends Instruccion{
    String id;
    public Identificador(String id, int fila, int columna) {
        this.id = id;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        
        Simbolo sim = tabla.getSimbolo(id);
        if(sim == null){
            arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". La variable no existe o no ha sido declarada: " +id+"\n");
            return null;
        }
        return sim.getValor();
    }
    
}
