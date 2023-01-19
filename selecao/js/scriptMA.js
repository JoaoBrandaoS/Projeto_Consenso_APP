var bordinha = document.querySelector("#meusagendamentos");

window.addEventListener("resize", () => {
  if (window.innerWidth < 600) {
    bordinha.classList.remove("borda-nav");
  } else {
    bordinha.classList.add("borda-nav");
  }
});
