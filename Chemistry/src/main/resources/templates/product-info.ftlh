<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h1></h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/admin/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<hr>
<form action="/admin/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>