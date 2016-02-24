<#include "../templates/itemTemplate.ftl">
<@mainTemplate />
<#macro m_body>
<div class="container">
    <ul class="breadcrumbs">
        <li><a href="#">Все категории</a></li>
        <li><a href="#">Для дома</a></li>
    </ul>
    <form action="post">
        <div class="container product">
            <div class="col-lg-6">
                <div class="product_image">
                    <img src="/resources/images/6 big.jpeg">
                </div>
            </div>
            <div class="col-lg-6">
                <h1>Umbra Панно для фотографий Gridart дерево</h1>

                <div class="product_info">
                    <div class="product_cost">2 700 $</div>
                    <div class="product_company"><a href="#">Enjoy me</a></div>
                </div>
                <p><a href="#" class="btn_buy hvr-fade">
                    Добавить в корзину</a>
                </p>
                <div class="product_description">
                    Панно для фотографий Motto позволит в одном месте хранить все Ваши любимые снимки.
                    Панно вмещает три фотографии размером 12,7 х 17,8 см
                    Одну фотографию 10,2 х 15,2 см
                    И три снимка 12,7 х 12,7 см
                    Разместите самые яркие и запоминающиеся кадры из жизни и они будут поднимать Вам настроение очень
                    долгое время!))
                    Крепится на стену при помощи стандартных дюбелей.
                </div>
            </div>
        </div>
    </form>
</div>

<div class="products_same">

    <h1 align="center">Похожие товары</h1>

    <div class="container things">
        <div class="row">
            <div class="col-lg-3 hvr-grow ">
                <div class="thumbnail">
                    <img src="/resources/images/1.jpeg">
                    <div class="caption">
                        <p>Spirit , производитель NOVA (AUSTRIA) 2009г/в. </p>
                        <div align="right">
                            <input type="submit" class="btn btn-default" value=" 2 100 P " name="addToTrash">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 hvr-grow">
                <div class="thumbnail">
                    <img src="/resources/images/2.jpeg">

                    <div class="caption">
                        <p>Spirit , производитель NOVA (AUSTRIA) 2009г/в.</p>
                        <div align="right">
                            <input type="submit" class="btn btn-default" value=" 100 P " name="addToTrash">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 hvr-grow">
                <div class="thumbnail">
                    <img src="/resources/images/3.jpeg">

                    <div class="caption">
                        <p>Spirit , производитель NOVA (AUSTRIA) 2009г/в.</p>
                        <div align="right">
                            <input type="submit" class="btn btn-default" value=" 2 100 P " name="addToTrash">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 hvr-grow">
                <div class="thumbnail">
                    <img src="/resources/images/4.jpeg">

                    <div class="caption">
                        <p>Spirit , производитель NOVA (AUSTRIA) 2009г/в.</p>
                        <div align="right">
                            <input type="submit" class="btn btn-default" value=" 2 100 P " name="addToTrash">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>