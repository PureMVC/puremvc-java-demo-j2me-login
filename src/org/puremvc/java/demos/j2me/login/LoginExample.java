/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

/*
* LoginExample.java
*/

package org.puremvc.java.demos.j2me.login;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LoginExample extends MIDlet
{
    private Display display;

	private ApplicationFacade facade = ApplicationFacade.getInst();

    public LoginExample()
    {
    	display = Display.getDisplay(this);
    }

	public Display fetchDisplay()
	{
		return display;
	}

    protected void destroyApp(boolean unconditional)
    {

    }

    protected void pauseApp()
    {

    }


    protected void startApp()throws MIDletStateChangeException
    {
		this.facade.startup(this);
    }

	public void exitApp()
	{
		destroyApp(false);
        notifyDestroyed();
	}

}

