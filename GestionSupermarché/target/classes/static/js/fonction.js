// fonction.js
$(document).ready(function() {
    $('.secteur-link').on('click', afficherRayons);
});

function afficherRayons(event) {
    event.preventDefault();
    let secteurId = $(this).data("id");
    $.ajax({
        url: "/secteur/" + secteurId + "/rayon",
        method: "get",
        success: function(rayons) {
            $('#rayons').empty();
            rayons.forEach(function(rayon) {
                $('#rayons').append(`<tr><td>${rayon.id}</td><td><a href="#" class="rayon-link" data-id="${rayon.id}">${rayon.nomR}</a></td></tr>`);
            });

            $('.rayon-link').on('click', afficherRayonInfo);
        },
        error: function() {
            alert("Erreur sur le chargement des rayons");
        }
    });
}

function afficherRayonInfo(event) {
    event.preventDefault();
    let rayonId = $(this).data("id");
    $.ajax({
        url: "/rayon/" + rayonId + "/info",
        method: "get",
        success: function(data) {
            console.log(data); // Log the data to inspect the response
            $('#employes-by-rayon').empty();
            data.employesByRayon.forEach(function(employe) {
                $('#employes-by-rayon').append(`<li>${employe.prenomE}</li>`);
            });

            $('#total-hours').text(data.totalHours);

            $('#all-employes').empty();
            data.allEmployes.forEach(function(employe) {
                $('#all-employes').append(`<li>${employe.prenomE}</li>`);
            });
        },
        error: function() {
            alert("Erreur sur le chargement des informations du rayon");
        }
    });
}
