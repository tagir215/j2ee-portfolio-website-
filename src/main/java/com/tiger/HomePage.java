package com.tiger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HomePage.class);
	int topicNumber=0;
	int skillnumber = 0;
	final int MARGIN_LEFT = -245;
	public boolean userOnPage=true;
	ArrayList<ArrayList<String>> buttonIds = new ArrayList<ArrayList<String>>(); 
	
	
	
	public HomePage(final PageParameters parameters) {
		super(parameters);	
	
		//add(new MouseoverBehavior("mouseover",this));
		//add(new MouseoverBehavior("mouseleave",this));
		
		Tabs tabs = new Tabs("bar-tabs");
		add(tabs);
		
		Image image = new Image("front-img","crocodile2.jpg");
		add(image);
		
		RepeatingView abouts = new RepeatingView("about");
		add(abouts);
		
		String aboutP = "Hei, tässä on portfolio koodaus projekteistani. Olen "
				+"pyrkinyt valitsemaan sekä itseä motivoivia, että kehittäviä "
				+ "töitä. Persoonani on sellainen, että motivoidun parhaiten "
				+ "haastavista projekteista, joten tein ensmmäisestä koodaus projektistani "
				+ "jo suhteellisen haastavan. En ole ehtinyt vielä harjoittelemaan nettisivujen tekemistä "
				+ "niin paljon, joten tämä portfolio on vielä vähän karkea, mutta yritän parannella sitä "
				+ "tulevaisuudessa. Olen oppinut paljon tämän 10kk "
				+ "aikana, mutta huomannut myös että on vieä paljon opittavaa.";
		abouts.add(new About("about","Portfolio 2022",aboutP));
		
		String experienceA= "Olen itse oppinut ja oppinut lähinnä projekteja tehdessä. Erilaiset "
				+ "tutoriaalit eivät yleensä jää pysyvästi mieleeni, joten opettelen asiat mielummin "
				+ "käytännössä. "
				+ "Tein kesällä myös n. kuukauden työharjoittelun/työvalmennuksen, "
				+ "jossa tein kolme erilaista "
				+ "harjoitus projektia. Minulla oli mentori joka tarkisteli koodejani joten opin "
				+ "paljon koodin muotoilusta ja sain lisäksi materiaalia sekä lukuvinkkejä. Olen opiskellut myös ammattikorkeakoulussa "
				+ "konetekniikkaa. Siellä opin matematiikkaa, elektroniikkaa, fysiikkaa sekä erilaisia cadeja "
				+ "";
		abouts.add(new About("about3","Opiskelut",experienceA));
		
		
		
		
		RepeatingView skillGraphs = new RepeatingView("skill-div");
		add(skillGraphs);
		
		
		String[] skills = new String[] {"Java","Kotlin","C#","Javascript","CSS","SQL"};
		int[] measures = new int[] {8,6,3,2,3,2};
		skillGraphs.add(new SkillGraph("skill-div1",skills,measures,"Koodaus"));
		
		String[] skills3 = new String[] {"Google Cloud","Heroku","Openshift","MySQL"};
		int[] measures3 = new int[] {4,2,1,2};
		skillGraphs.add(new SkillGraph("skill-div3",skills3,measures3,"Pilvi"));
		
		String[] skills2 = new String[] {"Android Studio","IntelliJ IDEA","Eclipse","Visual Studio","Unity","Apache Wicket"};
		int[] measures2 = new int[] {8,5,5,4,3,3};
		skillGraphs.add(new SkillGraph("skill-div2",skills2,measures2,"Framework/Ide"));
		
		
		String experienceP = "Minulla on tavallaan kokemusta koodaamisesta jo 12 vuotiaasta "
				+ "saakka. Vaikka en ole tehnyt varsinaista koodausta, olen tehnyt pelejä "
				+ "LittleBigPlanet ja Dreams pelinteko ohjelmilla. Oma tapani luoda pelejä "
				+ "näillä alustoilla oli aina koetella työkalujen rajoja ja yrittää rakentaa "
				+ "monimutkaisia tekoälyjä ja kontrolleja. En oikein edes pelaillut muita pelejä "
				+ "vaan käytin kaiken ajan näiden ohjelmien parissa. ";
		abouts.add(new About("about2","LittleBigPlanet?",experienceP));
		
		
		
		RepeatingView topics = new RepeatingView("topic");
		add(topics);
		
		
		String[] golfImages = new String[] {
				"golfpicture13.png","golfpicture14.png","golfpicture15.png",
				"golfpicture16.png"
		};
		String i1 = "C#, Unity, Xml, Google Cloud";
		String[] p1 = new String[] { 
				"GPS GOLF on AR peli kännykälle, joka käyttää "
				+ "GPS paikannusta pääpelimekaniikkanaan. Tarkoitus on golfata pallot lipputankoihin "
				+ "jotka päivittyvät satunnaisesti joka päivä. Kartalle on merkitty tähän mennessä "
				+ "kaikki Suomen tiet, jotka on tallennettu Xml tiedostoille Google Cloudiin. "
				+ "Tiedot on kerätty OpenStreetMap sivustolta. Pelimoottoina on Unity. " 
				};
		String[] ul1 = new String[] {
				"Tein pelille erillisen OSM xml datan muokkaus ohjelman Visual Studiota käyttäen, koska en löytänyt netistä vastinetta. Ohjelma "
				+ "käytti trie data struktuuria yhdistämään ja suodattamaan 15 miljoonaa Suomen teiden koordinaatteja sopivampaan "
				+ "muotoon (OSM datan tie merkinnöissä oli vain viittaukset varsinasiin koordinaatteihin).",
				"Tiet on piirretty 3D pallon muotoiselle objektille. 3D koordinaatit on laskettu mapallon säteen mukaan.",
				"Tiet on piirretty Unityn kolmioiden piirto työkaluilla tehden mahdollisimman yhtenäisiä mesh objekteja, "
				+ "jotta suorituskyky ei kärsisi.",
				"Peli objektien koot muokkautuvat kameran etäisyyden perusteella",
				"Tämä oli ensimmäinen koodaus projektini joten siinä meni noin 2 kuukautta. Opin yllättävän paljon data "
				+ "struktuureista sekä järjestely algoritmeista"
				
		};
		topics.add(new Topic("topic11",golfImages,"GPS GOLF",i1,p1,ul1));
		
		
		
		
		String[] mapImages = new String[] {
				"mappicture1.jpg","mappicture2.jpg","mappicture4.jpg","mappicture6.jpg"
		};
		String i2 = "Java, Android Studio, Xml, Json";
		String[] p2 = new String[] {
				"YourMindMap on ajatuskarttojen luontiin tarkoitettu sovellus. "
				+ "Sovelluksesta löytyy lukusisa asetuksia joissa käyttäjää on ajateltu "
				+ "antamalla hänelle mahdollisimman vapaat kädet. "
				+ "Kuitenkin pitämällä työkalut intuitiivisina ja helppokäyttöisinä. "
				+ "Sovelluksessa on rajoitettu erilaisten asetusikkunoiden navigointia "
				+ "pitämällä kaikki tiiviisti yhdessä paikassa.",
					"Sovelluksessa on kaikki vastaavien kilpailijasovellusten työkalut "
				+ "sekä mahdollisuus luoda yli viiden tuhannen "
				+ "solun ajatuskartoja. Ajatuskartta sommittautuu automaattisesti, joten "
				+ "käyttäjän ei tarvitse erikseen siirrellä soluja.  "
				};
		String[] ul2 = new String[] {
				"Ajatuskartan automaattinen tilan sommittelu. Kokeilin useita versioita, mutta päädyin laskemaan "
				+ "kaikki koordinaatit täysin matemaattisesti ja piirtämään kaiken canvakselle.",
				"Canvas ei piirrä karttaa joka ruudunpäivityksen jälkeen, vaan vain kun käyttäjä päästää irti "
				+ "esimerkiksi liikutettuuan karttaa. Bitmap itse siirtyy sormen mukana, mutta siirtyy takaisin "
				+ "paikoilleen sormen noustessa, jonka jälkeen piirtää kartan uudelleen, mutta ottaen siirretyn "
				+ "matkan huomioon",
				"Ajatuskartalla voi tehdä huonommallakin kännykällä yli 5 tuhannen solun karttoja ilman huomattavaa "
				+ "suorituskyvyn laskua.",
				"Suorakulmio valinta, ja monen solun muokkaaminen kerralla",
				"Viivan, laatikon, reuonojen muotojen, värien, ja viiva tyyppien editointi työkalut.",
				"Tekstien värien, fonttien, asettelu ja koon editointi työkalut, sekä kartan automaattinen sopeutuminen eri fontti- "
				+ "ja teksti-koko asetuksille",
				"Tallennus, undo ja redo komennont sekä useiden karttojen tallennus mahdollisuus",
				"Vienti mahdollisuuksia pdf, jpg tai png",
				"Zoom",
				"Haarakkeiden pakkaus työkalu",
				"Kopionti ja liittämistyökalut",
				"Keskittämis työkalu",
				"Kuvien lisäys mahdollisuus",
				"Tämän ohjelman tekoon minulla meni yli 4 kuukautta eikä se ole vieläkään ihan valmis. Opin paljon Android "
				+ "Studion työkaluja sekä Javan- ja olio-ohjelmoinnin perusteita. Aloitin projektin useaan kertaan alusta "
				+ "koska minulle tuli ongelmia suoristuskyvyn ja koodin sekavuuden kanssa. Vieläkin on paljon tekemistä "
				+ "työkalujen parantelussa ja koodin puhtaudessa, mutta yritän pian julkaista tämän myös App Storeen. "
		};
		topics.add(new Topic("topic12",mapImages,"Your Mind Map",i2,p2,ul2));
		
		
		
		
		String[] metronomeImages = new String[] {
				"picmetr1.jpg","picmetr2.jpg","picmetr3.jpg",
				"picmetr5.jpg","picmetr6.jpg",
		};
		String i3 = "Java, Android Studio, OpenGL, Fast Fourier Transform, YIN algorithm, Autocorrelation";
		String[] p3= new String[] { 
				"Visual Metronome on musiikin harjoitteluun tarkoitettu "
				+ "apuohjelma. Joillakin muusikoilla rytmitaju saattaa heikentyä "
				+ "soittaessa monimutkaisempia kuvioita, "
				+ "jolloin aivot priorisoi rytmin sijaan muita soitamiseen "
				+ "tarvittavaa keskittymistä. Tässä ongelmana on myös se, että "
				+ "itse soittaja ei välttämättä edes kuule omia rytmi ongelmiaan, ",
					" Visual Metronome pyrkii ratkaisemaan nämä ongelmat"
				+ "antamalla reaali aikaista selkeää feedbackiä, jolloin soittaja "
				+ "näkee virheet heti niiden tapahduttua."
				};
		String[] ul3 = new String[] {
				"Kokeilin erilaisia tapoja rytmien tunnistamiseen, kuten Fast Fourier transformia, Autocorrelaatiota sekä Yin algoritmia, "
				+ "mutta päädyin lopulta vain laskemaan nolla kohtien määrät, nopeuden vuoksi",
				"Sovellus aloittaa äänityken automaattisesti sekä toistaa soiton myös äänten hiljennyttä automaattisesti "
				+ "valitun viiveen jälkeen",
				"Ääniallot ja rytmi kuviot on mallinnettu käyttäen OpenGL:ää",
				"Rytmi kuviot muodostuvat y suunnassa suurempina, jos nollakohtien määrä muttuu paljon edelliseen nuottiin "
				+ "verrattuna, sekä taas keltaisena tai läpinäkyvän punaisena äänen amplitudin mukaan",
				"Ohjelma toimii hyvin kitaran kanssa, mutta toistaiseksi vielä vähän puutteellisesti esimerkiksi pianon kanssa, joten "
				+ "joitakin parannuksia pitää vielä tehdä",
				"Ylesiä asetuksia esim. playback odotusajalle ja temmolle, sekä tahtilajin muutoksille. ",
				"Tämän ohjelman tekemisessä suurin osa ajasta meni oikeastaan matematiikkaa opiskellessa. Tein tätä noin kuukauden, mutta "
				+ "saan tämän oikeastaan julkaistua ennen edellistä projektista, koska projektin koko on paljon pienempi."
		};
		topics.add(new Topic("topic13",metronomeImages,"Visual Metronme",i3,p3,ul3));
		
		
	
	}
	
	 
	
	@Override
	public void renderHead(IHeaderResponse response)
	{
		
	    super.renderHead(response);
	    StringBuilder stringBuilder1 = new StringBuilder();
	    stringBuilder1.append("window.onload = function(){");
	    List<String>initialButtons = new ArrayList<String>();
	    for(int i=0; i<buttonIds.size(); i++) {
	    	initialButtons.add(buttonIds.get(i).get(0));
	    }
	    for(int i=0; i<initialButtons.size(); i++) {
	    	stringBuilder1.append(getHighlightSelectedJs(initialButtons.get(i),"topic"+i));
	    }
	    
	    stringBuilder1.append("}");
	 	response.render(JavaScriptHeaderItem.forScript(stringBuilder1.toString()	,"ok"));
	   
	}
	
	private class SkillGraph extends WebMarkupContainer{

		public SkillGraph(String id, String[] skills, int[] measures, String title) {
			super(id);
			add(new Label("skillTitle",title));
			
			RepeatingView skillRow = new RepeatingView("skill");
			add(skillRow);
			for(int i=0; i<skills.length; i++) {
				Skill skill = new Skill("skill"+i+skillnumber,skills[i],measures[i]);
				skillRow.add(skill);
			}
			skillnumber++;
		}
		
	}
	private class Skill extends WebMarkupContainer{

		public Skill(String id,String skill,int measure) {
			super(id);
			
			RepeatingView repeatingView = new RepeatingView("skill-square");
			add(repeatingView);
			for(int i=9; i>-1; i--) {
				WebMarkupContainer square = new WebMarkupContainer("square"+skillnumber+i);
				if(measure>i)
					square.add(AttributeModifier.append("class", "square-yes"));
				else
					square.add(AttributeModifier.append("class", "square-no"));
				repeatingView.add(square);
			}
			
			Label label = new Label("skill-label",skill);
			add(label);
		}
		
	}
	private class About extends WebMarkupContainer{

		public About(String id,String title,String p) {
			super(id);
			
			add(new Label("about-title",title));
			add(new Label("about-p",p));
		}
		
	}
	

	private class Topic extends WebMarkupContainer{
		
		String selectedButtonId;
		String imageContainerId;
		ImagePickerButton previousButton;
		ImagePickerButton firstButton;
		ImagePickerButton currentButton;
		int waitTime = 0;
		String topicId;
		public Topic(String id , String[] images, String title, String italy, String[] p, String[] ul) {
			super(id);
			topicId = "topic"+topicNumber;
			this.setOutputMarkupId(true);
			this.setMarkupId(topicId);
			add(new Label("work-title",title));
			add(new Label("italic-section",italy));
			RepeatingView paragraphs = new RepeatingView("work-p");
			add(paragraphs);
			for(int i=0; i<p.length; i++) {
				paragraphs.add(new Label("p"+topicNumber + i,p[i]));
			}
			RepeatingView list = new RepeatingView("work-li");
			add(list);
			for(int i=0; i<ul.length; i++) {
				list.add(new Label("li"+topicNumber+i,ul[i]));
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
			String markupId = "image-container"+String.valueOf(topicNumber);
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
			
			buttonIds.add(new ArrayList<String>());
			
			
			for(int i=0; i<images.length; i++) {
				rvShow.add(new Image("imgSlideShow"+i,images[i]));
				rvSpan.add(new Label("span-image"+i));
				String buttonId = "button"+String.valueOf(i)+String.valueOf(topicNumber);
				
				buttonIds.get(topicNumber).add(buttonId);
				
				final int e = i * MARGIN_LEFT;
				ImagePickerButton button = new ImagePickerButton("button"+i,buttonId,this,e);
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
					if(i==images.length-1)
						button.nextButton = firstButton;
				}
				previousButton = button;
			}
			
			
			topicNumber++;
		}
		
		
	}
	
	
	
	
	
	private class ImagePickerButton extends AjaxButton {
	
		Topic topic;
		ImagePickerButton nextButton;
		String buttonId;
		int e;
		public ImagePickerButton(String id,String markupId, Topic topic, int e) {
			super(id);
			this.topic = topic;
			this.buttonId = markupId;
			this.e = e;
		}
		
		@Override
		protected String getOnClickScript() {
			return getAnimateMovementJs(topic.imageContainerId,e,buttonId,topic.topicId);
		}
		
		@Override
		protected void onSubmit(AjaxRequestTarget target) {
			super.onSubmit(target);
			topic.currentButton = this; 
			topic.waitTime = 5;
		}
		
		
	}
	
	private class IntervalMover2 extends AbstractAjaxTimerBehavior {
		Topic topic;
		long startTime = 0;
		public IntervalMover2(Duration updateInterval, Topic topic) {
			super(updateInterval);
			this.topic = topic;
		}

		protected void onTimer(AjaxRequestTarget target) {
			
			if(topic.waitTime<=0 && userOnPage) {
				topic.selectedButtonId = topic.currentButton.buttonId;
				target.appendJavaScript(getAnimateMovementJs(topic.imageContainerId,topic.currentButton.e,topic.selectedButtonId,topic.topicId));
				topic.currentButton = topic.currentButton.nextButton;
			} else {
				topic.waitTime --;
			}
			
		}
		
	}
	

	
	private String getHighlightSelectedJs(String selectedButtonId, String topicId) {
			
		return "$('#"+topicId+"').find('.selectedButton').removeClass('selectedButton').addClass('button');"
				+"$('#"+selectedButtonId+"').removeClass('button').addClass('selectedButton');";
	}
	
	
	private String getAnimateMovementJs(String id,int e, String selectedButtonId,String topicId) {
		return "$('#"+id+"').stop().animate({marginLeft:'"+e+"'},1000);"
				+ getHighlightSelectedJs(selectedButtonId,topicId);
				
	}
	
	
	

}
