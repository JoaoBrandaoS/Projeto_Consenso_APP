const deleteButtons = document.querySelectorAll('.delete-button');
console.log(deleteButtons);
deleteButtons.forEach(button => {
    button.addEventListener('click', handleDeleteButtonClick);
});

function handleDeleteButtonClick(event) {
    const button = event.target;
    const serviceId = button.getAttribute('data-id');
    fetch(`http://localhost:8080/servico/` + serviceId, {
        method: 'DELETE'
    })
    .then(response => response.json())
    .then(data => {
        alert("deu tudo certo")
    })
    .catch(error => {
        console.error(error);
    });
}
