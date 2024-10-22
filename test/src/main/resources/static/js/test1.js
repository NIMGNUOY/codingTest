const plus = document.querySelector(".area");
const result = document.querySelector("#result");

let num = 0;
plus.addEventListener("click", () => {

  num ++;

  // console.log(num);

  result.innerHTML = num;

});