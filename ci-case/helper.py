import socket

def communicate(host,port,request):
    s = socket.socket(socket.AF_INET,socket.SOCKET_STREAM)
    try:
        s.connect((host,port))
        s.send(request)
        response = s.recv(1025)
    finally:
        s.close()
    return response