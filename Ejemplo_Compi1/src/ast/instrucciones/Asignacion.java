/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.instrucciones;

import ast.AST;
import ast.Instruccion;
import ast.entorno.Simbolo;
import ast.entorno.Simbolo.Tipo;
import ast.entorno.TablaSimbolos;

/**
 *
 * @author huriel
 */
public class Asignacion extends Instruccion{
    
    String id;
    Instruccion valor;

    public Asignacion(String id, Instruccion valor, int fila) {
        this.id = id;
        this.valor = valor;
        this.fila = fila;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        
        Simbolo variable = tabla.getSimbolo(id);
        
        if(variable == null){
            arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". La variable no fue declarada: " +id+"\n");
            return null;
        }
        
        Object nuevoValor = valor.ejecutar(tabla, arbol);
        if(nuevoValor == null){
            return null;
        }
        
        Tipo tipoVariable = variable.getTipo();
        Tipo tipoExpresion = Simbolo.getTipoObjeto(nuevoValor);
        if(tipoVariable != tipoExpresion){
            arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". Error de tipos, no se puede asignar el valor a la variable: " +id+"\n");
            return null;
        }
        
        
        variable.setValor(nuevoValor);  //Modificando el valor de la variable
        
        return null;
    }
    
    
    
}
