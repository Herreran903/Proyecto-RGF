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
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def tIR(f:Finca, pi:ProgRiego): TiempoInicioRiego =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoTablon
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * i:
   * f:
   * pi:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def costoRiegoTablon(i: Int, f: Finca, pi: ProgRiego): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoFinca
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def costoRiegoFinca(f: Finca, pi: ProgRiego): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoRiegoFincaPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def costoRiegoFincaPar(f: Finca, pi: ProgRiego): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoMovilidad
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * d:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def costoMovilidad(f: Finca, pi: ProgRiego, d: Distancia): Int =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: costoMovilidad
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * pi:
   * d:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def costoMovilidadPar(f: Finca, pi: ProgRiego, d: Distancia): Int =
    {
      val parejasTablones = for {
        i <- (0 to pi.length - 2).par
      } yield (pi(i), pi(i + 1))
      val distanciaPorPareja = parejasTablones.map { case (x, y) => d(x)(y) }
      distanciaPorPareja.sum
    }
    */

  /** ****************************************************************************
   * FUNCIÓN: generarProgramacionesRiego
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * RETORNO
   * Matriz:
   * **************************************************************************** */
    /*
    def generarProgramacionesRiego(f: Finca): Vector[ProgRiego] =
    {

    }
    */

  /** ****************************************************************************
   * FUNCIÓN: generarProgramacionesRiegoPar
   * DESCRIPCIÓN:
   * PARÁMETROS DE ENTRADA
   * f:
   * RETORNO
   * Matriz:
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
   * Matriz:
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
   * Matriz:
   * **************************************************************************** */
    /*
    def programacionRiegoOptimoPar(f: Finca, d: Distancia): (ProgRiego, Int) =
    {

    }
    */
}
