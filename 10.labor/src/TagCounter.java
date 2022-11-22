import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class TagCounter extends DefaultHandler{
	public static void main(String[] args) {
		DefaultHandler handler = new TagCounter();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new java.io.File("bme.xml"), handler);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(busStops, (b1,b2)->{
			return (int)(b1.distance-b2.distance);
		});
		for(BusStop b : busStops) {
			System.out.println(b);
		}
		for (HashMap.Entry entry : tags.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
	}
	
	static Map<String, Integer> tags;
	BusStop bus;
	static List<BusStop> busStops;
	
	public TagCounter() {
		tags = new HashMap<String, Integer>();
		busStops = new ArrayList<>();
	}
	
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		if(tags.containsKey(qName)) tags.put(qName, tags.get(qName)+1);
		else tags.put(qName, 1);
		
		
		switch(qName) {
		case "node": //node kezdődik
			bus = new BusStop(Double.parseDouble(atts.getValue("lat")), Double.parseDouble(atts.getValue("lon")));
			break;
		case "tag": //tag kezdődik
			if("bus_stop".equals(atts.getValue("v"))) bus.valid = true;
			if("name".equals(atts.getValue("k"))) bus.name=atts.getValue("v");
			else if("old_name".equals(atts.getValue("k"))) bus.oldName=atts.getValue("v");
			else if("wheelchair".equals(atts.getValue("k"))) bus.wheelChair=atts.getValue("v");
			break; 
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
		case "node":
			if(bus.valid) busStops.add(bus);
			break;
		}
	}

}
