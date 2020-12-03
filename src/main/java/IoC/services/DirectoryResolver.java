package IoC.services;

import IoC.models.Directory;

public interface DirectoryResolver {

    Directory resolveDirectory(Class<?> startupClass);
}

