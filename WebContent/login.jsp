<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>login</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
  </head>
  <body>
    <h1>Login</h1>
	 <form action="Login.do" method="POST">
		<p>Username: <input type="text" name="username"/></p>
		<p>Password: <input type="password" name="password"/></p>
		<p><input type="reset" value="Reimposta"/></p>
        <p><input type="submit" value="Login" name="login"/></p>
	</form>
  </body>
</html>
