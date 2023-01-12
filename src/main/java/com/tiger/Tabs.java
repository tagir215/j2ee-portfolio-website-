package com.tiger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Tabs extends WebMarkupContainer{
	Logger log;
	long startTime;
	Tabs(String id) {
		super(id);
		log = LoggerFactory.getLogger(HomePage.class);
    	String[] tabNames = new String[] {"Esittely","Työt","Yhteystiedot"};
    	String[] markupIds = new String[] {"about","works","contact"};
    	Image image = new Image("img-me","mee4.png");
    	add(image);
    	WebMarkupContainer container = new WebMarkupContainer("tabs-container");
    	add(container);
    	RepeatingView rvTabs = new RepeatingView("tab-form");
    	container.add(rvTabs);
     	for(int i=0; i<tabNames.length; i++) {
     		Form form = new Form("form"+i);
			TabButton tabButton = new TabButton("tab-input",markupIds[i]);
			tabButton.add(new AttributeModifier("value",tabNames[i]));
			form.add(tabButton);
			rvTabs.add(form);
    	}
	}
	class TabButton extends Button {
		@Override
		protected String getOnClickScript() {
			return "$([document.documentElement, document.body])"
					+ ".stop().animate({"
					+ "scrollTop: $('#"+markupId+"').offset().top"
					+ "    }, 400);";
		}
		String markupId;
		

		public TabButton(String id, String markupId) {
			super(id);			
			this.markupId = markupId;
		}
		
		
		

		
	}
}
