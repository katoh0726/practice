<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Round1</title>
</head>
<body>
<div style="text-align: center">
<h2>Round1Monster</h2>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJypDarIpsnkqxKu6MOpIIAig87izWaepTZQ&usqp=CAU">
<%
//Integer yourHP =(Integer)request.getAttribute("yourHP");
//Integer yourMP =(Integer)request.getAttribute("yourMP");
//Integer yourPower =(Integer)request.getAttribute("yourPower");
//Integer monstersHP =(Integer)request.getAttribute("monstersHP");
Integer monstersPower =(Integer)request.getAttribute("monstersPower");
boolean attackFlg = (boolean)request.getAttribute("attackFlg");
boolean healFlg = (boolean)request.getAttribute("healFlg");
boolean diffenceFlg = (boolean)request.getAttribute("diffenceFlg");
boolean skilFlg = (boolean)request.getAttribute("skilFlg");
%>

<br>
<table border=1 align="center">
<tr><td></td><td>HP</td><td>MP</td><td>攻撃力</td></tr>
<tr><td>${name}</td><td>${yourHP}</td><td>${yourMP}</td><td>${yourPower}</td></tr>
<tr><td>敵</td><td>${monstersHP}</td><td></td><td>${monstersPower}</td></tr>
</table>
<br><br>
<%if(attackFlg==true){ %>
<p>${yourPower}のダメージを与えた！</p>
<p>${monstersPower}のダメージを受けた！</p>
<%}else if(healFlg==true){ %>
<p>20回復した！</p>
<p>MPが10減った！</p>
<%}else if(diffenceFlg==true){ %>
<p><%=monstersPower/2 %>のダメージを受けた！</p>
<%}else if(skilFlg==true){ %>
<p>${yourPower}のダメージを与えた！</p>
<p>${monstersPower}のダメージを受けた！</p>
<p>MPが20減った！</p>

<%} %>
[1:攻撃 2:回復3:防御 4:技 5:降参]<br>
<form action="round_1">
<select name="active" >
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
<input type="submit">
</form>

</div>

</body>
</html>