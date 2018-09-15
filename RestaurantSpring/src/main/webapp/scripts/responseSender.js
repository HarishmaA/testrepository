function onCreate() {
    	var receipeIdCreate=document.getElementById("receipeIdCreate").value;
    	var receipeNameCreate=document.getElementById("receipeNameCreate").value;
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("create-message").innerHTML = this.responseText;
        }
      };
      xhttp.open("POST", "/create", true);
      xhttp.send("receipeId="+receipeIdCreate+"&receipeName="+receipeNameCreate);
    }
    function onRetrieve() {
    	var receipeIdRetrieve=document.getElementById("receipeIdRetrieve").value;
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("retrieve-message").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "/retrieve?receipeId="+receipeIdRetrieve, true);
      xhttp.send();
    }
    function onUpdate() {
    	var receipeIdUpdate=document.getElementById("receipeIdUpdate").value;
    	var receipeNameUpdate=document.getElementById("receipeNameUpdate").value;
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("update-message").innerHTML = this.responseText;
        }
      };
      xhttp.open("PUT", "/update?receipeId="+receipeIdUpdate+"&receipeName="+receipeNameUpdate, true);
      xhttp.send();
    }
    function onDelete() {
    	var receipeIdDelete=document.getElementById("receipeIdDelete").value;
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("delete-message").innerHTML = this.responseText;
        }
      };
      xhttp.open("DELETE", "/delete?receipeId="+receipeIdDelete, true);
      xhttp.send();
    }