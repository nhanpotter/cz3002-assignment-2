package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

public class LoginActionTest extends StrutsTestCase {
    @Test
    public void testExecuteValidationPasses() throws Exception {
        request.setParameter("person.username", "nhan");
        request.setParameter("person.password", "awesome");

        ActionProxy actionProxy = getActionProxy("/Login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();

        assertNotNull("The action is null but should not be.", action);
    }
}
