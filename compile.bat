@echo off
REM Script para compilar o projeto com todas as dependências necessárias
javac -cp "lib\jakarta.xml.bind-api-3.0.1.jar;lib\jaxb-runtime-3.0.2.jar;lib\jakarta.activation-2.0.1.jar;lib\jaxb-core-3.0.2.jar;lib\istack-commons-runtime-4.0.1.jar" -d bin -sourcepath src src/com/rpglab/game/Main.java
echo Compilation completed!
