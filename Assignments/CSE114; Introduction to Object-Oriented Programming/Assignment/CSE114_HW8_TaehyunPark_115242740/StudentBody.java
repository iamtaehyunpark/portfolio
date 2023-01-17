class StudentBody {
    private Student[] students;

    public StudentBody(Student[] students) {
        this.students = students;
    }

    public void setOrdering(int order) {
        for (int i = 0; i < this.students.length; i++) {
            this.students[i].setOrdering(order);
        }
    }

    public void sort() {
        Selection.selectionSort(this.students);
    }

    public void printStudents() {
        ArrayTools.printArray(this.students, this.students[0].getOrdering());
    }
}