/*
  Login Example - J2ME / PureMVC Example
  Copyright(c) 2008 Jari Kemppinen <jari@viddem.com>
  Your reuse is governed by the Creative Commons Attribution 3.0 License
 */

/*
Multiple value objects can be created utilising a proxy.
*/
package org.puremvc.java.demos.j2me.login.model.vo;

public class ItemDataVO {

    private String url = "";
    private String label = "";

    public ItemDataVO(String url, String label)
    {
        if (url != null)
            this.url = url;
        if (label != null)
            this.label = label;
    }

    public ItemDataVO()
    {

    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}