文件过滤：
onlinelearn-1.0.0.jar

代码检出后执行：
mvn clean package -Dmaven.test.skip=true
cp server/onlinelearn/target/onlinelearn-1.0.0.jar .

应用发布前执行：
set +e
ps -ef | grep onlinelearn-1.0.0.jar | grep -v grep | awk '{print $2}' | xargs kill -9
PID=$(ps -ef | grep onlinelearn-1.0.0.jar | grep -v grep | awk '{print $2}')
if [ ! -z $PID ]; then
kill -9 $PID
fi


应用发布后执行：
nohup  java -Xms1000m -Xmx1000m -XX:-UseGCOverheadLimit -javaagent:/usr/local/src/pinpoint-agent-2.1.0/pinpoint-bootstrap-2.1.0.jar -Dpinpoint.agentId=renshe_prod_onlinelearn -Dpinpoint.applicationName=renshe_prod_onlinelearn -jar onlinelearn-1.0.0.jar --spring.profiles.active=prod > run.log &
