function atualizarServ(){
    const updateButtons = document.querySelectorAll('.update-button');
    updateButtons.forEach(button => {
        button.addEventListener('click', event => {
            const idServico = event.currentTarget.getAttribute('data-id');
            localStorage.setItem("idServico", idServico);
            window.location.href = "editaragendamentoPrestador.html";
        });
    });
};
