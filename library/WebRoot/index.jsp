<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    
<style type="text/css">
<!--
body {
background-image: url(1.jpg);
}
-->
</style>     

	<head>
        <title>查询书籍</title>
    </head>
    <p style="height: 50px; "></p>
    <h1 align="center" ">请输入作者姓名 </h1>
    	<p style="height: 46px; "></p>
        <p>
			<form  action="Booklist_execute.action" method="get" style="height: 202px; ">
	  			<p align="center" ><font size=6>名字:</font> <input type="text" name="name" style="height: 37px; width: 165px"/></p>
	  			<p style="height: 27px; "></p>
	  			<p align="center"><input type="submit" value="查询" style="height: 60px; width: 150px; "></p>
			</form>
		</p >
		<p  align="center">
			<input type="button" name="jump" value="添加新书" onclick="location.href='NewBook.jsp'" style="height: 31px; width: 104px; ">
		</p>
		<p  align="center">
			<input type="button" name="jump" value="全部书籍" onclick="location.href='Booklist_allBook.action'" style="height: 31px; width: 104px; ">
		</p>
	</body>
</html>