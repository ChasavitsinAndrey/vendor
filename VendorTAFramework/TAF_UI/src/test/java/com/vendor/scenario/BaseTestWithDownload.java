package com.vendor.scenario;

import com.google.gson.JsonElement;
import com.vendor.ClientBaseImpl;
import com.vendor.IClient;
import com.vendor.WebDriverHolder;
import com.vendor.driver.DriverTypeChrome;
import com.vendor.environment.Environment;
import com.vendor.manager.WebDriverManager;
import com.vendor.manager.WebDriverManagerImpl;
import com.vendor.utils.Converter;
import com.vendor.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTestWithDownload extends BaseTest {

    private final String URI = DriverTypeChrome.getDriverService().getUrl().toString() + "/session/";
    protected IClient iclient = new ClientBaseImpl();
    public WebDriver driver;
    private WebDriverManager manager;

    public BaseTestWithDownload() {
        initialize();
    }

    private void initialize() {
        manager = new WebDriverManagerImpl();
        manager.setupWebDriver(Environment.browserName);
        driver = WebDriverHolder.getWebDriver();
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        List<String> paths = preparePathsList(((ChromeDriver) driver).getSessionId().toString(), "chromium/send_command");
        iclient.sendPostRequest(URI, paths, params, headers, prepareBody(), JsonElement.class);
    }

    private List<String> preparePathsList(String... paths) {
        return Arrays.asList(paths);
    }

    private JsonElement prepareBody() {
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        String coordinatesJsonFilePath = "D:\\old_proj\\car2go\\UberTestFramework-master\\sikuli_proj\\src\\main\\resources\\basic_props.json";
        String innerJson = JsonReader.readJsonAsString(coordinatesJsonFilePath);
        return Converter.convertToJsonElement(innerJson);


    }

}
