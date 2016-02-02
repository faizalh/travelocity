import org.springframework.boot.context.embedded.FilterRegistrationBean
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.core.Ordered
import org.wso2.carbon.identity.sso.agent.saml.SSOAgentHttpSessionListener
import org.wso2.sample.is.sso.agent.ForwardingServlet
import org.wso2.sample.is.sso.agent.SSOAgentSampleFilter

// Place your Spring DSL code here
beans = {
    //register the servlet from the wso2 example
    forwardServlet (ServletRegistrationBean,
           new ForwardingServlet(),
            "/samlsso") {
        loadOnStartup = 1
    }

    //register the filter from the wso2 example
    ssoAgentFilter (FilterRegistrationBean) {
       filter = bean(SSOAgentSampleFilter)
        urlPatterns = ['/samlsso','/openid','/token','/logout','/travelocity/home']
        order = Ordered.HIGHEST_PRECEDENCE
    }

    // register the seesionlistener
    ssoAgentSessionListener(ServletListenerRegistrationBean) {
        listener = bean(SSOAgentHttpSessionListener)
    }
}
