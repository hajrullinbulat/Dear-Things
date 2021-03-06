<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<nav id="myNavmenu" class="navmenu navmenu-inverse navmenu-fixed-left offcanvas" role="navigation">
    <a class="navmenu-brand">Категории</a>
    <ul class="nav navmenu-nav">
    <#list categories as category>
        <li class="hvr-underline-from-right"><a href="/catalog?category=${category.id}">${category.name}</a></li>
    </#list>
    </ul>
</nav>


<div class="navbar navbar-inverse navbar-static-top">
    <div class="container margin-top">
        <a class="button hvr-grow-shadow" data-toggle="offcanvas" data-target="#myNavmenu" data-canvas="body"><i
                class="fa fa-bars"> Вещи</i></a>
        <div class="search">
            <input type="search" name="" placeholder="поиск" class="input"/>
            <input type="submit" name="" value="" class="submit"/>
        </div>

        <a href="/">
            <img class="header-icon" src="/resources/images/header.png">
        </a>

        <div class="tributton">

        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
            <a class="button button-first hvr-grow-shadow" id="log_but" data-toggle="modal" data-target="#modal-1"><i
                    class="fa fa-user"></i></a>
        </@sec.authorize>
        <@sec.authorize access="isAuthenticated()">
            <a href="/profile" class="button button-first hvr-grow-shadow"><i
                    class="fa fa-user"></i></a>
        </@sec.authorize>

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
            <form method="post" action="/j_spring_security_check" name="authForm" id="authForm">
                <div class="modal-body">
                    <div id="pre_log_email" class="reg_error_info log_error_info"></div>
                    <fieldset class="form__group">
                        <label class="form__label">Email</label>
                        <input class="form__field js_login_email" id="log_email" size="50" type="text"
                               name="j_username">
                    </fieldset>
                    <div id="pre_log_pass" class="reg_error_info log_error_info"></div>
                    <fieldset class="form__group">
                        <label class="form__label">Пароль</label>
                        <input class="form__field js_login_pass" id="log_pass" size="50" type="password"
                               name="j_password">
                    </fieldset>
                    <div class="checkbox_margin">
                        <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                        <label for="remember_me" class="checkbox_label">Запомнить меня</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <fieldset>
                        <input class="btn_log hvr-fade" name="commit" type="submit" value="Войти" id="commit">
                        <ul class="form-auth__additionalLinks">
                            <li><a href="/forgot">Забыли пароль?</a></li>
                            <li><a href="/signup">Еще не зарегистрированы?</a></li>
                            <li><a href="/activation">Не пришло подтверждение?</a></li>
                        </ul>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
