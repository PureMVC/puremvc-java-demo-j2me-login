/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

package org.puremvc.java.demos.j2me.login.model;

import java.util.Enumeration;
import java.util.Hashtable;

import org.puremvc.java.patterns.proxy.Proxy;

import org.puremvc.java.demos.j2me.login.model.vo.ItemDataVO;

public class ItemDataProxy extends Proxy
{
    public static final String NAME = "ItemDataProxy";

    public ItemDataProxy()
    {
        super(NAME, new Hashtable());
    }

    public Hashtable getItems()
    {
        return (Hashtable) super.getData();
    }

    public void addItem(Object item)
    {
        Hashtable temp = getItems();
        temp.put(item.toString(), item);
    }
}