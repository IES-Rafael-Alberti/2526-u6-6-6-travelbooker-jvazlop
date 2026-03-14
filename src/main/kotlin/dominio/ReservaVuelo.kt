package dominio

/**
 * Representa una reserva de vuelo concreta.
 */
class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(descripcion) {

    override val detalle: String
        get() = "$id - $descripcion - $origen -> $destino[$horaVuelo]"

    override fun toString(): String {
        return "ReservaVuelo(id=$id, descripcion=$descripcion, origen=$origen, destino=$destino, horaVuelo='$horaVuelo')"
    }

    companion object {
        /**
         * Crea una nueva instancia de ReservaVuelo validando la hora.
         */
        fun creaInstancia(
            descripcion: String,
            origen: String,
            destino: String,
            horaVuelo: String
        ): ReservaVuelo {
            val regexHora = Regex("^([01]\\d|2[0-3]):([0-5]\\d)$") // CORREGIDO
            if (!regexHora.matches(horaVuelo)) {
                throw IllegalArgumentException("Hora de vuelo invalida")
            }
            return ReservaVuelo(descripcion, origen, destino, horaVuelo)
        }
    }
}