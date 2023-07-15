import java.nio.file.Files
import java.nio.file.Paths
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    /*
    * Verify if the "~/.archinote" directory exists and create it if it doesn't.
    *
    * Inside this directory there should be the following directories:
    * - "lists" - Contains all the global user-defined lists.
    * */
    val home = System.getProperty("user.home")
    val archinote = Paths.get(home, ".archinote")
    val lists = Paths.get(archinote.toString(), "lists")

    if (!Files.exists(archinote)) {
        Files.createDirectory(archinote)
        Files.createDirectory(lists)
    }

    // Verify if the "~/.config/.archinote" directory exists and create it if it doesn't.
    val config = Paths.get(home, ".config", ".archinote")
    if (!Files.exists(config)) {
        Files.createDirectory(config)
    }

    if (args.isEmpty()) {
        println("""
            Welcome to Archinote!
            =====================
            
            Archinote is a filing cabinet not only for your notes, but also for all your knowledge, and can act as a documentation tool for your projects.
        """.trimIndent())
        return
    }

    val command = args[0]
    val arguments = args.drop(1)

    when (command) {
        // Show the version of Archinote.
        "--version", "-v" -> println("Archinote v0.1.0")

        // Show the help message.
        "--help", "-h" -> println("Help") // TODO: Implement help

        // Show a message saying that the command is not recognized.
        else -> {
            println("""
                Unknown command: $command
                Try 'archinote --help' for more information.
            """.trimIndent())
            // Send 1 as the exit code to indicate that the command is not recognized.
            exitProcess(1)
        }
    }
}
