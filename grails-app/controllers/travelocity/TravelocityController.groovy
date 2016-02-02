package travelocity

import org.wso2.carbon.identity.sso.agent.SSOAgentConstants
import org.wso2.carbon.identity.sso.agent.bean.LoggedInSessionBean
import org.wso2.carbon.identity.sso.agent.bean.SSOAgentConfig

class TravelocityController {

    def index() { }

    def logout() { }

    def home() {
        String subjectId
        Map<String, String> saml2SSOAttributes = null;
        // get the user info provided by the id server from the session.
        SSOAgentConfig ssoAgentConfig = (SSOAgentConfig)servletContext.getAttribute(SSOAgentConstants.CONFIG_BEAN_NAME);
        LoggedInSessionBean sessionBean = (LoggedInSessionBean)request.session.getAttribute(SSOAgentConstants.SESSION_BEAN_NAME);
        LoggedInSessionBean.AccessTokenResponseBean accessTokenResponseBean = null;
        if(sessionBean) {
            //get the user info.
            if(sessionBean.SAML2SSO) {
                subjectId = sessionBean.SAML2SSO.getSubjectId()
                saml2SSOAttributes = sessionBean.SAML2SSO.getSubjectAttributes()
                accessTokenResponseBean = sessionBean.SAML2SSO.getAccessTokenResponseBean()
            }
        }else {
            //put a message that a session was not found.
        }
        [sessionBean: sessionBean, subjectId: subjectId]

    }

    def data() { }
}
