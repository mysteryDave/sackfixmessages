#!/bin/bash
#REM stupid SBT runs out of mem on my dev lappie
#REM sbt sackfixmessagesfixt11/compile
#REM sbt sackfixmessagesfixt11/publishLocal
#REM
#REM sbt is a .bat, so stick call infront of it
export JAVA_OPTS=-Xmx1024M -Xss2M

sbt "project sackfixmessages40" clean compile test
sbt "project sackfixmessages40" publishLocal

sbt "project sackfixmessages41" clean compile test
sbt "project sackfixmessages41" publishLocal

sbt "project sackfixmessages42" clean compile test
sbt "project sackfixmessages42" publishLocal

sbt "project sackfixmessages43" clean compile test
sbt "project sackfixmessages43" publishLocal

sbt "project sackfixmessages44" clean compile test
sbt "project sackfixmessages44" publishLocal

sbt "project sackfixmessages44modified" clean compile test
sbt "project sackfixmessages44modified" publishLocal

sbt "project sackfixmessagesfixt11" clean compile test
sbt "project sackfixmessagesfixt11" publishLocal

sbt "project sackfixmessages50" clean compile test
sbt "project sackfixmessages50" publishLocal

sbt "project sackfixmessages50sp1" clean compile test
sbt "project sackfixmessages50sp1" publishLocal

sbt "project sackfixmessages50sp1modified" clean compile test
sbt "project sackfixmessages50sp1modified" publishLocal

sbt "project sackfixmessages50sp2" clean compile test
sbt "project sackfixmessages50sp2" publishLocal

sbt "project sackfixmessages50sp2modified" clean compile test
sbt "project sackfixmessages50sp2modified" publishLocal
