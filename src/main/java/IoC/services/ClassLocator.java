package IoC.services;

import IoC.exceptions.LocationExceptionCustom;

import java.util.Set;

public interface ClassLocator {

    Set<Class<?>> locateClasses(String directory) throws LocationExceptionCustom;

}
