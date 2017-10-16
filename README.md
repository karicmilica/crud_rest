# crud_rest
1. clone repository
2. navigate to root folder
3. 'mvn install'
4. 'mvn package' (the result should be jar file in root/target folder)
5. To create war file, rename pom.xml to pom.xml.xxx and pom.xml.wildfly to pom.xml and then call 'mvn package'. Copy created war file to $jboss_home/standalone/deployments. Comment lines ``` <extension module="org.jboss.as.jsf"/> ``` and ``` <subsystem xmlns="urn:jboss:domain:jsf:1.0"/> ``` in $jboss_home/standalone/configuration/standalone.xml. Start wildfly [ https://bgasparotto.com/start-stop-restart-wildfly/]( https://bgasparotto.com/start-stop-restart-wildfly/).

### swagger-definition
[http://localhost:8080/crud_rest/swagger-ui.html]( http://localhost:8080/crud_rest/swagger-ui.html )
