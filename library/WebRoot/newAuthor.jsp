<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>作者信息录入</title>

  </head>
<style type="text/css">
<!--
body {
background-image: url(1.jpg);
}
-->
</style>
        <h4 align="center">由于该作者信息未曾录入，请输入作者信息</h4>
        <h3 align="center">作者 ：${Name}</h3>
        <p align="center">
			<form action="UpdateInfo_newAuthor.action?" method="post">
			<input type="hidden" name="Name" value="${Name}"/>
			<input type="hidden" name="ISBN" value="${ISBN}"/>
				<input type="hidden" name="Publisher" value="${Publisher}"/>
				<input type="hidden" name="Title" value="${Title}"/>
				<input type="hidden" name="PublishDate" value="${PublishDate}"/>
				<input type="hidden" name="Price" value="${Price}"/>
	  			<p align="center">年龄: <input type="text" name="Age" /></p>
	  			<p align="center">国家: <input type="text" name="Country" /></p>
	 			<p align="center"><input  type="submit" value="提交" /></p>>
			</form>
		</p>
  </body>
</html>
