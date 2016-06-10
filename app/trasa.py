import sys
import telnetlib
import time

step = 5;
HOST = "localhost"
port = "5554"
password = "auth activity\r\n".encode('ascii')
trasa=[]

#user = raw_input("Enter your remote account: ")

#password = getpass.getpass()

tn = telnetlib.Telnet(HOST, port)
print("polaczono!")
print("wypisano")
#tn.read_until("OK")

tn.write(password)
print("wpisywanie fixa")
tn.write("geo fix 16.9507 52.403309\r\n".encode('ascii'))
time.sleep(step)
tn.write("geo fix 16.9512 52.40379\r\n".encode('ascii'))
time.sleep(step)
tn.write("geo fix 16.9523 52.40505\r\n".encode('ascii'))


input("exit")
