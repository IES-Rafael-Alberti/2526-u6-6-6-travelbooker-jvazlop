package dominio

/**
 * Representa una reserva de hotel.
 * Hereda de la clase abstracta Reserva y añade
 * información específica como la ubicación y el número de noches.
 */
class ReservaHotel private constructor(
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
) : Reserva(descripcion) {

    override val detalle: String
        get() = "$id - $descripcion - $ubicacion ($numeroNoches)"

    override fun toString(): String {
        return "ReservaHotel(id=$id, descripcion=$descripcion, ubicacion=$ubicacion, noches=$numeroNoches)"
    }

    companion object {

        /**
         * Crea una instancia de ReservaHotel validando el número de noches.
         */
        fun creaInstancia(
            descripcion: String,
            ubicacion: String,
            numeroNoches: Int
        ): ReservaHotel {

            if (numeroNoches <= 0) {
                throw IllegalArgumentException("El número de noches debe ser mayor que 0")
            }

            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }
    }
}