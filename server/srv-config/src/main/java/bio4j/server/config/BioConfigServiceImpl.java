package bio4j.server.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import bio4j.server.api.services.BioConfigService;
import bio4j.server.common.BioServiceBase;
import bio4j.server.model.BioConfig;

public class BioConfigServiceImpl extends BioServiceBase implements BioConfigService {
	private static Logger LOG = LoggerFactory.getLogger(BioConfigServiceImpl.class);
	private BioConfig config;

	public static String readStream(InputStream in) {
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb=new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read;
		try {
			read = br.readLine();
			while(read != null) {
			    sb.append(read);
			    read =br.readLine();
			}
		} catch (IOException ex) {
			LOG.error(ex.toString());
		}
		return sb.toString();		
	}
	
	private TmpConfig restoreCfg(InputStream in) {
		TmpConfig cfg = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TmpConfig.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cfg = (TmpConfig) jaxbUnmarshaller.unmarshal(in);
		} catch (JAXBException e) {
			LOG.error(e.toString());
		}	
		return cfg;
	}
	
	
	@Override
	protected void doOnInit() {
		
		ClassLoader myClassClassLoader = Activator.class.getClassLoader();
		System.out.println("ClassLoader of BasicOneActivator is " + myClassClassLoader);		
		
		XStream xstream = new XStream(new StaxDriver());
		Bundle bundle = this.getBundleContext().getBundle();
		if(bundle != null) {
			//try {
				String cfgDocPath = "/res/bio4j.xml";
				URL entry = bundle.getResource(cfgDocPath);
				InputStream configIn = getClass().getClassLoader().getResourceAsStream(cfgDocPath);
				if(configIn != null){
					String theXml = readStream(configIn);
					LOG.debug("config xml-body: " + theXml);
					try {
						ClassLoader myCl = TmpConfig.class.getClassLoader();
						//myCl = ((DefaultClassLoader) myCl).getDelegate());
						xstream.setClassLoader(myCl);
						TmpConfig cfg = (TmpConfig)xstream.fromXML(theXml);
						//TmpConfig cfg = restoreCfg(configIn);
						//LOG.debug("config loaded, ApplicationTitle: " + cfg.getApplicationTitle());
					} catch (CannotResolveClassException ex) {
						LOG.error(ex.toString());
					}
				} else {
					LOG.error("Entry \""+cfgDocPath+"\" not found!");
					
					Enumeration<String> entryEnum = bundle.getEntryPaths("/");
					List<String> entries = Collections.list(entryEnum);
					for (String e : entries) {
						LOG.debug(" -- entryName: " + e);
					}
					
				}
			//} catch (IOException ex) {
			//	LOG.error(ex.toString());
			//}
		} else
			LOG.error("Reference on owner Bundle is null!");
	}

	@Override
	public BioConfig getCurrentConfig() {
		return null;
	}
}
