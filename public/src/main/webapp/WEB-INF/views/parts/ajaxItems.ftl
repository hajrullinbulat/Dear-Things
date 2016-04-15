<#include "../parts/item.ftl">
<#if goods?? && goods?has_content>
    <#list goods as good>
        <@item good=good />
    </#list>
</#if>