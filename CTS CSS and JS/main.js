
/* Question 1 */


console.log("Welcome to the Community Portal");

window.onload = () =>{
    alert("Page Loaded Successfully");
};


/* Question 2 */

const eventName="Music Festival";
const eventDate="15-06-2026";
let seats=50;

console.log(`${eventName} on ${eventDate}`);

seats--;


/* Question 5 */


class Event{

    constructor(name,date,seats,category){

        this.name=name;
        this.date=date;
        this.seats=seats;
        this.category=category;
    }
}

Event.prototype.checkAvailability=function(){

    return this.seats>0;
}


/* Question 6 */


let events=[];

events.push(
new Event("Music Festival","2026-06-15",20,"Music")
);

events.push(
new Event("Baking Workshop","2026-06-20",10,"Workshop")
);

events.push(
new Event("Football Match","2026-06-25",0,"Sports")
);

let musicEvents=
events.filter(e=>e.category==="Music");

let formatted=
events.map(e=>`Workshop on ${e.name}`);

console.log(formatted);


/* Question 4 */


function addEvent(event){

    events.push(event);
}

function registerUser(event){

    if(event.seats>0){
        event.seats--;
    }
}

function filterEventsByCategory(category){

    return events.filter(
        e=>e.category===category
    );
}

/* Closure */

function registrationCounter(){

    let count=0;

    return function(){

        count++;
        return count;
    }
}

const trackRegistrations=
registrationCounter();


/* Question 3 */


events.forEach(event=>{

    if(event.seats>0){

        console.log(event.name);
    }
});

try{

    registerUser(events[0]);

}catch(error){

    console.log(error);
}


/* Question 7 */

const container=
document.querySelector("#eventContainer");

function displayEvents(data){

    container.innerHTML="";

    data.forEach(event=>{

        const card=
        document.createElement("div");

        card.className="eventCard";

        card.innerHTML=`
        <h3>${event.name}</h3>
        <p>Date: ${event.date}</p>
        <p>Seats: ${event.seats}</p>
        <button onclick="register('${event.name}')">
        Register
        </button>
        `;

        container.appendChild(card);
    });
}

displayEvents(events);


/* Question 8 */

function register(name){

    alert("Registered for "+name);
}

document
.querySelector("#categoryFilter")
.onchange=function(){

    if(this.value==="all"){

        displayEvents(events);

    }else{

        displayEvents(
            filterEventsByCategory(
                this.value
            )
        );
    }
};

document
.querySelector("#searchBox")
.addEventListener(
"keydown",
function(){

    let value=
    this.value.toLowerCase();

    let result=
    events.filter(e=>
    e.name.toLowerCase()
    .includes(value));

    displayEvents(result);
});

/* Question 9 */


fetch("events.json")
.then(response=>response.json())
.then(data=>{

    console.log(data);
})
.catch(error=>{

    console.log(error);
});

async function loadEvents(){

    try{

        const response=
        await fetch("events.json");

        const data=
        await response.json();

        console.log(data);

    }catch(error){

        console.log(error);
    }
}

loadEvents();


/* Question 10 */


const {
    name,
    date
}=events[0];

const copiedEvents=
[...events];


/* Question 11 */


document
.getElementById("registerForm")
.addEventListener(
"submit",
function(event){

event.preventDefault();

let name=
this.elements["name"].value;

let email=
this.elements["email"].value;

if(name===""){

document
.getElementById("nameError")
.innerText=
"Name Required";

return;
}

alert("Form Submitted");
});


/* Question 12 */


function submitRegistration(){

setTimeout(()=>{

fetch(
"https://jsonplaceholder.typicode.com/posts",
{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
name:"John"
})
}
)
.then(response=>response.json())
.then(data=>{

alert("Success");
})
.catch(()=>{

alert("Failed");
});

},2000);
}


/* Question 13 */


console.log("Form Started");
console.log("Validation Started");
console.log("Sending Request");

/*
Chrome DevTools
Console Tab
Network Tab
Breakpoints
*/


/* Question 14 */


$("#registerBtn").click(function(){

$(".eventCard").fadeOut(500)
.fadeIn(500);
});

/*
Benefit of React/Vue

Faster UI updates
Reusable Components
Better State Management
*/