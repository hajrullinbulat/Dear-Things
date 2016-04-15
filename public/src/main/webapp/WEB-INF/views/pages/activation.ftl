<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Выслать подтверждение - DearThings"/>
<#macro m_body>

<div class="authWrapper"><h1 class="title-h1">Не пришло подтверждение?</h1>
    <p class="authWrapper__note">Значит нужно попробовать еще раз! :)</p>
    <form action="/activation" class="form" method="post">
        <div id="pre_email_activ" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Введите email</label>
            <input class="form__field" size="50" type="email" id="user_email_activ">
        </fieldset>
        <div id="pre_pass_activ" class="reg_error_info"> </div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Пароль</label>
            <input class="form__field" size="50" type="password" id="user_pass_activ">
        </fieldset>
        <fieldset class="form__group-submit">
            <input class="btn_reg hvr-fade js_activation" type="submit" value="Выслать подтверждение">
        </fieldset>
        <br>
        <br>
    </form>
</div>
</#macro>