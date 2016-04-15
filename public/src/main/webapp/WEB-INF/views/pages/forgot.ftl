<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Восстановление аккаунта - DearThings"/>
<#macro m_body>

<div class="authWrapper"><h1 class="title-h1">Забыли пароль?</h1>
    <p class="authWrapper__note">Такое может пройзойти с каждым :)</p>
    <form action="/forgot" class="form" method="post">
        <div id="pre_email_forgot" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Введите email</label>
            <input class="form__field" size="50" type="email" id="user_email_forgot">
        </fieldset>
        <fieldset class="form__group-submit">
            <input class="btn_reg hvr-fade js_forgot" type="submit" value="Выслать пароль">
        </fieldset>
        <br>
        <br>
    </form>
</div>
</#macro>