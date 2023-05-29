from dateutil.parser import parse
from datetime import datetime, timedelta
from time import sleep
from socket import socket,SOL_SOCKET, SO_REUSEADDR
from threading import Thread


client_data = {};

def startRecievingTime(connector, address):

    while True:
        
        try:
            clock_time = parse(connector.recv(1024).decode())
            client_data[address] = {"connector":connector, "clock-time":clock_time, "time-difference":(datetime.now()-clock_time)}
            print("Recieved Client Time from : ", str(address),"\n")
        except Exception:
            print("Something went wrong in recieving Client Data from : ", str(address),"\n")

        sleep(8)

def startConnecting(master_server):

    while True:

        try:
            connector,address = master_server.accept();
            slave_address = str(address[0]) + ":" + str(address[1])
            print("Connected to Client at : ", str(slave_address),"\n")
            Thread(target=startRecievingTime, args=(connector,slave_address,)).start()
        except Exception:
            print("Something went wrong while connecting to client at : ", str(slave_address),"\n")
        
        sleep(8)

def synchronizeTime():

    while True:

        if(len(client_data)>=1):
        
            print("Number of Clients Connected : ", len(client_data), "\n")
            average_time_difference = sum(list(client["time-difference"] for client_address, client in client_data.items()), timedelta(1,1))/len(client_data);
            synchronized_time = datetime.now() + average_time_difference;

            for client_address, client in client_data.items():
                try :
                    client["connector"].send(str(synchronized_time).encode())
                    print("Synchronized Time sent to Client at : ", str(client_address),"\n")
                except Exception:
                    print("Something went wrong while sending Synchronized Time to Client at : ", str(client_address),"\n")

        else:
            print("No Clients Connected for Synchronization \n")
        
        sleep(8)


def initializeServer(port):

    master_server = socket()
    master_server.setsockopt(SOL_SOCKET,SO_REUSEADDR,1)
    print("Socket Created Succesfully \n")
    master_server.bind(('',port))
    master_server.listen(10)
    print("Staring to Connect to Clients ... \n")
    Thread(target=startConnecting, args=(master_server,)).start()
    print("Staring to Synchronize Client Time ... \n")
    Thread(target=synchronizeTime, args=()).start()

if __name__ == "__main__":
    initializeServer(8080)