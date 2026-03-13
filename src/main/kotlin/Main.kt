package presentacion

import datos.ReservaRepositoryMemoria
import servicios.ReservaService

fun main() {
    try {
        val repository = ReservaRepositoryMemoria()
        val service = ReservaService(repository)

        var opcion: Int

        do {
            println("\n=== TRAVEL BOOKER ===")
            println("1. Crear reserva")
            println("2. Listar reservas")
            println("3. Borrar reserva")
            println("4. Salir")
            print("Seleccione una opcion: ")

            opcion = readlnOrNull()?.toIntOrNull() ?: -1

            when (opcion) {
                1 -> crearReserva(service)
                2 -> listarReservas(service)
                3 -> borrarReserva(service)
                4 -> println("Saliendo...")
                else -> println("Opcion no valida")
            }

        } while (opcion != 4)

    } catch (e: Exception) {
        println("Ocurrió un error inesperado: ${e.message}")
    }
}

private fun crearReserva(service: ReservaService) {
    println("\n--- CREAR RESERVA ---")
    println("1. Reserva de vuelo")
    println("2. Reserva de hotel")
    print("Seleccione una opcion: ")

    when (readlnOrNull()?.toIntOrNull() ?: -1) {
        1 -> crearVuelo(service)
        2 -> crearHotel(service)
        else -> println("Opcion no valida")
    }
}

private fun crearVuelo(service: ReservaService) {
    println("Descripcion:")
    val descripcion = readlnOrNull()
    println("Origen:")
    val origen = readlnOrNull()
    println("Destino:")
    val destino = readlnOrNull()
    println("Hora vuelo (HH:MM):")
    val hora = readlnOrNull()

    if (listOf(descripcion, origen, destino, hora).any { it.isNullOrBlank() }) {
        println("Datos inválidos")
        return
    }

    service.crearReservaVuelo(descripcion, origen, destino, hora)
    println("Reserva de vuelo creada ✔")
}

private fun crearHotel(service: ReservaService) {
    println("Descripciun:")
    val descripcion = readlnOrNull()
    println("Ubicacion:")
    val ubicacion = readlnOrNull()
    println("Numero de noches:")
    val noches = readlnOrNull()?.toIntOrNull()

    if (listOf(descripcion, ubicacion).any { it.isNullOrBlank() } || noches == null || noches <= 0) {
        println("Datos inválidos")
        return
    }

    service.crearReservaHotel(descripcion, ubicacion, noches)
    println("Reserva de hotel creada ✔")
}

private fun listarReservas(service: ReservaService) {
    val reservas = service.obtenerReservas()
    if (reservas.isEmpty()) println("No hay reservas.")
    else {
        println("\n--- RESERVAS ---")
        reservas.forEach { println(it) }
    }
}

private fun borrarReserva(service: ReservaService) {
    println("Ingrese el ID de la reserva a borrar:")
    val id = readlnOrNull()?.toIntOrNull()
    if (id == null) {
        println("ID invalida")
        return
    }
    if (service.borrarReserva(id)) println("Reserva eliminada")
    else println("No se encontro reserva con ese ID")
}