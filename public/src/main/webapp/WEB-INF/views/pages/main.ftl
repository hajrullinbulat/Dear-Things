<#include "../templates/mainTemplate.ftl">
<@mainTemplate />
<#macro m_body>

<div class="container things">
    <div class="row">
        <#include "../parts/item.ftl">
        <#list goods as good>
        <@item good=good />
    </#list>
    </div>
</div>

<div class="loader"><a href="/catalog" class="btn-loader">Показать все</a></div>

</#macro>