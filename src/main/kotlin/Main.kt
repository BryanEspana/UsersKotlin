import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val listaUsuarios = mutableListOf<Usuarios>()
    listaUsuarios.add(Usuarios(1, "Juan", "Perez", null, 20, "brp23023", "ocupado", Estados.ACTIVO, ))
    listaUsuarios.add(Usuarios(2, "Carlos", "Estrada", "www.photo.com", 20, "asd23023", "sd", Estados.PENDIENTE, ))
    var continuar= true
    while(continuar){
        // Try adding program arguments via Run/Debug configuration.
        // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
        println("------------------------------------------------------------------------")
        println("                       Bienvenido a CustomPerfils                       ")
        println("------------------------------------------------------------------------")
        println("1. Crear un perfil.\n2. Buscar un perfil. \n3. Eliminar un perfil. \n4. Agregar un Hobby por perfil\n5. Ver lista de Usuarios\n6. Salir")
        val option = readLine()?.toString() ?: return
        when (option){
            "1"->{
                agregarPerfil(listaUsuarios)
            }
            "2"->{
                buscarPerfil(listaUsuarios)
            }
            "3"->{
                eliminarPerfil(listaUsuarios)
            }
            "4"->{
                agregarHobbie(listaUsuarios)
            }
            "5"->{
                println("Usuarios actuales:")
                for (usuario in listaUsuarios) {
                    println("ID: ${usuario.id}, Nombre: ${usuario.nombres}")
                }
            }
            "6"->{
                continuar = false
                println("Saliendo del programa")
            }
            else ->{
                println("Opción no valida, intentalo nuevamente")
            }
        }
    }

}
//---------------------DATA---------------------
data class  Usuarios(
    var id: Int = 0,
    var nombres: String = "",
    var apellidos: String = "",
    var urlPhoto: String? = null,
    var edad: Int = 0,
    var correo: String = "",
    var biografia: String = "",
    var estadoActual: Estados = Estados.ACTIVO,
    var hobbies: MutableList<hobby> = mutableListOf()

){
    data class hobby(   var titulo: String = "",  var description: String = "", var urlhobby: String? = "")
}

//----------------------------------------------
fun agregarHobbie(listaUsuarios: MutableList<Usuarios>){
    println("1. Buscar por ID \n2. Buscar por nombre y apellido")
    val optionSearch = readLine()?.toString() ?: return
    if(optionSearch == "1"){
        println("Ingrese el ID del usuario que desea agregarle un hobbie:")
        val optionSearchID = readLine()?.toInt() ?: return
        val usuarioEncontrado = listaUsuarios.find { usuarios -> usuarios.id == optionSearchID}
        if (usuarioEncontrado != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("\nPerfil encontrado:")
            //imprimir perfil:
            println("¿Desea agregarle un hobbie al usuario: ${usuarioEncontrado.nombres} con el ID: ${usuarioEncontrado.id}? 1.Si 2.No")
            val optionHobby = readLine()?.toString()
            if( optionHobby == "1"){
                println("Titulo de hobby:")
                val titulo = readLine()?.toString()?: return
                println("Descripción del hobby:")
                val description = readLine()?.toString()?: return
                println("URL de foto asociada al hobby:")
                val urlhobby = readLine()?.toString()?: return

                val hobby = Usuarios.hobby(titulo, description, urlhobby)
                usuarioEncontrado.hobbies.add(hobby)

                println("-------------Hobies------------")
                for (hobby in usuarioEncontrado.hobbies) {
                    println("Título: ${hobby.titulo}")
                    println("Descripción: ${hobby.description}")
                    println("URL del hobby: ${hobby.urlhobby ?: "No se importo ninguna foto"}")
                    println("--------------------------")
                }
            }
        }
        else {
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("Usuario no encontrado")
        }
    } else if(optionSearch == "2"){
        println("Ingrese el nombre o apellido del usuario para asignarle el hobby (solo nombre o solo apellido)")
        var searchText  = readLine()?.toString()
        println(searchText)
        var searchActualName = listaUsuarios.find { usuarios -> usuarios.nombres == searchText}
        var searchActualLastName = listaUsuarios.find {usuarios -> usuarios.apellidos == searchText}

        if(searchActualName != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("\nUsuario encontrado:")
            //imprimir perfil:
            println("¿Desea agregar un hobbie al usuario :${searchActualName.nombres} con el ID:${searchActualName.id}? 1.Si 2.No")
            val optionHobbyName = readLine()?.toString()
            if( optionHobbyName == "1"){
                println("Titulo de hobby:")
                val titulo = readLine()?.toString()?: return
                println("Descripción del hobby:")
                val description = readLine()?.toString()?: return
                println("URL de foto asociada al hobby:")
                val urlhobby = readLine()?.toString()?: return

                val hobby = Usuarios.hobby(titulo, description, urlhobby)
                searchActualName.hobbies.add(hobby)

                println("-------------Hobies------------")
                for (hobby in searchActualName.hobbies) {
                    println("Título: ${hobby.titulo}")
                    println("Descripción: ${hobby.description}")
                    println("URL del hobby: ${hobby.urlhobby ?: "No se importo ninguna foto"}")
                    println("--------------------------")
                }
            }

        }else if(searchActualLastName != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            //imprimir perfil:
            println("Usuario encontrado")
            println("¿Desea agregar un hobbie al usuario :${searchActualLastName.nombres} con el ID:${searchActualLastName.id}? 1.Si 2.No")
            val optionHobbyLastName = readLine()?.toString()
            if( optionHobbyLastName == "1"){
                println("Titulo de hobby:")
                val titulo = readLine()?.toString()?: return
                println("Descripción del hobby:")
                val description = readLine()?.toString()?: return
                println("URL de foto asociada al hobby:")
                val urlhobby = readLine()?.toString()?: return

                val hobby = Usuarios.hobby(titulo, description, urlhobby)
                searchActualLastName.hobbies.add(hobby)

                println("-------------Hobies------------")
                for (hobby in searchActualLastName.hobbies) {
                    println("Título: ${hobby.titulo}")
                    println("Descripción: ${hobby.description}")
                    println("URL del hobby: ${hobby.urlhobby ?: "No se importo ninguna foto"}")
                    println("--------------------------")
                }
            }
        } else{
            println("No existe ningún usuario con ese Nombre o apellido, prueba buscarlo por ID")
        }

    }

}

fun buscarPerfil(listaUsuarios: MutableList<Usuarios>){
    println("1. Buscar por ID \n2. Buscar por nombre y apellido")
    val optionSearch = readLine()?.toString() ?: return
    if(optionSearch == "1"){
        println("Ingrese el ID del usuario que desea buscar:")
        val optionSearchID = readLine()?.toInt() ?: return
        val usuarioEncontrado = listaUsuarios.find { usuarios -> usuarios.id == optionSearchID}
        if (usuarioEncontrado != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("\nPerfil encontrado:")
            //imprimir perfil:
            println("ID: ${usuarioEncontrado.id}")
            println("Nombre: ${usuarioEncontrado.nombres}")
            println("Apellido: ${usuarioEncontrado.apellidos}")
            println("Edad: ${usuarioEncontrado.edad}")
            println("Correo: ${usuarioEncontrado.correo}")
            println("Biografia: ${usuarioEncontrado.biografia}")
            println("Estado: ${usuarioEncontrado.estadoActual}")
            //Si el urlde la foto no existe o es null colocar un texto de error al usuario
            println("URL de la foto: ${usuarioEncontrado.urlPhoto ?: "-Usuario sin fotografía-"}")
            println("-------------Hobies------------")
            for (hobby in usuarioEncontrado.hobbies) {
                println("Título: ${hobby.titulo}")
                println("Descripción: ${hobby.description}")
                println("URL del hobby: ${hobby.urlhobby ?: "No se importo ninguna foto"}")
                println("--------------------------")
            }
        } else {
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("Usuario no encontrado")
        }
    } else if(optionSearch == "2"){
        println("Ingrese el nombre o apellido del usuario (solo nombre o solo apellido)")
        var searchText  = readLine()?.toString()
        println(searchText)
        var searchActualName = listaUsuarios.find { usuarios -> usuarios.nombres == searchText}
        var searchActualLastName = listaUsuarios.find {usuarios -> usuarios.apellidos == searchText}

        if(searchActualName != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            println("\nUsuario encontrado:")
            //imprimir perfil:
            println("ID: ${searchActualName.id}")
            println("Nombre: ${searchActualName.nombres}")
            println("Apellido: ${searchActualName.apellidos}")
            println("Edad: ${searchActualName.edad}")
            println("Correo: ${searchActualName.correo}")
            println("Biografia: ${searchActualName.biografia}")
            println("Estado: ${searchActualName.estadoActual}")
            println("URL de la foto: ${searchActualName.urlPhoto}")
            println("-------------Hobies------------")
            for (hobby in searchActualName.hobbies) {
                println("Título: ${hobby.titulo}")
                println("Descripción: ${hobby.description}")
                println("URL del hobby: ${hobby.urlhobby ?: "N/A"}")
                println("--------------------------")
            }

        }else if(searchActualLastName != null){
            print("Buscando perfil ")
            for (i in 1..3) {
                print(".")
                Thread.sleep(1000) // Pausa el hilo actual durante 1 segundo (1000 milisegundos)
            }
            //imprimir perfil:
            println("ID: ${searchActualLastName.id}")
            println("Nombre: ${searchActualLastName.nombres}")
            println("Apellido: ${searchActualLastName.apellidos}")
            println("Edad: ${searchActualLastName.edad}")
            println("Correo: ${searchActualLastName.correo}")
            println("Biografia: ${searchActualLastName.biografia}")
            println("Estado: ${searchActualLastName.estadoActual}")
            println("URL de la foto: ${searchActualLastName.urlPhoto}")
            println("-------------Hobies------------")
            for (hobby in searchActualLastName.hobbies) {
                println("Título: ${hobby.titulo}")
                println("Descripción: ${hobby.description}")
                println("URL del hobby: ${hobby.urlhobby ?: "N/A"}")
                println("--------------------------")
            }

        } else{
            println("No existe ningún usuario con ese Nombre o apellido, prueba buscarlo por ID")
        }

    }
}

fun eliminarPerfil(listaUsuarios: MutableList<Usuarios>){
    println("Ingresa el ID del usuario que se desea eliminar")
    var eliminarUsuarios = readLine()?.toIntOrNull()
    if (eliminarUsuarios == 1){
        println("¿Estas seguro que quieres eliminar el usuario? 1.Si, 2.No")
        val opcionDelete = readLine()?.toIntOrNull() ?:return
        if(opcionDelete == 1){
            val usuarioEliminado = listaUsuarios.removeIf{usuarios -> usuarios.id == eliminarUsuarios }
            if(usuarioEliminado){
                println("Usuario con ID: $eliminarUsuarios ha sido eliminado")
            }
        }

    }else{
        println("Usuario con ID: $eliminarUsuarios no encontrado")
    }
}
fun agregarPerfil(listaUsuarios: MutableList<Usuarios>) {

    var hobby: Usuarios.hobby? = null

    //Agregar ID
    println("Ingrese el id del usuario:")
    val id = readLine()?.toIntOrNull() ?: return
    if (listaUsuarios.any { usuario -> usuario.id == id }) {
        println("El ID ingresado ya está en uso por otro usuario. Por favor, ingrese un ID diferente.")
        return
    }

    //Agregar Nombre
    println("Ingrese el nombre del usuario:")
    val nombres = readLine()?.toString() ?: return

    //Agregar Apellido
    println("Ingrese el apellido del usuario:")
    val apellidos = readLine()?.toString() ?: return

    //Agregar Edad
    println("Ingrese la edad del usuario:")
    val edad = readLine()?.toInt() ?: return

    //Agregar Correo
    println("Ingrese el correo del usuario:")
    val correo = readLine()?.toString() ?: return

    //Agregar biografia
    println("Ingrese la biografia del usuario:")
    val biografia = readLine()?.toString() ?: return

    //Agregar estado
    println("Ingrese el estado del usuario (activo/inactivo/pendiente")
    val estadoInput = readLine()?.toUpperCase()
    val estadoActual = try {
        Estados.valueOf(estadoInput!!)
    } catch (e: IllegalArgumentException){
        println("Estado invalido. Se asignara como 'PENDIENTE'")
        Estados.PENDIENTE
    }

    //Agregar URL de la foto
    println("Ingrese la url de la foto del usuario")
    val urlPhoto = readLine()?.toString() ?: return

    //Agregar Hobby
    println("¿Quieres ingresar un hobby? 1.Si / 2.No")
    val optionHobby = readLine()?.toString() ?: return
    if( optionHobby == "1"){
        println("Titulo de hobby:")
        val titulo = readLine()?.toString()?: return
        println("Descripción del hobby:")
        val description = readLine()?.toString()?: return
        println("URL de foto asociada al hobby:")
        val urlhobby = readLine()?.toString()?: return
        hobby = Usuarios.hobby(titulo = titulo, description = description, urlhobby = urlhobby)
    }
    val newUsuario = Usuarios(id, nombres, apellidos, urlPhoto, edad, correo, biografia, estadoActual)
    if (hobby != null) {
        newUsuario.hobbies.add(hobby)
    }

    listaUsuarios.add(newUsuario)
    //-------------------------------Imprimir datos-------------------------
    println("El perfil se ha creado correctamente")
    //imprimir perfil:
    println("El perfil creado es: ")
    println("ID: $id")
    println("Nombre: $nombres")
    println("Apellido: $apellidos")
    println("Edad: $edad")
    println("Correo: $correo")
    println("Biografia: $biografia")
    println("Estado: $estadoActual")
    println("URL de la foto: $urlPhoto")
    println("-------------Hobies------------")
    for (hobby in newUsuario.hobbies) {
        println("Título: ${hobby.titulo}")
        println("Descripción: ${hobby.description}")
        println("URL del hobby: ${hobby.urlhobby ?: "N/A"}")
        println("--------------------------")
    }
    //-------------------------------------------------------------
}
//class estado
enum class Estados{
    ACTIVO, INACTIVO, PENDIENTE
}
/*
class Hobbies(private val listaHobbies: MutableList<hobby> = mutableListOf()){
    fun agregarHobby(hobby: hobby){
        listaHobbies.add(hobby)
    }
    fun obtenerHobby(): List<hobby>{
        return listaHobbies.toList()
    }
}
*/
