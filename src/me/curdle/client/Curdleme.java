package me.curdle.client;

import me.curdle.client.login.Login;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Curdleme implements EntryPoint {

  
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network " + "connection and try again.";

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    RootPanel rootPanel = RootPanel.get();
    
    HorizontalPanel horizontalPanel = new HorizontalPanel();
    rootPanel.add(horizontalPanel, 10, 10);
    horizontalPanel.setSize("430px", "280px");
    
    VerticalPanel verticalPanel = new VerticalPanel();
    verticalPanel.setHeight("271px");
    horizontalPanel.add(verticalPanel);
    
    Label lblWelcomeToCurdleme = new Label("Welcome to curdle.me");
    lblWelcomeToCurdleme.setStyleName("gwt-Label-Login");
    verticalPanel.add(lblWelcomeToCurdleme);
    
    Login login = new Login();
    horizontalPanel.add(login);
  }
}
