java -Xms1000m -Xmx1000m -XX:-UseGCOverheadLimit -javaagent:/usr/local/src/pinpoint-agent-2.1.0/pinpoint-bootstrap-2.1.0.jar -Dpinpoint.agentId=renshe_prod_onlinelearn -Dpinpoint.applicationName=renshe_prod_onlinelearn -jar onlinelearn-1.0.0.jar --spring.profiles.active=prod