import grails.core.GrailsApplication
import org.wso2.carbon.identity.sso.agent.SSOAgentConstants
import org.wso2.carbon.identity.sso.agent.SSOAgentException
import org.wso2.carbon.identity.sso.agent.bean.SSOAgentConfig
import org.wso2.carbon.identity.sso.agent.saml.SSOAgentX509Credential
import org.wso2.carbon.identity.sso.agent.saml.SSOAgentX509KeyStoreCredential
import org.wso2.sample.is.sso.agent.SampleAttributesRequestor

class BootStrap {
    GrailsApplication grailsApplication
    def init = { servletContext ->

         def grailsConfig = grailsApplication.config
         try {

             InputStream keyStoreInputStream = this.class.classLoader.getResourceAsStream("wso2carbon.jks")
             SSOAgentX509Credential credential =
             new SSOAgentX509KeyStoreCredential(keyStoreInputStream,
             grailsConfig.getProperty("KeyStorePassword").toCharArray(),
             grailsConfig.getProperty("IdPublicCertAlias"),
             grailsConfig.getProperty("PrivateKeyAlias"),
             grailsConfig.getProperty("PrivateKeyPassword").toCharArray());
             SSOAgentConfig config = new SSOAgentConfig();

             config.initConfig(grailsConfig.toProperties());
             config.getSAML2().setSSOAgentX509Credential(credential);
             config.getOpenId().setAttributesRequestor(new SampleAttributesRequestor());
             servletContext.setAttribute(SSOAgentConstants.CONFIG_BEAN_NAME, config);
             //adding the SAML2.IdPURL into the servletcontext so that can retrieve from SSOAgentSampleFilter instead
             // of that filter class having a dependency on the SampleContextEventListener (now defunct) properties.
             servletContext.setAttribute("SAML2.idPURL",grailsConfig.getProperty("SAML2.IdPURL"));
         } catch (IOException e){
         log.error( e.getMessage(), e);
         } catch (SSOAgentException e) {
         log.error( e.getMessage(), e);
         }

    }
    def destroy = {
    }
}
