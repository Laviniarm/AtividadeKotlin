fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 9) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {

            1 -> {
                print("Digite o nome do Animal: " )
                val nome = readln()
                print("Digite a idade do Animal: " )
                val idade = readln().toInt()
                val cachorro = Cachorro(idade, Color.Marrom)
                cachorro.nome = nome
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                print("Digite o nome do Animal: " )
                val nome = readln()
                print("Digite a idade do Animal: " )
                val idade = readln().toInt()
                val gato = Gato(idade, Color.Amarelo)
                gato.nome = nome
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                print("Digite o nome do Animal: " )
                val nome = readln()
                print("Digite a idade do Animal: " )
                val idade = readln().toInt()
                val passaro = Passaro(idade, Color.Preto)
                passaro.nome = nome
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                print("Digite o nome do Animal: " )
                val nome = readln()
                print("Digite a idade do Animal: " )
                val idade = readln().toInt()
                val humano = Humano(idade,Color.Marrom)
                humano.nome = nome
                repositorioAnimal.adicionar(humano)
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            7 -> {
                println("Digite a idade, para listar animais com essa idade:" )
                val idade = readln().toInt()
                repositorioAnimal.listarPorIdade(idade)
            }
            8 -> {
                println("Digite o nome do animal que deseja remover: ")
                val nomeAnimal =  readln()
                repositorioAnimal.remover(nomeAnimal)
            }
        }

    }
}

enum class Color() {
    Marrom,
    Amarelo,
    Preto,
}

abstract class Animal(var idade: Int, var color : Color ) {
    open var nome: String = ""
        get() = "Animal: $field"
        set(valor) {
            field = valor
        }

    open fun emitirSom() {

    }
    open fun idadeEmAnos(idade: Int): Int {
            return idade * 7
        }
    }

class Cachorro(idade: Int, color: Color) : Animal(idade, color) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, color: Color) : Animal(idade, color) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int,color: Color) : Animal(idade, color) {
    override fun emitirSom() {
        println("Piu piu")
    }
}
class Humano(idade: Int, color: Color): Animal(idade, color) {

    override fun idadeEmAnos(idade: Int): Int {
        return idade
    }

}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Humano")
    println("5 - Listar Animais")
    println("6 - Emitir som")
    println("7 - Listar animais por idade")
    println("8 - Remover Animal")
    println("9 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()


    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }
    fun remover(nome: String){
        val animaisEncontrados = animais.filter{animal -> animal.nome == nome}
        if(!animaisEncontrados.isEmpty()){
            animais.removeAll(animaisEncontrados)
            println("Animal removido")
        } else {
            println("Não existe animal com esse nome")
        }
    }
    fun listarPorCor(color: Color){
        animais.filter { animal -> animal.color == color }
            .forEach { animal -> println(animal.nome) }
    }
    fun listarPorIdade(idade: Int){
        animais.filter { animal -> animal.idade == idade }.forEach { animal -> println(animal.nome + " - " + animal.idade) }
    }
    fun buscarPorNome(nome: String): Animal ? {
        return animais.firstOrNull {animal -> animal.nome == nome  }
    }
}

