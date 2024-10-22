const btn = document.querySelector(".btn");

function pascalsTriangle(n) {

  const triangle = [];
  
  // 첫번째 행을 설정
  for (let i = 0; i < n; i ++) {
  
    triangle[i] = [];
    triangle[i][0] = 1;
  
    for(let j = 1; j < i; j++) {
  
      triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
  
      // if(triangle[i][j] === 20) {
      //   return triangle;
      // }
  
    }
  
    triangle[i][i] = 1;
  
    if(triangle[i].includes(20)) {
      return triangle;
    }
  }

  // console.log(triangle);

  return triangle;

}

// function printPascalsTriangle() {

//   const n = 10;
//   const triangle = pascalsTriangle(n);

//   triangle.forEach(row => console.log(row.join('  ')))

// }

function displayTriangle() {

  const n = 10;
  const triangle = pascalsTriangle(n);
  const container = document.querySelector(".container");

  container.innerHTML = '';

  triangle.forEach(row => {

    const rowElement = document.createElement('div');
    rowElement.classList.add('row');
    rowElement.textContent = row.join('  ');
    container.appendChild(rowElement);

  })

}