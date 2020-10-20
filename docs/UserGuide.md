---
layout: page
title: User Guide
---

Archangel is a desktop app for managing patient appointments, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, Archangel can get your patient management appointment done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1. Quick start

1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest `archangel.jar` from [here](https://github.com/AY2021S1-CS2103T-W11-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `p-list` : Lists all patients.

   * **`p-add`**`n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25` : Adds a Patient named John Doe to the Archangel.

   * **`p-delete`**`3` : Deletes the 3rd patient shown in the current list.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 2. Features

### 2.1 General Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Commands are identified by their quantifier type leading the actual command formatted as `{TYPE}-{COMMAND}`.
  * `p-{COMMAND}` - commands that acts on Patient-type data.
  * `a-{COMMAND}` - commands that acts on Appointment-type data.
  <br> e.g. `p-delete` deletes a patient, `a-delete` deletes an appointment.

* Words in UPPER_CASE are the parameters to be supplied by the user.<br>
  e.g. in `p-add n/NAME`, `NAME` is a parameter which can be used as `p-add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as   (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

#### 2.1.1 Viewing help : help

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

#### 2.1.2 Exiting the program : `exit`

Exits the program.

Format: `exit`

#### 2.1.3 Saving the data

The Archangel data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 2.2 Patient Features

#### 2.2.1 Adding a patient: `p-add`

Adds a patient to the address book.
Format: `p-add n/NAME g/GENDER bd/BIRTHDATE bt/BLOODTYPE p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…`​

* BIRTHDATE should be in YYYY/MM/DD format.

<div markdown="span" class="alert alert-primary">:bulb: Tip:
A patient can have any number of tags (including 0)
</div>

Examples:
* `p-add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `p-add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

#### 2.2.2 Listing all patients : `p-list`

Shows a list of all patients in the address book.

Format: `p-list`

#### 2.2.3 Editing a patient : `p-edit`

Edits an existing patient in the address book.

Format: `p-edit INDEX [n/NAME] [g/GENDER] [bd/BIRTHDATE] [bt/BLOODTYPE] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the patient at the specified INDEX. The index refers to the index number shown in the displayed patient list. The index must be a positive integer 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing `t/` without specifying any tags after it.

Examples:
* `p-edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be 91234567 and johndoe@example.com respectively.
* `p-edit 2 n/Betsy Crower t/` Edits the name of the 2nd patient to be Betsy Crower and clears all existing tags.

#### 2.2.4 Locating patients by name: `p-find`

Finds patients whose names contain any of the given keywords.

Format: `p-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. OR search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `p-find John` returns `john` and `John Doe`
* `p-find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

#### 2.2.5 Giving a patient a Remark : `p-remark`

Stores a remark under the patient's information.
Recommended usage would be to store Allergies, Preferences, etc.

Format: `p-remark INDEX r/REMARK`

* Store a remark for the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `p-remark 1 r/ Likes to swim.` gives the 1st patient in the list a remark of `Likes to swim.`

#### 2.2.6 Removing a patient's Remark : `p-remark`

Stores a remark under the patient's information.

Format: `p-remark INDEX`

* Removes the remark for the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `p-remark 1` removes the Remark of the 1st patient on the list.

#### 2.2.7 Deleting a patient : `p-delete`

Deletes the specified patient from the Archangel.

Format: `p-delete INDEX`

* Deletes the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `p-list` followed by `p-delete 2` deletes the 2nd patient in the Archangel.
* `p-find Betsy` followed by `p-delete 1` deletes the 1st patient in the results of the find command.


### 2.3 Appointment Features

#### 2.3.1 Schedule an appointment : `a-schedule`

Schedules a new patient appointment in Archangel.

Format: `a-schedule i/INDEXOFPATIENT start/DATE&TIME end/DATE&TIME d/DESCRIPTION [t/TAGS]…`

* Schedules patient appointment for patient NAME.
* Appointment will be set to input DATE (format: YYYY-MM-DD) and TIME (format: HH:MM).

Examples:
* `a-schedule i/2 start/2020-09-14 08:00 end/2020-09-14 10:00 d/Review Appointment` schedules an appointment for patient 2 on 2020-09-14 at 08-00 with appointment description Review Appointment.

#### 2.3.2 List all appointments : `a-list`

Shows a list of all patient appointments in Archangel.

Format: `a-list`

#### 2.3.3 Delete an appointment : `a-delete`

Deletes the specified patient appointment from Archangel.

Format: `a-delete INDEX`

* Deletes the appointment at the specified INDEX.
* The index refers to the index number shown in the displayed appointment list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `a-list` followed by `a-delete 2` deletes the 2nd appointment in the Archangel.
* `a-find Review` followed by `a-delete 1` deletes the 1st appointment in the results of the find command.

#### 2.3.4 Find appointments by patient name : `a-find`

Finds appointments whose patient's name contains any of the given keywords.

Format: `a-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `jack` will match `Jack`
* The order of the keywords does not matter. e.g. `Jack Jill` will match `Jill Jack`
* Only the patient name inside the appointment is searched.
* Only full words will be matched e.g. `Jack` will not match `Jacky`
* Appointments matching at least one keyword will be returned (i.e. OR search).
  e.g. `Jack Jill` will return Appointments with Patient name of `Jack Sparrow`, `Jill Ous`

Examples:
* `a-find Jack` returns Appointment with Patient name of `Jack Sparrow`
* `a-find Jack Jill` returns Appointments with Patient name of `Jack Sparrow` and `Jill Ous`

#### 2.3.5 Edit an appointment : `a-edit`

Edits an existing patient appointment in Archangel.

Format: `a-edit INDEX [start/DATE&TIME] [end/DATE&TIME] [d/DESCRIPTION] [t/TAGS]…`

* Edits the appointment at the specified INDEX. The index refers to the index number shown in the displayed appointment list. The index must be a positive integer 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the appointment will be removed i.e adding of tags is not cumulative.
* You can remove all the appointment’s tags by typing `t/` without specifying any tags after it.

Examples:
* `a-edit 1 start/2020-09-15 12:00 end/2020-09-15 14:00` Edits the start and end date & time of the 1st appointment to be 15/9/2020 12:00 and 15/9/2020 14:00 respectively.
* `p-edit 2 d/Review Session /t` Edits the description of the 2nd appointment to be Review Session and clears all existing tags.

#### 2.3.6 Find appointments by tags: `a-tag`
Finds appointments who are tagged by any of the given keywords.

Format: `a-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `friends` will match `Friends`
* The order of the keywords does not matter. e.g. `friends enemy` will match `Friends Enemy`
* Only the tags inside the appointment is searched.
* Only full words will be matched e.g. `Friend` will not match `Friends`
* Appointments matching at least one keyword will be returned (i.e. OR search).
  e.g. `friends enemy` will return Appointment tagged with `Friends`, `Jill Ous`

Examples:
* `a-tag friend` returns Appointments tagged `Friend`
* `a-tag friend enemy`  returns Appointments tagged `Friend` and `Enemy`

#### 2.3.7 Find an appointment by current date: `a-today`
Finds appointments schedule on the current date.

* The search has no keywords

Examples:
* `a-today` returns Appointments scheduled today.

#### 2.3.8 Find an appointment by current date: `a-upcoming`
Finds appointments schedule on the current week.

* The search has no keywords

Examples:
* `a-upcoming` returns Appointments scheduled this week (from Sunday to Saturday).
--------------------------------------------------------------------------------------------------------------------

## FAQ

Q: How do I transfer my data to another Computer?<br>
A: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action                               | Format, Examples
-------------------------------------|------------------------------------------------------------------------------
Add Patient                          | `p-add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…`​ <br> e.g. `p-add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
View Patient                         | `p-view n/NAME` <br>e.g. `p-view n/Kim Guan`
Delete Patient                       | `p-delete INDEX` <br>e.g. `p-delete 3`
Edit Patient                         | `p-edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br> e.g. `p-edit 2 n/James Lee e/jameslee@example.com`
Find Patient                         | `p-find KEYWORD [MORE_KEYWORDS]` <br> e.g. `p-find James Jake`
List Patients                        | `p-list`
Help                                 | `help`
Schedule Appointment                 | `a-schedule i/INDEXOFPATIENT start/DATE&TIME end/DATE&TIME d/DESCRIPTION [t/TAGS]…`​<br> e.g. `a-schedule i/2 start/2020-09-14 08:00 end/2020-09-14 10:00 d/Review Appointment`
Delete Appointment                   | `a-delete INDEX` <br>e.g. `a-delete 3`
Edit Appointment                     | `a-edit INDEX [start/DATE&TIME] [end/DATE&TIME] [d/DESCRIPTION] [t/TAGS]…` <br> e.g. `a-edit 2 start/2020-09-15 12:00 end/2020-09-15 14:00`
List Appointments                    | `a-list`
Find Appointments by Patient         | `a-find KEYWORD [MORE_KEYWORDS]` <br> e.g. `a-find Jack`
Find Appointments by Tags            | `a-tag KEYWORD [MORE_KEYWORDS]` <br> e.g. `a-find friends`
Find Appointments by Current Date    | `a-today`
Find Appointments by Current Week    | `a-upcoming`

