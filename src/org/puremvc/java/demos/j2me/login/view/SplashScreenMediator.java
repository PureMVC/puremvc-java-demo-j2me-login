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
import org.puremvc.java.demos.j2me.login.view.components.SplashScreen;

public class SplashScreenMediator extends Mediator
{
	public static final String NAME = "SplashScreenMediator";

	public SplashScreenMediator()
	{
		super(NAME, null);
	}

	public void GOTOMAIN()
	{
		this.facade.notifyObservers(new Notification(ApplicationFacade.LOGIN, null, null));
	}

	private SplashScreen getSplashScreen()
	{
		return new SplashScreen(this);
	}

	public String[] listNotificationInterests()
	{
		return new String[] {ApplicationFacade.STARTUP};
	}

	public void handleNotification(INotification note)
	{
		if(note.getName().equals(ApplicationFacade.STARTUP))
		{
			ApplicationFacade.midlet.fetchDisplay().setCurrent(getSplashScreen());
		}
	}
}