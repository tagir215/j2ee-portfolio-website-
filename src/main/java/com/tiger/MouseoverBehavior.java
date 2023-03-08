package com.tiger;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class MouseoverBehavior extends AjaxEventBehavior{
	String event;
	HomePage homepage;
	public MouseoverBehavior(String event, HomePage homepage) {
		super(event);
		this.event = event;
		this.homepage= homepage;
	}

	@Override
	protected void onEvent(AjaxRequestTarget arg0) {
		if(event.equals("mouseover")) {
			CurrentValues.userOnPage = true;
		} else {
			CurrentValues.userOnPage = false;
		}
	}
}
