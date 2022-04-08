## 一、ELK的介绍
ELK是三个开源软件的缩写，分别表示：Elasticsearch , Logstash, Kibana , 它们都是开源软件。

1. Elasticsearch是个开源分布式搜索引擎，提供搜集、分析、存储数据三大功能。
2. Logstash 主要是用来日志的搜集、分析、过滤日志的工具，支持大量的数据获取方式。
3. Kibana 也是一个开源和免费的工具，Kibana可以为 Logstash 和 ElasticSearch 提供的日志分析友好的 Web 界面，可以帮助汇总、分析和搜索重要数据日志。


## 二、安装包下载、解压
安装包下载地址：
https://mirrors.huaweicloud.com/elasticsearch/
https://mirrors.huaweicloud.com/kibana/
https://mirrors.huaweicloud.com/logstash/
注意事项：下载统一上传到 /usr/local

解压对应的包：

解压es：tar -zxvf  elasticsearch-7.8.0-linux-x86_64.tar.gz

解压kibana：tar -zxvf kibana-7.8.0-linux-x86_64.tar.gz

解压logstash：unzip logstash-7.8.0.zip

## 三、Elasticsearch部署
1. 修改配置文件 config/elasticsearch.yml
cluster.name: log-es

node.name: node-1

path.data: /usr/local/elasticsearch-7.8.0/data

path.logs: /usr/local/elasticsearch-7.8.0/logs

network.host: 0.0.0.0

http.port: 9200

cluster.initial_master_nodes: ["node-1"]

2. 如果是root账号操作的，需要改文件权限，因为es不允许root权限启动
adduser elk

passwd elk 

输入对应的密码

修改包权限

chown -R elk:elk elasticsearch-7.8.0/

chmod 770 elasticsearch-7.8.0/

3. 启动es
登录elk权限启动
su elk

进入es根目录
./bin/elasticsearch -d （加-d后台运行）

## 四、Logstash部署
1. 修改配置文件 config/logstash.yml
http.host: "10.1.138.16" （对应部署服务器的ip）

2. 在config目录下新建一个文件logstash.conf，并添加内容

`input {

  tcp {

    mode => "server"

    host => "10.1.138.16"  //logstash服务器地址

    port => 4560

    codec => "json_lines"

  }

}

filter {

}

output {

  elasticsearch {

    hosts => ["http://10.1.138.16:9200"]  //es服务器地址和端口

    index => "dev"

  }
  
}`



3. 启动

修改包权限
chown -R elk:elk elasticsearch-7.8.0/

chmod 770 elasticsearch-7.8.0/

nohup ./bin/logstash -f logstash.conf &


## 五、Kibana部署
1. 修改配置文件 config/logstash.yml

server.host: "0.0.0.0"

i18n.locale: "zh-CN"

2. 启动配置
nohup ./bin/kibana &


