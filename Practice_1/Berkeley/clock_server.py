from dateutil.parser import parse
from socket import socket,SOL_SOCKET,SO_REUSEADDR
from threading import Thread
from time import sleep
from datetime import datetime, timedelta

client_data = {}

def startRecievingTime(connector, address):

    while 1:

        try:
            clock_time = parse(connector.recv(1024).decode())
            time_difference = datetime.now() - clock_time
            client_data[address]= {
                "clock-time":clock_time,
                "time-difference":time_difference,
                "connector":connector
            }
            print("Time from Client at Address ", str(address), " recieved \n")
        except Exception:
            print("Something went wrong while recieving time from Client at Address ", str(address), "\n")
        sleep(5)


def startConnecting(master_server):

    while 1:

        try:
            connector, address = master_server.accept()
            slave_address = str(address[0]) + ":" + str(address[1])
            print("Connected to Client at Address ", str(slave_address), " \n")
            Thread(target=startRecievingTime, args=(connector,slave_address,)).start()
        except Exception:
            print("Something went wrong while connecting to Client at Address ", str(slave_address), "\n")

def startSynchronizing():

    while 1 :

        if(len(client_data) == 0):
            print("No Clients Connected \n")
        else:
            print("Clients Connected : ", str(len(client_data)));
            avg_time_diff = sum(list(client["time-difference"] for client_address, client in client_data.items()), timedelta(1,1))/len(client_data.items())
            for client_address, client in client_data.items():
                try:
                    synchronized_time = datetime.now() + avg_time_diff
                    client["connector"].send(str(synchronized_time).encode())
                    print("Sent Synchronzied Time to Client at : ", str(client_address), "\n")
                except Exception :
                    print("Something went wrong while sending Synchronzied Time to Client at : ", str(client_address), "\n")
        sleep(5)


def initializeServer(port):

    master_server = socket();
    master_server.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
    print("Socket Created \n")
    master_server.bind(('',port))
    master_server.listen(10)
    print("Starting to Connect to Clients \n")
    Thread(target=startConnecting, args=(master_server, )).start()
    print("Starting to Synchronize Clients \n")
    Thread(target=startSynchronizing, args=()).start()

if __name__ == "__main__":
    initializeServer(8080)
