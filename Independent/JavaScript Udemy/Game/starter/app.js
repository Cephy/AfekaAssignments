/*
GAME RULES:

- The game has 2 players, playing in rounds
- In each turn, a player rolls a dice as many times as he whishes. Each result get added to his ROUND score
- BUT, if the player rolls a 1, all his ROUND score gets lost. After that, it's the next player's turn
- The player can choose to 'Hold', which means that his ROUND score gets added to his GLBAL score. After that, it's the next player's turn
- The first player to reach 100 points on GLOBAL score wins the game



*/

/*~~~~~~~~~~~~~~~~~ How to ~~~~~~~~~~~~~~~~~*/

/*Change HTML aand add HTML code
document.querySelector('#current-' + activeplayer).innerHTML = '<em>' + dice '</em>';
*/

/*Change Css style
document.querySelector('.dice').style.display = 'none';
*/

/*get HTML text
var x = document.querySelector('#current-' + activeplayer).textContent;
*/

/*get Elment by ID instead of using the CSS style syntex
document.querySelector('#current-' + activePlayer).textContent ...
Instead we use:
document.getElementById('current-' + activePlayer).textContent ... - Here we don't need the '#'
*/



/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The Code
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

var scores, roundScore, activePlayer, winScore, gameFlag, doubleSixFlag;

doubleSixFlag = false;
gameFlag = true;
winScore = prompt('What should be the win condition?');

btnNew();   //Reset Game

/*~~~~~~~~~~~~~~~~~ Buttons ~~~~~~~~~~~~~~~~~*/

document.querySelector('.btn-roll').addEventListener('click', btnRoll);
document.querySelector('.btn-hold').addEventListener('click', btnHold);        
document.querySelector('.btn-new').addEventListener('click', btnNew);

/*~~~~~~~~~~~~~~~~~ Functions-Buttens ~~~~~~~~~~~~~~~~~*/


function btnRoll(){
    if(!gameFlag){
        return null;
    } 
    
    //1. 2 Random numbers
    var dice1 = randomNum();
    var dice2 = randomNum();
    
    
    
    //2.Display the result
    var diceDom1 = document.querySelector('.dice-1');
    diceDom1.style.display = 'block';
    diceDom1.src = 'dice-' + dice1 + '.png';
    
    var diceDom2 = document.querySelector('.dice-2');
    diceDom2.style.display = 'block';
    diceDom2.src = 'dice-' + dice2 + '.png';
    
    
    //3.Update score if it's not 1
    var activePlayerDom = document.querySelector('#current-' + activePlayer);
    var playerScoreDom = document.querySelector('#score-' + activePlayer);
    if( (dice1 === 6 || dice2 ===6) && doubleSixFlag){
        playerScoreDom.textContent = 0;
        switchPlayer();
        roundScore = 0; 
        activePlayerDom.textContent = roundScore;
    } else if (dice1 !== 1 && dice2 !== 1){
        roundScore += (dice1 + dice2);
        activePlayerDom.textContent = roundScore;
        if (dice1 === 6 || dice2 ===6) {
            doubleSixFlag = true;
        } else {
           doubleSixFlag = false; 
        }
    } else {
        roundScore = 0;
        switchPlayer();
        activePlayerDom.textContent = roundScore;
        doubleSixFlag = false;
    } 
}

function btnHold(){
    if(!gameFlag){
        return null;
    } 
    
    //Save score to player
    var playerScoreDom = document.querySelector('#score-' + activePlayer);
    scores[activePlayer] += roundScore; 
    playerScoreDom.textContent = scores[activePlayer];
    
    //Check win condition
    if(scores[activePlayer] >= winScore){
        document.getElementById('name-' + activePlayer).textContent = 'Winner!!!';
        document.querySelector('.player-' + activePlayer + '-panel').classList.toggle('winner');
        document.querySelector('.player-' + activePlayer + '-panel').classList.toggle('active');
        document.querySelector('.dice-1').style.display = 'none';
        document.querySelector('.dice-2').style.display = 'none';
        gameFlag = false;
    } else {
        switchPlayer();
        roundScore = 0;    
    }
    
    
}

function btnNew(){
    if(gameFlag){ //first time playing
        scores = [0,0];
        roundScore = 0;
        activePlayer = 0;
    } else {
        //reset player name after winning
        document.getElementById('name-' + activePlayer).textContent = 'PLAYER ' + (activePlayer+1);
        document.querySelector('.player-' + activePlayer + '-panel').classList.remove('winner');    
    }
     
    //reset each player score
    scores = [0,0];
    roundScore = 0;
    activePlayer = 0;
    
   //Update all labels
    document.querySelector('#current-' + 0).textContent = 0;
    document.querySelector('#current-' + 1).textContent = 0;
    document.querySelector('#score-' + 0).textContent = 0;
    document.querySelector('#score-' + 1).textContent = 0;
    document.querySelector('.player-' + activePlayer + '-panel').classList.add('active');
    
    //resetFlag
    gameFlag = true;
}

/*~~~~~~~~~~~~~~~~~ General Functions ~~~~~~~~~~~~~~~~~*/

function switchPlayer(){
    if (activePlayer === 1){
        document.querySelector('.player-' + activePlayer + '-panel').classList.remove('active');
        activePlayer = 0;
        document.querySelector('.player-' + activePlayer + '-panel').classList.add('active');
    } else {
        document.querySelector('.player-' + activePlayer + '-panel').classList.remove('active');
        activePlayer = 1;
        document.querySelector('.player-' + activePlayer + '-panel').classList.add('active');
    }
}

function randomNum(){
    return Math.floor((Math.random() * 6)) + 1
    
}

/*~~~~~~~~~~~~~~~~~ TODO ~~~~~~~~~~~~~~~~~*/
//All Done  


