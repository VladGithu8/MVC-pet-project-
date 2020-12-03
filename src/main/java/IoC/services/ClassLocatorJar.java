package IoC.services;

import IoC.constants.Constants;
import IoC.exceptions.LocationExceptionCustom;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassLocatorJar implements ClassLocator {

    @Override
    public Set<Class<?>> locateClasses(String directory) throws LocationExceptionCustom {
       final Set<Class<?>> locatedClasses = new HashSet<>();
        try{
            JarFile jarFile = new JarFile(new File(directory));
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()){
                JarEntry jarEntry = entries.nextElement();

                if(!jarEntry.getName().endsWith(Constants.JAVA_BINARY_EXTENSION)){
                    continue;
                }

                final String className = jarEntry.getName().replace(".class","")
                        .replaceAll("\\\\", ".")
                        .replaceAll("/", ".");

                locatedClasses.add(Class.forName(className));

                System.out.println(jarEntry.getName());

            }
        }catch (IOException | ClassNotFoundException ioe){
            throw new LocationExceptionCustom(ioe.getMessage());
        }
        return locatedClasses;
    }
}
