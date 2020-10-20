---
layout: page
title: Archangel Developer Guide
---
* Table of Contents
{:toc}
--------------------------------------------------------------------------------------------------------------------
## **1. Introduction**
### 1.1 Purpose
This document describes the setting up, design, implementation, documentation of Archangel.

### 1.2 Audience
The whole documentation is in general for anyone who wants to understand the documentation and implementation
of Archangel. The following groups are the intended target of this documentation.

1. CS2101/CS2103T Teaching Team - to evaluate Archangel's software architecture, design, 
implementation and documentation.
2. CS2103T Students - to understand Archangel's software architecture, design, 
implementation and documentation in order to enhance and implement some of the features
inside the software.

--------------------------------------------------------------------------------------------------------------------

## **2. Setting up**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **3. Design**

### 3.1 Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.

### 3.2 UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### 3.3 Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a patient).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### 3.4 Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the address book data.
* exposes an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* does not depend on any of the other three components.


<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique `Tag`, instead of each `Person` needing their own `Tag` object.<br>
![BetterModelClassDiagram](images/BetterModelClassDiagram.png)

</div>


### 3.5 Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

The `Storage` component,
* can save `UserPref` objects in json format and read it back.
* can save the address book data in json format and read it back.

### 3.6 Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **4. Implementation**

This section describes some noteworthy details on how certain features are implemented.

### 4.1 Patient Commands
#### 4.1.1 Add Patient
#### 4.1.2 View Patient
#### 4.1.3 Delete Patient
#### 4.1.4 Edit Patient
#### 4.1.5 Find Patient
#### 4.1.6 List Patient

--------------------------------------------------------------------------------------------------------------------
### 4.2 Appointment Commands
#### 4.2.1 Schedule Appointment
![Interactions Inside the Logic Component for the `a-schedule` Command](images/ScheduleAppointmentSequenceDiagram.png)
###### Implementation
The implementation of scheduling an appointment has a similar execution as adding a patient (see 4.1.1).

The user's input is parsed by the `ScheduleAppointmentCommandParser` class which extends `Parser`, resulting in an `AppointmentScheduleCommand` which extends `Command`.
Subsequently, the `LogicManager` executes the `AppointmentScheduleCommand` object to schedule an appointment.

The `Appointment` class stores relevant fields (e.g. `AppointmentTime`, `Description`) and the `Patient`, **and/or** a string representing the patient's index in the `ObservableList<Patient>`, depending on which constructor was invoked on creation of an `Appointment` object.

#### Reason for design of implementation:
The reason for having 2 `Appointment` constructors is to improve the ease of scheduling an appointment by the user using the CLI.

To address the problem of mandatory fields being highly time-consuming, we have decided to allow users to simply input a `patientIndex` to identify the patient from the visible `ObservableList<Patient>` without being concerned with typing the exact name or details of the desired patient to assign to the `Appointment`.

#### Design consideration:

##### Aspect: How `Patient` is stored in an `Appointment` object
* **Alternative 1 (current choice):** Saves the `Patient` object and/or the `patientIndex` String
  * Pros: 
    * Easy to implement, gives a less stringent check for `isSameAppointment` for other Appointment-type commands (e.g. `AppointmentEditCommand`). 
    * This allows for creation of `Appointment` objects which are not duplicates yet have the same `Patient` and/or `patientIndex` during command execution.
  * Cons: More test cases necessary to ensure that `patientIndex` is correctly parsed and retrieved from patient list in `AddressBook`.

* **Alternative 2:** Saves only the `Patient` object after parsing the `patientIndex` String
  * Pros: No extra parsing/handling of `Patient` once `Appointment` object has been created.
  * Cons: Difficult to edit the patient-field in an `Appointment` object as all fields of the `Patient` object itself must be present.
  

#### 4.2.2 Delete Appointment

###### Implementation
The implementation of deleting an appointment has a similar execution as deleting a patient (see 4.1.3).

The user's input is parsed by the `DeleteAppointmentCommandParser` class which extends `Parser`, resulting in an `AppointmentDeleteCommand` which extends `Command`.
Subsequently, the `LogicManager` executes the `AppointmentDeleteCommand` object to delete the appointment with the given index in `ObservableList<Appointment>`.

#### 4.2.3 Edit Appointment

![Interactions Inside the Logic Component for the `a-edit` Command](images/EditAppointmentSequenceDiagram.png)

###### Implementation
The implementation of editing an appointment has a similar execution as editing a patient (see 4.1.4).

The user's input is parsed by the `EditAppointmentCommandParser` class which extends `Parser`, resulting in an `AppointmentEditCommand` which extends `Command`.
Subsequently, the `LogicManager` executes the `AppointmentEditCommand` object to edit the appointment with the given index in `ObservableList<Appointment>`.

#### Reason for design of implementation:
The reason for having an `EditAppointmentDescriptor` is to enforce immutability by always creating the edited appointment as a new `Appointment` object.

#### Design consideration:

##### Aspect: How `Patient` is edited in an `Appointment` object
* **Alternative 1 (current choice):** Edits the `Patient` in the `Appointment` using a `patientIndex` String (e.g. `a-edit 1 pt/2`)
  * Pros: Easy for users to change the patient for the appointment using a single `patientIndex`.
  * Cons: `patientIndex` has to be carefully parsed and retrieved from a patient list that correctly reflects the patient list on the GUI.

* **Alternative 2:** Edits the `Patient` in the `Appointment` by `patientName` (e.g. `a-edit 1 pt/John Doe`)
  * Pros: None.
  * Cons: Greater difficulty for users to input the new `Patient` since the `patientName` may not be unique nor accurate to an existing patient in the patient list.
  

#### 4.2.4 Find Appointment (Patient)
#### 4.2.5 Find Appointment (Tag)
#### 4.2.6 Find Appointment (Today)
#### 4.2.7 Find Appointment (Current Week)
#### 4.2.8 List Appointment

--------------------------------------------------------------------------------------------------------------------

### 4.3 General Commands
#### 4.3.1 Undo/redo feature

###### Implementation

The proposed undo/redo mechanism is facilitated by `UserHistoryManager`. It extends `AddressBook` with an undo/redo history, stored internally in `userHistory` as  `Stack<Pair<List<Patient>, List<Appointment>>>`. Additionally, it implements the following operations:

* `UserHistoryManager#addHistory()` — Saves the current address book state in its history.
* `UserHistoryManager#undoHistory()` — Restores the previous address book state from its history.
* `UserHistoryManager#redoHistory()` — Restores a previously undone address book state from its history.

These operations are exposed in the `ModelManager` class as `ModelManager#getUserHistoryManager()`, `ModelManager#undoHistory()` and `Model#redoHistory()` respectively.

<!-- 
//I commented out the UML diagrams as I did not use the same design the AB3. Will design my own diagram in later commits.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step. 

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th patient in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new patient. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</div>

Step 4. The user now decides that adding the patient was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

![CommitActivityDiagram](images/CommitActivityDiagram.png)
--->

#### Reason for design of implementation:
The reason for the design of userHistory using a stack is due to the functionality of `undoHistory()`. We want to be able undo the latest changes to the `UniquePatientList` or `UniqueAppointmentList`.
This follows the `Last In,First Out(LIFO)` design which can be implementated using the `stack` data structure.

A concern using this design is that the memory usage might be undesirable due to the large of memory usage needed to store every user history at each command.
However, after many test runs, we concluded that the memory usage of the user history was insignificant and thus this design can be safely implememented with no drawbacks.

#### Design consideration:

##### Aspect: How undo & redo executes

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the patient being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.
  
* **Alternative 3:** Individual command is contained in a `reversible-pair-action` class. When we want to `undo`, we can just call its `pair command`.
  * Pros: Will use less memory (due to the fact that are not saving any additional data).
  * Cons: Very difficult to implement, some commands might not have `pair command`(e.g for `edit`, it is own pair command but pair command to call for undo is hard to implement).

#### 4.3.2 Help


### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **5. Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **6. Appendix: Requirements**

### 6.1 Product scope

**Target user profile**:

* has a need to manage a significant number of patient's contacts/details
* has a preference to check his schedule on desktop over handwritten schedule
* has a need to store patient's information on desktop
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: provide an application for psychiatrists to manage their patient's medical information and their upcoming appointments.


### 6.2 User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​          | I want to …​                                   | So that I can…​                                                        |
| -------- | --------------- | --------------------------------------------- | --------------------------------------------------------------------- |
| `* * *`  | Psychiatrist    | view the appointment history of my patient    | decide when I can schedule the next appointment for the patient.      |
| `* * *`  | Psychiatrist    | delete full patient records                   | remove any irrelevant patient records                                 |
| `* * *`  | Psychiatrist    | record details about the patient              | access his/her psychotherapy progress.                                |
| `* * *`  | Psychiatrist    | view my patient’s medical information         | access the type and dosage of medication to provide.                  |
| `* * *`  | Psychiatrist    | view my patient’s contact information         | I can contact them for their appointments.                            |
| `* * *`  | Psychiatrist    | store my patient’s reviews/preference         | I can alter the treatment plan to suit his preferences.               |

*{More to be added}*

### 6.3 Use cases

(For all use cases below, the **System** is the `AddressBook` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Delete a patient**

**MSS**

1.  User requests to list patients
2.  AddressBook shows a list of patients
3.  User requests to delete a specific patient in the list
4.  AddressBook deletes the patient

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. AddressBook shows an error message.

      Use case resumes at step 2.

**Use case: Edit a patient**

**MSS**

1.  User requests to view a patient.
2.  AddressBook shows the patient's information.
3.  User requests to the patient's information.
4.  AddressBook edits the patient's information.

    Use case ends.

**Extensions**

* 1a. The patient is not found.

    * 1a1. AddressBook shows an error message.

      Use case ends.

* 3a. The patient is not found.

    * 3a1. AddressBook shows an error message.

      Use case resumes at step 2.
      
**Use case: Schedule a patient appointment**

**MSS**

1.  User requests to show appointment list
2.  AddressBook shows appointment list
3.  User requests to schedule a patient appointment
4.  AddressBook schedule the patient appointment

    Use case ends.

**Extensions**

* 2a. The appointment has conflict with another appointment.

  Use case ends.

* 3a. The appointment's date/timing is invalid.

    * 3a1. AddressBook shows an error message.

      Use case resumes at step 3.
      
**Use case: Delete a patient appointment**

**MSS**

1.  User requests to delete a specific appointment in the list
2.  AddressBook deletes the appointment 

    Use case ends.

**Extensions**

* 1a. The appointment does not exist.

    * 1a1. AddressBook shows an error message.
  
      Use case resumes at step 1.

* 1b. The appointment list is empty.

    * 1a1. AddressBook shows an error message.
  
      Use case resumes at step 1.

*{More to be added}*

### 6.4 Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 patients without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4.  Should be able to schedule up to 100 appointments per patient without a noticeable sluggishness in performance for typical usage.

*{More to be added}*

### 6.5 Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Private contact detail**: A contact detail that is not meant to be shared with others
* **Priority Patient**: A patient that requires more attention that the typical patient.

--------------------------------------------------------------------------------------------------------------------

## **7. Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### 7.1 Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### 7.2 Deleting a patient

1. Deleting a patient while all patients are being shown

   1. Prerequisites: List all patients using the `list` command. Multiple patients in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No patient is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### 7.3 Viewing a patient

1. Viewing a patient while all patients are being shown

   1. Test case: `view Kim Guan`<br>
      Expected: Details of patient named 'Kim Guan' is shown.

   2. Other incorrect delete commands to try: `view`, `view x`, `...` (where x is not in the list)<br>
      Expected: Error details shown in status message. Status bar remains the same.

2. _{ more test cases …​ }_

### 7.4 Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

2. _{ more test cases …​ }_
