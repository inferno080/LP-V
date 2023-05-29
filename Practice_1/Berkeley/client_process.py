from dateutil.parser import parse
from socket import socket
from threading import Thread
from time import sleep
from datetime import datetime

def sendTime(slave_client):

    while 1:
        try:
            slave_client.send(str(datetime.now()).encode())
            print("Time sent Successfully \n")
        except Exception:
            print("Error in sending time\n")
        sleep(5)

def recieveTime(slave_client):
    
    while 1:
        try:
            synchronized_time = slave_client.recv(1024).decode()
            print("Synchronized is : ",str(synchronized_time),"\n")
        except Exception:
            print("Error in recieving time\n")
        sleep(5)

def initializeClient(port):

    slave_client = socket();
    slave_client.connect(('127.0.0.1',port))
    print("Starting to Send Time \n")
    Thread(target=sendTime, args=(slave_client,)).start()
    print("Starting to Recieve Time \n")
    Thread(target=recieveTime, args=(slave_client,)).start()


if __name__ == "__main__":
    initializeClient(8080)