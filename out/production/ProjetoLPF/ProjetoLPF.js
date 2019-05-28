if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'ProjetoLPF'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'ProjetoLPF'.");
}
var ProjetoLPF = function (_, Kotlin) {
  'use strict';
  var throwCCE = Kotlin.throwCCE;
  var ensureNotNull = Kotlin.ensureNotNull;
  var toInt = Kotlin.kotlin.text.toInt_pdl1vz$;
  function mostra() {
    var a = get('oi');
    a.innerHTML = a.innerHTML + 'pegou';
  }
  function get(nome) {
    var tmp$;
    var e = document.getElementById(nome);
    return Kotlin.isType(tmp$ = e, HTMLElement) ? tmp$ : throwCCE();
  }
  function jogada(pos) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2;
    var canv = Kotlin.isType(tmp$ = document.getElementById(pos), HTMLCanvasElement) ? tmp$ : throwCCE();
    var n = document.getElementById('numJogadas');
    var valor = n != null ? toInt(ensureNotNull(n.textContent)) : 0;
    var img = Kotlin.isType(tmp$_0 = document.getElementById('circulo'), HTMLImageElement) ? tmp$_0 : throwCCE();
    if (valor % 2 === 0) {
      img = Kotlin.isType(tmp$_1 = document.getElementById('x'), HTMLImageElement) ? tmp$_1 : throwCCE();
    }
    var context = Kotlin.isType(tmp$_2 = canv.getContext('2d'), CanvasRenderingContext2D) ? tmp$_2 : throwCCE();
    context.drawImage(img, 0.0, 0.0, 100.0, 100.0);
    n != null ? (n.innerHTML = (valor + 1 | 0).toString()) : null;
  }
  function main() {
    var tmp$;
    var img = Kotlin.isType(tmp$ = document.getElementById('imagem'), HTMLDivElement) ? tmp$ : throwCCE();
    img.style.display = 'none';
  }
  _.mostra = mostra;
  _.get_61zpoe$ = get;
  _.jogada = jogada;
  _.main = main;
  main();
  Kotlin.defineModule('ProjetoLPF', _);
  return _;
}(typeof ProjetoLPF === 'undefined' ? {} : ProjetoLPF, kotlin);
