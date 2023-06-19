Documento readme
=============
## Autores:
- Nicolas Herrera Marulanda
- Julian Alexander Alvarez Payares
- Luis Felipe Belalcazar Alvarez

## Archivos entregados:
- Se entregó el archivo package.scala (RiegoFinca)
- Se entregó el archivo pruebas.scala
- 
## Link informe:
[Docuemento](https://docs.google.com/document/d/19Dw8y32lmFTwPI8cfZCJRD5T8Ug7utBEbgn7MALrBm0/edit?usp=sharing)

package.scala (RiegoFinca)
-------------
Consiste en el archivo donde se implementan las funciones y tipos establecidas previamente, así como las funciones solicitadas en el proyecto y desarrolladas por el grupo de trabajo. En este archivo se podrá encontrar las siguientes funciones:

- fincaAlAzar
- distanciaAlAzar
- tsup
- treg
- prio
- tIR
- costoRiegoTablon
- costoRiegoFinca
- costoRiegoFincaPar
- costoMovilidad
- costoMovilidadPar
- generarProgramacionesRiego
- generarProgramacionesRiegoPar
- programacionRiegoOptimo
- programacionRiegoOptimoPar

pruebas.sc
-------------
Consiste en el archivo donde se implementan las pruebas de rendimiento de las funciones solicitadas y desarrolladas.

Instrucciones de uso:
-------------
Las funciones desarrolladas pueden ser utilizadas tanto a través del archivo pruebas.sc o en la consola.

### Visualizar resultados:
#### pruebas.sc:
En el archivo pruebas.sc solo consistira en presionar el boton correspondiente al entorno de trabajo para construir el proyecto. Una vez realizado lo anterior, tan solo se deben declarar primero las funciones ‘fincaAlAzar’ y ‘distanciaAlAzar’ ambas recibiendo como parámetro el mismo valor entero positivo’. Una vez guardado los resultados de las funciones, se declara la función ‘programacionOptima’ o ‘programacionRiegoOptimoPar’, a la cual se les pasara por parámetro los resultados de ‘fincaAlAzar’ y ‘distanciaAlAzar’ respectivamente. Una vez declarado todo lo anterior, se debe presionar el botón correspondiente a ejecutar en el entorno de trabajo. Un ejemplo de cómo debería quedar expresado el archivo es:

```
val f = fincaAlAzar(5)
val d = distanciaAlAzar(5)

programacionOptima(f, d)
programacionOptimaPar(f, d)
```

#### consola

### Comparar tiempos:
#### pruebas.sc:
#### consola:
