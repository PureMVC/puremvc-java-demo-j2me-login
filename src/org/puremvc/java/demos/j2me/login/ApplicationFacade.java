/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login;

import org.puremvc.java.patterns.facade.Facade;
import org.puremvc.java.patterns.observer.Notification;

import org.puremvc.java.demos.j2me.login.controller.StartupCommand;
import org.puremvc.java.demos.j2me.login.controller.ProcessLogin;
import org.puremvc.java.demos.j2me.login.LoginExample;

public class ApplicationFacade extends Facade
{
	public static final String STARTUP = "startup";

	public static final String LOGIN = "login";
	public static final String SUBMIT_LOGIN = "submitLogin";
	public static final String LOGIN_SUCCESSFUL = "loginSuccessful";
	public static final String LOGIN_FAIL = "loginFail";

	public static final String MAIN = "main";

	//Startup command notifications
    public static final String PREP_MODEL = "prepModel";
    public static final String PREP_VIEW = "prepView";

	private static ApplicationFacade instance = null;

	public static LoginExample midlet;

	public static ApplicationFacade getInst()
	{

		if(instance == null)
		{
			instance = new ApplicationFacade();
		}

		return instance;
	}

	protected void initializeController()
	{
		super.initializeController();

		registerCommand(STARTUP, StartupCommand.class);
		registerCommand(SUBMIT_LOGIN, ProcessLogin.class);
	}

	public void startup(LoginExample midlet)
	{
		this.midlet = midlet;
		notifyObservers(new Notification(STARTUP, null, null));
	}
}