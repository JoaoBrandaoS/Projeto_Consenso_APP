
document.addEventListener("DOMContentLoaded", function() {
    let idServico = localStorage.getItem("idServico");
    fetch(`http://localhost:8080/agendamento/` + idServico, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)
        let nome = data.servicos.nome;
        console.log(nome)
        let dataD = data.data;
        console.log(dataD)
        let div = document.getElementById("alterarAgendamentoCliente");
        div.innerHTML = `
        <div class="row justify-content-center">
            <div class="col-xl-5 col-lg-6 col-md-8 col">
                <div class="m-2 text-start text-secondary fs-4">
                    <label for="selServico">Selecione o serviço:</label>
                </div>
                <div class="form-label border-secondary border-2">
                    <select class="form-select border-secondary fs-3 border-3 rounded-3" id="selServico" aria-label="Floating label select example">
                        
                    </select>
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-xl-3 col-lg-4 col-md-5 col">
                <div class="m-2 text-start text-secondary fs-4">
                    <label for="data">Data:</label>
                </div>
                <div class="form-label  border-secondary ">
                  <input type="date" class="form-control border-secondary border-3 fs-3 rounded-3" placeholder="${dataD}" id="dataInput">
                </div>
            </div>
            <div class="col-xl-2 col-lg-2 col-md-3 col">
                <div class="m-2 text-start text-secondary fs-4">
                    <label for="data">Hora:</label>
                </div>
                <div class="form-label  border-secondar">
                <input type="time" id="horaInput" class="form-control border-secondary border-3 fs-3 rounded-3" min="08:00" max="18:00" required list="horarios">
                    <datalist id="horarios">
                        <option value="08:00">
                            <option value="08:30">
                            <option value="09:00">
                            <option value="09:30">
                            <option value="09:30">
                            <option value="10:00">
                            <option value="10:30">
                            <option value="11:00">
                            <option value="11:30">
                            <option value="12:00">
                            <option value="12:30">
                            <option value="13:00">
                            <option value="13:30">
                            <option value="14:00">
                            <option value="14:30">
                            <option value="15:00">
                            <option value="15:30">
                            <option value="16:00">
                            <option value="16:30">
                            <option value="17:00">
                            <option value="17:30">
                            <option value="18:00">
                    </datalist>
                </div>
            </div>
        </div>
        <div class="row justify-content-center mt-5">
            <div class="col-xl-5 col-lg-6 col-md-8 col">
                <div class="d-grid gap-2">
                    <button class="btn btn-primary fs-5 border border-secondary border-2 rounded-3 yourownclass botaozinho fs-3" id="agendar" type="submit">SALVAR</button>  
                </div>
            </div>
        </div>
        `;
        var today = new Date();
        today.setMinutes(0);
        today.setHours(0);
        today = today.toISOString().split('T')[0];
        document.getElementById("dataInput").setAttribute('min', today);
        carregarlista();

    })
    .catch(error => {
        console.log(error)
    });
})

const form = document.getElementById("alterarAgendamentoCliente");

form.addEventListener("submit", function(event) {
    event.preventDefault();
    let idServico = localStorage.getItem("idServico");
    const hora = document.getElementById("horaInput").value;
    const data = document.getElementById("dataInput").value;
    const dataFormatada = new Date(data).toLocaleDateString('pt-BR');
    console.log(dataFormatada);
    console.log(hora)

    fetch(`http://localhost:8080/agendamento/` + idServico, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            hora: hora,
            data: dataFormatada
        })
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        alert("Serviço alterado com sucesso");
        localStorage.getItem("idServico", null);
        window.location.href = "prestadoragendamentos.html"
    })
    .catch(error => {
        console.log(error);
    });
});

function carregarlista() {
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
    }

