var today = new Date();
today.setMinutes(0);
today.setHours(0);
today = today.toISOString().split('T')[0];
document.getElementById("dataInput").setAttribute('min', today);