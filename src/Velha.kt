import org.w3c.dom.*
import org.w3c.dom.events.MouseEvent
import kotlin.browser.*

@JsName("clicaTeste")
fun clicaTeste(id: String){
    val e = document.getElementById(id) as HTMLTableCellElement
    if(e.firstElementChild!!.className.equals("hashtag")) e.innerHTML = "<img class=\"x\" src=\"img/x.jpg\"/>"

    println(checaLinhas())
}

fun testeCheca(){
    val l = document.getElementsByTagName("td")
    println("pula")
    println(l.get(0)?.firstElementChild?.className.equals("x"))
}

@JsName("update")
fun update(id: String): Unit{
    if(!checa()) {
        val e = document.getElementById(id) as HTMLTableCellElement
        val rod = document.getElementById("rod") as HTMLElement
        val valor: Int = rod.textContent!!.toInt()


        jogada(e, valor)
        attRodada(rod, valor)//atualiza o valor da rodada

        if(checaVitoria()) if(valor%2==0) fim("x") else fim("o")
    } else
        if(tabuleiroCheio()) window.alert("Empate!")

}

@JsName("reinicia")
fun reinicia(): Unit{
    val e = document.getElementsByTagName("td")
    e.asList().forEach { obj ->
        obj.innerHTML = "#"
    }
    document.getElementById("rod")?.innerHTML = 0.toString()
}

fun fim(c: String): Unit {
    window.alert("Terminou, venceu o jogador $c ")
    reinicia()
}

fun jogada(elem: HTMLElement, rodada: Int): Unit{ //faz um movimento no html ao clicar numa celula vazia
    if (elem.textContent.equals("#"))
        if (rodada % 2 == 0)
            elem.innerHTML = "x"
        else
            elem.innerHTML = "o"
}

fun attRodada(rod: HTMLElement, valor: Int): Unit{
    rod.innerHTML= (valor+1).toString()
}

fun tabuleiroCheio(): Boolean{
    val l = document.getElementsByTagName("td")
    l.asList().forEach { obj ->
        if(obj.textContent.equals("#")) return false
    }
    for(e in l.asList())
        println(e.textContent)
    return true
}

fun checaLinhas(): Boolean{
    val l = document.getElementsByTagName("td")

    fun linha1Aux(): Boolean { //checa linha 1
        if(!l.get(0)?.firstElementChild?.className.equals("hashtag") || !l.get(1)?.firstElementChild?.className.equals("hashtag")
                || !l.get(2)?.firstElementChild?.className.equals("hashtag"))
            return (l.get(0)?.firstElementChild?.className.equals(l.get(1)?.firstElementChild?.className) && l.get(0)?.firstElementChild?.className.equals(l.get(2)?.firstElementChild?.className))
        else
            return false
    }

    fun linha2Aux(): Boolean { //checa linha 2
        if(!l.get(3)?.textContent.equals("#") || !l.get(4)?.textContent.equals("#") || !l.get(5)?.textContent.equals("#"))
            return (l.get(3)?.textContent.equals(l.get(4)?.textContent) && l.get(3)?.textContent.equals(l.get(5)?.textContent))
        else
            return false
    }

    fun linha3Aux(): Boolean { //checa linha 3
        if(!l.get(6)?.textContent.equals("#") || !l.get(7)?.textContent.equals("#") || !l.get(8)?.textContent.equals("#"))
            return (l.get(6)?.textContent.equals(l.get(7)?.textContent) && l.get(6)?.textContent.equals(l.get(8)?.textContent))
        else
            return false
    }

    return linha1Aux()
}

fun checaColuna(): Boolean{
    val l = document.getElementsByTagName("td")

    fun coluna1Aux(): Boolean{
        if(!l.get(0)?.textContent.equals("#") || !l.get(3)?.textContent.equals("#") || !l.get(6)?.textContent.equals("#"))
            return (l.get(0)?.textContent.equals(l.get(3)?.textContent) && l.get(0)?.textContent.equals(l.get(6)?.textContent))
        else
            return false
    }

    fun coluna2Aux(): Boolean { //checa linha 2
        if(!l.get(1)?.textContent.equals("#") || !l.get(4)?.textContent.equals("#") || !l.get(7)?.textContent.equals("#"))
            return (l.get(1)?.textContent.equals(l.get(4)?.textContent) && l.get(1)?.textContent.equals(l.get(7)?.textContent))
        else
            return false
    }

    fun coluna3Aux(): Boolean { //checa linha 2
        if(!l.get(2)?.textContent.equals("#") || !l.get(5)?.textContent.equals("#") || !l.get(8)?.textContent.equals("#"))
            return (l.get(2)?.textContent.equals(l.get(5)?.textContent) && l.get(2)?.textContent.equals(l.get(8)?.textContent))
        else
            return false
    }

    return coluna1Aux() || coluna2Aux() || coluna3Aux()
}

fun checaDiagonal(): Boolean{
    val l = document.getElementsByTagName("td")

    fun diagonal1Aux(): Boolean{
        if(!l.get(0)?.textContent.equals("#") || !l.get(4)?.textContent.equals("#") || !l.get(8)?.textContent.equals("#"))
            return (l.get(0)?.textContent.equals(l.get(4)?.textContent) && l.get(0)?.textContent.equals(l.get(8)?.textContent))
        else
            return false
    }

    fun diagonal2Aux(): Boolean{
        if(!l.get(6)?.textContent.equals("#") || !l.get(4)?.textContent.equals("#") || !l.get(2)?.textContent.equals("#"))
            return (l.get(6)?.textContent.equals(l.get(4)?.textContent) && l.get(6)?.textContent.equals(l.get(2)?.textContent))
        else
            return false
    }

    return diagonal1Aux() || diagonal2Aux()
}

fun checa(): Boolean = checaLinhas() || checaColuna() || checaDiagonal() || tabuleiroCheio()

fun checaVitoria() = checaLinhas() || checaColuna() || checaDiagonal()

fun main() {

}