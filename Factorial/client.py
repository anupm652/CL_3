import xmlrpc.client

def get_factorial(n):
    try:
        proxy = xmlrpc.client.ServerProxy("http://localhost:8000/")
        return proxy.factorial_rpc(n)
    except Exception as e:
        return f"Error: {e}"

if __name__ == "__main__":
    try:
        n = int(input("Enter a non-negative integer: "))
        factorial = get_factorial(n)
        print(f"Factorial of {n} is {factorial}")
    except ValueError:
        print("Invalid input. Please enter a non-negative integer.")
