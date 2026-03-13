package servicios

import datos.IReservaRepository
import dominio.Reserva
import dominio.ReservaVuelo
import dominio.ReservaHotel

/**
 * Servicio que gestiona la lógica de negocio de las reservas.
 * Se encarga de crear reservas y almacenarlas usando el repositorio.
 */
class ReservaService(
    private val repository: IReservaRepository<Reserva>
) {

    /**
     * Crea una reserva de vuelo y la guarda en el repositorio.
     * Valida que los campos no sean nulos ni vacíos antes de crear la instancia.
     */
    fun crearReservaVuelo(
        descripcion: String?,
        origen: String?,
        destino: String?,
        horaVuelo: String?
    ) {
        // Validación temprana
        if (descripcion.isNullOrBlank() || origen.isNullOrBlank() ||
            destino.isNullOrBlank() || horaVuelo.isNullOrBlank()
        ) {
            println("❌ Datos inválidos: no se puede crear la reserva de vuelo")
            return
        }

        // Ya sabemos que no son null, podemos pasar directamente
        val reserva = ReservaVuelo.creaInstancia(
            descripcion,
            origen,
            destino,
            horaVuelo
        )

        repository.agregar(reserva)
    }

    /**
     * Crea una reserva de hotel y la guarda en el repositorio.
     * Valida que los campos no sean nulos ni vacíos antes de crear la instancia.
     */
    fun crearReservaHotel(
        descripcion: String?,
        ubicacion: String?,
        numeroNoches: Int?
    ) {
        // Validación temprana
        if (descripcion.isNullOrBlank() || ubicacion.isNullOrBlank() ||
            numeroNoches == null || numeroNoches <= 0
        ) {
            println("❌ Datos inválidos: no se puede crear la reserva de hotel")
            return
        }

        val reserva = ReservaHotel.creaInstancia(
            descripcion,
            ubicacion,
            numeroNoches
        )

        repository.agregar(reserva)
    }

    /**
     * Devuelve todas las reservas registradas.
     */
    fun obtenerReservas(): List<Reserva> = repository.obtenerTodas()

    /**
     * Borra una reserva por su id.
     * @return true si se eliminó, false si no se encontró
     */
    fun borrarReserva(id: Int): Boolean = repository.eliminarPorId(id)
}