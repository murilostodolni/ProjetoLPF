if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'ProjetoLPF'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'ProjetoLPF'.");
}
var ProjetoLPF = function (_, Kotlin) {
  'use strict';
  var throwCCE = Kotlin.throwCCE;
  var ensureNotNull = Kotlin.ensureNotNull;
  var equals = Kotlin.equals;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var equals_0 = Kotlin.kotlin.text.equals_igcy3c$;
  var toInt = Kotlin.kotlin.text.toInt_pdl1vz$;
  var asList = Kotlin.org.w3c.dom.asList_kt9thq$;
  function clicaTeste(id) {
    var tmp$;
    var e = Kotlin.isType(tmp$ = document.getElementById(id), HTMLTableCellElement) ? tmp$ : throwCCE();
    if (equals(ensureNotNull(e.firstElementChild).className, 'hashtag'))
      e.innerHTML = '<img class="x" src="img/x.jpg"/>';
    println(checaLinhas());
  }
  function testeCheca() {
    var tmp$, tmp$_0;
    var l = document.getElementsByTagName('td');
    println('pula');
    println(equals_0((tmp$_0 = (tmp$ = l[0]) != null ? tmp$.firstElementChild : null) != null ? tmp$_0.className : null, 'x'));
  }
  function update(id) {
    var tmp$, tmp$_0;
    if (!checa()) {
      var e = Kotlin.isType(tmp$ = document.getElementById(id), HTMLTableCellElement) ? tmp$ : throwCCE();
      var rod = Kotlin.isType(tmp$_0 = document.getElementById('rod'), HTMLElement) ? tmp$_0 : throwCCE();
      var valor = toInt(ensureNotNull(rod.textContent));
      jogada(e, valor);
      attRodada(rod, valor);
      if (checaVitoria())
        if (valor % 2 === 0)
          fim('x');
        else
          fim('o');
    }
     else if (tabuleiroCheio())
      window.alert('Empate!');
  }
  function reinicia() {
    var tmp$;
    var e = document.getElementsByTagName('td');
    var tmp$_0;
    tmp$_0 = asList(e).iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      element.innerHTML = '#';
    }
    (tmp$ = document.getElementById('rod')) != null ? (tmp$.innerHTML = (0).toString()) : null;
  }
  function fim(c) {
    window.alert('Terminou, venceu o jogador ' + c + ' ');
    reinicia();
  }
  function jogada(elem, rodada) {
    if (equals_0(elem.textContent, '#'))
      if (rodada % 2 === 0)
        elem.innerHTML = 'x';
      else
        elem.innerHTML = 'o';
  }
  function attRodada(rod, valor) {
    rod.innerHTML = (valor + 1 | 0).toString();
  }
  function tabuleiroCheio() {
    var tmp$;
    var l = document.getElementsByTagName('td');
    var tmp$_0;
    tmp$_0 = asList(l).iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      if (equals_0(element.textContent, '#'))
        return false;
    }
    tmp$ = asList(l).iterator();
    while (tmp$.hasNext()) {
      var e = tmp$.next();
      println(e.textContent);
    }
    return true;
  }
  function checaLinhas$linha1Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5, tmp$_6, tmp$_7, tmp$_8, tmp$_9, tmp$_10, tmp$_11, tmp$_12;
      var tmp$_13 = !equals_0((tmp$_0 = (tmp$ = closure$l[0]) != null ? tmp$.firstElementChild : null) != null ? tmp$_0.className : null, 'hashtag');
      if (!tmp$_13) {
        tmp$_13 = !equals_0((tmp$_2 = (tmp$_1 = closure$l[1]) != null ? tmp$_1.firstElementChild : null) != null ? tmp$_2.className : null, 'hashtag');
      }
      var tmp$_14 = tmp$_13;
      if (!tmp$_14) {
        tmp$_14 = !equals_0((tmp$_4 = (tmp$_3 = closure$l[2]) != null ? tmp$_3.firstElementChild : null) != null ? tmp$_4.className : null, 'hashtag');
      }
      if (tmp$_14) {
        return equals_0((tmp$_6 = (tmp$_5 = closure$l[0]) != null ? tmp$_5.firstElementChild : null) != null ? tmp$_6.className : null, (tmp$_8 = (tmp$_7 = closure$l[1]) != null ? tmp$_7.firstElementChild : null) != null ? tmp$_8.className : null) ? equals_0((tmp$_10 = (tmp$_9 = closure$l[0]) != null ? tmp$_9.firstElementChild : null) != null ? tmp$_10.className : null, (tmp$_12 = (tmp$_11 = closure$l[2]) != null ? tmp$_11.firstElementChild : null) != null ? tmp$_12.className : null) : false;
      }
       else
        return false;
    };
  }
  function checaLinhas$linha2Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[3]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[4]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[5]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[3]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[4]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[3]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[5]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaLinhas$linha3Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[6]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[7]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[8]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[6]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[7]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[6]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[8]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaLinhas() {
    var l = document.getElementsByTagName('td');
    var linha1Aux = checaLinhas$linha1Aux(l);
    var linha2Aux = checaLinhas$linha2Aux(l);
    var linha3Aux = checaLinhas$linha3Aux(l);
    return linha1Aux();
  }
  function checaColuna$coluna1Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[0]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[3]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[6]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[0]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[3]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[0]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[6]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaColuna$coluna2Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[1]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[4]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[7]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[1]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[4]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[1]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[7]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaColuna$coluna3Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[2]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[5]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[8]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[2]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[5]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[2]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[8]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaColuna() {
    var l = document.getElementsByTagName('td');
    var coluna1Aux = checaColuna$coluna1Aux(l);
    var coluna2Aux = checaColuna$coluna2Aux(l);
    var coluna3Aux = checaColuna$coluna3Aux(l);
    return coluna1Aux() || coluna2Aux() || coluna3Aux();
  }
  function checaDiagonal$diagonal1Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[0]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[4]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[8]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[0]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[4]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[0]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[8]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaDiagonal$diagonal2Aux(closure$l) {
    return function () {
      var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5;
      var tmp$_6 = !equals_0((tmp$ = closure$l[6]) != null ? tmp$.textContent : null, '#');
      if (!tmp$_6) {
        tmp$_6 = !equals_0((tmp$_0 = closure$l[4]) != null ? tmp$_0.textContent : null, '#');
      }
      var tmp$_7 = tmp$_6;
      if (!tmp$_7) {
        tmp$_7 = !equals_0((tmp$_1 = closure$l[2]) != null ? tmp$_1.textContent : null, '#');
      }
      if (tmp$_7) {
        return equals_0((tmp$_2 = closure$l[6]) != null ? tmp$_2.textContent : null, (tmp$_3 = closure$l[4]) != null ? tmp$_3.textContent : null) ? equals_0((tmp$_4 = closure$l[6]) != null ? tmp$_4.textContent : null, (tmp$_5 = closure$l[2]) != null ? tmp$_5.textContent : null) : false;
      }
       else
        return false;
    };
  }
  function checaDiagonal() {
    var l = document.getElementsByTagName('td');
    var diagonal1Aux = checaDiagonal$diagonal1Aux(l);
    var diagonal2Aux = checaDiagonal$diagonal2Aux(l);
    return diagonal1Aux() || diagonal2Aux();
  }
  function checa() {
    return checaLinhas() || checaColuna() || checaDiagonal() || tabuleiroCheio();
  }
  function checaVitoria() {
    return checaLinhas() || checaColuna() || checaDiagonal();
  }
  function main() {
  }
  _.clicaTeste = clicaTeste;
  _.testeCheca = testeCheca;
  _.update = update;
  _.reinicia = reinicia;
  _.fim_61zpoe$ = fim;
  _.jogada_906ova$ = jogada;
  _.attRodada_906ova$ = attRodada;
  _.tabuleiroCheio = tabuleiroCheio;
  _.checaLinhas = checaLinhas;
  _.checaColuna = checaColuna;
  _.checaDiagonal = checaDiagonal;
  _.checa = checa;
  _.checaVitoria = checaVitoria;
  _.main = main;
  main();
  Kotlin.defineModule('ProjetoLPF', _);
  return _;
}(typeof ProjetoLPF === 'undefined' ? {} : ProjetoLPF, kotlin);
