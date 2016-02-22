<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">Paraglide Club</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Купить <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Параплан</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Парамотор</a></li>
                        <li><a href="#">Подвеску</a></li>
                        <li><a href="#">Вариометр</a></li>
                        <li><a href="#">Шлем</a></li>
                        <li><a href="#">Запаску</a></li>
                        <li><a href="#">Одежду</a></li>
                        <li><a href="#">Аксессуары</a></li>
                    </ul>
                </li>
                <li><a href="/catalog">Все товары</a></li>
                <li>
                    <a href="/cart">Корзина</a>
                </li>
            </ul>

        <#if !(user!false)>
            <div class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control input-sm" placeholder="Логин" name="login">
                    <input type="text" class="form-control input-sm" placeholder="Пароль" name="pass">
                    <input type="checkbox" class="form-control" value="1" name="remember">
                </div>
                <button type="submit" class="btn btn-primary btn-sm">
                    <i class="fa fa-sign-in"></i> ВОЙТИ
                </button>
                <button type="submit" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modal-1">
                    <i class="fa fa-user-plus"></i> РЕГИСТРАЦИЯ
                </button>
            </div>
        <#else>
            <div class="navbar-form navbar-right">
                <div class="form-group form-control">
                    hajrullinbulat@gmail.com
                </div>
                <button type="submit" class="btn btn-danger">
                    <i class="fa fa-user-times"></i> ВЫЙТИ
                </button>
            </div>
        </#if>


        </div>
    </div>
</div>

<div class="modal fade" id="modal-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"><i class="fa fa-close"></i></button>
                <h4 class="modal-title">РЕГИСТРАЦИЯ</h4>
            </div>
            <form action="post" action="">
                <div class="modal-body">
                    <input type="text" class="form-control" placeholder="Логин" name="loginReg">
                    <br>
                    <input type="text" class="form-control" placeholder="Пароль" name="passReg">
                    <br>
                    <input type="text" class="form-control" placeholder="Еще раз пароль" name="passAgainReg">
                    <br>
                    <input type="text" class="form-control" placeholder="Ваш E-mail" name="emailReg">
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit" data-dismiss="modal">Зарегестрироваться</button>
                </div>
            </form>
        </div>
    </div>
</div>
