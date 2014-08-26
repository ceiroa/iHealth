/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validatelogin() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if(username=="" || password=="") {
        alert("Please enter both Username and Password.");
        return false;
    } else {
        return true;
    }
}

function validatedate() {
    var date = document.getElementById("dateCreated").value;
    var patt_date = new RegExp("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$");
    
    if (patt_date.test(date) == false) {
        alert("Please enter a valid date (yyyy-MM-dd).");
        return false;
    } else {
      return true;
    }
}

function confirmDelete() {
    var answer = confirm("Are you sure you want to delete it?");

    if(answer) {
        return true;
    } else {
        return false;
    }
}