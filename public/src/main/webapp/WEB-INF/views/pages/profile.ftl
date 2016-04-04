<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Личный кабинет - DearThings"/>
<#macro m_body>

    <#include "../parts/userNavbar.ftl">

    <#list orders as order>
    <a href="/order/${order.id}">
        <div>${order.create_time}</div>
        <div>${order.total_sum}</div>
        <div>${order.total_count}</div>
        <div>${order.pay_type}</div>
        <div>${order.delivery_type}</div>
        <div>${order.addresses.id}</div>
        <div>${order.telephones.id}</div>
        <div>
            <#list order.orderGoods as good>
                <div>${good.goods.name}</div>
                <div>${good.count}</div>
            </#list>
        </div>

    </a>
    </#list>
</#macro>