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
            });
        })
        .catch(error => {
            console.log(error);
        })
});


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

    const p = document.createElement("div");
    p.classList.add("invalid-feedback")
    p.classList.add("mt-1")
    p.classList.add("fs-6")
    p.setAttribute("id", "pEditavel")
    p.innerHTML = `campo obrigatório`
    let x = document.getElementById("pEditavel")
    if(x != null){
      x.remove();
    }

    let horaDiv = document.getElementById("agendarHora");
    let dataDiv = document.getElementById("agendarData");

    let dataV = document.getElementById("dataInput");
    let horaV = document.getElementById("dataInput");
    
    if(dataFormatada === "Invalid Date"){
        dataV.classList.add("is-invalid");
        dataV.classList.add("border-danger");
        dataDiv.classList.add("text-start")
        dataDiv.appendChild(p);
    }else if(horaConvertida === "" || horaConvertida == null){
        horaV.classList.add("is-invalid");
        horaV.classList.add("border-danger")
        horaDiv.appendChild(p);
    }else{
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
            alert("Agendamento realizado!")
            window.location.href = "meusagendamentos.html"
            console.log(data);
        })
        .catch(error => {
            console.log(error);
        });
    }
    });
