@echo off
chcp 65001 > nul
echo Dang bien dich code Java...
if not exist "build\classes" mkdir "build\classes"
javac -encoding UTF-8 -d build/classes -sourcepath src src/Main.java src/utils/Validation.java src/entity/Fruit.java src/entity/Order.java src/bo/FruitManager.java
if %errorlevel% neq 0 (
    echo [LOI] Bien dich that bai!
    pause
    exit /b %errorlevel%
)
echo Chay chuong trinh...
java -Dfile.encoding=UTF-8 -cp build/classes Main
pause
