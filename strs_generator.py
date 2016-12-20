import random

letters = "abcdefghijklmnopqrstuvwxyz"
len = len(letters) - 1

for m in range(100):
	r = random.randint(3, 8)
	for n in range(1, r):
		print(letters[random.randint(0, len)], end="")
	print()
