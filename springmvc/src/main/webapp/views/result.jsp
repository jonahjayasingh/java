<%@page language="java" %>

<html>
    <body>
        <h2>Result is : <%= session.getAttribute("result") %></h2>
        <h2>Result is : ${result}</h2> 
        <a href="/">calculate</a>
    </body>
</html>
