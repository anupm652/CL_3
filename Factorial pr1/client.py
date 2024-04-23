import xmlrpc.client
proxy = xmlrpc.client.ServerProxy("http://localhost:8000/") #A ServerProxy instance is an object that manages communication with a remote XML-RPC server

n=int(input("Enter the number: "))
print(f"Factorial of Number {n} is : %s" % str(proxy.factorial_rpc(n)))

'''RPC supports procedural programming.	RMI supports object-oriented programming.
RPC is the older version of RMI.	While it is the successor version of RPC.'''


