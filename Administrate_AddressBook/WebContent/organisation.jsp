<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Organisation System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<script language="JavaScript">
	
</script>

<style type="text/css">
<!--
.style1 {
	font-size: 12px
}
-->
</style>
</head>
<body>
	<form name="logForm" method="post"
		action="searchEventByNameCatalog.htm">
		<br /> <br /> <br />
		<table width="80%" align="center" border="2">
			<tr>
				<td>
					<div id="header">
						&nbsp;
						<div align="center">Organisation Management System</div>
					</div>

					<table>
						<tr>
							<td width="100%">
								<table align="right" cellpadding="2">
									<tr>
										<td width="90">
											<div id="menu" align="center">
												<a href="<jstlcore:url value="/index.jsp"/>"> Home </a>
											</div>
										</td>


										<td width="160">
											<div id="menu">
												<a href="<jstlcore:url value="/addOrganisation.jsp"/>">Add_Organisation
												</a>
											</div>
										</td>



										</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="900">
								<div align="center">
									<img src="images/greenhorizontalline.jpg" height="5"
										width="100%" />
								</div> <br />
								<div id="content" align="center">

									<table class="content" width="96%" border="1" align="center">
										<tr bgcolor="#669966">
											<th scope="col">Organisation id</th>
											<th scope="col">Organisation name<br />
											<th scope="col">Delete</th>
											<th scope="col">Update</th>




										</tr>
										<jstlcore:forEach items="${organisations}" var="organisation">
											<tr>
												<td align="center"><jstlcore:out
														value="${organisation[0]}"></jstlcore:out></td>
												<td align="center"><jstlcore:out
														value="${organisation[1]}"></jstlcore:out></td>


												<td align="center"><a
													href="<jstlcore:url value="/deleteOrganisation.htm?id=${organisation[0]}"/>">
														Delete </a></td>
												<td width="160">
													<div id="menu">
														<a
															href="<jstlcore:url value="/updateOrgPage.htm?id=${organisation[0]}"/>">Update
														</a>
													</div>
												</td>


											</tr>
										</jstlcore:forEach>


									</table>

								</div>
							</td>
						</tr>
					</table>
		</table>
	</form>
</body>

</html>
