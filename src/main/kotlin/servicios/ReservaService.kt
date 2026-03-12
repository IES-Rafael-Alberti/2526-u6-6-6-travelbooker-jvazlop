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
     * Crea una reserva de vuelo y la guarda en el repositorio
     */
    fun crearReservaVuelo(
        descripcion: String,
        origen: String,
        destino: String,
        horaVuelo: String
    ) {
        val reserva = ReservaVuelo.creaInstancia(
            descripcion,
            origen,
            destino,
            horaVuelo
        )

        repository.agregar(reserva)
    }

    /**
     * Crea una reserva de hotel y la guarda en el repositorio
     */
    fun crearReservaHotel(
        descripcion: String,
        ubicacion: String,
        numeroNoches: Int
    ) {
        val reserva = ReservaHotel.creaInstancia(
            descripcion,
            ubicacion,
            numeroNoches
        )

        repository.agregar(reserva)
    }

    /**
     * Devuelve todas las reservas registradas
     */
    fun obtenerReservas(): List<Reserva> {
        return repository.obtenerTodas()
    }
}