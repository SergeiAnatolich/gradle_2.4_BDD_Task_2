package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;
import ru.netology.page.CardReplenishment;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static CardReplenishment cardReplenishment;

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @И("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyDashboardPage() {
        dashboardPage.verifyIsDashboardPage();
    }

    @И("есть баланс карты 1")
    public void setBalance1() {
        dashboardPage.getCardBalance(0);
    }

    @И("есть баланс карты 2")
    public void setBalance2() {
        dashboardPage.getCardBalance(1);
    }

    @И("нажимает кнопку пополнить напротив первой карты")
    public void cardReplenishment1() {
        dashboardPage.transferFromCard2ToCard1();
    }

    @И("нажимает кнопку пополнить напротив второй карты")
    public void cardReplenishment2() {
        cardReplenishment = dashboardPage.transferFromCard1ToCard2();
    }

    @И("делает перевод на сумму {string} и с карты {string} и нажимает кнопку пополнить")
    public void cardReplenishmentPage(String amount, String numberCard) {
        cardReplenishment.transfer(amount, numberCard);
    }

    @Тогда("Возвращается на страницу 'Личный кабинет'")
    public void returnVerifyDashboardPage() {
        dashboardPage.verifyIsDashboardPage();
    }
}
