class Test(object):

	"""docstring for Test"""
	def __init__(self, name):
		super(Test, self).__init__()
		self.name = name

	def setName(self, name):
		self.name = name

	def getName(self):
		return self.name

def selection_sort(L):
	N = len(L)
	for i in range(N-1):
		min_index = i
		for j in range(i+1, N):
			m_name = L[min_index].getName()
			j_name = L[j].getName()
			if m_name > j_name:
				min_index = j
		if min_index != i:
			L[min_index], L[i] = L[i], L[min_index]
	return L

names = []
file = open("names.txt", "r")

for line in file:
	names.append(Test(line)) 
file.close()

selection_sort(names)

for name in names:
	print(name.getName(), end="")