<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Welcome to Festival Registration System</title>
<script language="JavaScript">
<!--
	var nHist = window.history.length;
	if (window.history[nHist] != window.location)
		window.history.forward();
//-->
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 12
}
-->
</style>
<style>
.error {
	color: red;
	font-weight: bold;
	font-size: 20px;
}
</style>
</head>

<body>
	<br />
	<br />
	<form action="insertPerson.htm" name="regform" method="get"
		onsubmit="return validateForm()">

		<table width="80%" align="center" border="2">
			<tbody>
				<tr>
					<td>
						<div id="header">
							&nbsp;
							<div align="center">Organisation System</div>
						</div>

						<table>
							<tbody>
								<tr>
									<td width="100%">
										<table align="right" cellpadding="2">
											<tbody>
												<tr>
													<td width="90"></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td width="900">
										<div id="content">

											<table align="center" border="0">

												<tbody>
													<tr>
														<td align="center" colspan="2">
															<h3>New Person Registration Page</h3>
														</td>
													</tr>
													<!-- <tr><td align="center" colspan="2" style="font-style: italic;">Fields marked (<span style="font-weight: bold;color: red; font-size: 15px;"></span>) are Mandatory</td></tr> -->
													<tr>
														<td></td>
														<td></td>
													</tr>
													<tr>
														<td></td>
														<td></td>
													</tr>
													<tr>

														<td><span
															style="font-weight: bold; color: red; font-size: 15px;"></span>
															PERSON ID:</td>
														<td><input type="text" name="person_id" size="25"
															value="${id}"></input></td>
													</tr>
													<tr>
														<td><span
															style="font-weight: bold; color: red; font-size: 15px;"></span>
															PERSON NAME</td>
														<td><input type="text" name="person_name" size="25"
															value=""></input></td>
													</tr>
													<tr>
														<td><span
															style="font-weight: bold; color: red; font-size: 15px;"></span>
															ORGANISATION ID</td>
														<td><input type="text" name="organisation_id"
															size="25" value=""></input></td>
													</tr>
													<tr>
														<td><span
															style="font-weight: bold; color: red; font-size: 15px;"></span>
															ADDRESS</td>
														<td><input type="text" name="address" size="25"
															value=""></input></td>
													</tr>
													<tr>
														<td><span
															style="font-weight: bold; color: red; font-size: 15px;"></span>
															PHONE NUMBER</td>
														<td><input type="text" name="phone_number" size="25"
															value=""></input></td>
													</tr>

													<tr>
														<td colspan="2" align="right"><input
															value="Add New Person" type="submit"></td>
													</tr>
													<tr>
													</tr>
												</tbody>
											</table>
										</div>
									</td>
									<!-- content end -->
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center"><div
							style="font-size: 15px; color: red; font-weight: bold;">${REGISTRATIONSTATUSMESSAGE}</div></td>
				</tr>
			</tbody>
		</table>

	</form>
</body>

</html>
