package be.ixor.techtalks.devops;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;

import static java.util.jar.JarFile.MANIFEST_NAME;

public class VersionInfo {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> resources = VersionInfo.class.getClassLoader().getResources(MANIFEST_NAME);
        while (resources.hasMoreElements()) {
            Manifest manifest = new Manifest(resources.nextElement().openStream());
            if ("Micro-devOps-sample-lib".equals(manifest.getMainAttributes().getValue("Implementation-Title"))) {
                String version = manifest.getMainAttributes().getValue("Implementation-Version");
                System.out.println("version: " + version);
                return;
            }
        }
        System.out.println("could not read main manifest");
    }
}