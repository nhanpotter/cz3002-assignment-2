package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.login.model.Person;
import org.apache.struts.login.service.LoginService;
import org.apache.struts2.StrutsTestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

public class LoginActionTest extends StrutsTestCase {
    // Dependencies
    private LoginService loginService = Mockito.mock(LoginService.class);

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Mock correct accounts
        Mockito.when(loginService.authenticate(any(Person.class))).thenAnswer(
                invocationOnMock -> {
                    Person param = invocationOnMock.getArgument(0);
                    if (param.getUsername().equals("nhan") &&
                            (param.getPassword().equals("awesome"))) {
                        return true;
                    }
                    if (param.getUsername().equals("user") &&
                            (param.getPassword().equals("password"))) {
                        return true;
                    }
                    return false;
                }
        );
    }

    public void testExecuteValidationPasses() throws Exception {
        request.setParameter("person.username", "nhan");
        request.setParameter("person.password", "awesome");

        ActionProxy actionProxy = getActionProxy("/Login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();
        assertNotNull("The action is null but should not be.", action);

        // Mock loginService in loginAction
        LoginAction actionSpy = Mockito.spy(action);
        Mockito.doReturn(loginService).when(actionSpy).makeLoginService();

        String result = actionProxy.execute();
        assertEquals("The execute method did not return " +
                ActionSupport.SUCCESS + " but should have.", ActionSupport.SUCCESS, result);
    }

    public void testExecuteValidationFailsMissingUsername() throws Exception {
        request.setParameter("person.username", "nhan");

        ActionProxy actionProxy = getActionProxy("/Login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();
        assertNotNull("The action is null but should not be.", action);

        // Mock loginService in loginAction
        LoginAction actionSpy = Mockito.spy(action);
        Mockito.doReturn(loginService).when(actionSpy).makeLoginService();

        String result = actionProxy.execute();
        assertEquals("The execute method did not return " +
                ActionSupport.INPUT + " but should have.", ActionSupport.INPUT, result);
    }

    public void testExecuteValidationFailsMissingPassword() throws Exception {
        request.setParameter("person.password", "awesome");

        ActionProxy actionProxy = getActionProxy("/Login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();
        assertNotNull("The action is null but should not be.", action);

        // Mock loginService in loginAction
        LoginAction actionSpy = Mockito.spy(action);
        Mockito.doReturn(loginService).when(actionSpy).makeLoginService();

        String result = actionProxy.execute();
        assertEquals("The execute method did not return " +
                ActionSupport.INPUT + " but should have.", ActionSupport.INPUT, result);
    }
}
