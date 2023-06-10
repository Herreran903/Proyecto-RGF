/** ****************************************************************************
 * Integrantes:
 * Nicolas Herrera Marulanda
 * Julian Alexander Alvarez Payares
 * Luis Felipe Belalcazar Alvarez
 * **************************************************************************** */

import scala.collection.parallel.CollectionConverters._
import scala.util.Random

package object RiegoFinca
{
  /** ****************************************************************************
   * Tipos de datos entregadas por el profesor
   * **************************************************************************** */
  type Tablon = (Int, Int, Int)
  type Finca = Vector[Tablon]
  type Distancia = Vector[Vector[Int]]
  type ProgRiego = Vector[Int]
  type TiempoInicioRiego = Vector[Int]

  /** ****************************************************************************
   * Funciones entregadas por el profesor
   * **************************************************************************** */
  val random = new Random()

  def fincaAlAzar(long: Int): Finca =
  {
    val v = Vector.fill(long)
    {
      (
        random.nextInt(long * 2) + 1,
        random.nextInt(long) + 1,
        random.nextInt(4) + 1
      )
    }
    v
  }

  def distanciaAlAzar(long: Int): Distancia =
  {
    val v = Vector.fill(long, long)
    {
      random.nextInt(long * 3) + 1
    }
    Vector.tabulate(long, long)
    {
      (i, j) =>
        if (i < j) v(i)(j)
        else if (i == j) 0
        else v(j)(i)
    }
  }

  def tsup(f: Finca, i: Int): Int =
  {
    f(i)._1
  }

  def treg(f: Finca, i: Int): Int =
  {
    f(i)._2
  }

  def prio(f: Finca, i: Int): Int =
  {
    f(i)._3
  }

  /** ****************************************************************************
   * FUNCIÓN: tIR
   * DESCRIPCIÓN: Retorna un vector de enteros con el tiempo de inicio de riego por tablon.
   * PARÁMETROS DE ENTRADA
   * f: Finca.
   * pi: Programacion de riego.
   * RETORNO
   * TiempoInicioRiego: Vector con los tiempos de inicio de riego.
   * **************************************************************************** */
    def tIR(f:Finca, pi:ProgRiego): TiempoInicioRiego =
    {
      val tiemposRiego = pi.map(x => treg(f,x))

      tiemposRiego.init.scanLeft(0)(_ + _)
    }

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoTablon
   * DESCRIPCIÓN: Retorna un el costo de riego por tablon.
   * PARÁMETROS DE ENTRADA
   * i: Numero de tablon.
   * f: Finca.
   * pi: Programacion de riego.
   * RETORNO
   * Int: Costo de riego.
   * **************************************************************************** */
    def costoRiegoTablon(i: Int, f: Finca, pi: ProgRiego): Int =
    {
      val tiemposIniciales = tIR(f, pi)

      if((tsup(f,i) - treg(f,i)) >= tiemposIniciales(i))
      {
        tsup(f,i) - (tiemposIniciales(i) + treg(f,i))
      }
      else
      {
        prio(f,i) * ((tiemposIniciales(i) + treg(f,i)) - tsup(f,i))
      }
    }

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoFinca
   * DESCRIPCIÓN: Retorna un el costo de riego por toda la finca.
   * PARÁMETROS DE ENTRADA
   * f: Finca.
   * pi: Programacion de riego.
   * RETORNO
   * Int: Costo de riego.
   * **************************************************************************** */
    def costoRiegoFinca(f: Finca, pi: ProgRiego): Int =
    {
      pi.map(x => costoRiegoTablon(x, f, pi)).sum
    }

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoFincaPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * RETORNO
   * Int:
   * **************************************************************************** */
    /*
    def costoRiegoFincaPar(f: Finca, pi: ProgRiego): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoMovilidad
   * DESCRIPCIÓN: Retorna el costo de movilidad por toda la finca.
   * PARÁMETROS DE ENTRADA
   * f: Finca.
   * pi: Programacion de riego.
   * d: Distancia entre tablones.
   * RETORNO
   * Int: Costo de movilidad.
   * **************************************************************************** */
    def costoMovilidad(f: Finca, pi: ProgRiego, d: Distancia): Int =
    {
      (for(i <- 0 to pi.length-2) yield (d(pi(i))(pi(i+1)))).sum
    }

  /** ****************************************************************************
   * FUNCIÓN: costoMovilidadPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * d:
   * RETORNO
   * Int:
   * **************************************************************************** */
    /*
    def costoMovilidadPar(f: Finca, pi: ProgRiego, d: Distancia): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: generarProgramacionesRiego
   * DESCRIPCIÓN: Retorna toda las posibles programaciones de riego para la finca.
   * PARÁMETROS DE ENTRADA
   * f: Finca
   * RETORNO
   * Vector[ProgRiego]: Vector de programaciones de riego.
   * **************************************************************************** */
    def generarProgramacionesRiego(f: Finca): Vector[ProgRiego] =
    {
      def posiblesCombinaciones(indices: Vector[Int], combinaciones: Vector[Int]): Vector[Vector[Int]] =
      {
        indices match
        {
          case Vector() => Vector(combinaciones)
          case _ => for (indice <- indices; rest <- posiblesCombinaciones(indices.filterNot(_ == indice), combinaciones :+ indice)) yield rest
        }
      }
      val indices = (0 to f.length-1).map(x => x).toVector
      posiblesCombinaciones(indices, Vector())
    }

  /** ****************************************************************************
   * FUNCIÓN: generarProgramacionesRiegoPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * RETORNO
   * Vector[ProgRiego]:
   * **************************************************************************** */
    /*
    def generarProgramacionesRiegoPar(f: Finca): Vector[ProgRiego] =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: programacionRiegoOptimo
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * d:
   * RETORNO
   * (ProgRiego, Int):
   * **************************************************************************** */
    /*
    def programacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int) =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: programacionRiegoOptimoPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * d:
   * RETORNO
   * (ProgRiego, Int):
   * **************************************************************************** */
    /*
    def programacionRiegoOptimoPar(f: Finca, d: Distancia): (ProgRiego, Int) =
    {

    }
    */
}
