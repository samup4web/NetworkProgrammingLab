/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterclient;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

/**
 *
 * @author samup4web
 */
public class OAuth {

    public Twitter connectTwitter(String JTWITTER_OAUTH_SECRET, String JTWITTER_OAUTH_KEY, String username) {

        OAuthSignpostClient oauthClient = new OAuthSignpostClient(JTWITTER_OAUTH_KEY, JTWITTER_OAUTH_SECRET, "oob");
        oauthClient.authorizeDesktop();
        String pinCode = oauthClient.askUser("Please enter the verification PIN from Twitter");
        oauthClient.setAuthorizationCode(pinCode);
        //Object accessToken = oauthClient.getAccessToken();
        Twitter twitter = new Twitter(username, oauthClient);
        return twitter;
    }

    public static void main(String[] args) {
        // returns twitter from class Object
    }
}
