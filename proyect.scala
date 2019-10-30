import scala.language.postfixOps
//making the principal class for working
class DataBase(nstudents: Int, ndroppedstudents: Int, studentslist: List[List[Any]]){
	//class attributes
	private[this] var students: Int = nstudents
	private[this] var droppedStudents: Int = ndroppedstudents
	private[this] var studentsgrades: List[List[Any]] = studentslist

	//methods of the class
	//getter of the number of students
	def NumberOfStudents = students

	//getter of the number of Dropped students
	def NumberOfDroppedStudents= droppedStudents

	//setter to change the number of students
	def NumberOfStudents_= (x: Int) = {
		students = students + x
	}

	//setter to change the number of students
	def NumberOfDroppedStudents_= (x: Int) = {
		droppedStudents = droppedStudents + x
	}

	//function to add a new student
	def newstudent = {
		println("Introduce Name: ")
		//reading a variable
		var nombre=scala.io.StdIn.readLine();
		println("Introduce Grade: ")
		//reading a variable
		var calificacion=scala.io.StdIn.readInt();
		//adding a new element in the list 
		studentsgrades = studentsgrades :: List(List(nombre, calificacion))
		students = students + 1
	}

	//function to eliminate students given a number
	def eliminatestudent = {
		println("Introduce Number of students: ")
		//reading a variable
		var number=scala.io.StdIn.readInt();
		//new list that takes the first number of students grades
		var x = studentsgrades.take(number)
		//printing the eliminated students
		x.foreach(println)
		//getting only the students that are not eliminated
		studentsgrades = studentsgrades.drop(number) 
		droppedStudents = droppedStudents - number
	}
	
	//function that works like  a switch case 
	def ThingToDo(obj: Any): Unit = obj match {
		//in the case looks for the case pass trhough the option til find a pattern
		case "Number of Students" =>println("The number of students is : ", students)

		case "Number of dropped Students" => println("The number of dropped students is: ", droppedStudents)
			//in this case gets into a function
		case "Students and grades" => studentsgrades.foreach(println)

		case "New student" => newstudent 

		case "Eliminate student" => eliminatestudent

		case "Total" => println("Total of students: ", NumberOfStudents + NumberOfDroppedStudents)
 
		case _ => println("Unvalid option")

	}

}

//main function for running the programm
def main(){
	var lista: List[List[Any]] = List(List("Dave",9.5), List("Roberto", 10),List("Miguel",8.5),List("Angle",9.0))
	val base = new DataBase(15, 15, lista)
	//variable for the loop keep going
	var continue = "y"
	//mapping to create a kind of python dictionary 
	val options = Map("a"->"Number of Students","b"->"Number of dropped Students","c" ->"New student" , "d" -> "Eliminate student",
	"e"->"Students and grades","f" -> "Total")
	//main loop where there is the option that the programm can perform
	while(continue == "y"){
		//printing options
		println("What do you want to do?: ")
		println("a. Know the number of students")
		println("b. Know the number of dropped students")
		println("c. Add a new student and its grade")
		println("d. Eliminate students, works as a queue")
		println("e. Print all the students and its grades")
		println("f. Total of students")
		//reading variable
		var input=scala.io.StdIn.readLine();
		//getting into a method of the class base
		base ThingToDo(options(input))
		println("Do you want to continue")
		//reading a variable
		continue=scala.io.StdIn.readLine();
	}
}

main()