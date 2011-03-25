rem To run the build creation, please use
rem >win32build.bat buildall

rem MOZILLA_SRC_HOME has to point to compiled in
rem release mode sources of MOZILLLA with CVS tag
rem MOZILLA_1_4_RELEASE

set JAVA_HOME=C:\Program Files\Java\jdk1.5.0_13
set MOZILLA_SRC_HOME=D:\moz\mozilla
set MOZILLA=D:\moz\mozilla
set VC6_HOME=C:\PROGRA~1\MICROS~3\VC98
set ANT_HOME=C:\ANT
set PLATFORM_SDK=C:\PROGRA~1\MICROS~2.NET\VC7\PLATFO~1

set PATH=%JAVA_HOME%\BIN;%VC6_HOME%\BIN;%PATH%;%ANT_HOME%\BIN
set INCLUDE=%PLATFORM_SDK%\INCLUDE;%VC6_HOME%\INCLUDE;%VC6_HOME%\ATL\INCLUDE;%VC6_HOME%\MFC\INCLUDE
set LIB=%PLATFORM_SDK%\LIB;%VC6_HOME%\LIB;%VC6_HOME%\MFC\LIB

ant -lib "%JAVA_HOME%\jre\lib\javaws.jar" %*
