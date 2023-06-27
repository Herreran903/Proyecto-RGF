import RiegoFinca._
import org.scalameter._

val standardConfig = config (
  Key.exec.minWarmupRuns := 20,
  Key.exec.maxWarmupRuns := 40,
  Key.exec.benchRuns := 25,
  Key.verbose := false
) withWarmer (Warmer.Default())



val finca = Vector((10,3,4), (5,3,3), (2,2,1), (8,1,1), (6,4,2))
val programacion = Vector(0,1,4,2,3)
val programacion1 = Vector(2,1,4,3,0)
val distancia = Vector(Vector(0,2,2,4,4), Vector(2,0,4,2,6), Vector(2,4,0,2,3), Vector(4,2,2,0,4), Vector(4,6,2,4,0))

val finca2 = Vector((9,3,4), (5,3,3), (2,2,1), (8,1,1), (6,4,2))
val programacion2 = Vector(2,1,4,3,0)
val programacion3 = Vector(2,1,4,0,3)


val finca3 = fincaAlAzar(10)
val programacion4 = (0 to 9).toVector;
val distancia3 = distanciaAlAzar(10)

tIR(finca, programacion)
tIR(finca, programacion1)
tIR(finca2, programacion2)
tIR(finca2, programacion3)

val tiempoSeq = standardConfig measure {
  tIR(finca, programacion)
}

costoRiegoFinca(finca, programacion)

costoRiegoFinca(finca, programacion1)

costoMovilidad(finca, programacion, distancia)

val tiempoNormal= standardConfig measure {
  costoMovilidad(finca, programacion1, distancia)
}

val tiempoParallel = standardConfig measure {
  costoMovilidadPar(finca2, programacion1, distancia)
}

val tiempoPar = standardConfig measure {
  costoMovilidadPar2(finca2, programacion1, distancia)
}

/* Prueba con datos largos */

val tiempoNormal= standardConfig measure {
  costoMovilidad(finca3, programacion4, distancia3)
}

val tiempoParallel = standardConfig measure {
  costoMovilidadPar(finca3, programacion4, distancia3)
}

val tiempoPar = standardConfig measure {
  costoMovilidadPar2(finca3, programacion4, distancia3)
}

/*          *        */

costoRiegoFinca(finca2, programacion2)

costoRiegoFinca(finca2, programacion3)

costoMovilidad(finca2, programacion2, distancia)

costoMovilidad(finca2, programacion3, distancia)


generarProgramacionesRiego(finca).length

programacionRiegoOptimo(finca, distancia)

val a = fincaAlAzar(2)
val b = distanciaAlAzar(2)

programacionRiegoOptimo(a,b)