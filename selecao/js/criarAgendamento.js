const form = document.getElementById("formCadastAgeda");
form.addEventListener("submit", e => {
  e.preventDefault();
  const hora = document.getElementById("horaInput").value;
  const horaConvertida = hora.split(":").map(Number);
  console.log(horaConvertida)
  const data = document.getElementById("dataInput").value;
  const dataFormatada = new Date(data).toLocaleDateString('pt-BR', {timeZone: 'UTC'});
  console.log(dataFormatada)
  const idUsuario = localStorage.getItem("token");
  const idServico = document.getElementById("selServico").value;
  console.log(idServico);

  fetch("http://localhost:8080/agendamento", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        data: dataFormatada,
        hora: horaConvertida,
        usuario:{
            idUsuario: idUsuario
        },
        servicos:{
            idServico: idServico
        }
    })
  })
  .then(response => response.json())
  .then(data => {
    alert("Cadastro realizado")
    window.location.href = "meusagendamentos.html"
    console.log(data);
  })
  .catch(error => {
    console.log(error);
  });
});
