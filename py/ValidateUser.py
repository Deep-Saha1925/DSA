users = {
    "test": "test123",
    "snaha": "snaha123",
    "deep": "deep987"
}

username = input("Enter username:")
password = input("Enter password:")

if username not in users.keys():
    print("Invalid username")
elif password not in users.values():
    print("Invalid password")
else:
    print("User validated!!")