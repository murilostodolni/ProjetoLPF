import kotlin.browser.*
import kotlin.coroutines.EmptyCoroutineContext.get
import org.w3c.dom.*
import org.w3c.dom.events.MouseEvent



fun mostra(){
    val a = get("oi")
    a.innerHTML += "pegou"
}

fun get(nome: String): HTMLElement{
    val e = document.getElementById(nome)
    return e as HTMLElement
}

@JsName("jogada")
fun jogada(pos: String){
    val canv = document.getElementById(pos) as HTMLCanvasElement
    val n = document.getElementById("numJogadas")
    val valor: Int = if(n!=null)n.textContent!!.toInt() else 0
    var img = document.getElementById("circulo") as HTMLImageElement

    if(valor % 2 == 0) {
        img = document.getElementById("x") as HTMLImageElement
    }

    val context = canv.getContext("2d") as CanvasRenderingContext2D

    //if(context == null) {
    context.drawImage(img, 0.0, 0.0, 100.0, 100.0)

    n?.innerHTML = (valor + 1).toString()
    //}
}




fun main(){
    val img = document.getElementById("imagem") as HTMLDivElement
    img.style.display = "none"
}