#language:ru

Функциональность: Перевод средств

  Сценарий: : Перевод средств с карты 2 на карту 1 (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код 'из смс' "12345"
    И происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'
    И пользователь переводит "5000" рублей на свою корту 1 со своей карты № 2
    Тогда баланс его карты № 1 должен стать 15000 рублей