Maven2
======
mvn install
mvn eclipse:eclipse
mvn jetty:run-war


Eclipse Integration
===================

Test-Umgebungen
---------------
Tomcat 5.5.29 + Eclipse 3.3 + Europa + JDK 1.5  -> Tests erfolgreich (siehe unten)

Probleme mit EL unter Tomcat 6.0.14.

Integration von Jetty �ber Maven-Plugin funktioniert mit Einschr�nkungen.
Der Server l�sst nicht nicht wieder beenden. Abhilfe kann TCPView schaffen.
Konfiguration:
- Open External Tools Dialog: Maven-Aufruf mit jetty:run-war.
  Als Umgebungsoptionen setzen: MAVEN_OPTS=-Xms256m -Xmx256m -XX:PermSize=256m -XX:MaxPermSize=256m 
                                           -Xdebug -Xnoagent -Djava.compiler=NONE 
                                           -Xrunjdwp:transport=dt_socket,address=4000,server=y,suspend=n
- Debug Remote Application (Localhost, Port 4000) 
                                          

On-the-fly-�nderungen am Java Code oder FTL-Templates
-----------------------------------------------------
Folgende Konfiguration l��t die �nderung an Java-Code und
FTL-Dateien einer laufenden Anwendung zu, ohne dass diese neu
deployt werden muss.

1. Preferences > Server > Installed Runtimes: Tomcat 5.5 konfigurieren.
2. Project > Properties > Target Runtimes: Tomcat-Runtime markieren.
3. Project > Properties > Server: Tomcat-Runtime markieren.
4. Project > Properties > J2EE Module Dependencies: Alles markieren
   WICHTIG:
   - Unter Tomcat 5.5 H�kchen bei log4j und commons-logging entfernen.
     (Befindet sich commons logging im WEB-INF/lib-Verzeichnis kommt es beim Neuladen des
     Web Application Kontexts zur NullPointerException)
   - Unter Tomcat 6 m�ssen alle Eintr�ge markiert sein.
5. Project > Properties > Web Project Settings: Gew�nschten Kontext-Namen einstellen.
6. Servers View �ffnen und pr�fen, ob Anwendung deployt wird.
7. Projekt markieren + rechte Maustaste > Debug As > Debug on Server


Geplante Erweiterungen
----------------------

Abfrage: Haustierhalter, die Haustiertyp A besitzen, haben ebenfalls ein Haustier vom Typ B:

  create table tokens (custid integer, token varchar2(30));

  select t.token, count(t.token) num
  from pcp.tokens t 
  where token <> 'Lizard' and custid in (
    select distinct custid 
    from pcp.tokens 
    where token = 'Lizard' and custid <> 1)
  group by t.token order by num desc;






