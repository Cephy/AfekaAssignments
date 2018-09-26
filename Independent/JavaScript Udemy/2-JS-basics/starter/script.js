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

























