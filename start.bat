@echo off
::close echo

:Start
cls
::clean screen
Echo �������U ����Ҫ���еĳ��򣺡��������������������������� �U
Echo �������U����[1] �ܵ�/���������         �����������������U
Echo �������U����[2] ����/���ط��                           �U
Echo �������U����[3] �����������ͷ�񡡡����������������������U
Echo �������U����[Q] �˳�    ���������������������������������U
Echo.
Set Choice=
Set /P Choice=��������ѡ��Ҫ���еĲ��� (1/2/3/Q) ��Ȼ�󰴻س���
If "%Choice%"=="" Goto Start
If Not "%Choice%"=="" Set Choice=%Choice:~0,1%
If /I "%Choice%"=="1" Goto pipe
If /I "%Choice%"=="2" Goto invret
if /I "%Choice%"=="3" Goto adt
If /I "%Choice%"=="Q" Exit
Goto Start

:pipe
javac -d bin src\pipestyle\*.java
cd .\bin
java pipestyle.PipeKwic

goto end
:invret
javac -d bin src\invretstyle\*.java
cd .\bin
java invretstyle.InvRetKwic

goto end
:adt
javac -d bin src\adtstyle\*.java src\adtstyle\impl\*.java
cd .\bin
java adtstyle.ADTKwic

:end

pause
