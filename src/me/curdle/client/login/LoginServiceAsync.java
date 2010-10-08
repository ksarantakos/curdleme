package me.curdle.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginServiceAsync {
  void loginServer(String username, String password, AsyncCallback<String> callback) throws IllegalArgumentException;
}
