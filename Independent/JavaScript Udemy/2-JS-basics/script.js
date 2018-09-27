/*~~~~~~~~~~Variables and data types~~~~~~~~~~*/
/*
var firstName = 'John';
console.log(firstName);

var lastName = 'smith';
var age = 28;

var fullAge = true;
console.log(fullAge);

var job;
console.log(job);

var job = 'Teacher';
console.log(job);
*/

/*~~~~~~~~~~Variables mutation and type corercio~~~~~~~~~~*/

/*
//Type coercion:
var firstName = 'John';
var age = 28;

console.log(firstName + ' ' + age);

var job, isMarried; 
job = 'teacher';
isMarried = false;

console.log(firstName + ' is a ' + age + ' year old ' + job + '. Is he married? ' + isMarried);

//Type Mutation:
age = 'twenty eight';
job = 'driver';

alert(firstName + ' is a ' + age + ' year old ' + job + '. Is he married? ' + isMarried);

var lastName = prompt('What is his last name?');
console.log(firstName + ' ' + lastName);
*/

/*~~~~~~~~~~Basic operators~~~~~~~~~~*/
/*
//Math operators
var now, yearJhon, yearMark, ageJohn, ageMark;

ageJohn = 28
ageMark = 33;
now = 2020;
yearJhon = now - ageJohn;
yearMark = now - yearMark;

console.log(yearJhon);
console.log(yearMark);

console.log(now + 2);
console.log(now * 2);

//Logical operators
var johnOlder = ageJohn < ageMark;

console.log(johnOlder);

//typeof operator

console.log(typeof johnOlder);
console.log(typeof ageJohn);
console.log(typeof 'how are you?')
console.log(typeof X)
*/

/*~~~~~~~~~~Oparator precedence~~~~~~~~~~*/
/*
var now, yearJohn, fullAge, isFullAge, ageJohn, ageMark, average;

now = 2018;
yearJohn = 1989;
fullAge = 18;

// Multiple operators
isFullAge = now - yearJohn >= fullAge;

console.log(isFullAge);

// Grouping
ageJohn = now - yearJohn;
ageMark = 35;
average = (ageJohn + ageMark) / 2;

console.log(average);

//Multiple assignments

var x,y;
x = y = (3+5) * 4 - 6 // 8 * 4 -6 // 32 -6 // 26
console.log(x , y);
*/


/*****************************
* CODING CHALLENGE 1
*/

/*
Mark and John are trying to compare their BMI (Body Mass Index), which is calculated using the formula: BMI = mass / height^2 = mass / (height * height). (mass in kg and height in meter).

1. Store Mark's and John's mass and height in variables
2. Calculate both their BMIs
3. Create a boolean variable containing information about whether Mark has a higher BMI than John.
4. Print a string to the console containing the variable from step 3. (Something like "Is Mark's BMI higher than John's? true"). 

GOOD LUCK 😀
*/

/*~~~~~~~~~~Answer~~~~~~~~~~*/
/*
var markMass, markHeight, markBMI;
var johnMass, johnHeight, johnBMI;
var isJohnHeigher;


markMass = prompt('what is Mark mass?');
markHeight = prompt('what is Mark height?');
markBMI = markMass / (markHeight * markHeight);
alert('Mark BNI is ' + markBMI);

johnMass = prompt('what is John mass?');
johnHeight = prompt('what is John height?');
johnBMI = johnMass / (johnHeight * johnHeight);
alert('John BNI is ' + johnBMI);

isJohnHeigher = johnBMI > markBMI;

alert('Is John BMI heigher the Mark\'s? ' + isJohnHeigher);
*/

/*~~~~~~~~~~Ternary operator~~~~~~~~~~*/

/*
var firstName, age;

age = 16;

firstName = 'John';

age >= 18 ? console.log(firstName + ' is older then 18 years old')  : console.log(firstName + ' is younger then 18 years old');
*/

/*~~~~~~~~~~Truthy and Falsy values~~~~~~~~~~*/

// falsy values: undefined, null, 0, '', Nan
// truthy values: Not falsy values
/*
var height;

height = '';

if (height || height === 0) {
    console.log('Variable is defined');
} else {
    console.log('Variable is not beed defined');
}
*/


/*****************************
* CODING CHALLENGE 2
*/

/*
John and Mike both play basketball in different teams. In the latest 3 games, John's team scored 89, 120 and 103 points, while Mike's team scored 116, 94 and 123 points.

1. Calculate the average score for each team
2. Decide which teams wins in average (highest average score), and print the winner to the console. Also include the average score in the output.
3. Then change the scores to show different winners. Don't forget to take into account there might be a draw (the same average score)

4. EXTRA: Mary also plays basketball, and her team scored 97, 134 and 105 points. Like before, log the average winner to the console. HINT: you will need the && operator to take the decision. If you can't solve this one, just watch the solution, it's no problem :)
5. Like before, change the scores to generate different winners, keeping in mind there might be draws.

GOOD LUCK 😀
*/

/*~~~~~~~~~~Answer~~~~~~~~~~*/

/*
var johnScr1, johnScr2, johnScr3, johnAverage;
var mikeScr1, mikeScr2, mikeScr3, mikeAverage;
var maryScr1, maryScr2, maryScr3, maryAverage;

johnScr1 = 89;
johnScr2 = 120;
johnScr3 = 103;
johnAverage = (johnScr1 + johnScr2 + johnScr3) / 3;

mikeScr1 = 116;
mikeScr2 = 94;
mikeScr3 = 123;
mikeAverage = (mikeScr1 + mikeScr2 + mikeScr3) / 3;

maryScr1 = 97;
maryScr2 = 134;
maryScr3 = 105;
maryAverage = (maryScr1 + maryScr2 + maryScr3) / 3;

switch(true){
    case (johnAverage > mikeAverage && johnAverage > maryAverage):
        console.log('John has the highest average');
        break;
    case (mikeAverage > johnAverage && mikeAverage > maryAverage):
        console.log('Mike has the highest average');
        break;
    case (maryAverage > mikeAverage && maryAverage > johnAverage):
        console.log('Mary has the highest average');
        break;
    default:
        console.log('Mary has the highest average');
        break;
}*/

/*~~~~~~~~~~Functions statments and expressions~~~~~~~~~~*/

//Function delcration
/*
function whatDoYouDo(job, fristName) {
    
}
*/

/*
//Function expression
var whatDoYouDo = function (job, firstName) {
  switch (job) {
    case 'teacher':
        return firstName + ' Teaches kids'      
    case 'driver':
        return firstName + ' Dirves a cab'  
    case 'lover':
        return firstName + ' Love to touch people'  
    default:
        return firstName + ' Out of job';
  }
}

console.log(whatDoYouDo('teacher', 'John'));
console.log(whatDoYouDo('driver', 'Mark'));
*/

/*~~~~~~~~~~Arrays~~~~~~~~~~*/
/*
var names = ['John', 'Mark', 'Jane'];
var years = new Array(1190,1969,1948);

console.log(names[2]);
console.log(names);
console.log(names.length);

names[1] = 'Ben';
names[names.length] = 'Sefi';
names[5] = 'Mary';
console.log(names);
*/
//Data types
/*
var john = ['John', 'Smith', 1990, 'teacher', false];

john.push('blue');          //adds new data from the end
john.unshift('mister');     //adds new data at the begining
console.log(john);

john.pop();                 //pops data from the end
console.log(john);          
john.pop();
console.log(john);
john.shift();               //pops data from the begining
console.log(john);

console.log(john.indexOf(1990));
*/


/*****************************
* CODING CHALLENGE 3
*/

/*
John and his family went on a holiday and went to 3 different restaurants. The bills were $124, $48 and $268.

To tip the waiter a fair amount, John created a simple tip calculator (as a function). He likes to tip 20% of the bill when the bill is less than $50, 15% when the bill is between $50 and $200, and 10% if the bill is more than $200.

In the end, John would like to have 2 arrays:
1) Containing all three tips (one for each bill)
2) Containing all three final paid amounts (bill + tip).

(NOTE: To calculate 20% of a value, simply multiply it with 20/100 = 0.2)

GOOD LUCK 😀
*/

/*~~~~~~~~~~Answer~~~~~~~~~~*/
/*
var finalTip = [];
var finalPrices = [];
var meals = [124,48,268];

finalTip[finalTip.length] = Tip(meals[finalTip.length]);
finalTip[finalTip.length] = Tip(meals[finalTip.length]);
finalTip[finalTip.length] = Tip(meals[finalTip.length]);

finalPrices[finalPrices.length] = finalPrice(meals[finalPrices.length]);
finalPrices[finalPrices.length] = finalPrice(meals[finalPrices.length]);
finalPrices[finalPrices.length] = finalPrice(meals[finalPrices.length]);

console.log(finalTip[0]);
console.log(finalTip[1]);
console.log(finalTip[2]);

console.log(finalPrices[0]);
console.log(finalPrices[1]);
console.log(finalPrices[2]);

function Tip (bill){
    var lowTip, midTip, highTip;
    var midPrice, highPrice;
    
    lowTip = 0.1;
    midTip = 0.15;
    highTip = 0.2;
    midPrice = 50;
    highPrice = 200;
    
    switch(true){
        case bill < midPrice:
            return bill * highTip;
        case bill > midPrice && bill < highPrice:
            return bill * midTip;
        default: 
            return bill * lowTip;
    }   
}
  
function finalPrice(bill){
    return Tip(bill) + bill;
}
*/


/*~~~~~~~~~~Objects and properties~~~~~~~~~~*/

/*
var john = {
    firstName: 'john',
    lastName: 'smith',
    birthYear: 1990,
    family: ['jane', 'Mark', 'Bob', 'Emily'],
    isMarried: false
};

//How to access
console.log(john.firstName);
console.log(john['lastName']);
var x = 'birthYear'
console.log(john[x]);

//How to change
john.job = 'driver';
john['isMarried'] = true;
console.log(john);

//Add new properties to an object
var jane = new Object();

jane.name = 'Jane';
jane.birthYear = 1969;
jane['lastName'] = 'Smith';

console.log(jane);
*/
/*~~~~~~~~~~Objects and methods~~~~~~~~~~*/
/*
var john = {
    firstName: 'john',
    lastName: 'smith',
    birthYear: 1990,
    family: ['jane', 'Mark', 'Bob', 'Emily'],
    isMarried: false,
    calcAge: function() {
        this.age = 2018 - this.birthYear;
    }
    
};

john.calcAge();
console.log(john);
*/

/*****************************
* CODING CHALLENGE 4
*/

/*
Let's remember the first coding challenge where Mark and John compared their BMIs. Let's now implement the same functionality with objects and methods.
1. For each of them, create an object with properties for their full name, mass, and height
2. Then, add a method to each object to calculate the BMI. Save the BMI to the object and also return it from the method.
3. In the end, log to the console who has the highest BMI, together with the full name and the respective BMI. Don't forget they might have the same BMI.

Remember: BMI = mass / height^2 = mass / (height * height). (mass in kg and height in meter).

GOOD LUCK 😀
*/

/*~~~~~~~~~~Answer~~~~~~~~~~*/
/*
var Mark = {
    fullName: 'Mark',
    mass: 95,
    height: 1.97,
    calcBMI: function(){
        this.BMI = (this.mass / (this.height * this.height));
    }
};


var John = {
    fullName: 'John',
    mass: 68,
    height: 1.68,
    calcBMI: function(){
        this.BMI = this.mass / (this.height * this.height);
    }
}

John.calcBMI();
Mark.calcBMI();

if(Mark.BMI > John.BMI){
    console.log('Mark\'s BMI is heigher the Jon\'s')
} else {
    console.log('John\'s BMI is heigher the Mark\'s')
}

*/


/*~~~~~~~~~~Loops and iteration~~~~~~~~~~*/
/*
//Syntex for loop
for(var i = 0 ; i < 10 ; i++){
    console.log(i);
}

//Syntex while loop
var i = 0;
while(i < 10){
    console.log(i);
    i++;
}
*/  
//continue and break;   
    
 var john = ['John', 'Smith', 1990, 'teacher', false];   
    
console.log('~~~~with Continue~~~~');
for(var i = 0 ; i < john.length ; i++){
    if(typeof john[i] !== 'string') continue;
        console.log(john[i]);
    
}
 
console.log('~~~~with break~~~~');
for(var i = 0 ; i < john.length ; i++){
    if(typeof john[i] !== 'string') break;
        console.log(john[i]);
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



















