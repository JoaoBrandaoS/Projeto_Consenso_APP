getUserId();
function getUserId() {
    console.log(localStorage.getItem("token"));
    return localStorage.getItem("token");
}

function logout() {
    try {
      localStorage.removeItem("token");
    } catch (error) {
      console.error("Erro ao limpar o token: " + error);
    }
}