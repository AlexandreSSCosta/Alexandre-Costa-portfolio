import kotlin.math.*

fun main() {
    var continuar: Int
    var anguloRadianos: Double
    val larguraGrafico = 50
    val alturaGrafico = 20
    val grafico = Chart(larguraGrafico, alturaGrafico)
    var alturaDoSalto: Double
    var velocidadeInicial: Double
    var angulo: Double
    val gPlaneta = 9.8 * 2
    var escolha: Int
    println(""" 
                Um astraunauta num planata estranho quer realizar um salto de 100 metros em 2 segundos
                Este planeta tem uma força gravitica 2 vezes superior à da terra
                
                
    """.trimIndent())

    do {
        do {
            println("Escolha uma das seguintes opções:\n\n1->Gráfico com ângulo inicial de 0º;\n2->Gráfico com ângulo inicial de 340º/-20º;\n3->Gráfico com ângulo inicial de 315º/-45º;\n4->Gráfico com ângulo inicial de 300º/-60º;\n5->Introduzir os valores da velocidade inicial, altura e ângulo de salto.\n")
            escolha = readLine()?.toIntOrNull() ?: return
            if (escolha !in 1..5) {
                println("Resposta inválida")
            }
        } while (escolha !in 1..5)

        var x = 0.0
        var y: Double
        if (escolha == 1) {
            angulo = 0.0
            anguloRadianos = (angulo * PI) / 180
            velocidadeInicial = 50.0 / cos(anguloRadianos)
            alturaDoSalto = 9.8 * 4.0 - 2 * velocidadeInicial * sin(anguloRadianos)
            y = alturaDoSalto //altura inicial

            while (y >= 0.0 && x <= 100.0) {// trajetoria
                grafico.ponto(x, y)
                x += 0.2
                y =
                    alturaDoSalto + (tan(anguloRadianos) * x) - ((gPlaneta / 2) * (x.pow(2)) / ((velocidadeInicial * cos(
                        anguloRadianos
                    ))).pow(2))

            }
            grafico.draw()
            println("Velocidade inicial:$velocidadeInicial metros/segundo\nAltura de salto:$alturaDoSalto metros\n")
            println("Passado 2 segundos o astronauta realizou um salto de $x metros\nE encontra-se a cerca de ${y.toInt()} metros do solo\n")

        }


        if (escolha == 2) {
            angulo = -20.0
            anguloRadianos = (angulo * PI) / 180
            velocidadeInicial = 50.0 / cos(anguloRadianos)
            alturaDoSalto = 9.8 * 4.0 - 2 * velocidadeInicial * sin(anguloRadianos)
            y = alturaDoSalto

            while (y >= 0.0 && x <= 100.0) {// trajetoria
                grafico.ponto(x, y)
                x += 0.2
                y =
                    alturaDoSalto + (tan(anguloRadianos) * x) - ((gPlaneta / 2) * (x.pow(2)) / ((velocidadeInicial * cos(
                        anguloRadianos
                    ))).pow(2))

            }
            grafico.draw()
            println("Velocidade inicial:$velocidadeInicial metros/segundo\nAltura de salto:$alturaDoSalto metros\n")
            println("Passado 2 segundos o astronauta realizou um salto de $x metros\nE encontra-se a cerca de ${y.toInt()} metros do solo\n")

        }
        if (escolha == 3) {
            angulo = -45.0
            anguloRadianos = (angulo * PI) / 180
            velocidadeInicial = 50.0 / cos(anguloRadianos)
            alturaDoSalto = 9.8 * 4.0 - 2 * velocidadeInicial * sin(anguloRadianos)
            y = alturaDoSalto

            while (y >= 0.0 && x <= 100.0) {// trajetoria
                grafico.ponto(x, y)
                x += 0.2
                y =
                    alturaDoSalto + (tan(anguloRadianos) * x) - ((gPlaneta / 2) * (x.pow(2)) / ((velocidadeInicial * cos(
                        anguloRadianos
                    ))).pow(2))

            }
            grafico.draw()
            println("Velocidade inicial:$velocidadeInicial metros/segundo\nAltura de salto:$alturaDoSalto metros\n")
            println("Passado 2 segundos o astronauta realizou um salto de $x metros\nE encontra-se a cerca de ${y.toInt()} metros do solo\n")
        }
        if (escolha == 4) {
            angulo = -60.0
            anguloRadianos = (angulo * PI) / 180
            velocidadeInicial = 50.0 / cos(anguloRadianos)
            alturaDoSalto = 9.8 * 4.0 - 2 * velocidadeInicial * sin(anguloRadianos)
            y = alturaDoSalto

            while (y >= 0.0 && x <= 100.0) {// trajetoria
                grafico.ponto(x, y)
                x += 0.2
                y =
                    alturaDoSalto + (tan(anguloRadianos) * x) - ((gPlaneta / 2) * (x.pow(2)) / ((velocidadeInicial * cos(
                        anguloRadianos
                    ))).pow(2))

            }
            grafico.draw()
            println("Velocidade inicial:$velocidadeInicial metros/segundo\nAltura de salto:$alturaDoSalto metros\n")
            println("Passado 2 segundos o astronauta realizou um salto de $x metros\nE encontra-se a cerca de ${y.toInt()} metros do solo\n")
        }
        if (escolha == 5) {
            do {
                println("Introduza a altura")
                alturaDoSalto = readLine()?.toDoubleOrNull() ?: 0.0
                if (alturaDoSalto <= 0.0) {
                    println("Resposta inválida")
                }
            } while (alturaDoSalto <= 0)

            do {
                println("Introduza a velocidade inicial")
                velocidadeInicial = readLine()?.toDoubleOrNull() ?: 0.0
                if (velocidadeInicial <= 0.0) {
                    println("Resposta inválida")
                }
            } while (velocidadeInicial <= 0.0)

            do {
                println("Introduza o ângulo de salto entre 270º e 360º ou -90º e 0º")
                angulo = readLine()?.toDoubleOrNull() ?: -1.0
                if (!((angulo > 270.0 && angulo <= 360.0) || (angulo > -90.0 && angulo <= 0.0))) {
                    println("Resposta inválida")
                }
            } while (!((angulo > 270.0 && angulo <= 360.0) || (angulo > -90.0 && angulo <= 0.0)))

            anguloRadianos = (angulo * PI) / 180
            y = alturaDoSalto

            while (y >= 0.0 && x <= 100.0) {// trajetoria
                grafico.ponto(x, y)
                x += 0.2
                y =
                    alturaDoSalto + (tan(anguloRadianos) * x) - ((gPlaneta / 2) * (x.pow(2)) / ((velocidadeInicial * cos(
                        anguloRadianos
                    ))).pow(2))

            }
            grafico.draw()
            println("Passado 2 segundos o astronauta realizou um salto de $x metros\nE encontra-se a cerca de ${y.toInt()} metros do solo\n")

            //MANDAR FAZER O GRAFICO COM OS VALORES DO UTILIZADOR E VER QUAL O X PARA T=2

        }

        do {
            println("Quer desenhar um novo gráfico?\n0->Continuar;\n1->Terminar.\n")
            continuar = readLine()?.toIntOrNull() ?: 5
            if (continuar != 0 && continuar != 1) {
                println("\nResposta inválida.\n")
            }
        } while (continuar != 0 && continuar != 1)
        println()
    } while (continuar == 0)
}