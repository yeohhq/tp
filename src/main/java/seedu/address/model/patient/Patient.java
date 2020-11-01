package seedu.address.model.patient;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Patient in the Archangel.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient {

    // Identity fields
    private final Name name;
    private final Gender gender;
    private final Birthdate birthdate;
    private final BloodType bloodtype;

    // Data fields
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    // Extra fields
    private final Remark remark;

    /**
     * Every field must be present and not null.
     */
    public Patient(Name name, Gender gender,
                   Birthdate birthdate, BloodType bloodtype,
                   Phone phone, Email email,
                   Address address, Remark remark,
                   Set<Tag> tags) {
        requireAllNonNull(name, birthdate, bloodtype, phone, email, address, tags);
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.bloodtype = bloodtype;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.remark = remark;
        this.tags.addAll(tags);
    }

    public Patient(Patient patient) {
//        String patientNameCopy = patient.name.toString();
//        this.name = new Name(patientNameCopy);
//        String patientGender = patient.gender.toString();
//        this.gender = new Gender(patientGender);
//        String patientBirthdate = patient.birthdate.toString();
//        this.birthdate = new Birthdate(patientBirthdate);
//        String patientBloodType = patient.bloodtype.toString();
//        this.bloodtype = new BloodType(patientBloodType);
//        String patientPhone = patient.phone.toString();
//        this.phone = new Phone(patientPhone);
//        String patientEmail = patient.email.toString();
//        this.email = new Email(patientEmail);
//        String patientAddress = patient.address.toString();
//        this.address = new Address(patientAddress);
//        String patientRemark = patient.remark.toString();
//        this.remark = new Remark(patientRemark);
//        Set<Tag> copy = new HashSet<>();
//        copy.addAll(patient.tags);
//        this.tags.addAll(copy);
        this(patient.getName(),patient.getGender(),patient.getBirthdate(),patient.getBloodType(),patient.getPhone()
        , patient.getEmail(), patient.getAddress() , patient.getRemark(), patient.getTags());
        System.out.println(patient.getName());
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Birthdate getBirthdate() {
        return birthdate;
    }

    public BloodType getBloodType() {
        return bloodtype;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Remark getRemark() {
        return remark;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name, gender, age and bloodtype,
     * and have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePatient(Patient otherPatient) {
        if (otherPatient == this) {
            return true;
        }

        return otherPatient != null
                && otherPatient.getName().equals(getName())
                && otherPatient.getGender().equals(getGender())
                && otherPatient.getBirthdate().equals(getBirthdate())
                && otherPatient.getBloodType().equals(getBloodType())
                && (otherPatient.getPhone().equals(getPhone()) || otherPatient.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPatient = (Patient) other;
        return otherPatient.getName().equals(getName())
                && otherPatient.getGender().equals(getGender())
                && otherPatient.getBirthdate().equals(getBirthdate())
                && otherPatient.getBloodType().equals(getBloodType())
                && otherPatient.getPhone().equals(getPhone())
                && otherPatient.getEmail().equals(getEmail())
                && otherPatient.getAddress().equals(getAddress())
                && otherPatient.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, gender, birthdate, bloodtype, phone, email, address, remark, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Gender: ")
                .append(getGender())
                .append(" Birthdate: ")
                .append(getBirthdate())
                .append(" BloodType: ")
                .append(getBloodType())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
