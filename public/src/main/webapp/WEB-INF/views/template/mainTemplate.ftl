<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#macro mainTemplate title="Paraglides">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" media="screen" href="<@c.url value="/resources/css/bootstrap.css"/>" />
        <link rel="stylesheet" type="text/css" media="screen" href="<@c.url value="/resources/css/font-awesome.css"/>" />
        <link rel="stylesheet" type="text/css" media="screen" href="<@c.url value="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"/>" />
        <link rel="stylesheet" type="text/css" media="screen" href="<@c.url value="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"/>" />
        <link rel="stylesheet" type="text/css" media="screen" href="<@c.url value="/resources/css/my.css"/>" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="/resources/js/bootstrap.js"></script>
        <script src="/resources/js/my.js"></script>
    </head>

    <body>
        <div class="main">
            <#include "header.ftl"/>
            <#include "carousel.ftl"/>
            <@m_body/>
        </div>
    </body>
</html>
</#macro>