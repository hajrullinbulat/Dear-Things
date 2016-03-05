<!--offcanvas здесь крч-->
<nav id="myNavmenu" class="navmenu navmenu-inverse navmenu-fixed-left offcanvas" role="navigation">
    <a class="navmenu-brand" href="#">Категории</a>
    <ul class="nav navmenu-nav">
        <li class="hvr-underline-from-right"><a href="#">Новый год!</a></li>
        <li class="hvr-underline-from-right"><a href="#">Подарки</a></li>
        <li class="hvr-underline-from-right"><a href="#">Для детей</a></li>
        <li class="hvr-underline-from-right"><a href="#">Для дома</a></li>
        <li class="hvr-underline-from-right"><a href="#">Офис</a></li>
        <li class="hvr-underline-from-right"><a href="#">Гаджеты</a></li>
        <li class="hvr-underline-from-right"><a href="#">Лайфстайл</a></li>
        <li class="hvr-underline-from-right"><a href="#">Обед с тобой</a></li>
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
            <a href="#" class="button button-first hvr-grow-shadow" data-toggle="modal" data-target="#modal-1"/><i class="fa fa-user"></i></a></li>
            <a href="#" class="button button-second hvr-grow-shadow"/><i class="fa fa-th"></i></a></li>
            <a href="#" class="button button-third hvr-grow-shadow"/><i class="fa fa-trash-o"></i></a></li>
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
                    <fieldset class="form__group">
                        <label class="string required form__label">Email</label>
                        <input class="string email optional form__field" id="email"
                               name="user[login_or_email]" size="50" type="text">
                    </fieldset>
                    <fieldset class="form__group">
                        <label class="string required form__label">Пароль</label>
                        <input class="string email optional form__field" id="pass"
                               name="user[login_or_email]" size="50" type="text">
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <fieldset>
                        <input class="btn_log hvr-fade" name="commit" type="submit" value="Войти">
                        <ul class="form-auth__additionalLinks">
                            <li><a href="#">Забыли пароль?</a></li>
                            <li><a href="#">Еще не зарегистрированы?</a></li>
                            <li><a href="#">Не пришло подтверждение?</a></li>
                        </ul>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
