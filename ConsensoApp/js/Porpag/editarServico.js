const idServico = localStorage.getItem("idServico");
document.addEventListener("DOMContentLoaded", function() {
    fetch(`http://localhost:8080/servico/${idServico}`, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        let nome = data.nome;
        let descricao = data.descricao;
        let divTeste = document.getElementById("editarServicosPresta");
        divTeste.innerHTML = `
            <div class="d-flex fs-5">
                <label for="nomeServico ps-1">Nome:</label>
            </div>
            <div class="mt-4">
                <input type="text" class="form-control form-control-lg border-3 borderCor fs-5" id="nomeEditarServ" placeholder="${nome}">
            </div>
            <div class="d-flex mt-4 fs-5 ps-1">
                <label for="nomeServico ps-1">Descrição:</label>
            </div>
            <div class="mt-4 ">
                <textarea class="form-control form-control-lg border-3 borderCor fs-5" id="descricaoEditarServ" rows="4" placeholder="${descricao}"></textarea>
            </div>
            <div class="d-grid gap-2 col mt-5">
                <button class="btn btn-primary fs-5 border-3 borderCor botaoTexto" type="submit">SALVAR</button>
            </div>
        `;
    })
    .catch(error => {
        console.log(error)
    });
});


const form = document.getElementById("editarServicosPresta");

form.addEventListener("submit", function(event) {
    event.preventDefault();
    const nome = document.getElementById("nomeEditarServ").value;
    const descricao = document.getElementById("descricaoEditarServ").value;

    fetch(`http://localhost:8080/servico/` + idServico, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome,
            descricao: descricao
        })
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        alert("Serviço alterado com sucesso")
        window.location.href = "Servicos.html"
    })
    .catch(error => {
        console.log(error);
    });
});
