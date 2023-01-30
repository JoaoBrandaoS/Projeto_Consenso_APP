let loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", async (event) => {
  event.preventDefault();

  let email = document.getElementById("emailLogin").value;
  let senha = document.getElementById("senhaLogin").value;

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
    } else {
      alert("Usuário ou senha inválidos");
    }
  } catch (error) {
    console.error(error);
  }
});