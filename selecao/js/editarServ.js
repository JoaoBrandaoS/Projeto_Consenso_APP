const idServico = localStorage.getItem("idServico");

fetch(`http://localhost:8080/servico/` + idServico, {
    method: 'PUT',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        // informações aqui
    })
})
.then(response => response.json())
.then(data => {
    console.log(data);
})
.catch(error => {
    console.log(error);
});