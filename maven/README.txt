

Maven Shortcuts
--------------

#Create Java Project
mvn archetype:generate -DgroupId={project-packaging}
   -DartifactId={project-name}
   -DarchetypeArtifactId=maven-archetype-quickstart
   -DinteractiveMode=false

# Create Web Project
mvn archetype:generate -DgroupId={project-packaging}
	-DartifactId={project-name}
	-DarchetypeArtifactId=maven-archetype-webapp
	-DinteractiveMode=false

# Eclipse Integration
mvn eclipse:eclipse

# Eclipse Integration
mvn eclipse:eclipse -Dwtpversion=2.0
