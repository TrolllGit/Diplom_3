package base;

import api.BurgerApiClient;
import models.User;
import org.junit.After;
import org.junit.Before;
import utils.TestData;

public abstract class BaseApiTest extends BaseTest{
    protected BurgerApiClient apiClient;
    protected User user;
    protected String accessToken;

    @Before
    public void apiSetUp(){
        apiClient = new BurgerApiClient();
        user = TestData.randomUser();
        apiClient.register(user);
        accessToken = apiClient.login(user.getEmail(), user.getPassword());
    }

    @After
    public  void apiTearDown(){
        apiClient.deleteUser(accessToken);
    }
}
