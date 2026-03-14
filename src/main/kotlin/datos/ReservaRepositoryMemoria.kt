package datos

import dominio.Reserva

/**
 * Implementación en memoria del repositorio de reservas.
 */

class ReservaRepositoryMemoria : IReservaRepository<Reserva> {

    private val reservas = mutableListOf<Reserva>()

    override fun agregar(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun obtenerTodas(): List<Reserva> {
        return reservas.toList()
    }

    override fun eliminarPorId(id: Int): Boolean {
        return reservas.removeIf { it.id == id }
    }

}