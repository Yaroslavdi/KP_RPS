<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>

<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/admin/product/${product.id}">Подробнее...</a></p>

    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый продукт</h3>
<form action="/admin/product/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="title"/><br><br>
    Описание на странице продукта: <input type="text" name="description"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    Превью: <input type="file" name="file1"/><br><br>
    Дополнительная картинка 1: <input type="file" name="file2"/><br><br>
    Дополнительная картинка 2: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>