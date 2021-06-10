<%@ include file="/include.jsp"%>

<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<script language="JavaScript">
<!--
var nHist = window.history.length;
if(window.history[nHist] != window.location)
  window.history.forward();
//-->
</script>

<script type="text/javascript">
function validateForm()
{
var uname=document.forms["logForm"]["USERNAME"].value;
var password=document.forms["logForm"]["PASSWORD"].value;
if (uname==null || uname=="")
{
alert("Please provide Username");
return false;
}
if (password==null || password=="")
{
alert("Please provide Password");
return false;
}
}
</script>
</head>
<style>
.error {
	color: red;
	font-size: 13px; 
	font-weight: bold;
}
</style>

<body>
<br/><br/><br/><br/><br/><br/>
<%
	HttpSession session=request.getSession(true);
	session.invalidate();
%>
<form method="post" name="logForm" action="catalog.htm" onsubmit="return validateForm()">



<table width="80%" align="center" border="2" bordercolor="#339999">
	<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">Organisation Management System</div>
		</div>
		<!-- header end -->
		<br/>
		<table>
			<tr>
				<!--content begin -->
				<td colspan="2" align="center">
				<div id="content">
				<h3>Address Book Link</h3>
				</div>
				</td>
			</tr>
			<tr>
				<td>
				<a href="/Administrate_AddressBook/organisation.htm">All Organisations</a>
				</td>
			</tr>
			<tr>
				
			<td><a href="/Administrate_AddressBook/person.htm">All Persons</a></td>
			
		</table>
		<br />
		</td>
	</tr>
</table>

</form>

</body>

</html>
