<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>${auth_frame_caption}</title>
</head>
<body>
<form style="zoom: 100%" method="post" action="auth">
<table align="center">
    <tr>
        <td colspan="2" align="center"><h1>${app_name} / ${auth_frame_caption}</h1></td>
    </tr>
    <tr>
        <td>
            <label>Login</label>
        </td>
        <td>
            <input type="text" name="login">
        </td>
    </tr>
    <tr>
        <td>
            <label>Password</label>
        </td>
        <td>
            <input type="password" name="pass">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button name="submit_button">submit</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
