<%@ page contentType="text/html; charset=UTF-8" %>
<!-- 导入Struts 标签库 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
<!--
body {
background-image: url(1.jpg);
}
-->
</style>     

<p align="center">
<table  border="2">
	<tr>
		<td align="center" style="width:120px; height: 21px;" valign="middle"> 
		书名</td>
		<td align="center" style="width:120px; height: 21px;" valign="middle"> 
		作者</td>
		<td align="center" style="width:120px; height: 21px;" valign="middle"> 
		是否删除</td>
	</tr>
	<s:iterator value="books" var="b">
		<tr>
			<td align="center" style="width:120px; height: 21px;" valign="middle"> 
			<a href="Booklist_detail.action?ID=${b.ID}">${b.name}</a></td>
			<td align="center" style="width:120px; height: 21px;" valign="middle"> 
			${b.oauther}</td>
			<td align="center" style="width:120px; height: 21px;" valign="middle">
			<input type="button" name="jump" value= "删除" 
			onclick="location.href='Booklist_delete.action?ID=${b.ID}'"/></td>
		
		</tr>
	</s:iterator>
	
</table>
</p>
</body>