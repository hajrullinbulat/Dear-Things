<#-- @ftlvariable name="goods" type="java.util.List<ru.dz.labs.model.Goods>" -->
<#include "../template/catalogTemplate.ftl">
<@catalogTemplate />
<#macro m_body>




<div class="container">
    <div class="row">
        <#list goods as good>

            <div class="col-lg-3">
                <div class="thumbnail">
                    <img src="http://placehold.it/300x240">

                    <div class="caption">
                        <h3><a href="/item?id=${good.id}">${good.name}</a></h3>

                        <p>производитель NOVA (AUSTRIA) 2009г/в.</p>
                        <input type="submit" class="btn btn-success" value="В корзину" name="addToTrash">
                    </div>
                </div>
            </div>

        </#list>
    </div>
</div>

</#macro>