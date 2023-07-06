# DemoClientServer
Demonstração para aplicação cliente e aplicação servdor onde o servidor foi escrito em java e o cliente em powershell

Exempĺo escrito para exercítar.

## Servidor
O servidor foi escrito em java. Compile com o comando `javac socketServer.java`. Inicie o servidor com o comando `java socketServer`. É possível selecionar a porta informando via linha de comando, como em `java socketServer 1234`. Após iniciado, o servidor finalizará após o cliente enviar a string `sair` ou via `ctrl + C`.

## Cliente
O cliente foi escrito em powershell, inicie o console e execute o script usando `./client.ps1`. Por política de segurança, o powershell bloqueia execução de scripts. A execução de scripts pode ser autorizada com o comando `Set-ExecutionPolicy -ExecutionPolicy Bypass`. No linux, a execution policy padrão é `Unrestricted`.


