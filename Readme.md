Documento readme
=============
## Autores:
- Nicolas Herrera Marulanda
- Julian Alexander Alvarez Payares

## Archivos entregados:
- Se entregó el archivo package.scala (RiegoFinca)
- Se entregó el archivo pruebas.scala
  
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
A travez de pruebas.sc se pueden ingresar los nombres de las funciones con sus respectivos parametros. Una vez hecho lo anterior, unicamente se debe 'buildar' el proyecto y presionar 'start', todo ello presionando en los respectivos botones de tu entorno de trabajo. Se declarara primero las funciones ‘fincaAlAzar’ y ‘distanciaAlAzar’ ambas recibiendo como parámetro el mismo valor entero positivo’. Una vez guardado los resultados de las funciones, se declara la función ‘programacionOptima’, a la cual se les pasara por parámetro los resultados de ‘fincaAlAzar’ y ‘distanciaAlAzar’ respectivamente. Un ejemplo de cómo debería quedar expresado el archivo es:

```
val f = fincaAlAzar(5)
val d = distanciaAlAzar(5)

programacionOptima(f, d)
```

#### consola:
A travez de consola se ingresa en un primer momento el comando 'sbt'. Se espera a que cargue y se ingresa el comando 'console'. Se espera a que cargue para posteriormente copiar todo el contenido que se encuentra dentro del package de RiegoFinca y se ingresa por consola. Ahora cada vez que se quiera ejecutra una funcion, simplemente ingrese el nombre de la funcion con sus respectivos parametros. Para obtener los resultados esperados segun el proposito del proyecto, recomendados ingresar las funciones en este orden:

```
val f = fincaAlAzar(5)
val d = distanciaAlAzar(5)

programacionOptima(f, d)
```

### Comparar tiempos:
#### pruebas.sc:
A travez de pruebas.sc se pueden ingresar los nombres de las funciones con sus respectivos parametros. Una vez hecho lo anterior, unicamente se debe 'buildar' el proyecto y presionar 'start', todo ello presionando en los respectivos botones de tu entorno de trabajo. Se declarara primero las funciones ‘fincaAlAzar’ y ‘distanciaAlAzar’ ambas recibiendo como parámetro el mismo valor entero positivo’. Una vez guardado los resultados de las funciones, se declara la función ‘programacionOptima’ o ‘programacionRiegoOptimoPar’, las cuales deben estar dentro de un standarConfig. Se les pasara por parámetro los resultados de ‘fincaAlAzar’ y ‘distanciaAlAzar’ respectivamente. Un ejemplo de cómo debería quedar expresado el archivo es:

```
val f = fincaAlAzar(5)
val d = distanciaAlAzar(5)

val timeSeq = {programacionOptima(f, d)}
val timePar = {programacionOptimaPar(f, d)}
```

#### consola:
A travez de consola se ingresa en un primer momento el comando 'sbt'. Se espera a que cargue y se ingresa el comando 'console'. Se espera a que cargue para posteriormente copiar todo el contenido que se encuentra dentro del package de RiegoFinca y del package de common, y se ingresa por consola. Tambien se ingresa en consola el siguinte codigo:

```
import org.scalameter._

val standardConfig = config (
  Key.exec.minWarmupRuns := 20,
  Key.exec.maxWarmupRuns := 40,
  Key.exec.benchRuns := 25,
  Key.verbose := false
) withWarmer (Warmer.Default())
```

Ahora cada vez que se quiera ejecutra una funcion, simplemente ingrese el nombre de la funcion con sus respectivos parametros, dentro de un standarConfig. Para obtener los resultados esperados segun el proposito del proyecto, recomendados ingresar las funciones en este orden:

```
val f = fincaAlAzar(5)
val d = distanciaAlAzar(5)

val timeSeq = {programacionOptima(f, d)}
val timePar = {programacionOptimaPar(f, d)}
```
