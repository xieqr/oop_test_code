class Person 
	def initialize(name)
		@name = name
	end

	def setName(name)
		@name = name
	end

	def getName()
		return @name
	end
end

def selection_sort(arr)
	len  = arr.length
	for i in 0...len-1
		min = i
		for j in (i + 1)...len
			min = j if arr[j].getName() < arr[min].getName()
		end
		arr[i], arr[min] = arr[min], arr[i] if min != i
	end
end

persons = Array.new
count = 0
IO.foreach("names.txt") do |line|
	persons[count] = Person.new(line)
	count += 1
end

selection_sort(persons)
persons.each do |p|
	puts p.getName()
end