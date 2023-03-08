package com.tiger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

public class GitLink extends Link {

	public GitLink(String id, String url) {
		super(id);
		// TODO Auto-generated constructor stub
		add(new AttributeModifier("href",url));
	}
	@Override
	public MarkupContainer setDefaultModel(IModel arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onClick() {
		// TODO Auto-generated method stub
	}
	
}
