<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查询书籍详细信息</title>
  </head>
  
<style type="text/css">
<!--
body {
background-image: url(1.jpg);
}
-->
</style>  
  
	  <h1 align="center">查询书籍</h1>
	  <h2 align="center">书籍信息</h2>
	  <p align="center">
	  	名称：${book[1]}<br>
	  	作者：${book[7]}<br>
	  	出版社：${book[3]}<br>
	  	出版日期：${book[4]}<br>
	  	价格：${book[5]}元<br>
	  </p>
	   <h2  align="center">作者信息</h2>
	  <p align="center">
	  	作者：${book[7]}<br>
	  	年龄：${book[8]}<br>
	  	国家：${book[9]}<br>
      </p>
      <p align="center"> <input type="button" name="jump" value= "更新信息" onclick="location.href='Booklist_refresh.action?ID=${book[0]}'"/>
   	</p>
  </body>
</html>
