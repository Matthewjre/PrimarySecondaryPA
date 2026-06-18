package cpsc2150.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a student attempting to register for courses.
 *
 * @invariant name != null && !name.isBlank()
 * @invariant completedCourses != null
 */
public class Student {

    private final String name;
    private final Set<String> completedCourses;
    private final boolean honorsStudent;
    private final int creditHours;

    /**
     * Creates a student.
     *
     * @param name the student's name
     * @param completedCourses course codes the student has already completed
     * @param honorsStudent true if the student is in the honors program
     * @param creditHours the number of credit hours the student has completed
     *
     * @pre name != null && !name.isBlank()
     * @pre completedCourses != null
     * @pre creditHours >= 0
     *
     * @post getName().equals(name)
     * @post getCompletedCourses().equals(completedCourses)
     * @post isHonorsStudent() == honorsStudent
     * @post getCreditHours() == creditHours
     */
    public Student(String name, Set<String> completedCourses,
                   boolean honorsStudent, int creditHours) {
        this.name = name;
        this.completedCourses = new HashSet<>(completedCourses);
        this.honorsStudent = honorsStudent;
        this.creditHours = creditHours;
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name
     *
     * @post getName() != null && !getName().isBlank()
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the course codes the student has completed.
     *
     * @return an unmodifiable set of completed course codes
     *
     * @post getCompletedCourses() != null
     */
    public Set<String> getCompletedCourses() {
        return Collections.unmodifiableSet(completedCourses);
    }

    /**
     * Checks whether the student has completed a course.
     *
     * @param courseCode the course code being checked
     *
     * @return true if the student has completed the given course
     *
     * @pre courseCode != null && !courseCode.isBlank()
     */
    public boolean hasCompleted(String courseCode) {
        return completedCourses.contains(courseCode);
    }

    /**
     * Checks whether the student is an honors student.
     *
     * @return true if the student is an honors student
     */
    public boolean isHonorsStudent() {
        return honorsStudent;
    }

    /**
     * Gets the number of credit hours the student has completed.
     *
     * @return the number of completed credit hours
     *
     * @post getCreditHours() >= 0
     */
    public int getCreditHours() {
        return creditHours;
    }
}