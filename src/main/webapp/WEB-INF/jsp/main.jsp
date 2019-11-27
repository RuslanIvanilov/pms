<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>${main_frame_title}</title>

    <script>
        function requestSelected(elementId) {
            var e = document.getElementById(elementId);
            var path = document.getElementById('reports_path').value+"/";
            //document.location.href="Mmenu?userid="+userid+"&module="+e.options[e.selectedIndex].value;
           //alert("file://"+path + e.options[e.selectedIndex].value);

           var result = "file://"+path + e.options[e.selectedIndex].value;
            alert(result)

            // window.open( "file://"+ path + e.options[e.selectedIndex].value )
           // window.location.href= "file://"+ path + e.options[e.selectedIndex].value

        }
    </script>
    <script>
        /*      --На всякий случай таймер для обновления
        var sentinel;

        function Timer(){
            sentinel = setTimeout(openFile, 3000);
        }
        */

        function openFile(fileName){
            var file = 'file://///opt/reports/'+fileName;
            window.open(file, "JReport");
        }

    </script>

    <style>
        select {
            width: 300px; /* Ширина списка в пикселах */
        }
    </style>
</head>
<body>
<!--
<form style="zoom: 200%"
      action='javascript:requestSelectedModule()'
      method="post"
>
-->
    <form style="zoom: 200%" method="post" action="setup">
<!-- <h2>${message}</h2>  -->

<table>
    <tr>
        <td> <label>${message}</label> </td>
        <td align="right">
           <!-- <button style="font-size: 8px;" id="setup_action" onclick="alert('Not have permission!')">${setup_admin_caption}</button>  -->
            <button style="font-size: 8px;" id="setup_action" action="setup">${setup_admin_caption}</button>
        </td>
    </tr>
    <tr>
        <td>
            <label style="color:green;font-size: 10px;">${templates_path_caption}</label>
            <input readonly style="width: 83%;font-size: 9px;" type="text" id="templates_path" value="${templates_path}">
        </td>

        <td>
            <label style="color:blue;font-size: 10px;" >${reports_path_caption}</label>
            <input readonly style="width: 86%;font-size: 9px;" type="text" id="reports_path" value="${reports_path}">
        </td>
    </tr>

<!-- <div style="width: 230px; overflow-x: none; overflow-y: none; height: 160px;">  -->
    <tr>
        <td>
            <select id="fileselect" size="11" class="select" onchange="requestSelected('fileselect)">
                <c:forEach var="listValue" items="${template_list}">
                <option selected value='${listValue}' class='option'>${listValue}</option>
                </c:forEach>
            </select>
        </td>

<!-- </div> file:///Users/ruaiar2/temp/reports/report12_123.html onclick=openFile('${listReportValue}')> ${listReportValue} </option> -->
       <td>
    <select id="reportselect" size="11" class="select">
            <c:forEach var="listReportValue" items="${report_list}">
                <option selected value='${listReportValue}' class='option' onclick='openFile("${listReportValue}")'> ${listReportValue} </option>
            </c:forEach>
    </select>
       </td>
    </tr>
</table>


    </form>
</body>
</html>
