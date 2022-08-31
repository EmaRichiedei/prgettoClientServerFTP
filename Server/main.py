# This is a sample Python script.

# Press Maiusc+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import pyftpdlib

from pyftpdlib.authorizers import DummyAuthorizer
from pyftpdlib.handlers import FTPHandler
from pyftpdlib.servers import FTPServer


# The port the FTP server will listen on.
# This must be greater than 1023 unless you run this script as root.
FTP_PORT = 2121

# The name of the FTP user that can log in.
FTP_USER = "myuser"

# The FTP user's password.
FTP_PASSWORD = "1234"

# The directory the FTP user will have full read/write access to.
FTP_DIRECTORY = "C:/Users/Utente/IdeaProjects/ProgettoFrancoFTP/Server/"  #path nel quale ho salvato il progetto. Come test



authorizer = DummyAuthorizer()
PERM ='elradfmw'
# Define a new user having full r/w permissions.
authorizer.add_user(FTP_USER, FTP_PASSWORD, FTP_DIRECTORY, PERM )

handler = FTPHandler
handler.authorizer = authorizer

# Define a customized banner (string returned when client connects)
handler.banner = "pyftpdlib based ftpd ready."

# Optionally specify range of ports to use for passive connections.
#handler.passive_ports = range(60000, 65535)

address = ('127.0.0.1', FTP_PORT)
server = FTPServer(address, handler)

server.max_cons = 256
server.max_cons_per_ip = 5

server.serve_forever()


