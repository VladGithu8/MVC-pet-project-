package IoC.services;

import IoC.constants.Constants;
import IoC.exceptions.LocationExceptionCustom;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ClassLocatorDirectory implements ClassLocator {

    private static final String INVALID_DIRECTORY_MSG = "Invalid directory '%s'!";

    private final Set<Class<?>> locatedClasses;

    public  ClassLocatorDirectory(){
        this.locatedClasses = new HashSet<>();
    }

    @Override
    public Set<Class<?>> locateClasses(String directory) throws LocationExceptionCustom {
        this.locatedClasses.clear();
        File file = new File(directory);

        if(!file.isDirectory()){
            throw new LocationExceptionCustom(String.format(INVALID_DIRECTORY_MSG, directory));
        }

        try {
            for (File innerFile : file.listFiles()) {
                this.scanDirectory(innerFile, "");
            }
        } catch (LocationExceptionCustom e) {
                e.getCause();
            }
        return this.locatedClasses;
    }

    private void scanDirectory(File file, String packageName)  {
        if(file.isDirectory()){
            packageName += file.getName() + ".";

            for(File innerFile: file.listFiles()){
                this.scanDirectory(innerFile, packageName);
            }
        } else {
            if(!file.getName().endsWith(Constants.JAVA_BINARY_EXTENSION)){
                return;
            }

            final String className = packageName + file.getName().replace(Constants.JAVA_BINARY_EXTENSION, "");
            try {
                this.locatedClasses.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
