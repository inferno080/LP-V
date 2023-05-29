from dateutil.parser import parse
from datetime import datetime
from time import sleep
from socket import socket
from threading import Thread

def startSendingTime(slave):

    while True:

        try:
            slave.send(str(datetime.now()).encode())
            print("Recent Time Sent Successfully \n")
        except Exception:
            print("Something went wrong while sending Time \n")
        
        sleep(8)

def startRecievingTime(slave):

    while True:

        try:
            synchronzied_time = parse(slave.recv(1024).decode())
            print("Synchronized Time : ",synchronzied_time,"\n")
        except Exception:
            print("Something went wrong while recieving Time \n")
        
        sleep(8)

def initializeClient(port):

    slave_client = socket()
    slave_client.connect(("127.0.0.1",port))
    print("Staring to send time")
    Thread(target=startSendingTime, args=(slave_client,)).start();
    print("Staring to recieve synchronized time")
    Thread(target=startRecievingTime, args=(slave_client,)).start();

if __name__ == "__main__":
    initializeClient(8080)