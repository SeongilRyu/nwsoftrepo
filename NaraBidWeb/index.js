window.onload = function() {
  document.querySelector('#greeting').innerText =
    'Hello, World! It is ' + new Date();
    //getHttp();
    init();
};
function init() {
    //var ROOT ="http://www.w3schools.com/website/Customers_MYSQL.php";
    var ROOT = "http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFcltyBsisAmount?sDate=&eDate=&pageNo=&numOfRows=&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D&bidNum=20141124315&_type=json";
    var xhr = new XMLHttpRequest();
    xhr.open('GET', ROOT);
    xhr.onload = function(e) {
      game(JSON.parse(e.target.responseText));
    };
    xhr.send();
}
function game(data) {
  alert(data.toString());
}
function getHttp() {
  var xmlhttp = new XMLHttpRequest();
  //var url = "http://www.w3schools.com/website/Customers_MYSQL.php";
  var url="http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFcltyBsisAmount?sDate=&eDate=&pageNo=&numOfRows=&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D&bidNum=20141124315&_type=json";

  xmlhttp.onreadystatechange=function() {
      if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
          myFunction(xmlhttp.responseText);
      }
  }
  xmlhttp.open("GET", url, true);
  xmlhttp.send();

  function myFunction(response) {
      var arrJson = JSON.parse(response);
      var objResp = JSON.parse(arrJson.response);
      var objHead = JSON.parse(objResp.head);
      var objBody = JSON.parse(objResp.body);
      var objItems = JSON.parse(objBody.items);
      var i;
      var out = "<table>";
      alert(arrJson.toString());
      for (x in objItems) {
        txt += objItems[x]
      }
      alert(txt);
      for(i = 0; i < arr.length; i++) {
          out += "<tr><td>" +
          arr[i].response +
          "</td><td>" +
          arr[i].header +
          "</td><td>" +
          arr[i].body +
          "</td></tr>";
      }
      out += "</table>"
      document.getElementById("id01").innerHTML = out;
  }
}