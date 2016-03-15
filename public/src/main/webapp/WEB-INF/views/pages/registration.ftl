<#include "../templates/registrationTemplate.ftl">
<@registrationTemplate />
<#macro m_body>

<div class="authWrapper"><h1 class="title-h1">Открывай новое с нами!</h1>
    <p class="authWrapper__note">Исследуй огромный мир удивительных вещей. Заказывай товары и рассказывайте о нас
        друзьям.</p>
    <form action="/signup/" class="form" id="reg" method="post">
        <div id="pre_name" class="reg_error_info">Формат: Костя Косточкин</div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Имя и фамилия</label>
            <input class="form__field" name="user_name" size="50" type="text" id="user_name">
        </fieldset>
        <div id="pre_email" class="reg_error_info">Формат: kostochkin@bones.com</div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">E-mail</label>
            <input class="form__field" name="user_email" size="50" type="email" id="user_email">
        </fieldset>
        <div id="pre_pass" class="reg_error_info">Пароли не совпадают</div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Пароль</label>
            <input class="form__field" name="user_pass" size="50" type="password" id="user_pass">
        </fieldset>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Пароль еще раз</label>
            <input class="form__field" name="user_pass_again" size="50" type="password" id="user_pass_again">
        </fieldset>
        <fieldset class="form__group-submit">
            <input class="btn_reg hvr-fade js_check" name="commit" type="submit" value="Зарегистрироваться">
        </fieldset>
    </form>
</div>
</#macro>