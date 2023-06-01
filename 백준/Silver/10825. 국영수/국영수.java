import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static Student[] students;
	static class Student implements Comparable<Student>{
		String name;
		int korean;
		int english;
		int math;
		
		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		

		@Override
		public String toString() {
			return "Student [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
		}


		@Override
		public int compareTo(Student o) {
			 if( o.korean-this.korean ==0) {
				 if( o.english-this.english ==0) {
					 if( o.math-this.math ==0) {
							return this.name.compareTo(o.name);
					 }
						return o.math-this.math;
				 }
				 return this.english-o.english;
			 }
			
			return o.korean-this.korean;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		

		Arrays.sort(students);
		
		for (int i = 0; i < N; i++) {
			System.out.println(students[i].name);
		}
		
	}

}