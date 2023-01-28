function funcaoPaginaCarregada() {
    const deleteButtons = document.querySelectorAll('.delete-button');
    deleteButtons.forEach(button => {
        button.addEventListener('click', event => {
            const idServico = event.currentTarget.getAttribute('data-id');
            console.log(idServico);
            fetch(`http://localhost:8080/servico/` + idServico, {
                method: 'DELETE'
            })
            .then(response => {
                console.log(response);
                if (response.ok) {
                    return alert
                } else {
                    throw new Error("Não foi possível deletar o serviço");
                }
            })
            .then(data => {
                alert("Serviço deletado com sucesso!");
                location.reload();
            })
            .catch(error => {
                console.log(error);
                alert(error.message);
            });
        });
    });
}
