class HW1Test {
	HW1 hw;
	
	public HW1Test(HW1 hw) {
		this.hw = hw;
	}
	
	public HW1Test() {}
	
	public void Test() {
		
		  Student s1 = new Student("Foo1", "CS", 1); 
		  Student s2 = new Student("Foo2", "FS", 2);
		  Student s3 = new Student("Foo3", "BS", 3); 
		  Student s4 = new Student("Foo4", "AS", 4); 
		  Student s5 = new Student("Foo5", "DS", 5);
		  Student s6 = new Student("Foo6", "ES", 6); 
		  Student s7 = new Student("Foo1", "CS", 1);

		  hw.addStudent(s1); hw.addStudent(s3);

		  assert(s1.equals(s7));
		  assert(s3.equals(hw.find(s3))); 
		  assert(hw.find(s2) == null); 
		  assert(s3.equals(hw.findByID(3))); 
		  assert(hw.removeStudent(s1));
		  assert(!hw.removeStudent(s4));
		  assert(s3.equals(hw.findByMajor("BS")));
		  assert(hw.findByMajor("AS") == null); 
		  assert(!s5.equals(s6));
		  assert(hw.removeStudent(s3));
		  for(int i = 0; i < 20; i++) {
			  if(i == 0) assert(hw.addStudent(s1));
			  else assert(!hw.addStudent(s1));
		  } 
		  assert(!hw.addStudent(s1));

	}
	
}

//			int indexOfRaw = 0;//This would tell which index need to be filled at the moment
