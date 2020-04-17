#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
SERVER_NAME="pay-third-gateway"

echo "------------------------------------------------------------"
echo "SERVER_NAME: $SERVER_NAME"
echo "run path: $DEPLOY_DIR/lib/pay-third-gateway.jar"

PIDS=`ps -ef | grep java | grep "$DEPLOY_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
fi
JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`

if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx5440M -Xms5440M -Xmn1984M -Xss512K -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+ParallelRefProcEnabled -XX:ErrorFile=/data/logs/hs_err_pid%p.log   -Xloggc:/data/logs/gc_%p.log -XX:HeapDumpPath=/data/logs -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintClassHistogramBeforeFullGC -XX:+PrintClassHistogramAfterFullGC -XX:+PrintCommandLineFlags -XX:+PrintGCApplicationStoppedTime -XX:+PrintHeapAtGC "
else
    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g -XX:PermSize=128m -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi

# 获取本地主机的ip
localip=`ifconfig eth0 | grep "inet" | awk '{ print $2}'`
echo "current ip: ${localip}"

if [[ "$localip" =~ ^172.16.* ]] || [[ "$localip" = 10.19.92.165 ]] || [[ "$localip" =~ ^10.2.* ]] || [[ "$localip" = 10.10.51.171 ]] || [[ "$localip" =~ ^10\.1\..+ ]]; then
# 测试环境ip的话内存大小设置小一点
JAVA_MEM_OPTS=" -server -Xms256m -Xmx1g -XX:PermSize=128m -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi
echo "Start shell: nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -jar $DEPLOY_DIR/lib/pay-third-gateway.jar > /dev/null 2>&1 &"
echo -e "Starting the $SERVER_NAME ...\c"

nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -jar $DEPLOY_DIR/lib/pay-third-gateway.jar > /dev/null 2>&1 &

echo "OK!"
PIDS=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
