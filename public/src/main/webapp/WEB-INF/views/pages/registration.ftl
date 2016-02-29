<#include "../templates/registrationTemplate.ftl">
<@registrationTemplate />
<#macro m_body>
<div class="authWrapper"><h1 class="title-h1">Открывай новое с нами!</h1>
    <p class="authWrapper__note">Исследуй огромный мир удивительных вещей. Заказывай товары и делись ими с
        друзьями.</p>
    <form action="/signup/" class="form " id="reg" method="post">
        <fieldset class="form__group">
            <label class="string optional form__label form__label__add">Имя и фамилия</label>
            <input class="string optional form__field" id="user_fullname" name="user[fullname]" size="50" type="text">
        </fieldset>
        <fieldset class="form__group">
            <label class="string required form__label form__label__add">Логин</label>
            <input class="string required form__field" id="user_login" name="user[login]" size="50" type="text">
        </fieldset>
        <fieldset class="form__group">
            <label class="email optional form__label form__label__add">E-mail</label>
            <input class="string email optional form__field" id="user_email" name="user[email]" size="50" type="email">
        </fieldset>
        <fieldset class="form__group">
            <label class="password optional form__label form__label__add">Пароль</label>
            <input class="password optional form__field" id="user_password" name="user[password]" size="50"
                   type="password">
        </fieldset>
        <fieldset class="form__group-submit">
            <input class="btn_reg hvr-fade" name="commit" type="submit" value="Зарегистрироваться">
        </fieldset>
    </form>
</div>
</#macro>