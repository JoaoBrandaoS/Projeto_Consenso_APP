let form = document.getElementById("cadastrarServico");
form.addEventListener("submit", async (event) => {
  event.preventDefault();

  let nome = document.getElementById("nomeServico").value;
  let descricao = document.getElementById("descricaoServico").value;
  let idUsuario = getUserId();

  const p = document.createElement("div");
  p.classList.add("invalid-feedback");
  p.classList.add("mt-1");
  p.classList.add("fs-6");
  p.classList.add("text-start");
  p.setAttribute("id", "pEditavel");
  p.innerHTML = `campo obrigatório`;

  let nomeV = document.getElementById("nomeServico");
  let descricaoV = document.getElementById("descricaoServico")

  let nomeDiv = document.getElementById("nomeDiv");
  let descricaoDiv = document.getElementById('descricaoDiv');


  let x = document.getElementById("pEditavel");
  if(x != null){
    x.remove();
    descricaoV.classList.remove("is-invalid");
    descricaoV.classList.remove("border-danger");
    nomeV.classList.remove("is-invalid");
    nomeV.classList.remove("border-danger");
  }

  if(nome === "" || nome == null){
    nomeV.classList.add("is-invalid");
    nomeV.classList.add("border-danger");
    nomeDiv.appendChild(p);
  }else if(descricao === "" || descricao == null){
    descricaoV.classList.add("is-invalid");
    descricaoV.classList.add("border-danger");
    descricaoDiv.appendChild(p);
  }else{
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
      else if(response.ok){
        alert("Cadastro realizado com sucesso!");
        window.location.href = "Servicos.html"
      }
    } catch (error) {
      console.error(error);
      alert("Erro ao realizar cadastro, tente novamente mais tarde.")
    }
  }
});

function getUserId() {
  return localStorage.getItem("token");
}