/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.view.components;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.Enumeration;
import java.util.Hashtable;

import org.puremvc.java.demos.j2me.login.view.MainScreenMediator;
import org.puremvc.java.demos.j2me.login.model.vo.NameVO;

import org.puremvc.java.demos.j2me.login.model.vo.ItemDataVO;

public class MainScreen extends Form implements CommandListener
{
	private Command exitCommand;
	private MainScreenMediator mediator;

	public MainScreen(MainScreenMediator mediator, Hashtable items)
	{
		super("Main Screen");

		this.mediator = mediator;

		StringItem si = new StringItem(null, "Hello " + NameVO.getInstance().getName() + ". Welcome to the world of PureMVC and J2ME.");
		this.append(si);

		try
		{
			Enumeration e;
			int count = 0;
			ItemDataVO itemVo;

     		for (e = items.elements(); e.hasMoreElements();)
     		{
				itemVo = (ItemDataVO) e.nextElement();

				Image im = Image.createImage(itemVo.getUrl());

				ImageItem ii = new ImageItem(itemVo.getLabel(), im, Item.LAYOUT_NEWLINE_AFTER, itemVo.getLabel());
				this.append(ii);

				count++;
     		}
		}
		catch(Exception ee){}


		exitCommand = new Command("Exit", Command.EXIT, 1);
		this.addCommand(exitCommand);
		setCommandListener(this);
	}

	public void commandAction(Command command, Displayable displayable)
	{
		if(command == exitCommand)
        {
			mediator.EXIT();
		}
	}
}

