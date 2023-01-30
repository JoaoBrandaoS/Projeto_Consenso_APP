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