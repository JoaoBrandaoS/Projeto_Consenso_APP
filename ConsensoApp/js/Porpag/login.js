let loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", async (event) => {
  event.preventDefault();

  let email = document.getElementById("emailLogin").value;
  let senha = document.getElementById("senhaLogin").value;

  let emailDiv = document.getElementById("emailLoginDiv")
  let senhaDiv = document.getElementById("senhaLoginDiv")

  let emailV = document.getElementById("emailLogin");
  let senhaV = document.getElementById("senhaLogin");

  const p = document.createElement("div");
  p.classList.add("invalid-feedback")
  p.classList.add("mt-1")
  p.classList.add("fs-6")
  p.classList.add("text-start")
  p.setAttribute("id", "pEditavel")
  p.innerHTML = `campo obrigatório`
  let x = document.getElementById("pEditavel")
  if(x != null){
    x.remove();
  }
  
  if(email == null || email === ""){
    emailV.classList.add("is-invalid");
    emailV.classList.add("border-danger");
    emailDiv.appendChild(p);
  }
  else if(senha == null || senha === ""){
    senhaV.classList.add("is-invalid");
    senhaV.classList.add("border-danger");
    senhaDiv.appendChild(p);
  }
  else if(validarEmail(String(email)) == false){
    emailV.classList.add("is-invalid");
    emailV.classList.add("border-danger");
    p.innerHTML = `Email inválido`
    emailDiv.appendChild(p);
  }
  else if(validarEmail(String(email)) == true){
    try {
      let response = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          email: email,
          senha: senha
        }),
      });
      console.log(response);
      const content = await response.json();
      if (response.ok) {
        localStorage.setItem("token", content.idUsuario);
        if(content.tipoUsuario.idTipoUsuario === 1){
          window.location.href = "meusagendamentos.html";
        }
        else if(content.tipoUsuario.idTipoUsuario === 2){
          window.location.href = "prestadoragendamentos.html";
        }
      }
    } catch (error) {
      emailV.classList.add("is-invalid");
      emailV.classList.add("border-danger");
      senhaV.classList.add("is-invalid");
      senhaV.classList.add("border-danger");
      p.innerHTML = `Email ou senha não correspondentes`
      senhaDiv.appendChild(p);
    }
  }
});

function validarEmail(ev) {
  let re = /\S+@\S+\.\S+/
  return re.test(ev)
}