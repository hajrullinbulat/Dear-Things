<#include "../templates/cartTemplate.ftl">
<@cartTemplate />
<#macro m_body>

<div class="container things">
    <div class="row">
        <div class="container">
            <h1 class="cart_title" align="center">А это Ваша корзина</h1>


            <form action="post">
                <div class="container cart_product">
                    <div class="col-lg-3">
                        <div class="cart_product_image">
                            <img src="/resources/images/1.jpeg">
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <h1>Umbra Панно для фотографий Gridart дерево</h1>
                        <div class="cart_product_info">
                            <div class="cart_product_cost">2 700 $</div>
                            <div class="cart_product_company"><a href="#">Enjoy me</a></div>
                        </div>
                        <p><a href="#" class="cart_btn_del hvr-buzz-out">
                            Удалить из корзины</a>
                        </p>
                        <div class="cart_product_description">
                            Панно для фотографий Motto позволит в одном месте хранить все Ваши любимые снимки.
                            Панно вмещает три фотографии размером 12,7 х 17,8 см
                            Одну фотографию 10,2 х 15,2 см
                            И три снимка 12,7 х 12,7 см
                            Разместите самые яркие и запоминающиеся кадры из жизни и они будут поднимать Вам настроение
                            очень
                            долгое время!))
                            Крепится на стену при помощи стандартных дюбелей.
                        </div>
                    </div>
                </div>
            </form>
            <form action="post">
                <div class="container cart_product">
                    <div class="col-lg-3">
                        <div class="cart_product_image">
                            <img src="/resources/images/1.jpeg">
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <h1>Umbra Панно для фотографий Gridart дерево</h1>
                        <div class="cart_product_info">
                            <div class="cart_product_cost">2 700 $</div>
                            <div class="cart_product_company"><a href="#">Enjoy me</a></div>
                        </div>
                        <p><a href="#" class="cart_btn_del hvr-buzz-out">
                            Удалить из корзины</a>
                        </p>


                        <div class="cart_product_description">
                            Панно для фотографий Motto позволит в одном месте хранить все Ваши любимые снимки.
                            Панно вмещает три фотографии размером 12,7 х 17,8 см
                            Одну фотографию 10,2 х 15,2 см
                            И три снимка 12,7 х 12,7 см
                            Разместите самые яркие и запоминающиеся кадры из жизни и они будут поднимать Вам настроение
                            очень
                            долгое время!))
                            Крепится на стену при помощи стандартных дюбелей.
                        </div>
                    </div>
                </div>
            </form>


            <div class="order btn_buy hvr-fade">
                Оформить заказ
            </div>

        </div>
    </div>
</div>


</#macro>