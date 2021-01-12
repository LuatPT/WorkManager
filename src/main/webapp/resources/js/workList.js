 var table = document.getElementById("orderTable");
 for (var i = 1, row; row = table.rows[i]; i++) {
//iterate through rows
//rows would be accessed using the "row" variable assigned in the for loop

var orderTime= row.cells[3];
countDownTime = new Date(orderTime.innerHTML.replace(/-/g, "/")).getTime();
var countDown = row.cells[4];
// Update the count down every 1 second

var x = setInterval(
function () {
    // Get todays date and time
    var now = new Date().getTime();

    // Find the distance between now an the count down date
    var distance = countDownDate - now;

    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);


    // Display the result in the element
    countDown.innerHTML = (days + "d " + hours + "h "
        + minutes + "m " + seconds + "s ");

     //If the count down is finished, write some text 
    if (distance < 0) {
        clearInterval(x);
        countDown.innerHTML = "Finish";
    }
  }, 1000);
 }