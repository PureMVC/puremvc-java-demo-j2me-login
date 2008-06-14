/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.controller;

import org.puremvc.java.patterns.command.MacroCommand;

public class StartupCommand extends MacroCommand
{
	protected void initializeMacroCommand()
	{
		addSubCommand(PrepViewCommand.class);
		addSubCommand(PrepModelCommand.class);
	}
}
