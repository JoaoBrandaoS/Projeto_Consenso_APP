getUserId();
function getUserId() {
    console.log(localStorage.getItem("token"));
    return localStorage.getItem("token");
}