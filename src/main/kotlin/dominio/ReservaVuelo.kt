package dominio

/**
 * Representa una reserva de vuelo concreta.
 *
 * Hereda de Reserva y añade los atributos específicos
 * de un vuelo: origen, destino y hora de vuelo.
 *
 * @property origen ciudad de salida del vuelo
 * @property destino ciudad de llegada del vuelo
 * @property horaVuelo hora del vuelo en formato HH:mm
 */

class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) :Reserva(descripcion) {
    override val detalle: String
        get() = "$id - $descripcion - $origen -> $destino[$horaVuelo]"

    override fun toString(): String {
        return "ReservaVuelo(id=$id, descripcion=$descripcion, origen=$origen, destino=$destino, horaVuelo='$horaVuelo')"
    }

    companion object {
        /**
         * Crea una nueva instancia de ReservaVuelo validando la hora.
         *
         * @param descripcion descripción del vuelo
         * @param origen ciudad de salida
         * @param destino ciudad de llegada
         * @param horaVuelo hora del vuelo en formato HH:mm
         * @return nueva instancia de ReservaVuelo
         * @throws IllegalArgumentException si la hora no tiene formato válido
         */

        fun creaInstancia(
            descripcion: String,
            origen: String,
            destino: String,
            horaVuelo: String
        ): ReservaVuelo {
            val regexHora = Regex("^([01]\\\\d|2[0-3]):([0-5]\\\\d)\$")
            if (!regexHora.matches(horaVuelo)) {
            throw IllegalArgumentException("Hora de vuelo invalida")
        }
        return ReservaVuelo(descripcion, origen, destino, horaVuelo)

    }


}


}