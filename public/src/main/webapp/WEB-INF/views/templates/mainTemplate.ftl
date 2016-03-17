<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#macro mainTemplate title="DearThings">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <#include "../parts/head.ftl"/>


<body>
        <div>
            <#include "../parts/header.ftl"/>
            <#include "../parts/carousel.ftl"/>
            <@m_body/>
            <#include "../parts/footer.ftl"/>
        </div>

            <#include "../parts/scripts.ftl" />

    </body>
</html>
</#macro>