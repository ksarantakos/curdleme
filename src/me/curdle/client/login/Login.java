package me.curdle.client.login;

import me.curdle.shared.FieldVerifier;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
  private final LoginServiceAsync loginService = GWT.create(LoginService.class);

  private TextBox textBoxUsername;
  private PasswordTextBox passwordTextBox;

  private Button signInButton;

  public Login() {

    VerticalPanel verticalPanel = new VerticalPanel();
    initWidget(verticalPanel);

    Label lblSignIntoYour = new Label("Sign into your account");
    lblSignIntoYour.setStyleName("gwt-Label-Login");
    verticalPanel.add(lblSignIntoYour);

    FlexTable flexTable = new FlexTable();
    verticalPanel.add(flexTable);

    Label lblUsername = new Label("Username:");
    lblUsername.setStyleName("gwt-Label-Login");
    flexTable.setWidget(0, 0, lblUsername);

    textBoxUsername = new TextBox();
    flexTable.setWidget(0, 1, textBoxUsername);

    Label lblPassword = new Label("Password:");
    lblPassword.setStyleName("gwt-Label-Login");
    flexTable.setWidget(1, 0, lblPassword);

    passwordTextBox = new PasswordTextBox();
    flexTable.setWidget(1, 1, passwordTextBox);

    CheckBox chckbxRememberMe = new CheckBox("Remember me");
    chckbxRememberMe.setStyleName("gwt-Checkbox-Login");
    flexTable.setWidget(2, 1, chckbxRememberMe);

    signInButton = new Button("New button");
    signInButton.addClickHandler(new LoginClickHandler());

    signInButton.setText("Sign In");
    flexTable.setWidget(3, 1, signInButton);
  }

  private class LoginClickHandler implements ClickHandler, KeyUpHandler {
    /**
     * Fired when the user clicks on the sendButton.
     */
    public void onClick(ClickEvent event) {
      sendNameToServer();
    }

    /**
     * Fired when the user types in the nameField.
     */
    public void onKeyUp(KeyUpEvent event) {
      if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
        sendNameToServer();
      }
    }

    /**
     * Send the name from the nameField to the server and wait for a response.
     */
    private void sendNameToServer() {
      String textToServer = textBoxUsername.getText();
      if (!FieldVerifier.isValidName(textToServer)) {
        Window.alert("Username or password is empty.");
        return;
      }
      // Then, we send the input to the server.
      signInButton.setEnabled(false);

      loginService.loginServer(textToServer, passwordTextBox.getText(), new AsyncCallback<String>() {
        public void onFailure(Throwable caught) {
          // Show the RPC error message to the user
          Window.alert("Remote Procedure Call - Failure");
        }

        public void onSuccess(String result) {
          Window.alert("Remote Procedure Call - Success");
        }
      });
    }

  }
}
