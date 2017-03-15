package be.ixor.techtalks.devops;

import static java.util.jar.JarFile.*;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;

public class VersionInfo {
	public static void main(String[] args) throws IOException {
		System.out.println(getVersion());
	}

	public static String getVersion() throws IOException {
		Enumeration<URL> resources = VersionInfo.class.getClassLoader().getResources(MANIFEST_NAME);
		while (resources.hasMoreElements()) {
			Manifest manifest = new Manifest(resources.nextElement().openStream());
			if ("Micro-devOps-sample-lib".equals(manifest.getMainAttributes().getValue("Implementation-Title"))) {
				String version = manifest.getMainAttributes().getValue("Implementation-Version");
				return version;
			}
		}
		return "could not read main manifest";
	}
}
