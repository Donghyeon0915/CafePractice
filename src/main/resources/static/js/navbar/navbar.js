const body = document.querySelector('body');
const sidebar = body.querySelector('nav');
const modeText = body.querySelector(".mode-text");

function toggle(){
    sidebar.classList.toggle("close");
}

function searchBtn(){
    sidebar.classList.remove("close");
}

function modeSwitch(){
    body.classList.toggle("dark");

    if(body.classList.contains("dark")) modeText.innerText = "Light mode";
    else modeText.innerText = "Dark mode";
}