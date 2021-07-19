package org.example.navigate;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

public enum AppPage {
    HOME_PAGE_EN("home.page.en"),
    HOME_PAGE_SK("webdriver.base.url");

    private String urlKey;

    AppPage(String urlKey) {
        this.urlKey = urlKey;
    }

    public String url(){
        return EnvironmentSpecificConfiguration.from(ConfiguredEnvironment.getEnvironmentVariables()).getProperty(urlKey);
    }

    @Override
    public String toString() {
        return urlKey;
    }
}
