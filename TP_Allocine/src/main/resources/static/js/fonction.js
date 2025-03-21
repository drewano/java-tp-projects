$(document).ready(function() {
    $('.btn').on('click', afficherLesFilms);
});

function afficherLesFilms() {
    let codeCinema = $(this).data("codecinema");
    let cinemaName = $(this).closest('.cinema-card').find('h2').text();
    $.ajax({
        url: "/cinema/" + codeCinema + "/films",
        method: "get",
        success: function (films) {
            $('#divFilms').empty();
            var header = `<h2 class='h2-vrmtstyle'>Liste des films dans le cinéma : ${cinemaName}</h2>`;
            var chaine = "<div class='film-grid'>";
            films.forEach(function (film) {
                chaine += `
                    <div class="film-card">
                        <img src="${film.imageFilm}" alt="Image du film">
                        <div class="film-details">
                            <h3>${film.nomFilm}</h3>
                            <div class="rating" data-film-id="${film.codeFilm}">
                                ${[1, 2, 3, 4, 5].map(i => `<span class="star" data-value="${i}">&#9733;</span>`).join('')}
                            </div>
                            <p>Nombre de votes : ${film.nbVotes}</p>
                            <p>Total de votes : ${film.totalVotes}</p>
                        </div>
                    </div>
                `;
            });
            chaine += "</div>";
            $("#divFilms").append(header + chaine);

            // Ajouter des écouteurs d'événements pour les étoiles de notation
            $('.star').on('click', function() {
                let rating = $(this).data('value');
                let filmId = $(this).closest('.rating').data('film-id');
                $.ajax({
                    url: "/film/" + filmId + "/rate",
                    method: "post",
                    contentType: "application/json",
                    data: JSON.stringify({ rating: rating }),
                    success: function(response) {
                        alert(`Merci pour votre vote!`);
                        location.reload(); // Rafraîchir la page pour actualiser les notes
                    },
                    error: function() {
                        alert("Erreur lors de l'enregistrement du vote");
                    }
                });
            });
        },
        error: function () {
            alert("Erreur sur le chargement des films");
        }
    });
}