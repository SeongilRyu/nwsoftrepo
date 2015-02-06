window.onload = function() {
  var d = new Date();
  document.querySelector('#greeting').innerText = 'Date: ' + d.toISOString();
    getHttp0("0");
    document.getElementById("liThng").addEventListener("click", function () {getHttp0('0');});
    document.getElementById("liCnst").addEventListener("click", function () {getHttp0('1');});
    document.getElementById("liSrvc").addEventListener("click", function () {getHttp0('2');});
    document.getElementById("liFrgn").addEventListener("click", function () {getHttp0('3');});
     document.getElementById("liThng").addEventListener("onmouseover", function () {mOver(this);});
    //
    document.getElementById("btnGet").addEventListener("click", getHttp1);
    //---getHttp1();
};
function getHttp0(opt) {
    document.getElementById("id00").innerHTML = ""; //물품
    var d=new Date();
    var sd= new Date();
    var ed=d.toISOString().replace("-","").replace("-","").substr(0,8);
    sd.setDate(sd.getDate()-0);
    var nd = sd.toISOString().replace("-","").replace("-","").substr(0,8);

    var myUrl = "http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoThng?";  //물품
    if (opt=="1") myUrl="http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFclty?";  //공사
    if (opt=="2") myUrl="http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoServc?";  //용역
    if (opt=="3") myUrl="http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFrgcpt?";  //외자
    //오늘 날짜
    myUrl += "sDate="+nd + "&eDate=" + ed + "&pageNo=&numOfRows=3";
    myUrl += "&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D";
    //myUrl += "&bidNum=" + document.getElementsByName("txtBidNo")[0].value;  //20141124315
    myUrl += "&_type=json";
    console.log(myUrl);

    var xhr = new XMLHttpRequest();
    xhr.open('GET', myUrl);
    xhr.onload = function(e) {
      //parseJson(e.target.responseText);
      var json = JSON.parse(e.target.responseText);
      var aheader =json.response.header.resultCode + "," + json.response.header.resultMsg;
      document.getElementById('aheader').innerText = "응답결과:" + aheader;
      if ("00"==json.response.header.resultCode) {
        document.getElementById('msg').innerText="totalCount: " + (json.response.body.totalCount);
        myFuncList(json.response.body.items);
      }
    };
    xhr.send();
}
function getHttp1() {
    document.getElementById("id01").innerHTML = "";
    //var myUrl ="http://www.w3schools.com/website/Customers_MYSQL.php";
    var myUrl = "http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoFcltyBsisAmount?";
    myUrl += "sDate=&eDate=&pageNo=&numOfRows=";
    myUrl += "&serviceKey=Kp7AOPELDDH%2FlM4%2BjmRtklFuw3J1YIjQeJcwxs8NIeQNMKBd3KwY4Tfyb%2FBF4I4%2BQILc%2BKqI2nRdvd%2Fdu5jnQw%3D%3D";
    myUrl += "&bidNum=" + document.getElementsByName("txtBidNo")[0].value;  //20141124315
    myUrl += "&_type=json";
    var xhr = new XMLHttpRequest();
    xhr.open('GET', myUrl);
    xhr.onload = function(e) {
      parseJson(e.target.responseText);
    };
    xhr.send();
}
function parseJson(str) {
  var text=str;//'{"response":{"header":{"resultCode":"00","resultMsg":"NORMAL SERVICE."},"body":{"items":{"item":{"공고명":"동남지역본부 신축 전기공사","국민건강보험료":0,"국민연금보험료":0,"기초금액공개시각":20141211104436,"기초예정가격":2382930000,"노인장기요양보험료":0,"안전관리비":0,"예비가격범위from":-2,"예비가격범위to":"+2","입찰공고번호":20141124315,"입찰공고차수":"02","입찰분류":0,"퇴직공제부금비":0,"평가기준금액":0,"하도급대금지급보증수수료":0,"환경보전비":0}},"numOfRows":1,"pageNo":1,"totalCount":1}}}';
  var json = JSON.parse(text);
  var aheader =json.response.header.resultCode + "," + json.response.header.resultMsg;
  document.getElementById('aheader').innerText = "응답결과:" + aheader;
  if ("00"==json.response.header.resultCode) {
    myFunc(json.response.body.items);
  }
}
function myFunc(response) {
    var jsonItems = response;
    var item=jsonItems.item;
    alert(item.toString());
    var i;
    alert(item.공고명);
    var out = "<table><tr><th>입찰공고번호</th><th>공고명</th><th>기초예가</th><th>공개시각</th></tr>";
    //for (x in jsonItems) {
        out += "<tr><td>" +
        item.입찰공고번호  +"-" + item.입찰공고차수 +
        "</td><td>" +
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
function mOver(obj) {
  console.log(obj);
  obj.style="background-color:#D94A38;width:120px;height:20px;padding:40px;"
  //document.getElementsByName("txtBidNo")[0].value=obj.innerText;
};
function myFuncList(response) {
    var jsonItems = response;
    var item=jsonItems.item;
    console.log(item.toString());
    var i;
    console.log(item[0].공고명);
    var out = "<table><tr><th>입찰공고번호</th><th>공고명</th><th>추정가격</th><th>공고일시</th></tr>";
    for (x in item) {
        console.log(x);
        out += "<tr><td>" +
        //"<div onmouseover=mOver(this)>"+item[x].입찰공고번호 +"</div>-" + item[x].입찰공고차수 +
        item[x].입찰공고번호 +"-" + item[x].입찰공고차수 +
        "</td><td>" +
        item[x].공고명 +
        "</td><td>" +
        item[x].추정가격 +
        "</td><td>" +
        item[x].공고일시 +
        "</td></tr>";
    }
    out += "</table>"
    document.getElementById("id00").innerHTML = out;
}
/*
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
  xmlhttp.send();  
}
*/