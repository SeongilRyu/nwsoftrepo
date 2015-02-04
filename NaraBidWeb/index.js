window.onload = function() {
  document.querySelector('#greeting').innerText =
    'Hello, World! It is ' + new Date();
    getHttp();
    //init();
};
function init() {
    //var ROOT ="http://www.w3schools.com/website/Customers_MYSQL.php";
    var ROOT = "http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFcltyBsisAmount?sDate=&eDate=&pageNo=&numOfRows=&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D&bidNum=20141124315&_type=json";
    var xhr = new XMLHttpRequest();
    xhr.open('GET', ROOT);
    xhr.onload = function(e) {
      parseJson(e.target.responseText);
    };
    xhr.send();
}
function parseJson(str) {
  var text=str;//'{"response":{"header":{"resultCode":"00","resultMsg":"NORMAL SERVICE."},"body":{"items":{"item":{"공고명":"동남지역본부 신축 전기공사","국민건강보험료":0,"국민연금보험료":0,"기초금액공개시각":20141211104436,"기초예정가격":2382930000,"노인장기요양보험료":0,"안전관리비":0,"예비가격범위from":-2,"예비가격범위to":"+2","입찰공고번호":20141124315,"입찰공고차수":"02","입찰분류":0,"퇴직공제부금비":0,"평가기준금액":0,"하도급대금지급보증수수료":0,"환경보전비":0}},"numOfRows":1,"pageNo":1,"totalCount":1}}}';
  var json = JSON.parse(text);
  var aheader =json.response.header.resultCode + "," + json.response.header.resultMsg;
  document.getElementById('aheader').innerText = aheader;

  myFunc(json.response.body.items);
}
function myFunc(response) {
    var jsonItems = response;
    var item=jsonItems.item;
    alert(item.toString());
    var i;
    var out = "<table><tr><th>공고명</th><th>기초예가</th><th>공개시각</th></tr>";
    //for (x in jsonItems) {
        alert(item.공고명);
        out += "<tr><td>" +
        item.공고명 +
        "</td><td>" +
        item.기초예정가격 +
        "</td><td>" +
        item.기초금액공개시각 +
        "</td></tr>";
    //}
    out += "</table>"
    document.getElementById("id01").innerHTML = out;
}

function getHttp() {
  var xmlhttp = new XMLHttpRequest();
  //var url = "http://www.w3schools.com/website/Customers_MYSQL.php";
  var url="http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFcltyBsisAmount?sDate=&eDate=&pageNo=&numOfRows=&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D&bidNum=20141124315&_type=json";

  xmlhttp.onreadystatechange=function() {
      if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
          parseJson(xmlhttp.responseText);
      }
  }
  xmlhttp.open("GET", url, true);
  xmlhttp.send();
}