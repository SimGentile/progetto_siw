<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login</title>
    </head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" ></link>
  <body>
  <f:view>
	 <h:form>
		<div>Username: 
		<h:inputTextarea value="${controller.username}" required="true" id="username">
		<f:validateLength minimum="2" maximum="15"/>
		</h:inputTextarea>
		</div>
		<div> Password: <h:inputText value="${controller.password}"/></div>
        <div><h:commandButton value="Submit" action="${controller.findUtente}"/></div>
	</h:form>
	</f:view>
  </body>
</html>
