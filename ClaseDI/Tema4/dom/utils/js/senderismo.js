const nombreRuta = document.querySelector("#input-nombre-ruta");
const distanciaRuta = document.querySelector("#input-distancia");
const dificultadRuta = document.querySelector("#select-dificultad");
const btnAñadir = document.querySelector("#btn-añadir");
const listaRutas = document.querySelector("#listaRutas");

btnAñadir.addEventListener("click", () => {
  const nombre = nombreRuta.value;
  const distancia = distanciaRuta.value;
  const dificultad = dificultadRuta.value;

  if (nombre.trim() === "" || distancia <= 0) {
    Swal.fire({
      icon: "error",
      title: "Oops...",
      text: "Faltan datos!",
    });
    return;
  }

  listaRutas.innerHTML += `
        <li class="list-group-item d-flex justify-content-between align-items-center">
            ${nombre} - ${distancia} km (${dificultad})
            <button class="btn btn-danger btn-sm" onclick="this.parentElement.remove()">Eliminar</button>
        </li>
    `;

  nombreRuta.value = "";
  distanciaRuta.value = "";
  dificultadRuta.value = "Fácil";
});
