@echo off
REM Script para executar o jogo com todas as dependências necessárias
java -cp "bin;lib\jakarta.xml.bind-api-3.0.1.jar;lib\jaxb-runtime-3.0.2.jar;lib\jakarta.activation-2.0.1.jar;lib\jaxb-core-3.0.2.jar;lib\istack-commons-runtime-4.0.1.jar" com.rpglab.game.Main
