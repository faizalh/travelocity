<%--
  Created by IntelliJ IDEA.
  User: Faizal
  Date: 28/1/2016
  Time: 4:50 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
</head>

<body>
<p>
    This is the homepage.
</p>
<p>
<g:if test="${sessionBean != null}">
    User logged in as: ${subjectId}
</g:if>
<g:else>
    User does not have a session. Subject Id: ${subjectId}
</g:else>
</p>
<p>
<a href="logout?SAML2.HTTPBinding=HTTP-Redirect">Logout (HTTPRedirect)
</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout?SAML2.HTTPBinding=HTTP-POST">Logout (HTTP Post)</a><br/>
</p>
</body>
</html>