package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.network_configuration_tool.Login;
import com.solvd.laba.carina.homework.pages.network_configuration_tool.MainPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NetworkConfigurationToolTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "ivan")
    @TestPriority(Priority.P0)
    @TestLabel(name = "feature", value= {"login"})
    public void testLogin(){
        Login login = new Login(getDriver());
        login.open();
        Assert.assertTrue(login.isPageOpened());

        // First assert. By default, TELMEX has to be the username
        Assert.assertEquals(login.getEnteredUsername(), "TELMEX");

        login.enterPassword(R.CONFIG.get("passw"));
        MainPage mainPage = login.clickLoginButton();

        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened());

        Login backToLogin = mainPage.endSession();
        Assert.assertTrue(backToLogin.isPageOpened());
    }

    @Test
    @MethodOwner(owner = "ivan")
    @TestPriority(Priority.P0)
    @TestLabel(name="feature", value={"login", "Login blocking"})
    public void testLoginBlocking(){
        Login login = new Login(getDriver());
        login.open();
        Assert.assertTrue(login.isPageOpened());
        Assert.assertTrue(login.getEnteredUsername().equals("TELMEX"), "Default username is not shown");

        MainPage mainPage;
        for (int i = 0; i < 3; i++) {
            login.enterPassword("wrongpassword");
            mainPage = login.clickLoginButton();
            Assert.assertFalse(mainPage.isPageOpened(3), "Entered credentials are correct. Should change input data");
            login.waitForJSToLoad();
        }

        Assert.assertTrue(login.errorMessageExists(), "Login blocking failed");
    }
}
//La combinación de la usuario/contraseña es incorrecta. Favor de volver a intentarlo.
//Ha intentado muchas veces. Vuelva a intentarlo dentro de 59 segundos.