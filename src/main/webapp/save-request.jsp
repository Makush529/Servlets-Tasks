<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Ввод заявки</title>
</head>
<body>
<h1>Форма подачи заявки</h1>
<form action="/save-request" method="post">
    <div>
        <label for="fullName">ФИО:</label>
        <input type="text" id="fullName" name="fullName" required />
    </div>
    <div>
        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" required />
    </div>
    <div>
        <label for="phone">Телефон:</label>
        <input type="tel" id="phone" name="phone" pattern="[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$" required />
    </div>
    <button type="submit">Отправить заявку</button>
</form>
</body>
</html>