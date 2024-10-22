const btn = document.querySelector("#btn");

btn.addEventListener("click", () => {

  fetch('/test66')
  .then(resp => resp.json())
  .then(data => {
    console.log(data);
    const table = document.querySelector("#table");
    table.innerHTML = '';
  
    data.forEach(row => {
      
      const tr = document.createElement('tr');
      row.forEach(cell => {
  
        const td = document.createElement('td');
        td.textContent = cell;
        tr.appendChild(td);
  
      });
      table.appendChild(tr);
      console.log(table);
    });
  
  }).catch(err => console.log('error', err));

});

