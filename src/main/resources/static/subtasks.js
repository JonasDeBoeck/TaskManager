window.addEventListener("load", initPage);

function initPage() {
    if (document.getElementById("downArrow")) {
        document.getElementById("downArrow").addEventListener("click", showSubtasks);
        document.getElementById("upArrow").addEventListener("click", hideSubtasks);
        document.getElementById("done").addEventListener("click", taakDone);
        for (let i = 0; i < document.querySelectorAll(".info"); i++) {
            alert("Yey");
            document.querySelectorAll(".info")[i].addEventListener("click", toggleInfo);
        }
    }
}

function showSubtasks (evt) {
    document.getElementById("upArrow").style.display = "block";
    document.getElementById("downArrow").style.display = "none";
    document.getElementById("subTasks").style.display = "block";
}

function hideSubtasks (evt) {
    document.getElementById("upArrow").style.display = "none";
    document.getElementById("downArrow").style.display = "initial";
    document.getElementById("subTasks").style.display = "none";
}

function taakDone (evt) {
    evt.target.parentNode.parentNode.parentNode.style.backgroundColor = "lightgreen";
}

function toggleInfo(evt) {
    alert("Yey");
    if (evt.target.parentNode.parentNode.lastElementChild.style.display === "none") {
        evt.target.parentNode.parentNode.lastElementChild.style.display = "block";
    } else {
        evt.target.parentNode.parentNode.lastElementChild.style.display = "none";
    }
}