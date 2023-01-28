document.addEventListener("DOMContentLoaded", function() {
    let idUser = localStorage.getItem("token");
    fetch('http://localhost:8080/servico/usuario/' + idUser)
    .then(response => response.json())
    .then(data => {
        data.forEach(servico => {
        const div = document.createElement('div');
        div.classList.add('mb-3');
        div.innerHTML = 
        `<div class="mb-3">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-lg-6 col-md-8 col azulzinho border-3 redondinho">
                    <div class="mt-2 mb-2 row">
                        <div class="col-9 text-start fs-4">
                            <label for="" class="color-light col textolabel">${servico.nome}</label>
                        </div>
                        <div class="ms-4 col-1 mt-2">
                            <a type="button" class=" btn-lab" href="editaragendamento.html">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
                                </svg>
                            </a>
                        </div>
                        <div class="col-1 mt-2">
                            <button type="button" class="delete-button btn-lab" data-id="${servico.idServico}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                    <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>`
        const criar = document.getElementById("servicosLista");
        criar.appendChild(div);
        });
    })
    .catch(error => {
        console.error('Erro ao obter dados:', error);
    });

})


