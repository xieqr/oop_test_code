import java.io.*;

public class test {
	public static void selection_sort(Person[] arr) {
		int i, j, min, len = arr.length;
		Person temp;
		for (i = 0; i < len - 1; i++) {
			min = i;
			for (j = i + 1; j < len; j++)
				if (arr[min].getName().compareTo(arr[j].getName()) > 0)
					min = j;
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		Person[] persons = new Person[10000];

		try {
			InputStream in = new FileInputStream("names.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line = null;
			int n = 0;
			while ((line = reader.readLine()) != null) {
				persons[n] = new Person(line);
				n++;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (persons[9999] != null) {
			selection_sort(persons);
			for (int i = 0; i < 10000; i++) {
				System.out.println(persons[i].getName());
			}
		}
	}
}

class Person{
	private String name;

	Person(String name) {
		this.name = name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return this.name;
	}
}