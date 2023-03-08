package com.tiger;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;

public class About extends WebMarkupContainer{

	public About(String id,String title,String p) {
		super(id);
		
		add(new Label("about-title",title));
		add(new Label("about-p",p));
	}
	
}
