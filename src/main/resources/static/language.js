$(document).ready(function() {
    $(".lang").on('click', function (evt) {
        let selectedOption = evt.target.innerText;
        window.location.replace('?lang=' + selectedOption);
    });
});