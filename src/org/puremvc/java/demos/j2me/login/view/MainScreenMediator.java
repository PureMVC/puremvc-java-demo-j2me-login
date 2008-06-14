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
import org.puremvc.java.demos.j2me.login.view.components.MainScreen;

import org.puremvc.java.demos.j2me.login.model.ItemDataProxy;
import org.puremvc.java.demos.j2me.login.model.vo.ItemDataVO;

public class MainScreenMediator extends Mediator
{
	public static final String NAME = "MainScreenMediator";
	private MainScreen mainScreen = null;

	public MainScreenMediator()
	{
		super(NAME, null);
	}

	private MainScreen getMainScreen(ItemDataProxy itemProxy)
	{
		if(mainScreen == null)
			mainScreen = new MainScreen(this, itemProxy.getItems());

		return mainScreen;
	}

	public void EXIT()
	{
		ApplicationFacade.midlet.exitApp();
	}

	public String[] listNotificationInterests()
	{
		return new String[] {ApplicationFacade.MAIN, ApplicationFacade.LOGIN_SUCCESSFUL};
	}

	public void handleNotification(INotification note)
	{

		if(note.getName().equals(ApplicationFacade.LOGIN_SUCCESSFUL))
		{
			ItemDataProxy itemProxy = (ItemDataProxy)facade.retrieveProxy(ItemDataProxy.NAME);
			ApplicationFacade.midlet.fetchDisplay().setCurrent(getMainScreen(itemProxy));
		}
	}
}