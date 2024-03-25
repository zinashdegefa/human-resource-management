
// JavaScript file
let click = false;
function toggle(){

    click = !click;

    updateElement(click);
}

function updateElement(toggleValue) {
console.log("toggle value: " + toggleValue);

        let welcome = document.getElementById("welcome");

        if(toggleValue) {
            welcome.style.fontSize = "40px";
            welcome.style.color = "#032a2a";
            welcome.innerText = "This is the home page for our human resource management website! Please login to access the website"
        }  else {
            welcome.style.fontSize = "40px";
            welcome.style.color = "#832f2f";
            welcome.innerText = "In this page you can add and view role, level, department, manager and employee data"
        }

}