package org.apache.struts.login.service;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

public class LoginServiceTest extends StrutsTestCase {
    @Test
    public void testConnection() throws Exception {
        LoginService service = new LoginService();
        service.getConnection();
    }
}
