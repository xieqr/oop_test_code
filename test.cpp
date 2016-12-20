#include <iostream>
#include <fstream>
using namespace std;

class Person {
private:
	string name;

public:
	Person() {

	}

	Person(string name) {
		this->name = name;
	}

	void setName(string name) {
		this->name = name;
	}

	string getName() {
		return this->name;
	}
};

void selection_sort(Person arr[], int len) {
	int i, j, min;
	for (i = 0; i < len - 1; i++) {
		min = i;
		for (j = i + 1; j < len; j++)
			if (arr[min].getName() > arr[j].getName())
				min = j;
		swap(arr[i], arr[min]);
	}
}

int main(int argc, char const *argv[])
{
	ifstream fin("names.txt");
	string line;
	Person *persons = new Person[10000];
	int count = 0;

	getline(fin, line);
	while (line != "") {
		persons[count++].setName(line);
		getline(fin, line);
	}
	fin.close();

	selection_sort(persons, 10000);

	for (int i = 0; i < 10000; ++i) {
		cout << persons[i].getName() << endl;
	}
	delete [] persons;

	return 0;
}