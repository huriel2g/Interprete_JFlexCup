z:
cd Z:\NetBeansProjects\Ejemplo_Compi1\src\analisis
java -jar C:\LibFlexCup\jflex-full-1.7.0.jar Alexico.jflex
pause
java -jar C:\LibFlexCup\java-cup-11b.jar -parser Parser -symbols Symbols Asintactico.cup 
pause