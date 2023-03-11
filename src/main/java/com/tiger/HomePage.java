package com.tiger;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;



public class HomePage extends WebPage {
	
	
	
	public HomePage(final PageParameters parameters) {
		super(parameters);	
	
		//add(new MouseoverBehavior("mouseover",this));
		//add(new MouseoverBehavior("mouseleave",this));
		
		Tabs tabs = new Tabs("bar-tabs");
		add(tabs);
		
		add( new Image("front-img","title2.png") );
		
		RepeatingView abouts = new RepeatingView("about");
		add(abouts);
		
		String aboutP = "Hei, tässä on portfolio koodaus projekteistani. Olen "
				+"pyrkinyt valitsemaan sekä itseä motivoivia, että kehittäviä "
				+ "töitä. Motivoidun parhaiten "
				+ "haastavista ja uniikeista projekteista, joten olen pyrkinyt valitsemaan "
				+ "projekteja sen perusteella. Olen oppinut paljon tämän vuoden "
				+ "aikana, mutta huomannut myös että on vielä paljon opittavaa. ";
		abouts.add(new About("about","Portfolio 2023",aboutP));
		
		String experienceA= "Olen oppinut lähinnä projekteja tehdessä ja katsomalla opetusvideoita. "
				+ "Katson opetusvideot yleensä Kotlinilla ja muutan koodit Java kielelle. "
				+ "Tein kesällä myös n. kuukauden työharjoittelun, "
				+ "jossa tein kolme erilaista "
				+ "harjoitus projektia. Minulla oli mentori joka tarkisteli koodejani joten opin "
				+ "oleellisia asioita koodin muotoilusta ja sain lisäksi materiaalia sekä lukuvinkkejä. Olen opiskellut myös ammattikorkeakoulussa "
				+ "konetekniikkaa. Siellä opin matematiikkaa, elektroniikkaa, fysiikkaa sekä erilaisia cadeja. ";
		abouts.add(new About("about3","Opiskelut",experienceA));
		
		
		
		
		RepeatingView skillGraphs = new RepeatingView("skill-div");
		add(skillGraphs);
		
		
		String[] skills = new String[] {"Java","Kotlin","C#","Javascript","CSS","SQL","Google Cloud","Heroku","Openshift","MySQL","Android","IntelliJ IDEA","Eclipse","Visual Studio","Unity","Apache Wicket"};
		int[] measures = new int[] {7,5,3,2,3,1,3,2,1,2,7,5,5,4,3,3};
		skillGraphs.add(new SkillGraph("skill-div1",skills,measures,"Taidot"));
		
		
		RepeatingView topics = new RepeatingView("topic");
		add(topics);
		
		
		String[] starImages = new String[] {
				"starchat0.jpg","starchat6.jpg","starchat2.jpg","starchat3.jpg","starchat7.jpg"
		};
		String i0 = "Java, Firebase, OpenGL, Xml, Retrofit, GLSL, JUnit";
		String[] p0 = new String[] {
				"STAR CHAT on whatsapp klooni, jossa kaikki kirjoittaminen tapahtuu Star Wars alkuteksteistä "
				+ "insipiroituun tyyliin. Projektissa oli tarkoitus opetella Firebase ja OpenGl "
				+ "teknologioita saman aikaisesti. Sovelluksessa on melkein kaikki samat ominaisuudet mitä "
				+ "whatsapissakin on, paitsi muutamia asioita kuten viestien salaus.  "
		};
		String[] ul0 = new String[] {
				"Kaikille käyttäjille ja ryhmille on generoitu uniiki id jotka on tallennettu firebaseen",
				"Käyttäjä solmuihin on tallennettu yleisiä käyttäjätietoja ja ryhmille on lisäksi tallennettu "
				+ "myös ryhmien jäsenet ja erilaisia aikamääreitä kuten milloin kukin henkilö on viimeksi nähty ryhmässä tai "
				+ "viestien päivämäärät, jotta uusien viestien lukumäärät voitaisiin laskea",
				"Tektstin renderöinti openGl:llä oli ehkä haastavempaa kuin kuvittelin kaikkineen "
				+ "koordinaattilaskuineen eri kokoisille kirjaimille ja tekstuurikoordinaattilaskuineen ja tekstuuriatlaskoordinaattilaskuineen "
				+ "ja matriisilaskuineen, mutta onpahan siitäkin nyt selvitty.",
				"Kaikki tekstit on piirretty yhdelle objektille jotta prosessorin tarvitsi tehdä vain yksi piirtokutsu. Ja samasta syystä tuli käyttää tekstuuri atlasta",
				"Kirjaimet piti myös lajitella sanoiksi jotta uudet rivit eivät alkaisi sanan keskeltä tai toisaalta jos sanan pituus oli yli tekstin laatikon leveyden "
				+ "niin ottaa myös ne tilanteet huomioon. Lisäksi Star Wars alkutekstit on aseteltu niin että kaikki rivit "
				+ "ovat yhtä pitkät, joten kirjainten välinen etäisyys muokkautuu kunkin rivin tekstin leveyden perusteella",
				"Tein kaikki tarvittavat järjestely algoritmit ja matriisi kertomat itse harjoituksen vuoksi",
				"Tämä projekti oli ehkä vähän suoraviivaisempi kuin nuo edelliset projektit (OpenGL:ää lukuunottamatta), joten siinä meni lopulta vain noin "
				+"kolme viikkoa. Tein tällä kertaa UI:n heti ensimmäisenä, koska en ilmeisesti projektien lopussa enää jaksa "
				+ "keskittyä visuaaleihin"
		};
		
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
				+ "Tiedot on kerätty OpenStreetMap sivustolta. Pelimoottorina on Unity. " 
				};
		String[] ul1 = new String[] {
				"Tein pelille erillisen OSM xml datan muokkaus ohjelman Visual Studiota käyttäen, koska en löytänyt netistä vastinetta. Ohjelma "
				+ "käytti trie data struktuuria yhdistämään ja suodattamaan n. 900 miljoonaa Suomen teiden koordinaatteja sopivampaan "
				+ "muotoon (OSM datan tie merkinnöissä oli vain viittaukset varsinasiin koordinaatteihin). Sekä lajitteli n.5 neliökilometrin "
				+ "kokoisia alueita koordinaattien perusteella nimettyihin kansioihin. Jotka sitten lopulta latasin Google Cloudiin",
				"Tiet on piirretty 3D pallon muotoiselle objektille, koska 2D alustalla koordinaatit vääristyivät hieman. 3D koordinaatit on laskettu mapallon säteen mukaan.",
				"Tiet on piirretty Unityn kolmioiden piirto työkaluilla tehden mahdollisimman yhtenäisiä objekteja, "
				+ "jotta suorituskyky ei kärsisi.",
				"Peli objektien koot muokkautuvat kameran etäisyyden perusteella",
				"Tämä oli ensimmäinen koodaus projektini joten siinä meni noin 2 kuukautta. Opin yllättävän paljon data "
				+ "struktuureista ja järjestely algoritmeista sekä myös Google Cloudin käyttöä"
				
		};
		
		
		
		
		String[] mapImages = new String[] {
				"mindmap0.jpg","mindmap1.jpg","mindmap2.jpg","mindmap3.jpg","mindmap4.jpg"
		};
		String i2 = "Java, Android Studio, Xml, Json";
		String[] p2 = new String[] {
				"YourMindMap on ajatuskarttojen luontiin tarkoitettu sovellus. "
				+ "Sovelluksesta löytyy lukuisia työkaluja joissa käyttäjää on huomioitu "
				+ "antamalla hänelle mahdollisimman vapaat kädet. "
				+ "Ajatuskartat sommittautuvat automaattisesti ja niiden soluja on helppoa siirrellä. "
				+ "Yritin tehdä tästä julkaistavan äpin, joten aika suuri osa ajasta meni 90-90 säännön mukaisesti "
				+ "pieniä korjauksia tehdessä"
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
				"Viivan, laatikon, reuonojen muotojen, värien, ja viiva tyyppien editointi työkalut",
				"Tekstien värien, fonttien, asettelu ja koon editointi työkalut, sekä kartan automaattinen sopeutuminen eri fontti- "
				+ "ja teksti-koko asetuksille",
				"Tallennus, undo ja redo komennot sekä useiden karttojen tallennus mahdollisuus",
				"Vienti mahdollisuuksia pdf, jpg tai png",
				"Zoom",
				"Haarakkeiden pakkaus työkalu",
				"Kopionti ja liittämistyökalut",
				"Keskittämis työkalu",
				"Kuvien lisäys mahdollisuus",
				"Tämän ohjelman tekoon minulla meni yli 4 kuukautta. Opin paljon Android "
				+ "Frameworkin työkaluja sekä Javan- ja olio-ohjelmoinnin perusteita. Aloitin projektin useaan kertaan alusta "
				+ "koska minulle tuli ongelmia suoristuskyvyn ja koodin sekavuuden kanssa. "
		};
		
		
		
		
		String[] metronomeImages = new String[] {
				"picmetr1.jpg","picmetr2.jpg","picmetr3.jpg",
		};
		String i3 = "Java, Android Studio, OpenGL, Fast Fourier Transform, Autocorrelation";
		String[] p3= new String[] { 
				"Visual Metronome on musiikin harjoitteluun tarkoitettu "
				+ "apuohjelma. Joillakin muusikoilla rytmitaju saattaa heikentyä "
				+ "soittaessa monimutkaisempia kuvioita, "
				+ "jolloin aivot priorisoi rytmin pitämisen sijaan muita soittamiseen "
				+ "tarvittavia keskittymis alueita. Tässä ongelmana on myös se, että "
				+ "itse soittaja ei välttämättä edes kuule omia rytmi ongelmiaan. "
				+	"Visual Metronome pyrkii ratkaisemaan nämä ongelmat "
				+ "antamalla reaali aikaista selkeää feedbackiä, jolloin soittaja "
				+ "näkee virheet heti niiden tapahduttua."
				};
		String[] ul3 = new String[] {
				"Kokeilin erilaisia tapoja rytmien tunnistamiseen, kuten Fast Fourier transformia ja autokorrelaatiota, "
				+ "mutta päädyin lopulta vain laskemaan ääni aaltojen nollakohtien määrät nopeuden vuoksi, sekä ottamaan huomioon myös amplitudin muutokset ylöspäin. "
				+ "Jos nollakohtien määrä muuttuu edelliseen nuottiin verrattuna, tai "
				+ "jos amplitudi nousee ylöspäin yllättäen. niin se on todennäköisesti uusi nuotti ",
				"Ääniallot ja rytmi kuviot on mallinnettu käyttäen OpenGL:ää",
				"Rytmi kuviot muodostuvat y suunnassa suurempina nollakohtien perusteella "
				+ "sekä taas keltaisena tai läpinäkyvän punaisena äänen amplitudin mukaan",
				"Sovelluksessa on mahdollisuus myös äänittää soittoa sekä toistaa soitto äänten hiljennettyä automaattisesti "
				+ "valitun viiveen jälkeen. Tällöin soittajan ei tarvitse jatkuvasti painella 'record' ja 'play' nappeja",
				"Äänityksen ollessa päällä, sovellus tallentaa nauhoitusta AudioBufferiin, josta se karsii n. sekunnin vanhat osiot pois, "
				+ "jotta äänitystä toistaessa nauhoitus alkaisi sopivasta kohdasta ",
				"Ylesiä asetuksia esim. playback odotusajalle ja temmolle, sekä tahtilajin muutoksille ",
				"Ohjelma toimii hyvin kitaran kanssa, mutta toistaiseksi vielä puutteellisesti esimerkiksi pianon kanssa, joten "
				+ "joitakin parannuksia pitää vielä tehdä",
				"Tämän projektin tekemisessä suurin osa ajasta meni oikeastaan matematiikkaa opiskellessa. Tein tätä noin kuukauden. "
		};
		topics.add(new Topic("topic10",starImages,"Star Chat",i0,p0,ul0,"https://github.com/tagir215/Star-Chat/tree/master/main/java/com/android/starchat",0));		
		topics.add(new Topic("topic13",metronomeImages,"Visual Metronme",i3,p3,ul3,"https://github.com/tagir215/VisualMetronome/tree/master/main/java/com/example/artmetronome",1));
		topics.add(new Topic("topic12",mapImages,"Your Mind Map",i2,p2,ul2,"https://github.com/tagir215/YourMindMap/tree/master/myapplication",2));
		topics.add(new Topic("topic11",golfImages,"GPS GOLF",i1,p1,ul1,"https://github.com/tagir215/GPSGolf",3));
		
		
		
		
	}
	
	 
	
	@Override
	public void renderHead(IHeaderResponse response)
	{
		
	    super.renderHead(response);
	    StringBuilder stringBuilder1 = new StringBuilder();
	    stringBuilder1.append("window.onload = function(){");
	    List<String>initialButtons = new ArrayList<String>();
	    for(int i=0; i<CurrentValues.buttonIds.size(); i++) {
	    	initialButtons.add(CurrentValues.buttonIds.get(i).get(0));
	    }
	    for(int i=0; i<initialButtons.size(); i++) {
	    	stringBuilder1.append(JsScripts.getHighlightSelectedJs(initialButtons.get(i),"topic"+i));
	    }
	    
	    stringBuilder1.append("}");
	 	response.render(JavaScriptHeaderItem.forScript(stringBuilder1.toString(),"ok"));
	 	
	 	StringBuilder stringBuilder2 = new StringBuilder();
	 	
	 	for(String name : CurrentValues.currentPositions) {
	 		String script ="var "+ name +" =0;";
	 		stringBuilder2.append(script);
	 	}
	 	response.render(JavaScriptHeaderItem.forScript(stringBuilder2.toString(), "new var"));
	   
	}
	
	


	
	
	
	
	

}
