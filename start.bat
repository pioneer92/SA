@echo off
::close echo

:Start
cls
::clean screen
Echo 　　　║ 　请要运行的程序：　　　　　　　　　　　　　　 ║
Echo 　　　║　　[1] 管道/过滤器风格         　　　　　　　　║
Echo 　　　║　　[2] 调用/返回风格                           ║
Echo 　　　║　　[3] 抽象数据类型风格　　　　　　　　　　　　║
Echo 　　　║　　[Q] 退出    　　　　　　　　　　　　　　　　║
Echo.
Set Choice=
Set /P Choice=　　　请选择要进行的操作 (1/2/3/Q) ，然后按回车：
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
