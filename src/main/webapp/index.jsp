<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h1>Welcome To Group 32 Login Page</h1>
<s:form action="Login">
  <s:textfield key="username"/>
  <s:password key="password"/>
  <s:submit/>
</s:form>
</body>
</html>