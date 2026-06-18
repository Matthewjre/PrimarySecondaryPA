package registration;

import cpsc2150.models.Course;
import cpsc2150.models.Student;

/**
 * Determines whether a student can register for an honors-restricted course.
 *
 * This version intentionally does not use inheritance or abstraction.
 * All registration logic is implemented directly in this class, even when
 * that causes duplicate code with StandardRegistrationPolicy.
 */
public class HonorsRegistrationPolicy {

    /**
     * Checks whether the student can register for the course.
     *
     * A student can register if:
     * - the course is open
     * - the student has completed all prerequisites
     * - the student has enough credit hours
     * - the student is an honors student
     *
     * @param student the student attempting to register
     * @param course the course the student wants to register for
     *
     * @return true if the student can register, false otherwise
     *
     * @pre student != null
     * @pre course != null
     *
     * @post canRegister returns true iff the course is open, the student has
     *       completed all prerequisites, the student has enough credit hours,
     *       and the student is an honors student
     */
    public boolean canRegister(Student student, Course course) {
        return isOpen(course)
                && hasPrerequisites(student, course)
                && hasEnoughCreditHours(student, course)
                && isHonorsStudent(student);
    }

    /**
     * Gives a reason explaining why the student cannot register.
     *
     * @param student the student attempting to register
     * @param course the course the student wants to register for
     *
     * @return a message explaining the registration result
     *
     * @pre student != null
     * @pre course != null
     *
     * @post getRejectionReason returns a non-null, non-empty message
     */
    public String getRejectionReason(Student student, Course course) {
        if (!isOpen(course)) {
            return "Course is full.";
        }

        if (!hasPrerequisites(student, course)) {
            return "Student has not completed the required prerequisites.";
        }

        if (!hasEnoughCreditHours(student, course)) {
            return "Student does not have enough credit hours.";
        }

        if (!isHonorsStudent(student)) {
            return "Student is not in the honors program.";
        }

        return "Student can register.";
    }

    /**
     * Checks whether the course has available seats.
     *
     * @param course the course being checked
     *
     * @return true if current enrollment is below capacity
     *
     * @pre course != null
     *
     * @post isOpen returns true iff course current enrollment is less than capacity
     */
    public boolean isOpen(Course course) {
        return course.getCurrentEnrollment() < course.getCapacity();
    }

    /**
     * Checks whether the student has completed all prerequisites for the course.
     *
     * @param student the student attempting to register
     * @param course the course the student wants to register for
     *
     * @return true if the student has completed every prerequisite course
     *
     * @pre student != null
     * @pre course != null
     *
     * @post hasPrerequisites returns true iff the student's completed courses
     *       contain all of the course prerequisites
     */
    public boolean hasPrerequisites(Student student, Course course) {
        return student.getCompletedCourses().containsAll(course.getPrerequisites());
    }

    /**
     * Checks whether the student has enough completed credit hours.
     *
     * @param student the student attempting to register
     * @param course the course the student wants to register for
     *
     * @return true if the student has at least the minimum required credit hours
     *
     * @pre student != null
     * @pre course != null
     *
     * @post hasEnoughCreditHours returns true iff the student's credit hours are
     *       greater than or equal to the course minimum credit hours
     */
    public boolean hasEnoughCreditHours(Student student, Course course) {
        return student.getCreditHours() >= course.getMinimumCreditHours();
    }

    /**
     * Checks whether the student is in the honors program.
     *
     * @param student the student attempting to register
     *
     * @return true if the student is an honors student
     *
     * @pre student != null
     *
     * @post isHonorsStudent returns true iff student.isHonorsStudent() is true
     */
    public boolean isHonorsStudent(Student student) {
        return student.isHonorsStudent();
    }
}