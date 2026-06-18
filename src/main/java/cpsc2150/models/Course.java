package cpsc2150.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a course that students may attempt to register for.
 *
 * @invariant courseCode != null && !courseCode.isBlank()
 * @invariant title != null && !title.isBlank()
 * @invariant capacity >= 0
 * @invariant currentEnrollment >= 0
 * @invariant currentEnrollment <= capacity
 * @invariant prerequisites != null
 */
public class Course {

    private final String courseCode;
    private final String title;
    private final int capacity;
    private final int currentEnrollment;
    private final Set<String> prerequisites;
    private final boolean honorsOnly;
    private final int minimumCreditHours;

    /**
     * Creates a course.
     *
     * @param courseCode the course code, such as "CPSC 2150"
     * @param title the title of the course
     * @param capacity the maximum number of students allowed
     * @param currentEnrollment the number of students currently enrolled
     * @param prerequisites course codes that must be completed first
     * @param honorsOnly true if only honors students may register
     * @param minimumCreditHours the minimum completed credit hours needed
     *
     * @pre courseCode != null && !courseCode.isBlank() AND title != null && !title.isBlank()
     * AND capacity >= 0 AND currentEnrollment >= 0 && currentEnrollment <= capacity
     * AND prerequisites != null AND minimumCreditHours >= 0
     *
     * @post getCourseCode().equals(courseCode) AND getTitle().equals(title) AND
     * getCapacity() == capacity AND getCurrentEnrollment() == currentEnrollment AND
     * getPrerequisites().equals(prerequisites) AND isHonorsOnly() == honorsOnly
     * AND getMinimumCreditHours() == minimumCreditHours
     */
    public Course(String courseCode, String title, int capacity,
                  int currentEnrollment, Set<String> prerequisites,
                  boolean honorsOnly, int minimumCreditHours) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
        this.currentEnrollment = currentEnrollment;
        this.prerequisites = new HashSet<>(prerequisites);
        this.honorsOnly = honorsOnly;
        this.minimumCreditHours = minimumCreditHours;
    }

    /**
     * Gets the course code.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Gets the course title.
     *
     * @return the course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the maximum enrollment capacity.
     *
     * @return the course capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the current enrollment.
     *
     * @return the current number of enrolled students
     */
    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    /**
     * Gets the prerequisite course codes.
     *
     * @return an unmodifiable set of prerequisite course codes
     */
    public Set<String> getPrerequisites() {
        return Collections.unmodifiableSet(prerequisites);
    }

    /**
     * Checks whether the course is honors-only.
     *
     * @return true if the course is restricted to honors students
     */
    public boolean isHonorsOnly() {
        return honorsOnly;
    }

    /**
     * Gets the minimum credit hours needed to register.
     *
     * @return the minimum completed credit hours
     */
    public int getMinimumCreditHours() {
        return minimumCreditHours;
    }
}