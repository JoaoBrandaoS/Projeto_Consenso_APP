document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/servico')
        .then(response => response.json())
        .then(servicos => {
            console.log(servicos)
            servicos.forEach(servico => {
                const option = document.createElement('option');
                option.value = servico.idServico;
                option.innerText = servico.nome;
                let b = document.querySelector('#selServico')
                console.log(b)
                b.appendChild(option);
                criarAgendamento();
            });
        })
        .catch(error => {
            console.log(error);
        })
});

function criarAgendamento(){
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
}