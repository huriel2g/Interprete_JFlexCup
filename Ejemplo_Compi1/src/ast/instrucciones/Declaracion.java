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
 * @author Huriel
 */
public class Declaracion extends Instruccion{
    
    Tipo tipo;
    String id;
    Instruccion valor;

    // TIPO id = EXPRESION;
    public Declaracion(Tipo tipo,String id, Instruccion valor, int fila) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.fila = fila;
    }
    // TIPO id;
    public Declaracion(Tipo tipo,String id, int fila) {
        this.tipo = tipo;
        this.id = id;
        this.valor = null;
        this.fila = fila;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        Simbolo nuevo = null;
        
        if(valor != null){  //Declaracion y asignacion
            
            if(tabla.existeId(id)){
                arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". La variable ya fue declarada: " +id+"\n");
                return null;
            }else{
                Object expresion = valor.ejecutar(tabla, arbol);
                if(expresion == null){
                    arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". Error en la expresion que se desea asignar: " +id+"\n");
                    return null;
                }
                nuevo = new Simbolo(tipo, id, expresion);   //Creo un nuevo simbolo
                tabla.addSimbolo(nuevo);    //Agrego el simbolo a mi tabla
            }
            
        }else{  //Solo se declaro la variable
            if(tabla.existeId(id)){
                arbol.getConsola().append("Error Semantico en la Línea " + fila +" Columna "+columna+ ". La variable ya fue declarada: " +id+"\n");
                return null;
            }else{
                nuevo = new Simbolo(tipo, id);   //Creo un nuevo simbolo
                tabla.addSimbolo(nuevo);    //Agrego el simbolo a mi tabla
            }
        }
        
        return null;
    }
    
    
    
    
    
    
    
    
    
}
