<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <style type="text/css">
    .container {
        max-width: 500px;
        margin: auto;
    }
  </style>
  <s:head/>
</head>
<body>
<div class="container">
  <h1>Welcome To Group 32 Login Page</h1>
  <s:if test="hasActionErrors()">
    <div>
      <s:actionerror/>
    </div>
  </s:if>
  <s:form action="Login">
    <s:textfield name="person.username" label="Username"/>
    <s:password name="person.password" label="Password"/>
    <s:submit/>
  </s:form>
</div>
</body>
</html>