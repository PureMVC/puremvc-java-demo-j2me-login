/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.view;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;
import org.puremvc.java.patterns.observer.Notification;

import org.puremvc.java.demos.j2me.login.ApplicationFacade;
import org.puremvc.java.demos.j2me.login.view.components.LoginScreen;

public class LoginScreenMediator extends Mediator
{
	public static final String NAME = "LoginScreenMediator";

	private LoginScreen loginScreen = null;

	public LoginScreenMediator()
	{
		super(NAME, null);
	}

	public void SUBMITLOGIN(String user, String pass)
	{
		String[] details = new String[]{user,pass};

		this.facade.notifyObservers(new Notification(ApplicationFacade.SUBMIT_LOGIN, details, null));
	}

	public void EXIT()
	{
		ApplicationFacade.midlet.exitApp();
	}

	private LoginScreen getLoginScreen()
	{
		try
		{
			if(loginScreen == null)
			{
				loginScreen = new LoginScreen(this);
			}

			return loginScreen;
		}
		catch(Exception e){System.out.println(e.toString()); return null;}
	}

	public String[] listNotificationInterests()
	{
		return new String[] {ApplicationFacade.LOGIN, ApplicationFacade.LOGIN_FAIL};
	}

	public void handleNotification(INotification note)
	{
		if(note.getName().equals(ApplicationFacade.LOGIN))
		{
			ApplicationFacade.midlet.fetchDisplay().setCurrent(getLoginScreen());
		}
		else if(note.getName().equals(ApplicationFacade.LOGIN_FAIL))
		{
			getLoginScreen().loginFail();

		}
	}
}