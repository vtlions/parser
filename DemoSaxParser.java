package collections;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Characters;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DemoSaxParser extends DefaultHandler {

	private final static String PROJECT = "project";
	private final static String MODEL_VERSION = "modelVersion";
	private final static String GROUP_ID = "groupId";

	private final static String ARTIFACT_ID = "artifactId";
	private final static String VERSION = "version";
	private final static String NAME = "name";

	private boolean isModelVersion;
	private boolean isGroupId;
	private boolean isArtifactId;
	private boolean isVersion;
	private boolean isName;

	private Maven maven;

	@Override
	public void characters(char[] ch, int start, int length) {

		if (isModelVersion) {
			maven.setModelVersion(getValue(ch, start, length));
		}

		if (isGroupId) {
			maven.setGroupId(getValue(ch, start, length));
		}
		if (isArtifactId) {
			maven.setArtifactId(getValue(ch, start, length));
		}
		if (isVersion) {
			maven.setVersion(getValue(ch, start, length));
		}

		if (isName) {
			maven.setName(getValue(ch, start, length));
		}
	}

	private String getValue(char[] ch, int start, int length) {
		String value = "";
		for (int i = start; i < start + length; i++) {
			value += ch[i];
		}

		return value.trim().isEmpty() ? "" : value.trim();

	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Maven has: " + maven);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {

		case MODEL_VERSION:
			isModelVersion = false;
			break;

		case ARTIFACT_ID:
			isArtifactId = false;
			break;

		case VERSION:
			isVersion = false;
			break;

		case NAME:
			isName = false;
			break;

		case GROUP_ID:
			isGroupId = false;
			break;

		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		//System.out.println("Found node: " + qName);

		switch (qName) {
		case PROJECT:
			maven = new Maven();
			break;

		case MODEL_VERSION:
			isModelVersion = true;
			break;

		case ARTIFACT_ID:
			isArtifactId = true;
			break;

		case VERSION:
			isVersion = true;
			break;

		case NAME:
			isName = true;
			break;

		case GROUP_ID:
			isGroupId = true;
			break;
		}
	}
}
