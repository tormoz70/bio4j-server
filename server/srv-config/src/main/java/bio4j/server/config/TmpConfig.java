package bio4j.server.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//@XStreamAlias("config")
@XmlRootElement(name="config")
public class TmpConfig {
	
	//@XStreamAlias("app_title")
	@XmlElement(name="app_title")
	private String applicationTitle;

	public String getApplicationTitle() {
		return applicationTitle;
	}

	
}
