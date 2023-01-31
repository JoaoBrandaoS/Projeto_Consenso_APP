let form = document.getElementById("cadastroForm");
form.addEventListener("submit", async (event) => {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const tipouser = document.getElementById("tipoUser").value;
  const nome = document.getElementById("nome").value;
  const sobrenome = document.getElementById("sobrenome").value;

  try {
    const response = await fetch("http://localhost:8080/usuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      },
      body: JSON.stringify({
        nome: nome,
        sobrenome: sobrenome,
        email: email,
        senha: senha,
        tipoUsuario: {
            idTipoUsuario: tipouser
        }
      }),
    });
    console.log(response);

    if (response.status == 201) {
        if(tipouser == 1){
          let data = await response.json();
          localStorage.setItem("idUsuario", data.idUsuario);
          alert("Cadastro completo " + nome);
          window.location.href = "../login.html";
        }
        else if(tipouser == 2){
          let data = await response.json();
          localStorage.setItem("idUsuario", data.idUsuario);
          alert("Cadastro completo " + nome);
          window.location.href = "../login.html";
        }
    }
  } catch (error) {
    console.error(error);
  }
});
