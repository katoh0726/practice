<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<div style="text-align: center">
<h2>Round1Monster</h2>
<h2>■</h2>


<br>
敵に<%=power %>のダメージを与えた<br>
<%=monstersPower %>のダメージを受けた

<table border=1 align="center">
<tr><td></td><td>HP</td><td>MP</td></tr>
<tr><td>あなた</td><td><%=hp %></td><td><%=mp %></td></tr>
</table>
<br><br>
<table align="center">
<tr><td><form action="attackServlet" method ="post">
<button type="submit">攻撃</button>
</form></td>
<td><form action="healServlet" method ="post">
<button type="submit">防御</button>
</form></td></tr>
<tr><td><form action="diffenceServlet" method ="post">
<button type="submit">回復</button>
</form></td>
<td><form action="loseServlet" method ="post">
<button type="submit">降参</button>
</form></td></tr>
</table>
</div>
</body>
</html>