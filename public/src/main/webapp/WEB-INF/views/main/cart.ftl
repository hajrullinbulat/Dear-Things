<#include "../template/cartTemplate.ftl">
<@cartTemplate />
<#macro m_body>

<div class="container">
    <div class="row">

        <div class="col-lg-3">
            <div class="thumbnail">
                <img src="http://placehold.it/300x240">

                <div class="caption">
                    <h3><a href="#">Spirit</a></h3>

                    <p>производитель NOVA (AUSTRIA) 2009г/в.</p>
                    <input type="submit" class="btn btn-danger" value="Удалить" name="addToTrash">
                </div>
            </div>
        </div>

        <div class="col-lg-3">
            <div class="thumbnail">
                <img src="http://placehold.it/300x240">

                <div class="caption">
                    <h3><a href="#">Spirit</a></h3>

                    <p>производитель ADVANCE (SWITZERLAND) 2006г/в</p>
                    <input type="submit" class="btn btn-danger" value="Удалить" name="addToTrash">
                </div>
            </div>
        </div>

        <div class="col-lg-3">
            <div class="thumbnail">
                <img src="http://placehold.it/300x240">

                <div class="caption">
                    <h3><a href="#">Spirit</a></h3>

                    <p>производитель A.S.A. (RUSSIA) 2012г/в</p>
                    <input type="submit" class="btn btn-danger" value="Удалить" name="addToTrash">
                </div>
            </div>
        </div>

        <div class="col-lg-3">
            <div class="thumbnail">
                <img src="http://placehold.it/300x240">

                <div class="caption">
                    <h3><a href="#">Spirit</a></h3>

                    <p>производитель AXIS (CZECH REPUBLIC) 2011г/в</p>
                    <input type="submit" class="btn btn-danger" value="Удалить" name="addToTrash">
                </div>
            </div>
        </div>

        <div class="col-lg-3">
            <div class="thumbnail">
                <img src="http://placehold.it/300x240">

                <div class="caption">
                    <h3><a href="#">Spirit</a></h3>

                    <p>производитель GRADIENT (CZECH REPUBLIC)2002 г/в</p>
                    <input type="submit" class="btn btn-danger" value="Удалить" name="addToTrash">
                </div>
            </div>
        </div>
    </div>
</div>

<input type="submit" class="btn btn-success btn-lg btn-block" value="Купить" name="buy"/>

</#macro>