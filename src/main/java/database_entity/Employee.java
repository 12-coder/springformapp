package database_entity;

public class Employee implements Comparable<Employee>{
		private int id;
		private String name;
		private long salary;
		public Employee(int id,String name,long salary) {
			this.id=id;
			this.name=name;
			this.salary=salary;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getSalary() {
			return salary;
		}
		public void setSalary(long salary) {
			this.salary = salary;
		}
		@Override
		public int compareTo(Employee o) {
			if(this.salary>o.salary) {
				return -1;
			}
			else if(this.salary<o.salary) {
				return +1;
			}
			else {
			return this.getName().compareTo(o.getName());

			}
		}

		
}
