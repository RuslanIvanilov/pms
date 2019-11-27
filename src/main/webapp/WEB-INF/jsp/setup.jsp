<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>${settings_frame_title}</title>

</head>
<body>

<form style="zoom: 200%" method="post" action="setup_save">
    <h2>${settings_name}</h2>

<table>
    <tr>
        <td>
            <label style="color:green;font-size: 10px;">${main_frame_template_path}
            </label>
        </td>
        <td colspan="4"><input style="width: 300%; font-size: 9px;" type="text" id="template_path" name="template_path" value="${main_frame_template_path_value}"></td>
    </tr>

    <tr>
        <td>
            <label style="color:blue;font-size: 10px;">${main_frame_reports_path}
            </label>
        </td>
        <td colspan="4"><input style="width: 300%; font-size: 9px;" type="text" id="reports_path" name="reports_path" value="${main_frame_reports_path_value}"></td>
    </tr>

    <tr>
        <td>
            <label style="font-size: 10px;">${main_frame_use_local_path}
            </label>
        </td>
        <td colspan="4"><input style="width: 30%;font-size: 9px;" type="text" name="${main_frame_use_local_path}" value="${main_frame_use_local_path_value}"></td>
    </tr>

    <tr>
        <td colspan="4" align="right"  height="50">
            <button style="font-size: 8px;" id="setup_back" onclick="window.history.go(-1); return false;">${back_button}</button>
            <button style="font-size: 8px;" id="setupSave" action="setup_save">${save_button}</button>
        </td>
    </tr>

</table>


</form>

</body>
</html>
