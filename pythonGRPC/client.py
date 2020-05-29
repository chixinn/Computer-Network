import grpc
import Network_pb2
import Network_pb2_grpc
 
IP = 'localhost:9091'
def run():
    channel = grpc.insecure_channel(IP)
    stub =  Network_pb2_grpc.NetworkStub(channel=channel)
    response = stub.CallBack(Network_pb2.Request(clientName='Tq'))
    print("recevied: " + response.message)
 
if __name__ == '__main__':
    run()