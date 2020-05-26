/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import ast.entorno.TablaSimbolos;
import ast.instrucciones.Declaracion;
import java.util.LinkedList;
import javax.swing.JTextArea;

/**
 *
 * @author Huriel
 */
public class AST extends Instruccion{

    LinkedList<Instruccion> instrucciones;
    JTextArea consola;
    
    public AST(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        
        //Llenando mi tabla de simbolos GLOBAL con las variabales declaradas globalmente
        for (Instruccion ins : instrucciones) {
            if(ins instanceof Declaracion){
                Declaracion variable = (Declaracion)ins;
                variable.ejecutar(tabla, arbol);
            }
        }
        
        
        
        for (Instruccion ins : instrucciones) {
            
            
            if(!(ins instanceof Declaracion)){
                ins.ejecutar(tabla, arbol);
            }
        }
        
        
        
        return null;
    }
    
    
    
    public void setConsola(JTextArea consola) {
        this.consola = consola;
    }

    public JTextArea getConsola() {
        return consola;
    }
    
}
