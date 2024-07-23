//  for menu
const menu = document.querySelector(".menu");
const hamMenuIcon = document.querySelector(".ham-menu-icon");
let i = true;
hamMenuIcon.addEventListener("click", (e) => {
    if (i) {
        menu.style.display = 'flex';
        e.target.classList.remove("bi-list"); //e.target = icon 
        e.target.classList.add("bi-x-lg");
        i = false;
    } else {
        e.target.classList.remove("bi-x-lg");
        e.target.classList.add("bi-list"); //e.target = icon 
        menu.style.display = 'none';
        i = true;
    }
});

    document.addEventListener('DOMContentLoaded', function() {
    const figures = document.querySelectorAll('.photo'); // Selectează toate elementele cu clasa 'photo'

    figures.forEach((figure) => {
    let lastRotateTime = 0; // Va stoca timestamp-ul ultimei rotații pentru fiecare figură

    figure.addEventListener('mouseenter', function() {
    const currentTime = new Date().getTime(); // Obținem timpul curent în milisecunde

    // Verificăm dacă au trecut cel puțin 1 secundă de la ultima rotație pentru această figură
    if (currentTime - lastRotateTime >= 1000) {
    figure.classList.toggle('rotate-180'); // Adăugăm/eliminăm clasa pentru a roti figura

    // Actualizăm timestamp-ul ultimei rotații pentru această figură
    lastRotateTime = currentTime;
}
});
});
});


//     function deleteTour(id) {
//     if (confirm("Are you sure you want to delete this tour?")) {
//     fetch('/deleteTour?id=' + id, {
//     method: 'DELETE'
// })
//     .then(response => {
//     if (response.ok) {
//     window.location.href = "/index"; // Redirecționare după ștergere reușită
// } else {
//     alert("Failed to delete tour.");
// }
// })
//     .catch(error => {
//     console.error('Error:', error);
//     alert("Failed to delete tour.");
// });
// }
// }
// for select 


