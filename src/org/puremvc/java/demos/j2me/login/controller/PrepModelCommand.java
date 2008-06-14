/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.controller;

import org.puremvc.java.demos.j2me.login.model.ItemDataProxy;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

public class PrepModelCommand extends SimpleCommand
{
    public void execute(INotification notification)
    {
        this.facade.registerProxy(new ItemDataProxy());
    }
}