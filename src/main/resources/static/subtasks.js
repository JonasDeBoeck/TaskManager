window.addEventListener("load", initPage);

function initPage() {
    if (document.getElementById("downArrow")) {
        document.getElementById("downArrow").addEventListener("click", showSubtasks);
        document.getElementById("upArrow").addEventListener("click", hideSubtasks);
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