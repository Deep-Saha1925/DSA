balance = 20000
amount = int(input("Enter amount:"))

if amount % 10 != 0:
    print("Only 100, 200 and 500 notes are avaliable")
elif amount > balance:
    print("Insufficient balance")
elif (balance - amount) < 500:
    print("Minimum balance must be 500")
    print("Current balance:", balance)
else:
    balance -= amount
    print(amount, "amount debited..")
    print("Current balance:", balance)

