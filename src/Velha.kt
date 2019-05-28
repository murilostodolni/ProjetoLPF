import org.w3c.dom.*
import org.w3c.dom.events.MouseEvent
import kotlin.browser.*

@JsName("update2")
fun clicaTeste(id: String){
    println("2")

    val e = document.getElementById(id) as HTMLTableCellElement
    val rod = document.getElementById("rod") as HTMLElement
    val valor: Int = rod.textContent!!.toInt()

    val img = if(valor%2==0) "<img class=\"x\" src=\"img/x.jpg\"/>" else "<img class=\"x\" src=\"img/circulo.jpg\"/>"

    if(e.firstElementChild!!.className.equals("branco")) e.innerHTML = img

    attRodada(rod, valor)//atualiza o valor da rodada

    println(checaLinhas())
}

/*@JsName("update")
fun update(id: String): Unit{
    if(!checa()) {
        val e = document.getElementById(id) as HTMLTableCellElement
        val rod = document.getElementById("rod") as HTMLElement
        val valor: Int = rod.textContent!!.toInt()


        jogada(e.firstElementChild, valor)
        attRodada(rod, valor)//atualiza o valor da rodada

        println(checaLinhas())

        if(checaVitoria()) if(valor%2==0) fim("x") else fim("o")
    } else
       if(tabuleiroCheio()) window.alert("Empate!")

}*/

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


fun attRodada(rod: HTMLElement, valor: Int): Unit{
    rod.innerHTML= (valor+1).toString()
}

fun tabuleiroCheio(): Boolean{
    val l = document.getElementsByTagName("td")
    l.asList().forEach { obj ->
        if(obj.firstElementChild?.className.equals("branco")) return false
    }
    return true
}

fun checaLinhas(): Boolean{
    val l = document.getElementsByTagName("td")

    fun linha1Aux(): Boolean { //checa linha 1
        if(!l.get(0)?.firstElementChild?.className.equals("branco") || !l.get(1)?.firstElementChild?.className.equals("branco")
                || !l.get(2)?.firstElementChild?.className.equals("branco"))
            return (l.get(0)?.firstElementChild?.className.equals(l.get(1)?.firstElementChild?.className) && l.get(0)?.firstElementChild?.className.equals(l.get(2)?.firstElementChild?.className))
        else
            return false
    }

    fun linha2Aux(): Boolean { //checa linha 2
        if(!l.get(3)?.firstElementChild?.className.equals("branco") || !l.get(4)?.firstElementChild?.className.equals("branco")
                || !l.get(5)?.firstElementChild?.className.equals("branco"))
            return (l.get(3)?.firstElementChild?.className.equals(l.get(4)?.firstElementChild?.className) && l.get(3)?.firstElementChild?.className.equals(l.get(5)?.firstElementChild?.className))
        else
            return false
    }

    fun linha3Aux(): Boolean { //checa linha 3
        if(!l.get(6)?.firstElementChild?.className.equals("branco") || !l.get(7)?.firstElementChild?.className.equals("branco")
                || !l.get(8)?.firstElementChild?.className.equals("branco"))
            return (l.get(6)?.firstElementChild?.className.equals(l.get(7)?.firstElementChild?.className) && l.get(6)?.firstElementChild?.className.equals(l.get(8)?.firstElementChild?.className))
        else
            return false
    }

    return linha1Aux() || linha2Aux() || linha3Aux()
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

fun checa(): Boolean = checaLinhas()

fun checaVitoria() = checaLinhas() || checaColuna() || checaDiagonal()

fun main() {

}