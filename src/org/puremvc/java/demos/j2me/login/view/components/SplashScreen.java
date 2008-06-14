/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.view.components;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

import org.puremvc.java.demos.j2me.login.view.SplashScreenMediator;

public class SplashScreen extends Canvas
{
	private Timer timer = null;
	private TimerTask task = null;
	private Image image = null;
	private Command exitCommand;
	private ImageItem imageItem = null;
	private SplashScreenMediator mediator;

	private final String imageURL = "/puremvc.png";

	public SplashScreen(SplashScreenMediator mediator)
	{
		this.setFullScreenMode(true);
		this.mediator = mediator;

		try
		{
			image = Image.createImage(imageURL);
		}
		catch(Exception e){}

		timer = new Timer();
		task = new SplashTask();
		timer.schedule(task, 3000);
	}

    protected void paint(Graphics g)
    {
    	g.setColor(0xffffff);
    	g.fillRect (0, 0, getWidth (), getHeight ());
    	g.drawImage (image, getWidth () / 2, getHeight () / 2, Graphics.HCENTER | Graphics.VCENTER);
	}

	class SplashTask extends TimerTask
	{
		SplashTask(){}
		public void run()
		{
			mediator.GOTOMAIN();

			timer.cancel();
			task.cancel();
			timer = null;
			task = null;
			image = null;
			imageItem = null;
		}
	}
}

