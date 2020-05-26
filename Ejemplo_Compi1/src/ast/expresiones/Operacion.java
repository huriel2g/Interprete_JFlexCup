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
public class Operacion extends Instruccion{

    public static enum TipoOperacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        MAYOR,
        MENOR,
        NOT
    }
    
    TipoOperacion tipoOp;
    Instruccion operador1;
    Instruccion operador2;
    Instruccion operadorU;
    int fila;

    public Operacion(TipoOperacion op, Instruccion operador1, Instruccion operador2, int fila) {
        this.tipoOp = op;
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.fila = fila;
    }
    
    public Operacion(TipoOperacion op, Instruccion operador1, int fila) {
        this.tipoOp = op;
        this.operadorU = operador1;
        this.fila = fila;
    }
    
    @Override
    public Object ejecutar(TablaSimbolos tabla, AST arbol) {
        Object num1 = operador1.ejecutar(tabla, arbol);
        Object num2 = operador2.ejecutar(tabla, arbol);
        Object numU;
        if(operadorU != null){
            numU = operadorU.ejecutar(tabla, arbol);
        
        }else if(num1 == null || num2 == null){
            return null;
        }
        
        
        
        switch(tipoOp){
            case SUMA:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    return (int)num1 + (int)num2;
                }else if(num1 instanceof Double && num2 instanceof Double){
                    return (double)num1 + (double)num2;
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    return (int)num1 + (double)num2;
                }if(num1 instanceof Double && num2 instanceof Integer){
                    return (double)num1 + (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al sumar\n");
                return null;
                
            case RESTA:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    return (int)num1 - (int)num2;
                }else if(num1 instanceof Double && num2 instanceof Double){
                    return (double)num1 - (double)num2;
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    return (int)num1 - (double)num2;
                }if(num1 instanceof Double && num2 instanceof Integer){
                    return (double)num1 - (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al restar\n");
                return null;

            case MULTIPLICACION:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    return (int)num1 * (int)num2;
                }else if(num1 instanceof Double && num2 instanceof Double){
                    return (double)num1 * (double)num2;
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    return (int)num1 * (double)num2;
                }if(num1 instanceof Double && num2 instanceof Integer){
                    return (double)num1 * (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al multiplicar\n");
                return null;
                
            case DIVISION:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    if((int)num2 == 0){
                        arbol.getConsola().append("Error Semantico en la linea: "+fila +".  No es permitida la divicion entre 0\n");
                        return null;
                    }
                    return (int)num1 / (int)num2;
                    
                }else if(num1 instanceof Double && num2 instanceof Double){
                    if((double)num2 == 0){
                        arbol.getConsola().append("Error Semantico en la linea: "+fila +".  No es permitida la divicion entre 0\n");
                        return null;
                    }
                    return (double)num1 / (double)num2;
                    
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    if((double)num2 == 0){
                        arbol.getConsola().append("Error Semantico en la linea: "+fila +".  No es permitida la divicion entre 0\n");
                        return null;
                    }
                    return (int)num1 / (double)num2;
                    
                }if(num1 instanceof Double && num2 instanceof Integer){
                    if((int)num2 == 0){
                        arbol.getConsola().append("Error Semantico en la linea: "+fila +".  No es permitida la divicion entre 0\n");
                        return null;
                    }
                    return (double)num1 / (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al dividir\n");
                return null;
                
            case MENOR:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    return (int)num1 < (int)num2;
                }else if(num1 instanceof Double && num2 instanceof Double){
                    return (double)num1 < (double)num2;
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    return (int)num1 < (double)num2;
                }if(num1 instanceof Double && num2 instanceof Integer){
                    return (double)num1 < (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al comparar <\n");
                return null;
                
            case MAYOR:
                if(num1 instanceof Integer && num2 instanceof Integer){
                    return (int)num1 > (int)num2;
                }else if(num1 instanceof Double && num2 instanceof Double){
                    return (double)num1 > (double)num2;
                }else if(num1 instanceof Integer && num2 instanceof Double){
                    return (int)num1 > (double)num2;
                }if(num1 instanceof Double && num2 instanceof Integer){
                    return (double)num1 > (int)num2;
                }
                arbol.getConsola().append("Error Semantico en la linea: "+fila +".  Error de tipos al comparar >\n");
                return null;
                
            case NOT:
                
                
                
                return null;
        }
        
        return null;
    }
    
}
