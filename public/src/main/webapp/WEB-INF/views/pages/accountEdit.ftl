<#include "../templates/baseTemplate.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<@baseTemplate title="Редактировать - DearThings"/>
<#macro m_body>

    <#include "../parts/userNavbar.ftl">

<div class="authWrapper"><h1 class="title-h1">Редактировать</h1>
    <div id="pre_edit_name" class="reg_error_info"></div>
    <div id="pre_name_success" class="reg_success_info"></div>

    <fieldset class="form__group">
        <label class="form__label form__label__add">Имя и фамилия</label>
        <input class="form__field js_edit_name" size="50" type="text" id="user_edit_name">
    </fieldset>

    <div id="pre_avatar_success" class="reg_success_info"></div>
    <fieldset class="form__group">
        <label class="form__label form__label__add">Аватар</label>
        <input class="form__field js_edit_avatar" size="50" id="user_edit_avatar">
    </fieldset>

    <div id="pre_edit_oldpass" class="reg_error_info"></div>
    <div id="pre_pass_success" class="reg_success_info"></div>
    <fieldset class="form__group">
        <label class="form__label form__label__add">Старый пароль</label>
        <input class="form__field" size="50" type="password" id="user_edit_oldpass">
    </fieldset>

    <div id="pre_edit_newpass" class="reg_error_info"></div>
    <fieldset class="form__group">
        <label class="form__label form__label__add">Новый пароль</label>
        <input class="form__field js_edit_password" size="50" type="password" id="user_edit_newpass">
    </fieldset>

    <div id="pre_edit_telephone" class="reg_error_info"></div>
    <div id="pre_tel_success" class="reg_success_info"></div>
    <fieldset class="form__group">
        <label class="form__label form__label__add">Телефон</label>
        <input class="form__field js_edit_telephone" size="50" id="user_edit_telephone">
    </fieldset>

    <div id="pre_address_success" class="reg_success_info"></div>
    <fieldset class="form__group">
        <label class="form__label form__label__add">Адрес доставки</label>
        <input class="form__field js_edit_address" size="50" id="user_edit_address" name="user_edit_address">
        <#include "../parts/addressAuto.ftl">
    </fieldset>


    <br>
    <br>

</div>


<#--<@form.form commandName="editForm" action="/edit" acceptCharset="UTF-8" method="post">-->

<#--<div class="authWrapper">-->
<#--<h1 class="title-h1">Редактировать</h1>-->
<#--<div class="reg_error_info">-->
<#--<@form.errors path="name"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Имя и фамилия</label>-->
<#--<@form.input path="name" cssClass="form__field" size="50"/>-->
<#--</fieldset>-->

<#--<div class="reg_error_info">-->
<#--<@form.errors path="avatar"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Аватар</label>-->
<#--<@form.input path="avatar" cssClass="form__field" size="50"/>-->
<#--</fieldset>-->

<#--<div class="reg_error_info">-->
<#--<@form.errors path="address"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Адрес</label>-->
<#--<@form.input path="address" cssClass="form__field" size="50"/>-->
<#--</fieldset>-->

<#--<div class="reg_error_info">-->
<#--<@form.errors path="phone"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Телефон</label>-->
<#--<@form.input path="phone" cssClass="form__field" size="50"/>-->
<#--</fieldset>-->

<#--<div class="reg_error_info">-->
<#--<@form.errors path="oldPassword"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Старый пароль</label>-->
<#--<@form.input path="oldPassword" cssClass="form__field" size="50"/>-->
<#--</fieldset>-->

<#--<div class="reg_error_info">-->
<#--<@form.errors path="newPassword"/>-->
<#--</div>-->
<#--<fieldset class="form__group">-->
<#--<label class="form__label form__label__add">Новый пароль</label>-->
<#--<@form.input path="newPassword" cssClass="form__field" size="50" />-->
<#--</fieldset>-->

<#--<fieldset class="form__group-submit">-->
<#--<input class="btn_reg hvr-fade" type="submit" value="Применить">-->
<#--</fieldset>-->

<#--</div>-->
<#--</@form.form>-->
</#macro>