/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.view.components;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.StringItem;

import org.puremvc.java.demos.j2me.login.view.LoginScreenMediator;

public class LoginScreen extends Form implements CommandListener
{
	private Command exitCommand;
    private Command submitCommand;

    private TextField txtUserName;
    private TextField txtPassword;
    private StringItem message;


    private LoginScreenMediator mediator;

	public LoginScreen(LoginScreenMediator mediator)
	{
		super("Login");

		this.mediator = mediator;

		txtUserName = new TextField("Username:", "", 20, TextField.NON_PREDICTIVE);
		this.append(txtUserName);

		txtPassword = new TextField("Password:", "", 20, TextField. PASSWORD);
		this.append(txtPassword);
		txtPassword.setString("puremvc");

		message = new StringItem(null, "Enter your name as usename.");
		this.append(message);

		exitCommand = new Command("Exit", Command.EXIT, 1);
		submitCommand = new Command("Submit", Command.OK, 1);

		this.addCommand(exitCommand);
		this.addCommand(submitCommand);

		setCommandListener(this);
	}

	public void loginFail()
	{
		message.setText("Please enter puremvc as password! ");
	}

	public void commandAction(Command command, Displayable displayable)
	{
		if(command == exitCommand)
        {
			mediator.EXIT();
		}
		else if(command == submitCommand)
		{
			mediator.SUBMITLOGIN(txtUserName.getString(), txtPassword.getString());
		}
	}
}