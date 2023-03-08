package com.tiger;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.repeater.RepeatingView;


public class Topic extends WebMarkupContainer{
	
	public String selectedButtonId;
	public String imageContainerId;
	public String topicId;
	public ImagePickerButton previousButton;
	public ImagePickerButton firstButton;
	public ImagePickerButton currentButton;
	public int waitTime = 0;
	public int number;
	public Topic(String id , String[] images, String title, String italy, String[] p, String[] ul,String url) {
		super(id);
		topicId = "topic"+CurrentValues.topicNumber;
		this.setOutputMarkupId(true);
		this.setMarkupId(topicId);
		add(new Label("work-title",title));
		add(new Label("italic-section",italy));
		add(new GitLink("gitlink",url));
		number = CurrentValues.topicNumber;
		WebMarkupContainer background = new WebMarkupContainer("background");
		background.add(new Image("background-img","sale.jpg"));
		background.add(new AttributeModifier("class","background"+CurrentValues.topicNumber));
		add(background);
		
		
		CurrentValues.currentPositions.add("currentPosition"+topicId);
		Form formSlider = new Form("slider-form");
		formSlider.add(new NextImageButton("slider-prev",this,false,images.length));
		formSlider.add(new NextImageButton("slider-next",this,true,images.length));
		add(formSlider);
		
		RepeatingView paragraphs = new RepeatingView("work-p");
		add(paragraphs);
		for(int i=0; i<p.length; i++) {
			paragraphs.add(new Label("p"+CurrentValues.topicNumber + i,p[i]));
		}
		RepeatingView list = new RepeatingView("work-li");
		add(list);
		for(int i=0; i<ul.length; i++) {
			list.add(new Label("li"+CurrentValues.topicNumber+i,ul[i]));
		}
	

		
		WebMarkupContainer containerPlus = new WebMarkupContainer("container-plus");
		add(containerPlus);
		Image imagePhone = new Image("imgPhone","phone20.9.png");
		imagePhone.setOutputMarkupId(true);
		containerPlus.add(imagePhone);
		
		WebMarkupContainer containerSlide = new WebMarkupContainer("slide-container");
		containerPlus.add(containerSlide);
		containerSlide.setOutputMarkupId(true);
		
		
		WebMarkupContainer containerImages = new WebMarkupContainer("images-container");
		containerSlide.add(containerImages);
		String markupId = "image-container"+String.valueOf(CurrentValues.topicNumber);
		imageContainerId = markupId;
		containerImages.setMarkupId(markupId);
		
		Form form = new Form("button-form");
		containerPlus.add(form);
		
		form.add(new IntervalMover2(Duration.ofMillis(4000),this));
		
		RepeatingView rvSpan = new RepeatingView("span-image");
		containerSlide.add(rvSpan);
		RepeatingView rvShow = new RepeatingView("imgSlideShow");
		containerImages.add(rvShow);
		RepeatingView rvButton = new RepeatingView("button");
		form.add(rvButton);
		
		CurrentValues.buttonIds.add(new ArrayList<String>());
		
		
		for(int i=0; i<images.length; i++) {
			rvShow.add(new Image("imgSlideShow"+i,images[i]));
			rvSpan.add(new Label("span-image"+i));
			String buttonId = "button"+String.valueOf(i)+String.valueOf(CurrentValues.topicNumber);
			
			CurrentValues.buttonIds.get(CurrentValues.topicNumber).add(buttonId);
			
			final int margin = i * Constants.MARGIN_LEFT;
			ImagePickerButton button = new ImagePickerButton("button"+i,buttonId,this,margin,i);
			button.setMarkupId(buttonId);
			button.setOutputMarkupId(true);
			rvButton.add(button);
			
			if(i==0) {
				selectedButtonId = buttonId;
				firstButton = button;
				currentButton = firstButton;
			}
			
			if(previousButton != null) {
				previousButton.nextButton = button;
				button.previousButton = previousButton;
				if(i==images.length-1) {
					button.nextButton = firstButton;
					firstButton.previousButton = button;
				}
			}
			previousButton = button;
		}
		
		
		CurrentValues.topicNumber++;
	}
	
	
}
