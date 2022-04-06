package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishment {
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement action = $("[data-test-id=action-transfer]");
    private SelenideElement cancel = $("[data-test-id=action-cancel]");

    public DashboardPage transfer(String amount, String numberCard) {
        this.amount.shouldBe(visible, Duration.ofSeconds(10)).setValue(amount);
        from.setValue(numberCard);
        action.click();
        return new DashboardPage();
    }

    public DashboardPage cancel() {
        cancel.click();
        return new DashboardPage();
    }
}
