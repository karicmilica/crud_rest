# crud_rest
1. clone repository
2. navigate to root folder
3. use 'mvn install' to install dependencies
4.1 'mvn package' (the result should be jar file in root/target folder)
4.2 To create war file, change pom.xml name to pom.xml.xxx and pom.xml.wildfly to pom.xml and then call 'mvn package'. Copy created war file to $jboss_home/standalone/deployments. Comment lines <extension module="org.jboss.as.jsf"/> and <subsystem xmlns="urn:jboss:domain:jsf:1.0"/> in $jboss_home/standalone/configuration/standalone.xml. Start wildfly https://bgasparotto.com/start-stop-restart-wildfly/ .
