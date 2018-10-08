/*~~~~~~~~~~~ const and let ~~~~~~~~~~~*/
/*
//ES5

var name5 = 'Jane Smith';
var age5 = 23;
name5 = 'Jane Miller';

console.log(name5);

//ES6
const name6 = 'Jane Smith';
let age6 = 23;
//name6 = 'Jane Miller'; - can't be changed because it's a const

console.log(name6);
*/

/*
//ES5
function driverLicence5(passedTest) {
    
    if (passedTest){
        var firstName = 'John';
        var yOB = 1990;
    }
    
    console.log(firstName + ' born in ' + yOB);
}

driverLicence5(true);

//ES6
function driverLicence6(passedTest) {
    
    if (passedTest){
        let firstName = 'John';
        const yOB = 1990;     
    }
    
    //console.log(firstName + ' born in ' + yOB); - won't work because the veriables are only created within the bloc
}

driverLicence6(true);
*/
/*
//How to make it work: 
//define let outside of the bloc and set the value within
//define const and set the value outside of the bloc - otherwise it won't work. it's different from "let".
function driverLicence6(passedTest) {
    
    //console.log(firstName); - diffrent from ES5 the veriable is not "undifined" it just throws an error and it's unusable!
    
    let firstName;
    const yOB = 1990;
    
    if (passedTest){
        firstName = 'John';   
    }
    
    console.log(firstName + ' born in ' + yOB); 
}

driverLicence6(true);
*/

/*
let i = 23;

for (let i = 0 ; i < 5 ; i++){
    console.log(i);
}

console.log(i);
*/

/*~~~~~~~~~~~ Blocks and IIFEs ~~~~~~~~~~~*/

/*
{
    const a = 1;
    let b = 2;
    
}
*/
//console.log(a + b); can't use them so it's like an IIFE


/*~~~~~~~~~~~ Strings ~~~~~~~~~~~*/

/*
let firstName = 'John';
let lastName = 'Smith';
const yOB = 1990;

function calcAge(year){
    return 2016 - year;
}

//ES5
console.log('This is ' + firstName + ' ' + lastName + '. He was born in ' + yOB + '. Today, he is ' + calcAge(yOB) + ' years old.');

//ES6
console.log(`This is ${firstName} ${lastName}. He was born in ${yOB}. Today, he is ${calcAge(yOB)} years old.`);

//New strings methods
const n = `${firstName} ${lastName}`;

console.log(n.startsWith('J'));
console.log(n.endsWith('th'));
console.log(n.includes(' ')); //checks a subString


console.log(firstName.repeat(5));
console.log(`${firstName} `.repeat(5) );    //with a space using the `
*/

/*~~~~~~~~~~~ Arrow functions ~~~~~~~~~~~*/
/*
const years = [1990, 1965, 1982, 1937];

//ES5
var ages5 = years.map(function(el) {
    return 2016 - el;
});
console.log(ages5);

//ES6
let ages6 = years.map(el => 2016 - el);
console.log(ages6);

ages6 = years.map((el,index) => `Age element ${index + 1}: ${2016 - el}.`)
console.log(ages6);

ages6 = years.map((el, index) => {
    const now = new Date().getFullYear();
    const age = now - el;
    return `Age element ${index + 1}: ${age}.`
});

console.log(ages6);
*/                  

/*~~~~~~~~~~~ Arrow functions 2 ~~~~~~~~~~~*/
/*                 
//ES5 - will not work becuase the fuction is attached to the golabel window and not the object. but you can bipass it by doing 'self = this;' within the function
var box5 = {
    color: 'green',
    position: 1,
    clickMe: function(){
        document.querySelector('.green').addEventListener('click', function() {
            var str = 'This is box number ' + this.position + ' and it is ' + this.color;
            
            alert(str);
        });
    }
};

box5.clickMe();
*/

//ES6 - first example
/*
const box6 = {
    color: 'green',
    position: 1,
    clickMe: function(){
        document.querySelector('.green').addEventListener('click', () => {
            var str = 'This is box number ' + this.position + ' and it is ' + this.color;
            
            alert(str);
        });
    }
};

box6.clickMe();
*/
/*
//ES6 - Second example - shows that if you define the function 'clickMe' using "arrow" the suranding envierment is the global object ("window") and then again you have no excess to 'color' and 'position'  
const box6 = {
    color: 'green',
    position: 1,
    clickMe: () => {
        document.querySelector('.green').addEventListener('click', () => {
            var str = 'This is box number ' + this.position + ' and it is ' + this.color;
            
            alert(str);
        });
    }
};

box6.clickMe();
*/

//ES5
/*
function Person(name){
    this.name = name;
}

Person.prototype.myFriends5 = function(friends){
    
    var arr = friends.map(function(el){
        return this.name + ' is friends with ' + el;
    }.bind(this));
    
    console.log(arr);
}

var friends = ['Bob', 'Jane', 'Mark'];

new Person('John').myFriends5(friends);
*/

//ES6
function Person(name){
    this.name = name;
}

Person.prototype.myFriends6 = function(friends){
    
    var arr = friends.map((el) => this.name + `is friends with ${el}`)
    
    console.log(arr);
}

var friends = ['Bob', 'Jane', 'Mark'];

new Person('John').myFriends6(friends);



















