CALL clean.bat
cd bin
set "JAVA_OPTS=%JAVA_OPTS% -Dlogback.ContextSelector=JNDI -Dfile.encoding=UTF-8 -server -Xms128m -Xmx512m -XX:MaxPermSize=256m"
@rem set "JAVA_OPTS=%JAVA_OPTS% -Dconfig.folder=C:/Java/apache-tomcat-8.0.26/config -Ddata.folder=C:/Java/apache-tomcat-8.0.26/data"
catalina jpda run