<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#macro baseTemplate title="...">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="html">
    <#include "../parts/head.ftl"/>

<body class="body">
<div>
    <#include "../parts/header.ftl"/>
    <@m_body/>
    <#include "../parts/footer.ftl"/>
</div>

    <#include "../parts/scripts.ftl" />

</body>
</html>
</#macro>