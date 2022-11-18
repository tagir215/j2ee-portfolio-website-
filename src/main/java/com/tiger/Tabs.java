package com.tiger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Tabs extends WebMarkupContainer{
	Logger log;
	long startTime;
	Tabs(String id) {
		super(id);
		log = LoggerFactory.getLogger(HomePage.class);
    	String[] tabNames = new String[] {"Works","About","Contact"};
    	String[] markupIds = new String[] {"works","about","contact"};
    	WebMarkupContainer container = new WebMarkupContainer("tabs-container");
    	add(container);
    	Form form = new Form("tab-form");
    	container.add(form);
    	RepeatingView rvTabs = new RepeatingView("tab-input");
    	form.add(rvTabs);
     	for(int i=0; i<tabNames.length; i++) {
			TabButton tabButton = new TabButton("tab-input"+i,markupIds[i]);
			tabButton.add(new AttributeModifier("value",tabNames[i]));
			rvTabs.add(tabButton);
    	}
	}
	class TabButton extends AjaxButton {
		String markupId;
		public TabButton(String id, String markupId) {
			super(id);
			this.markupId = markupId;
		}
		@Override
		protected void onSubmit(AjaxRequestTarget target) {
			super.onSubmit(target);
			target.appendJavaScript("$([document.documentElement, document.body])"
					+ ".animate({"
					+ "scrollTop: $('#"+markupId+"').offset().top"
					+ "    }, 400);");
			
		}

		
	}
}
