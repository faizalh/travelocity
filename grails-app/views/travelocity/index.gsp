<%--
  Created by IntelliJ IDEA.
  User: Faizal
  Date: 28/1/2016
  Time: 10:42 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
</head>

<body>
<p>
    this is the index page with the authentication form.
</p>
<g:form method="post" mapping="samlsso" params="['SAML2.HTTPBinding': 'HTTP-POST']">
    <h2>Login with <asset:image src="saml2-logo.png" height="22" width="60"/> (Post Binding) from
        <asset:image src="identity_logo.gif" height="20" width="120"/> with user credentials</h2>
    Username : <input type="text" name="username"/>
    Password : <input type="password" name="password">
    <input type="submit" value="Login"/>
</g:form>
<hr/>
<h2>Click <a href="samlsso?SAML2.HTTPBinding=HTTP-Redirect">here</a> to login with <asset:image src="saml2-logo.png" height="22" width="60"/>
    (Redirect binding) from <asset:image src="identity_logo.gif" height="20" width="120"/></h2>
<hr/>
<h2>Click <a href="samlsso?SAML2.HTTPBinding=HTTP-POST">here</a> to login with
    <asset:image src="saml2-logo.png" height="22" width="60"/> (Post Binding) from <asset:image src="identity_logo.gif" height="20" width="120"/></h2>
<hr/>
<h2>Click <a href="openid?OpenId.ClaimedId=">here</a> to login with <asset:image src="openid-logo.svg" height="20" width="55"/> from
    <asset:image src="identity_logo.gif" height="20" width="120"/></h2>
<hr/>
<h2>Click <a href="openid?OpenId.ClaimedId=https://www.google.com/accounts/o8/id">here</a> to login with <asset:image src="google-openid.png" height="20" width="75"/></h2>
<hr/>
<fieldset>
    <legend>Login with your Claimed OpenID URI</legend>
    <form action="openid" method="post">
        <div align="center">
            <input type="text" name="OpenId.ClaimedId" size="30"/> <input type="submit" name="login" value="Login"/>
        </div>
    </form>
</fieldset>

</body>
</html>