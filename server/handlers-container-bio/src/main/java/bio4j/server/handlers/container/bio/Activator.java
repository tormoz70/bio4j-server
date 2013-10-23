package bio4j.server.handlers.container.bio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import bio4j.common.utils.StringUtl;
import bio4j.server.common.HandlersContainerActivatorBase;

public class Activator implements BundleActivator {

	private String pkg2path(String packageName) {
		return (StringUtl.isNullOrEmpty(packageName) ? null : "/"+packageName.replace('.', '/')+"/");
	}
	private String path2pkg(String path) {
		if(StringUtl.isNullOrEmpty(path)) return null;
		String result = path.replace('/', '.');
		if(result.charAt(0) == '.')
			result = result.substring(1);
		if(result.charAt(result.length()-1) == '.')
			result = result.substring(0, result.length()-1);
		return result;
	}
	
	private String classNameFromPath(String path) {
		if(StringUtl.isNullOrEmpty(path)) return null;
		return path.endsWith(".class") ? path2pkg(path.replaceAll("\\.class$", "")) : null;
	}
	
	private List<Class<?>> findClassesOfBandle(BundleContext context, String packageName) {
		String path = pkg2path(packageName);
		Enumeration<String> entrEnum = context.getBundle().getEntryPaths(path);
		List<String> entrs = Collections.list(entrEnum);
		List<Class<?>> lst = new ArrayList<Class<?>>();
		for (String entry : entrs) {
			Class<?> clazz;
			try {
				clazz = Class.forName(classNameFromPath(entry));
			} catch (ClassNotFoundException ex) {
				clazz = null;
			}
			if(clazz != null)
				lst.add(clazz);
		}
		return lst;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		List<Class<?>> clss = findClassesOfBandle(context, "bio4j.server.handlers.container.bio");
		for (Class<?> c : clss) {
			System.out.println(" -- className: "+c);
		}
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
