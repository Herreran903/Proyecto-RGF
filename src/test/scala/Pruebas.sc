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

tIR(finca, programacion)
tIR(finca, programacion1)
tIR(finca2, programacion2)
tIR(finca2, programacion3)

costoRiegoFinca(finca, programacion)

costoRiegoFinca(finca, programacion1)

costoMovilidad(finca, programacion, distancia)

costoMovilidad(finca, programacion1, distancia)

costoRiegoFinca(finca2, programacion2)

costoRiegoFinca(finca2, programacion3)

costoMovilidad(finca2, programacion2, distancia)

costoMovilidad(finca2, programacion3, distancia)


generarProgramacionesRiego(finca).length

programacionRiegoOptimo(finca, distancia)

val a = fincaAlAzar(2)
val b = distanciaAlAzar(2)

programacionRiegoOptimo(a,b)