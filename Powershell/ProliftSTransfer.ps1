
#Need to make sure that the WinSCP .NET assembly is installed
Add-Type -Path "WinSCPnet.dll"
#HostName = "s3.amazonaws.com" # your_sftp_server"

 $accessKey = "[Redacted]"
    $secretKey = "[Redacted]"
# Set up session options
$sessionOptions = New-Object WinSCP.SessionOptions -Property @{
    Protocol = [WinSCP.Protocol]::S3
    HostName = "s3.amazonaws.com" # your_sftp_server"
    Username = $accessKey
    Password = $secretKey # Consider using a more secure method to handle passwords
}

$session = New-Object WinSCP.Session

try {

    $session.SessionLogPath = "C:\ProliftTransfer\TransferLog.txt"
    # Connect
    $session.Open($sessionOptions)


    $session.PutFileToDirectory("S:\ELC_Templates\D2V_Order\D2V - Update Ordered Units wFrame.xlsx", "/documents-4/prolift")
    $session.PutFileToDirectory("S:\ELC_Templates\D2V_Order\D2V - Update Ordered Units.xlsx", "/documents-4/prolift")
    # Throw on any error
    
}
finally {
    # Disconnect, clean up
    $session.Dispose()
}
