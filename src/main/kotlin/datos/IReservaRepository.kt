package datos

/**
 * Interfaz generica de repositorio para almacenar reservas.
 */
interface IReservaRepository<T> {

    fun agregar(reserva: T)

    fun obtenerTodas(): List<T>

    fun eliminarPorId(id: Int): Boolean
}
