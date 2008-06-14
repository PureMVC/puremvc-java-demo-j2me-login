/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.controller;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;
import org.puremvc.java.patterns.observer.Notification;

import org.puremvc.java.demos.j2me.login.ApplicationFacade;

import org.puremvc.java.demos.j2me.login.model.ItemDataProxy;
import org.puremvc.java.demos.j2me.login.model.vo.ItemDataVO;

import org.puremvc.java.demos.j2me.login.model.vo.NameVO;


public class ProcessLogin extends SimpleCommand implements ICommand
{
	private String[] url = new String[]{"/puremvc.png", "/java.png"};
	private String[] data = new String[]{"PureMVC", "Java J2ME"};

    public void execute(INotification notification)
    {
		String[] params = (String[])notification.getBody();

		if(params[1].equals("puremvc"))
		{
			//Add Name to singleton NameVO object
			NameVO name = NameVO.getInstance();
			name.setName(params[0]);

			//Add some ItemDataVO objects using proxy
			ItemDataProxy itemProxy = (ItemDataProxy)facade.retrieveProxy(ItemDataProxy.NAME);
			for(int i=0; i<url.length;i++)
			{
				ItemDataVO item = new ItemDataVO(url[i], data[i]);
				itemProxy.addItem(item);
			}

			this.facade.notifyObservers(new Notification(ApplicationFacade.LOGIN_SUCCESSFUL, null, null));
		}
		else
		{
			this.facade.notifyObservers(new Notification(ApplicationFacade.LOGIN_FAIL, null, null));
		}

    }
}