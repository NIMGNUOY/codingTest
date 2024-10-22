function playGame(playerChoice) {

  console.log(playerChoice);

  fetch('/rpsGame', {
    method : 'POST',
    headers : {'Content-Type' : 'application/x-www-form-urlencoded'},
    body : new URLSearchParams({
      'playerChoice' : playerChoice
    })
  })
  .then(resp => resp.json())
  .then(result => {
    document.querySelector('#message').innerText = result.message;
    document.querySelector('#playerChoice').innerText = result.playerChoice;
    document.querySelector('#computerChoice').innerText = result.computerChoice;
    document.querySelector('#score').innerText = result.score;
    document.querySelector('#attempts').innerText = result.attempts;
    document.querySelector('#draws').innerText = result.draws;
    document.querySelector('#strikes').innerText = result.strikes;
    document.querySelector('#outs').innerText = result.outs;
  }) 

}