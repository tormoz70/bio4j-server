package bio4j.server.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.common.utils.StringUtl;
import bio4j.server.api.services.BioService;

public class HandlersContainerActivatorBase implements BundleActivator {
	public static Logger LOG;
	
	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException{
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    URL packageURL;
	    ArrayList<String> names = new ArrayList<String>();;

	    packageName = packageName.replace(".", "/");
	    packageURL = classLoader.getResource(packageName);

	    if(packageURL.getProtocol().equals("jar")){
	        String jarFileName;
	        JarFile jf ;
	        Enumeration<JarEntry> jarEntries;
	        String entryName;

	        // build jar file name, then loop through zipped entries
	        jarFileName = URLDecoder.decode(packageURL.getFile(), "UTF-8");
	        jarFileName = jarFileName.substring(5,jarFileName.indexOf("!"));
	        LOG.debug(">"+jarFileName);
	        jf = new JarFile(jarFileName);
	        try {
		        jarEntries = jf.entries();
		        while(jarEntries.hasMoreElements()){
		            entryName = jarEntries.nextElement().getName();
		            if(entryName.startsWith(packageName) && entryName.length()>packageName.length()+5){
		                entryName = entryName.substring(packageName.length(),entryName.lastIndexOf('.'));
		                names.add(entryName);
		            }
		        }
	        } finally {
	        	jf.close();
	        }

	    // loop through files in classpath
	    } else {
	    	URI uri = null;
	    	try {
	    		uri = new URI(packageURL.toString());
	    	} catch (URISyntaxException ex) {
	    		
	    	}
	    	File folder = new File(uri.getPath());
	        // won't work with path which contains blank (%20)
	        // File folder = new File(packageURL.getFile()); 
	        File[] contenuti = folder.listFiles();
	        String entryName;
	        for(File actual: contenuti){
	            entryName = actual.getName();
	            entryName = entryName.substring(0, entryName.lastIndexOf('.'));
	            names.add(entryName);
	        }
	    }
	    return names;
	}
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Service ["+this.getClass().getName()+"] - started");
		Boolean vvv = StringUtl.isNullOrEmpty("dfg");
		//ArrayList<String> clss = getClassNamesFromPackage("bio4j.server.common");
		Enumeration<String> clssEnum = context.getBundle().getEntryPaths("/");
		List<String> clss = Collections.list(clssEnum);
		for (String c : clss) {
			System.out.println(" -- className: "+c);
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Service ["+this.getClass().getName()+"] - stopped");
	}

}
