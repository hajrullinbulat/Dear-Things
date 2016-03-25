<!--offcanvas здесь крч-->
<nav id="myNavmenu" class="navmenu navmenu-inverse navmenu-fixed-left offcanvas" role="navigation">
    <a class="navmenu-brand" href="/catalog/1?category=1">Категории</a>
    <ul class="nav navmenu-nav">
    <#--<#list categories as category>-->
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=1">Все категории</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=2">Новый год </a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=3">Подарки</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=4">Для детей</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=5">Для дома</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=6">Офис</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=7">Гаджеты</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=8">Лайфстайл</a></li>
        <li class="hvr-underline-from-right"><a href="/catalog/1?category=11">Украшения</a></li>
    <#--</#list>-->
    </ul>
</nav>


<div class="navbar navbar-inverse navbar-static-top">
    <div class="container margin-top">
        <a href="#" class="button hvr-grow-shadow" data-toggle="offcanvas" data-target="#myNavmenu" data-canvas="body"/><i
            class="fa fa-bars"> Вещи</i></a></li>
        <div class="search">
            <input type="search" name="" placeholder="поиск" class="input"/>
            <input type="submit" name="" value="" class="submit"/>
        </div>

        <a href="#">
            <img class="header-icon" src="/resources/images/header.png">
        </a>

        <div class="tributton">

        <#if !user??>
            <a class="button button-first hvr-grow-shadow" data-toggle="modal" data-target="#modal-1"><i
                    class="fa fa-user"></i></a>
        <#else>
            <a href="/profile" class="button button-first hvr-grow-shadow"><i
                    class="fa fa-user"></i></a>
        </#if>

            <a href="/collections" class="button button-second hvr-grow-shadow"><i class="fa fa-th"></i></a>
            <a href="/cart" class="button button-third hvr-grow-shadow"><i class="fa fa-shopping-cart"></i></a>
        </div>
    </div>
</div>


<div class="modal fade" id="modal-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"><i class="fa fa-close"></i></button>
                <h4 class="modal-title">Войти, используя email и пароль</h4>
            </div>
            <form action="post" action="">
                <div class="modal-body">
                    <div id="pre_log_email" class="reg_error_info log_error_info"></div>
                    <fieldset class="form__group">
                        <label class="form__label">Email</label>
                        <input class="form__field" id="log_email" size="50" type="text">
                    </fieldset>
                    <div id="pre_log_pass" class="reg_error_info log_error_info"></div>
                    <fieldset class="form__group">
                        <label class="form__label">Пароль</label>
                        <input class="form__field" id="log_pass" size="50" type="password">
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <fieldset>
                        <input class="btn_log hvr-fade js_login" name="commit" type="submit" value="Войти">
                        <ul class="form-auth__additionalLinks">
                            <li><a href="#">Забыли пароль?</a></li>
                            <li><a href="/signup">Еще не зарегистрированы?</a></li>
                            <li><a href="#">Не пришло подтверждение?</a></li>
                        </ul>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
