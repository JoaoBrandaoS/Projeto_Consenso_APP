const email = document.getElementById("email");
const senha = document.getElementById("senha");
const tipoUser = document.getElementById("tipoUser");

console.log(email.value)
addEventListener('submit', (e) => {
    e.cadastro(email, senha);
});

function cadastro(email, senha){
    (async () => {
        const respostaLista = await fetch("http://localhost:8080/usuario", {
            method: "POST",
            body: JSON.stringify({
                email: email,
                senha: senha
            }),
            headers:{
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        const content = await respostaLista.json();
    })
}
