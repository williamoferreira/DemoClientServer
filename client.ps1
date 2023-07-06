param(
    [Parameter()]
    [String]$servidor = "localhost",

    [Parameter()]
    [String]$socket = "8888"
)

Write-Host "Servidor: ${servidor}:${socket}";

try {
    $conexao = New-Object System.Net.Sockets.TcpClient($servidor, $socket)
    $envio = New-Object System.IO.StreamWriter($conexao.GetStream())
    $envio.AutoFlush = $True
    
    while ($conexao.Connected) {
    
        $mensagem = Read-Host -Prompt "Mensagem"
    
        $envio.WriteLine($mensagem) 
    
        if ($mensagem.Equals("sair")) {
            $conexao.Close();    
        }    
    
    }
    
    $envio.close()
}
catch {
    Write-Host "Error!"
    Write-Host $_
}
