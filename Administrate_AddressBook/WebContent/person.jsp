<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Organisation System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />

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
		action="searchpersonByNameCatalog.htm">
		<br />
		<br />
		<br />
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
												<a href="<jstlcore:url value="/index.jsp"/>"> Home</a>
											</div>
										</td>


										<td width="90">
											<div id="menu">
												<a href="<jstlcore:url value="/addPerson.jsp"/>">Add_person
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
											<th scope="col">Person id</th>
											<th scope="col">Person name<br />
											<th scope="col">Org id<br />
											<th scope="col">Address<br />
											<th scope="col">Phone number<br />
											<th scope="col">Delete</th>
											<th scope="col">Update</th>


											<jstlcore:if test="${visitor.admin == false}">
												<th scope="col">Update</th>
												<th scope="col">Delete</th>
											</jstlcore:if>
										</tr>
										<jstlcore:forEach items="${persons}" var="person">
											<tr>
												<td align="center"><jstlcore:out value="${person[0]}"></jstlcore:out></td>
												<td align="center"><jstlcore:out value="${person[1]}"></jstlcore:out></td>
												<td align="center"><jstlcore:out value="${person[2]}"></jstlcore:out></td>
												<td align="center"><jstlcore:out value="${person[3]}"></jstlcore:out></td>
												<td align="center"><jstlcore:out value="${person[4]}"></jstlcore:out></td>



												<td align="center"><a
													href="<jstlcore:url value="/deletePerson.htm?id=${person[0]}"/>">
														Delete </a></td>
												<td width="160">
													<div id="menu">
														<a
															href="<jstlcore:url value="/updatePersonPage.htm?id=${person[0]}"/>">Update
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
