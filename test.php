<?php
class Person {
	private $name;

	public function __construct($name) {
		$this->name = $name;
	}

	public function setName($name) {
		$this->name = $name;
	}

	public function getName() {
		return $this->name;
	}
}

function swap(&$x, &$y) {
	$t = $x;
	$x = $y;
	$y = $t;
}

function selection_sort(&$arr) {
	for ($i = 0; $i < count($arr) - 1; $i++) {
		$min = $i;
		for ($j = $i + 1; $j < count($arr); $j++)
			if ($arr[$min]->getName() > $arr[$j]->getName())
				$min = $j;
		swap($arr[$min], $arr[$i]);
	}
}

$persons = array();
$file = fopen("names.txt", "r");
while (!feof($file)) {
	$persons[] = new Person(fgets($file));
}
selection_sort($persons);
foreach ($persons as $p) {
	echo $p->getName();
}
?>
