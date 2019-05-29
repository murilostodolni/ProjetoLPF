import org.w3c.dom.*
import kotlin.browser.*

fun rodadaElemento() = document.getElementById("rod") as HTMLElement

fun attRodada(rod: HTMLElement, valor: Int): Unit{
    rod.innerHTML= (valor+1).toString()
}

fun rodadaValor() = rodadaElemento().textContent!!.toInt()

fun img() =
        if(rodadaElemento().textContent!!.toInt()%2==0)
            "<img class=\"x\" src=\"img/x.jpg\"/>"
        else
            "<img class=\"circulo\" src=\"img/circulo.jpg\"/>"

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
        if(!l.get(0)?.firstElementChild?.className.equals("branco") || !l.get(3)?.firstElementChild?.className.equals("branco")
                || !l.get(6)?.firstElementChild?.className.equals("branco"))

            return (l.get(0)?.firstElementChild?.className.equals(l.get(3)?.firstElementChild?.className) && l.get(0)?.firstElementChild?.className.equals(l.get(6)?.firstElementChild?.className))
        else
            return false
    }

    fun coluna2Aux(): Boolean { //checa linha 2
        if(!l.get(1)?.firstElementChild?.className.equals("branco") || !l.get(4)?.firstElementChild?.className.equals("branco")
                || !l.get(7)?.firstElementChild?.className.equals("branco"))

            return (l.get(1)?.firstElementChild?.className.equals(l.get(4)?.firstElementChild?.className) && l.get(1)?.firstElementChild?.className.equals(l.get(7)?.firstElementChild?.className))
        else
            return false
    }

    fun coluna3Aux(): Boolean { //checa linha 2
        if(!l.get(2)?.firstElementChild?.className.equals("branco") || !l.get(5)?.firstElementChild?.className.equals("branco") || !l.get(8)?.firstElementChild?.className.equals("branco"))
            return (l.get(2)?.firstElementChild?.className.equals(l.get(5)?.firstElementChild?.className) && l.get(2)?.firstElementChild?.className.equals(l.get(8)?.firstElementChild?.className))
        else
            return false
    }

    return coluna1Aux() || coluna2Aux() || coluna3Aux()
}

fun checaDiagonal(): Boolean{
    val l = document.getElementsByTagName("td")

    fun diagonal1Aux(): Boolean{
        if(!l.get(0)?.firstElementChild?.className.equals("branco") || !l.get(4)?.firstElementChild?.className.equals("branco")
                || !l.get(8)?.firstElementChild?.className.equals("branco"))
            return (l.get(0)?.firstElementChild?.className.equals(l.get(4)?.firstElementChild?.className) && l.get(0)?.firstElementChild?.className.equals(l.get(8)?.firstElementChild?.className))
        else
            return false
    }

    fun diagonal2Aux(): Boolean{
        if(!l.get(6)?.firstElementChild?.className.equals("branco") || !l.get(4)?.firstElementChild?.className.equals("branco")
                || !l.get(2)?.firstElementChild?.className.equals("branco"))
            return (l.get(6)?.firstElementChild?.className.equals(l.get(4)?.firstElementChild?.className) && l.get(6)?.firstElementChild?.className.equals(l.get(2)?.firstElementChild?.className))
        else
            return false
    }

    return diagonal1Aux() || diagonal2Aux()
}

fun tabuleiroCheio(): Boolean{
    val l = document.getElementsByTagName("td")
    l.asList().forEach { obj ->
        if(obj.firstElementChild?.className.equals("branco")) return false
    }
    return true
}

fun checa(): Boolean = vitoria() || tabuleiroCheio()

fun vitoria() = checaLinhas() || checaColuna() || checaDiagonal()

@JsName("reinicia") //prepara o jogo para ser recomecado
fun reinicia(): Unit{
    val e = document.getElementsByTagName("td")
    e.asList().forEach { obj ->
        obj.innerHTML = "<img class=\"branco\"/>"
    }
    document.getElementById("rod")?.innerHTML = 0.toString()
}

fun fim(): Unit {

    if (vitoria())
        if (rodadaValor()%2==0) window.alert("Jogador X venceu!") else window.alert("Jogador O venceu!")
    else if(tabuleiroCheio()) window.alert("Empate!"); reinicia()

}

@JsName("update")
fun update(id: String){
    if(!checa()) {
        val e = document.getElementById(id) as HTMLTableCellElement

        if (e.firstElementChild?.className.equals("branco")) e.innerHTML = img()

        attRodada(rodadaElemento(), rodadaValor())//atualiza o valor da rodada

        fim()
    }

}

fun main() {

}