<%@ page contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	   <title>������ʾҳ</title>
	</head>
	<body>
		<TABLE width="780" align="center" CELLSPACING=0 background="images/bodybg.jpg">
			<tr> 
				<td height="39" valign=top>
					<br><div align="center"><font color="blue" size="+1"><b>ϵͳ���������з�����һ��������Ϣ���£�</b></font></div>
				</td>
			</tr>
			<tr>
				<td height="100" valign=top>
					<div class="error"><br><br>
						<s:property value="errMsg"/>
						<s:property value="exception"/>
					</div>
				</td>
			</tr>
			<tr>
				<td valign=top>
					<div>
						����<br><br><s:fielderror/><s:actionerror/>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center">
					<br><br><br>
					<input type="button" value="����" onClick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</body>
</html>