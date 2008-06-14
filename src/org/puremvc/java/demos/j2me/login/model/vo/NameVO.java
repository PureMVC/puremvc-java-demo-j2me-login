/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

/*
Singleton Value Object
*/

package org.puremvc.java.demos.j2me.login.model.vo;

public class NameVO
{
	private static NameVO instance = null;
	private String name = "";

	public NameVO()
	{

	}

	public static NameVO getInstance()
	{
		if(instance == null)
		{
			instance = new NameVO();
		}

		return instance;
	}

	public void setName(String name)
	{
		if(name != null)
			this.name = name;
	}

	public String getName()
	{
		return name;
	}

}