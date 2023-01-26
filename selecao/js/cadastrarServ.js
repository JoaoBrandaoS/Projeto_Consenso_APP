let form = document.getElementById("cadastrarServico");
form.addEventListener("submit", async (event) => {
  event.preventDefault();

  let nome = document.getElementById("nomeServico").value;
  let descricao = document.getElementById("descricao").value;
  let idUsuario = getUserId();

  try {
    let response = await fetch("http://localhost:8080/servico", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        nome: nome,
        descricao: descricao,
        usuario: {
            idUsuario: idUsuario
        }
      }),
    });

    if (!response.ok) {
      throw new Error(response.statusText);
    }
    alert("Cadastro realizado com sucesso!");
    window.location.href = "index.html"
  } catch (error) {
    console.error(error);
    alert("Erro ao realizar cadastro, tente novamente mais tarde.")
  }
});
function getUserId() {
  return localStorage.getItem("token");
}

