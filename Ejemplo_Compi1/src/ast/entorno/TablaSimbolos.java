/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.entorno;

import java.util.LinkedList;

/**
 *
 * @author Huriel
 */
public class TablaSimbolos {
    
    
    private LinkedList<Simbolo> tablaSimbolos;  //Almacenara los simbolos de la tabla o entorno actual
    private TablaSimbolos anterior;             //Apuntador a la tabla de simbolos del ambito superior o anterior

    //Agregando un nuevo entorno en cuando ya existe uno
    public TablaSimbolos(TablaSimbolos anterior){
        tablaSimbolos = new LinkedList<>();
        this.anterior = anterior;
    }
    
    //Agregando nuevos simbolos a la tabla
    public void addSimbolo(Simbolo simbolo){
        tablaSimbolos.add(simbolo);
    }
    
    //Verificando si existe un id
    public boolean existeId(String id){
        for(TablaSimbolos actual = this; actual != null; actual = actual.getAnterior()){ //iterando en el entorno actual y los anteriores
            LinkedList tablaActual = actual.getTablaSimbolos();
            for (Object obj : tablaActual) { //iterando en los simbolos de la tabla
                Simbolo sim = (Simbolo)obj;
                if(sim.getId().equals(id)){
                    return true;
                }
            }
        }
        return false;
    }
    
      
    
    
    
    //Retorna el simbolo que coincide con el id
    public Simbolo getSimbolo(String id){
        for(TablaSimbolos actual = this; actual != null; actual = actual.getAnterior()){ //iterando en el entorno actual y los anteriores
            for (Simbolo sim : actual.getTablaSimbolos()) { //iterando en los simbolos de la tabla
                if(sim.getId().equals(id)){
                    return sim;
                }
            }
        }
        return null;
    }
    
    //modifica el valor de un simbolo
    public boolean setAsignacion(String id, Simbolo nuevoValor){
        for(TablaSimbolos actual = this; actual != null; actual = actual.getAnterior()){ //iterando en el entorno actual y los anteriores
            for (Simbolo sim : actual.getTablaSimbolos()) { //iterando en los simbolos de la tabla
                if(sim.getId().equals(id)){
                    sim = nuevoValor;
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    
    public LinkedList<Simbolo> getTablaSimbolos(){
        return tablaSimbolos;
    }
    public TablaSimbolos getAnterior(){
        return anterior;
    }
    
    
    
}
