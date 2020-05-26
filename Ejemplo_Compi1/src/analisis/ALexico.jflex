package analisis;
import java_cup.runtime.Symbol;
import javax.swing.JTextArea;
/*
Directivas:
public: clase publica
cup: compatibilidad con cup
full: extender el alfabeto con todos los valores de 8 bits
line: agrega la variable int yyline, para indicar la fila del lexema
char: agrega la variable int yychar, indica el indice del primer caracter del lexema
ignorecase: validar, indistitntamente si la letra es mayuscula o minuscula
eofval: especifica un valor de retorno al final del archivo
*/

%% 
%public 
%class Lexer
%{

    JTextArea consola;
    public void setConsola(){
        this.consola = consola;
    }
    

%}
%cupsym Symbols
%line 
%char 
%cup 
%unicode
%ignorecase
%init{ 
    yyline = 0; 
    yychar = 0;
%init} 

%eofval{
    return new Symbol(Symbols.EOF,new String("Fin del archivo"));
%eofval}

//Expresiones regulares
letra = [a-zA-Z]
digito = [0-9]
entero = [0-9]+
decimal = [0-9]+"."[  |0-9]+
espacio = \t|\f|" "|\r|\n
id = ({letra}|"." {letra}) ({letra}|{digito}|"_"|".")*
cadena = [\"]([^\"\n]|(\\\"))*[\"]

//Comentarios
comentarioUnilinea =("//".*\r\n)|("//".*\n)|("//".*\r)

%%

{comentarioUnilinea}        {}



//Palabras reservadas, valor de expresiones
"int"            {return new Symbol(Symbols.int_, yychar, yyline, yytext());}
"double"         {return new Symbol(Symbols.double_, yychar, yyline, yytext());}
"="              {return new Symbol(Symbols.igual, yychar, yyline, yytext());}
";"              {return new Symbol(Symbols.pcoma, yychar, yyline, yytext());}
"print"          {return new Symbol(Symbols.print, yychar, yyline, yytext());}

"boolean"         {return new Symbol(Symbols.boolean_, yychar, yyline, yytext());}
"String"         {return new Symbol(Symbols.String_, yychar, yyline, yytext());}
"true"         {return new Symbol(Symbols.true_, yychar, yyline, yytext());}
"false"         {return new Symbol(Symbols.false_, yychar, yyline, yytext());}

"while"          {return new Symbol(Symbols.while_, yychar, yyline, yytext());}
"{"              {return new Symbol(Symbols.llaveAbre, yychar, yyline, yytext());}
"}"              {return new Symbol(Symbols.llaveCierra, yychar, yyline, yytext());}
">"              {return new Symbol(Symbols.mayor, yychar, yyline, yytext());}
"<"              {return new Symbol(Symbols.menor, yychar, yyline, yytext());}
"break"          {return new Symbol(Symbols.break_, yychar, yyline, yytext());}
"if"          {return new Symbol(Symbols.if_, yychar, yyline, yytext());}
"else"          {return new Symbol(Symbols.else_, yychar, yyline, yytext());}

"+"              {return new Symbol(Symbols.mas, yychar, yyline, yytext());}
"-"              {return new Symbol(Symbols.menos, yychar, yyline, yytext());}
"*"              {return new Symbol(Symbols.por, yychar, yyline, yytext());}
"/"              {return new Symbol(Symbols.div, yychar, yyline, yytext());}
"("              {return new Symbol(Symbols.pAbre, yychar, yyline, yytext());}
")"              {return new Symbol(Symbols.pCierra, yychar, yyline, yytext());}



{id}             {return new Symbol(Symbols.id, yychar, yyline, yytext());}
{entero}         {return new Symbol(Symbols.entero, yychar, yyline, yytext());}
{decimal}			{return new Symbol(Symbols.decimal, yychar, yyline, yytext());}
{cadena}			{return new Symbol(Symbols.cadena, yychar, yyline, yytext());}
{espacio}   {}
.       {   
    consola.append("Este es un error lexico: "+yytext()+", en la linea: "+yyline +", en la columna: "+yychar);
    //System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline +", en la columna: "+yychar);

}