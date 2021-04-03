fun checkIsNumber(numero: String): Boolean {
    if (numero.toIntOrNull() != null) {
        return true
    }
    return false
}

fun ultimaLinhaAzul(showLegend: Boolean, countLines: Int, numColumns: Int, numLines: Int): String {
    var tabuleiro = ""
    val esc: String = 27.toChar().toString()
    val end = "$esc[0m"
    val startBlue = "$esc[30;44m"
    var countColumns: Int
    val quadradoAzul = "$startBlue   $end"
    if (showLegend && countLines == numLines) {
        countColumns = 0
        do {
            tabuleiro += quadradoAzul
            countColumns++
        } while (countColumns < numColumns + 1)
        tabuleiro += quadradoAzul
    }
    return tabuleiro
}

fun whiteGray(countColumns:Int,startWhite:String,startGrey:String,pecaPreta:String,end:String):String{
    var tabuleiro=""
    tabuleiro += if (countColumns % 2 == 1) {
        "$startWhite $pecaPreta $end"
    } else {
        "$startGrey $pecaPreta $end"
    }
    return tabuleiro
}

fun linhaspares(countColumns: Int,startGrey: String,startWhite: String,end: String):String{
    var tabuleiro=""
    tabuleiro += if (countColumns % 2 == 1) {
        "$startGrey   $end"
    } else {
        "$startWhite   $end"
    }
    return tabuleiro
}

fun linhasimpares(countColumns: Int,startWhite: String,startGrey: String,end: String):String{
    var tabuleiro=""
    tabuleiro += if (countColumns % 2 == 1) {
        "$startWhite   $end"
    } else {
        "$startGrey   $end"
    }
    return tabuleiro
}

fun ultimaLinhapecas(countLines: Int,countColumns: Int,startWhite: String,startGrey: String,pecaBranca:String,end: String):String{
    var tabuleiro=""
    tabuleiro += if (countLines % 2 == 0) { //ultima linha se par
        if (countColumns % 2 == 1) {
            "$startGrey $pecaBranca $end"
        } else {
            "$startWhite $pecaBranca $end"
        }
    } else { //ultima linha se ímpar
        if (countColumns % 2 == 1) {
            "$startWhite $pecaBranca $end"
        } else {
            "$startGrey $pecaBranca $end"
        }
    }
    return tabuleiro
}

fun buildBoard(numColumns: Int, numLines: Int, showLegend: Boolean = false, showPieces: Boolean = false): String {
    val esc: String = 27.toChar().toString()
    var tabuleiro = ""
    val end = "$esc[0m"
    val startBlue = "$esc[30;44m"
    val startGrey = "$esc[30;47m"
    val startWhite = "$esc[30;30m"
    var countLegenda = 0
    var countLines = 0
    var quadradoAzul = ""
    var pecaBranca = " "
    var pecaPreta = " "
    var countColumns = 0
    var numero = 1
    if (showPieces) {
        pecaBranca = "\u2659"
        pecaPreta = "\u265F"
    }
    if (showLegend) {
        quadradoAzul = "$startBlue   $end"
    }
    while (countLines < numLines) {
        if (showLegend && countLines == 0) {
            do {
                when {// parte da legenda das letras
                    countColumns == 0 -> {
                        tabuleiro += quadradoAzul
                    }
                    countColumns < numColumns + 1 -> {
                        val abc = ('A'.toInt() + countLegenda).toChar()
                        tabuleiro += "$startBlue $abc $end"
                        countLegenda++
                    }
                    else -> {
                        tabuleiro += quadradoAzul
                    }
                }
                countColumns++
            } while (countColumns < numColumns + 2)
            tabuleiro += "\n"
        }
        if (countColumns != 0 && showLegend) {// onde vao ser números
            tabuleiro += "$startBlue $numero $end"
            numero++
        }
        countLines++
        countColumns = 0
        while (countColumns < numColumns) {
            if (countLines == 1) { //primeira linha
                countColumns++
                tabuleiro += whiteGray(countColumns,startWhite,startGrey,pecaPreta,end)
            } else if (countLines == numLines) { //ultima linha
                countColumns++
                tabuleiro += ultimaLinhapecas(countLines,countColumns,startWhite,startGrey,pecaBranca,end)
            } else if (countLines % 2 == 0 && countLines > 1) { //linhas inseridas pares
                countColumns++
                tabuleiro += linhaspares(countColumns,startGrey,startWhite,end)
            } else if (countLines % 2 != 0 && countLines > 1) { //linhas inseridas ímpares
                countColumns++
                tabuleiro += linhasimpares(countColumns,startWhite,startGrey,end)
            }
        }
        if (showLegend && countColumns == numColumns && countLines > 0 && countLines < numLines + 1) {
            tabuleiro += quadradoAzul
        }
        tabuleiro += "\n" +ultimaLinhaAzul(showLegend, countLines, numColumns, numLines)
    }
    return tabuleiro
}

fun showChessLegendOrPieces(mensagem: String): Boolean? {
    return when (mensagem) {
        "y", "Y" -> true
        "n", "N" -> false
        else -> null
    }
}

fun checkName(nome: String): Boolean {
    var count = 0
    while (count < nome.length - 1) {
        if (nome[count] == ' ') {
            return !((nome[0] !in 'A'..'Z') || (nome[count + 1] !in 'A'..'Z'))
        } else count++
    }
    return false
}

fun buildMenu(): String {
    return ("\n1-> Start New Game;\n0-> Exit Game;\n")
}

fun main() {
    print("Welcome to the Chess Board Game!")
    do {
        var inicio = 2
        while (inicio >= 2 || inicio < 0) {
            println(buildMenu())
            inicio = readLine()?.toIntOrNull() ?: 2
        }
        if (inicio != 0) {// corre o programa inteiro
            do {
                println("First player name?\n")
                val nome1 = readLine().toString()
                if (!checkName(nome1)) {
                    println("Invalid response.")
                }
            } while (!checkName(nome1))

            do {
                println("Second player name?\n")
                val nome2 = readLine().toString()
                if (!checkName(nome2)) {
                    println("Invalid response.")
                }
            } while (!checkName(nome2))

            println("How many chess columns?\n")
            var numColumns: String = readLine()!!
            while (!checkIsNumber(numColumns) || numColumns.toInt() < 5) {
                println("Invalid response.\nHow many chess columns?\n")
                numColumns = readLine().toString()
            }

            println("How many chess lines?\n")
            var numLines = readLine()!!
            while (!checkIsNumber(numLines) || numLines.toInt() < 5) {
                println("Invalid response.\nHow many chess lines?\n")
                numLines = readLine().toString()
            }

            println("Show legend (y/n)?\n")
            var showLegend = readLine()!!
            while (showChessLegendOrPieces(showLegend) == null) {
                println("Invalid response.\nShow legend (y/n)?\n")
                showLegend = readLine()!!
            }

            println("Show pieces (y/n)?\n")
            var showPieces = readLine()!!
            while (showChessLegendOrPieces(showPieces) == null) {
                println("Invalid response.\nShow pieces (y/n)?\n")
                showPieces = readLine()!!
            }
            println(
                buildBoard(
                    numColumns.toInt(),
                    numLines.toInt(),
                    showChessLegendOrPieces(showLegend)!!,
                    showChessLegendOrPieces(showPieces)!!
                )
            )
        }
    } while (inicio != 0)
}