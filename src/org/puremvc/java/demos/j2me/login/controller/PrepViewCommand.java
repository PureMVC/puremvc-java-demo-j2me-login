/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.controller;

import org.puremvc.java.demos.j2me.login.view.SplashScreenMediator;
import org.puremvc.java.demos.j2me.login.view.LoginScreenMediator;
import org.puremvc.java.demos.j2me.login.view.MainScreenMediator;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

public class PrepViewCommand extends SimpleCommand implements ICommand
{
    public void execute(INotification notification)
    {
		this.facade.registerMediator(new SplashScreenMediator());
        this.facade.registerMediator(new LoginScreenMediator());
        this.facade.registerMediator(new MainScreenMediator());
    }
}
