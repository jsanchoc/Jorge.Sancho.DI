let mazo = [];
const palos = ["T", "D", "C", "P"];
const especiales = ["1", "J", "Q", "K"];

let puntosJugador = 0,
  puntosBanca = 0;

const btnPedir = document.querySelector("#btnPedir");
const btnDetener = document.querySelector("#btnDetener");
const btnNuevo = document.querySelector("#btnNuevo");

const divCartasJugador = document.querySelector("#jugador-cartas");
const divCartasBanca = document.querySelector("#banca-cartas");
const puntosHTML = document.querySelectorAll("small");

const crearMazo = () => {
  mazo = [];
  for (let i = 2; i <= 10; i++) {
    for (let palo of palos) {
      mazo.push(i + palo);
    }
  }
  for (let palo of palos) {
    for (let esp of especiales) {
      mazo.push(esp + palo);
    }
  }
  mazo = _.shuffle(mazo);
};

const valorCarta = (carta) => {
  const valor = carta.substring(0, carta.length - 1);
  return isNaN(valor) ? (valor === "A" ? 11 : 10) : valor * 1;
};

const turnoBanca = (puntosMinimos) => {
  do {
    const carta = mazo.pop();
    puntosBanca += valorCarta(carta);
    puntosHTML[1].innerText = puntosBanca;

    const imgCarta = document.createElement("img");
    imgCarta.src = `images/${carta}.png`;
    imgCarta.classList.add("carta");
    divCartasBanca.append(imgCarta);

    if (puntosMinimos > 21) break;
  } while (puntosBanca < puntosMinimos && puntosMinimos <= 21);

  setTimeout(() => {
    if (puntosBanca === puntosMinimos) alert("Empate técnico");
    else if (puntosMinimos > 21) alert("La Banca gana");
    else if (puntosBanca > 21) alert("¡Ganaste! La banca se pasó");
    else alert("La Banca gana");
  }, 150);
};

btnPedir.addEventListener("click", () => {
  const carta = mazo.pop();
  puntosJugador += valorCarta(carta);
  puntosHTML[0].innerText = puntosJugador;

  const imgCarta = document.createElement("img");
  imgCarta.src = `images/${carta}.png`;
  imgCarta.classList.add("carta");
  divCartasJugador.append(imgCarta);

  if (puntosJugador > 21) {
    btnPedir.disabled = true;
    btnDetener.disabled = true;
    turnoBanca(puntosJugador);
  } else if (puntosJugador === 21) {
    btnPedir.disabled = true;
    btnDetener.disabled = true;
    turnoBanca(puntosJugador);
  }
});

btnDetener.addEventListener("click", () => {
  btnPedir.disabled = true;
  btnDetener.disabled = true;
  turnoBanca(puntosJugador);
});

btnNuevo.addEventListener("click", () => {
  console.clear();
  crearMazo();
  puntosJugador = 0;
  puntosBanca = 0;
  puntosHTML[0].innerText = 0;
  puntosHTML[1].innerText = 0;
  divCartasJugador.innerHTML = "";
  divCartasBanca.innerHTML = "";
  btnPedir.disabled = false;
  btnDetener.disabled = false;
});

crearMazo();
