package dominio

import java.time.LocalDateTime
/**
 * Clase abstracta que representa una reserva genérica en el sistema.
 *
 * Contiene la lógica y propiedades comunes para todas las reservas
 * @property descripcion descripción de la reserva
 */
abstract class Reserva(
    val descripcion: String,
) {
    /** Identificador único de la reserva generado automáticamente */
    val id: Int = generarId()

    /** Fecha y hora de cracion de la reserva */
    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    /**
     * Devuelve la combinacion del id y la descripción */

    open val detalle: String
        get() = "$id - $descripcion"


    companion object{

        private var contadorId = 0

        /**
         * Generador de un nuevo identificador incremental para cada reserva.
         */
        private fun generarId(): Int{
            contadorId++
            return contadorId
        }
    }
}