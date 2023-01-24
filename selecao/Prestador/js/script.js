var bordinha = document.querySelector("#bordinha");

if (window.innerWidth < 576) {
  bordinha.classList.remove("borda-nav");
} else {
  bordinha.classList.add("borda-nav");
}

window.addEventListener("resize", () => {
  if (window.innerWidth < 576) {
    bordinha.classList.remove("borda-nav");
  } else {
    bordinha.classList.add("borda-nav");
  }
});
