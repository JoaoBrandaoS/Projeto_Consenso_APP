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
    const content = await response.json();
    if (response.ok) {
      let token = await response.text();
      localStorage.setItem("token", token);
    } else {
      alert("Usuário ou senha inválidos");
    }
  } catch (error) {
    console.error(error);
  }
});
