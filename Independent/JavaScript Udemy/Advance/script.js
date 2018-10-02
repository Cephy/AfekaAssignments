/*~~~~~~~~~~~~~Function constructer~~~~~~~~~~~~~*/
/*
var Person = function(name, yearOfBirth, job){
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    this.job = job;
}

Person.prototype.calculteAge = function() {
    console.log(2016 - this.yearOfBirth);
    
}

Person.prototype.lastName = 'Smith';

var john = new Person('John', 1990, 'teacher');

john.calculteAge();

console.log(john.lastName);
*/
/*~~~~~~~~~~~~~ Object.create ~~~~~~~~~~~~~*/
/*
var personProto = {
    calculateAge: function(){
        console.log(2016 - this.yearOfBirth);
    }
}

var john = Object.create(personProto);
john.name = 'john';
john.yearOfBirth = 1990;
john.job = 'teacher';

console.log(john);

var jane = Object.create(personProto, 
{
    name: {value: 'Jane'},
    yearOfBirth: {value: 1969},
    job: {value: 'designe'}
});

console.log(jane);

*/
/*~~~~~~~~~~~~~ Passing functions as arguments ~~~~~~~~~~~~~*/
/*
var year = [1990,1965,1937,2005,1998];

function arrayCalc(arr, fn){
    var arrRes = [];
    
    for(var i = 0 ; i < arr.length ; i++){
        arrRes.push(fn(arr[i]));
    }
    return arrRes;
}

function calculateAge(el){
    return 2016 - el;
}

function isFullAge(el) {
    return el >= 18 ;
}

function maxHR (el){
    
    if(el <= 18 && el <= 81  ){
        return -1;
    }
    
    return Math.round(206.9 - (0.67 * el));
}

var ages = arrayCalc(year, calculateAge);
console.log(ages);

var areFullAges = arrayCalc(ages, isFullAge);
console.log(areFullAges);

var maxHRArr = arrayCalc(ages, maxHR);
console.log(maxHRArr);
*/

/*~~~~~~~~~~~~~ returning functions as arguments ~~~~~~~~~~~~~*/
/*
function interviewQ(job){
    if (job === 'designer'){
        return function(name){
            console.log(name + ', can you explain what UX design is?');
        }
    } else if (job === 'teacher') {
       return function(name){
            console.log(name +  ', what subject do you teach?');
       }   
    } else {
        return function (name){
            console.log('Hello, ' + name + 'what do you do?');
        }
    }
}

//Store in a veriable
var teacherQuestion = interviewQ('teacher');
teacherQuestion('John');

var designerQuestion = interviewQ('designer');
designerQuestion('John');

//call immidiatly
interviewQ('teacher')('mark');
*/

/*~~~~~~~~~~~~~ IIFE ~~~~~~~~~~~~~*/
/*
//The old way
function game(){
    var score = Math.random() * 10;
    console.log(score >= 5);
}

game();

//We can only use & call IIFE once!

//IIFE
(function (){
    var score = Math.random() * 10;
    console.log(score >= 5);
})();

//How to pass an argument into the IIFE
(function (goodLuck){
    var score = Math.random() * 10;
    console.log(score >= 5 - goodLuck);
})(5);
*/
/*~~~~~~~~~~~~~ Closures ~~~~~~~~~~~~~*/
/*
function retiremnt(retirementAge){
    var a = ' years left until retirement.';
    
    return function(yOB){
        var age = 2016 - yOB;
        console.log((retirementAge - age) + a);
    }
}


var retirementUS = retiremnt(66);
retirementUS(1990);

retiremnt(66)(1990);
*/


/*~~~~~~~~~~~~~ Bind call and apply ~~~~~~~~~~~~~*/

/*
var john = {
    name: 'John',
    age: 26,
    job: 'teacher',
    presntaion:  function(style, timeOfDay){
        if(style === 'formal'){
            console.log('Good ' + timeOfDay + ' Ladies and gentlmen! I\'m ' + this.name + ', I am ' + this.job + ' and I am ' + this.age + ' years old.');
        } else if (style === 'friendly'){
            console.log('Hey what\'s up? I\'m ' + this.name + ', I am ' + this.job + ' and I am ' + this.age + ' years old. have a nice ' + timeOfDay + '.');
        }
    }
};

var emily = {
    name: 'Emily',
    age: 35,
    job: 'designer'
};

john.presntaion('formal', 'morning');
john.presntaion('friendly', 'evening');

//Call john function on emily;
john.presntaion.call(emily, 'friendly', 'evening');

//using apply is the same thing just with an array but the function should recive an array in order for the "apply" to work.
//john.presntaion.apply(emily, ['friendly', 'evening']);

//How to use bind - setting the other arguments and only leaving one to be determind in the future.
var johnFriendly = john.presntaion.bind(john, 'friendly');
johnFriendly('morning');
johnFriendly('Night');

//combining bind while using emily for "this" and calling the method on her data.
var emilyFormal = john.presntaion.bind(emily, 'formal');
emilyFormal('afternoon');
*/

/////////////////////////////
// CODING CHALLENGE


/*
--- Let's build a fun quiz game in the console! ---

1. Build a function constructor called Question to describe a question. A question should include:
a) question itself
b) the answers from which the player can choose the correct one (choose an adequate data structure here, array, object, etc.)
c) correct answer (I would use a number for this)

2. Create a couple of questions using the constructor

3. Store them all inside an array

4. Select one random question and log it on the console, together with the possible answers (each question should have a number) (Hint: write a method for the Question objects for this task).

5. Use the 'prompt' function to ask the user for the correct answer. The user should input the number of the correct answer such as you displayed it on Task 4.

6. Check if the answer is correct and print to the console whether the answer is correct ot nor (Hint: write another method for this).

7. Suppose this code would be a plugin for other programmers to use in their code. So make sure that all your code is private and doesn't interfere with the other programmers code (Hint: we learned a special technique to do exactly that).

--- Expert level ---

8. After you display the result, display the next random question, so that the game never ends (Hint: write a function for this and call it right after displaying the result)

9. Be careful: after Task 8, the game literally never ends. So include the option to quit the game if the user writes 'exit' instead of the answer. In this case, DON'T call the function from task 8.

10. Track the user's score to make the game more fun! So each time an answer is correct, add 1 point to the score (Hint: I'm going to use the power of closures for this, but you don't have to, just do this with the tools you feel more comfortable at this point).

11. Display the score in the console. Use yet another method for this.
*/


/*~~~~~~~~~~~~~~~~~~~ Answer ~~~~~~~~~~~~~~~~~~~*/

// TODO 
//function that recives an array of question and an array of answers
//in the function souldbe within an other function so that the score will be saved 

var question1, answersQ1, Q1CorrectNum, question2, answersQ2, Q2CorrectNum, question3, answersQ3, Q3CorrectNum, questions;

questions = [];

/*~~~~~~~ Data ~~~~~~~*/
//Question 1 data
question1 = 'Who is the best OverWatch character?';
answersQ1 = ['Ana', 'Reaper', 'Reinhart'];
Q1CorrectNum = 0;

//Question 2 data
question2 = 'which map is winston\'s home?';
answersQ2 = ['Rialto', 'Lunar colony', 'Dorado'];
Q2CorrectNum = 1;

//Question 3 data
question3 = 'Who does more AOE healing?';
answersQ3 = ['Lucio', 'Brigitta', 'Moira'];
Q3CorrectNum = 2;

questions.push(QuestionGame().bind(this, question1, answersQ1, Q1CorrectNum));
questions.push(QuestionGame().bind(this, question2, answersQ2, Q2CorrectNum));
questions.push(QuestionGame().bind(this, question3, answersQ3, Q3CorrectNum));

//playGame(questions);

/*~~~~~~~ Game Function with privet IIFE function ~~~~~~~*/

(function (){
    var notExit, randomNum, answer;
    var score = 0;
    notExit = true;
    
    while(notExit){
        randomNum = Math.floor((Math.random() * (questions.length)));
        answer = questions[randomNum]();
        if (answer === -1){
            console.log('Bye Bye');
            notExit = false;
        } else if (answer === 1){
            score++;
            console.log('Your score is ' + score);
        } else if(answer === 0){
            console.log('Your score is ' + score); 
    
        }
    }
})(questions);

/*~~~~~~~ Question Function ~~~~~~~*/
function QuestionGame(){   
    var promtePhrase = 'Please enter the correct number for an answer';
    
    return function (questionStr, answers, correctQNum){      
            console.log(questionStr);

            for (var i = 0 ; i < answers.length ; i++){
                console.log(i + ': ' + answers[i]);
            }
            
            var answer;
            answer = prompt(promtePhrase);
            if(answer == correctQNum){
                console.log('corret answer!!');
                return 1;                
            } else if (answer === 'exit'){
                isWrongAnswer = false;
                return -1;
            } else {
                console.log('Wrong answer.');
                return 0;
            } 
        
    }
}


























































