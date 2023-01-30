function deletarCarregado(){
    const buttons = document.querySelectorAll('.button-delete');
    console.log(buttons)
    buttons.forEach(button => {
      button.addEventListener('click', event => {
        const id = event.currentTarget.getAttribute('data-id');
        console.log(id)
        fetch("http://localhost:8080/agendamento/" + id, {
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
          console.error('Erro ao deletar agendamento:', error);
        });
      });
    });    
}
