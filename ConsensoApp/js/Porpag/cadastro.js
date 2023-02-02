let form = document.getElementById("cadastroForm");
form.addEventListener("submit", async (event) => {
  event.preventDefault();

  let email = document.getElementById("email").value;
  let senha = document.getElementById("senha").value;
  let nome = document.getElementById("nome").value;
  let sobrenome = document.getElementById("sobrenome").value;

  validarEntradas(nome, email, senha, sobrenome);
});


async function validarEntradas(n, e, s, sn) {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
    const tipouser = document.getElementById("tipoUser").value;
    const nome = document.getElementById("nome").value;
    const sobrenome = document.getElementById("sobrenome").value;

    const emailV = document.getElementById("email");
    const senhaV =  document.getElementById("senha");
    const nomeV = document.getElementById("nome");
    const sobrenomeV = document.getElementById("sobrenome");

    emailV.className = "form-control border-secondary fs-4 border-3 rounded-3";
    senhaV.className = "form-control border-secondary fs-4 border-3 rounded-3";
    nomeV.className = "form-control border-secondary fs-4 border-3 rounded-3";
    sobrenomeV.className = "form-control border-secondary fs-4 border-3 rounded-3";

    let emailDiv = document.getElementById("emailDiv");
    let senhaDiv = document.getElementById("senhaDiv");
    let sobrenomeDiv = document.getElementById("sobrenomeDiv");
    let nomeDiv = document.getElementById("nomeDiv");

    const p = document.createElement("div");
    p.classList.add("invalid-feedback")
    p.classList.add("mt-1")
    p.classList.add("fs-6")
    p.setAttribute("id", "pEditavel")
    p.innerHTML = `campo obrigatório`
    let x = document.getElementById("pEditavel")
    if(x != null){
      x.remove();
    }

    const nomeValue = String(n);
    const emailValue = String(e);
    const senhaValue = String(s);
    const sobrenomeValue = String(sn);

    if (nomeValue === "" || nomeValue == null) {
      nomeV.classList.add("is-invalid");
      nomeV.classList.add("border-danger");
      nomeDiv.appendChild(p);
    } else if(sobrenomeValue === "" || sobrenomeValue == null){
      sobrenomeV.classList.add("is-invalid");
      sobrenomeV.classList.add("border-danger");
      sobrenomeDiv.appendChild(p)
    }
    else if (emailValue === "" || emailValue == null) {
      emailV.classList.add("is-invalid");
      emailV.classList.add("border-danger");
      emailDiv.appendChild(p)
    } else if (validarEmail(emailValue) === false) {
      emailV.classList.add("is-invalid");
      emailV.classList.add("border-danger");
      p.innerText = `Email inválido`
      emailDiv.appendChild(p)
    } else if (senhaValue === "" || senhaValue == null) {
      senhaV.classList.add("is-invalid");
      senhaV.classList.add("border-danger");
      senhaDiv.appendChild(p);
    } else if (senhaValue.length < 8) {
      senhaV.classList.add("is-invalid");
      senhaV.classList.add("border-danger");
      console.log(senhaValue.length)
      p.innerHTML = `Mín 8`
      senhaDiv.appendChild(p);
    } else {
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
              $('#modalCadastroSucesso').modal('show');
              localStorage.setItem("idUsuario", data.idUsuario);
            }
            else if(tipouser == 2){
              let data = await response.json();
              $('#modalCadastroSucesso').modal('show');
              localStorage.setItem("idUsuario", data.idUsuario);
            }
        }
        else if(response.status == 400){
          emailV.classList.add("is-invalid");
          emailV.classList.add("border-danger");
          p.innerHTML = `Email em uso`
          emailDiv.appendChild(p)
        }
      } catch (error) {
        console.log(error)
      }
    }
}

function validarEmail(ev) {
    let re = /\S+@\S+\.\S+/
    return re.test(ev)
}