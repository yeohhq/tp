---
layout: page
title: User Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1 Introduction

Archangel is a desktop application for managing patient appointments, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
Archangel integrates storing of patient data and scheduling patient appointments in a single application.
It supports adding, editing, deleting of patients/appointments and facilitates search using filter commands to help improve your experience in handling patient data.
If you can type fast, Archangel can get your patient management appointment done faster than traditional GUI apps.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/GUI_Labelled_1.png" width="95%" /> <br />
<img src="images/GUI_Labelled_2.png" width="95%" /> <br />
Figure 1: <i>The user interface of Archangel.</i>
</div>

### 1.2 User Guide Icons

These are icons that are used throughout this User Guide for better readability:
- :bulb: — A useful tip for the users when using Archangel.
- :information_source: — A point for users to take note of.
- `code` — Indicates commands that will be type into the <i>command box</i> (see below)

### 1.3 Quick start

1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest `archangel.jar` from [here](https://github.com/AY2021S1-CS2103T-W11-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for Archangel.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   <img src="images/Ui.png" width="150%"> <br />

5. Type the command in the command box and press `Enter` to execute it. e.g. typing `help` and pressing `Enter` will open the help window.<br>
   Some example commands you can try:

   * `p-list` : Lists all patients.

   * `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25` : Adds a Patient named John Doe to the Archangel.

   * `p-delete 3` : Deletes the 3rd patient shown in the current list.

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

#### 2.1.1 Viewing help : `help`

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

Adds a patient to Archangel.

"A new patient has contacted me and wants to make an appointment. First, I have to add him along with his details to Archangel!" One of the most fundamental use of Archangel; to store patient data, can be done through the command `p-add`

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* Compulsory fields include NAME, GENDER, BIRTHDATE, BLOODTYPE, PHONE_NUMBER, EMAIL and ADDRESS <br />
* TAGS are not compulsory <br />
* BIRTHDATE should be in YYYY/MM/DD format. <br />
* BLOODTYPE can be only one of the following per patient: `A+`, `A-`, `B+`, `B-`, `O`, `O+`, `O-`, `AB+`, `AB-` <br />
* At initial launch of Archangel, there is a pre-loaded sample list of Patients. <br />
</div>

Format: `p-add n/NAME g/GENDER bd/BIRTHDATE bt/BLOODTYPE p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…`​

Examples:
* `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25` adds a Patient with the mentioned information into Archangel.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.1.1: <i>Figure 2.1.1.1: Before `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25`.</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.1.2: <i>After `Figure 2.1.1.1: After `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25`.</i>
</div>

<div markdown="span" class="alert alert-primary">:bulb: Tip:
A patient can have any number of tags (including 0)
</div>

Examples:
* `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`
* `p-add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

#### 2.2.2 Listing all patients : `p-list`

"I want to see all of my patients in one list." You can do so with the command `p-list`

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* This is the default for Archangel, whenever Archangel is started, the patient list on the right is what you will see on `p-list`. <br />
* Typical use case for this command is to change the current patient list that is being viewed back to the All-Patients list. <br />
</div>

Format: `p-list`

Examples:
* `p-find alex` followed by `p-list` changes the patient list under view from patients with alex in their names to the All-Patients list

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.2.1: <i>Initial state of Archangel at launch(All-Patient list is the list under view!).</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.2.2: <i>After `p-find alex`(All-Patients list changed to List of Patients with Alex in their name!).</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.2.3: <i>After `p-list`(All-Patient list is back as the list under view!).</i>
</div>

#### 2.2.3 Editing a patient : `p-edit`

"Oh no, I keyed in one of my patient's information incorrectly." Do not worry, as you can change your patients' particulars with the command `p-edit`

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* Edits the patient at the specified INDEX. The index refers to the index number shown in the displayed patient list. The index must be a positive integer 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing `t/` without specifying any tags after it.
* For editting of remarks, please look at the commands specifically related to remarks.
* Note: Editing a patient will also update the patient in Appointments that contain the patient.
</div>

Format: `p-edit INDEX [n/NAME] [g/GENDER] [bd/BIRTHDATE] [bt/BLOODTYPE] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`


Examples:
* `p-edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be 91234567 and johndoe@example.com respectively.
* `p-edit 2 n/Betsy Crower t/` Edits the name of the 2nd patient to be Betsy Crower and clears all existing tags.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.3.1: <i>Initial state of Archangel at launch(All-Patient list is the list under view!).</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.3.2: <i>After `p-edit 2 n/Betsy Crower`(Patient at index 2 on the patient list has their name changed to Betsy Crower!).</i>
</div>

#### 2.2.4 Locating patients by name: `p-find`

"I want to find all patients with Yeoh in their names" You can find all of these patients with the command `p-find`

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name will be searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. OR search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
</div>

Format: `p-find KEYWORD [MORE_KEYWORDS]`

Examples:
* `p-find John` returns `John Chew` and `John Doe`
* `p-find alex david` returns `Alex Yeoh`, `David Li`<br>

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.4.1: <i>Initial state of Archangel at launch(All-Patient list is the list under view!).</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.4.2: <i>After `p-find Yeoh`(All patients with Yeoh in their names will be displayed!).</i>
</div>

#### 2.2.5 Giving a patient a Remark : `p-remark`

"One of my patients has allergies. I want to be able to store this information." You can store special information using the command `p-remark`.

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* Store a remark for the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​
</div>

Format: `p-remark INDEX r/REMARK`

Examples:
* `p-remark 1 r/Allergic to nuts.` gives the 1st patient in the list a remark of `Allergic to nuts.`

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.5.1: <i>Before `p-remark 1 /rAllergic to nuts` (patient Alex Yeoh has no remarks.)</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.5.2: <i>After `p-remark 1 /rAllergic to nuts` (Alex Yeoh now has a remark that says "Allergic to nuts!".</i>
</div>

#### 2.2.6 Removing a patient's Remark : `p-remark`

"I want to remove the remark of a patient." You can remove remarks using the command `p-remark`.

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* Removes all your remarks for the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​
</div>

Format: `p-remark INDEX`

Examples:
* `p-remark 1` removes the Remark of the 1st patient on the list.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.6.1: <i>Before `p-remark 1` (patient Alex Yeoh has a remark that says "Allergic to nuts!".)</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.6.2: <i>After `p-remark 1` (Alex Yeoh no longer has a remark!)</i>
</div>

#### 2.2.7 Deleting a patient : `p-delete`

"One of my patients will no longer be visiting. I want to be remove him from Archangel so it looks less cluttered." You can remove patients from Archangel using the command `p-delete`.

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* Deletes the patient at the specified INDEX.
* The index refers to the index number shown in the displayed patient list.
* The index must be a positive integer 1, 2, 3, …​
* Note: Deleting a patient will also delete all Appointments that contains the deleted patient.
</div>

Format: `p-delete INDEX`

Examples:
* `p-delete 1` deletes the 1st patient in Archangel and also deletes all of his/her appointment.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.7.1: <i>Before p-delete 1 (patient Alex Yeoh is in the patient list, and the appointment list shows an appointment under Alex Yeoh.)</i>
<img src="images/UserGuide/filler_image_for_huiqing.png" width="95%" /> <br />
Figure 2.2.7.2: <i>After `p-delete 1` (Alex Yeoh is no longer on the patient list, every appointment under Alex Yeoh is removed from the all-appointments list)</i>
</div>


### 2.3 Appointment Features

#### 2.3.1 Scheduling an appointment : `a-schedule`

Now that you have patients, it is time to schedule your first appointment! Scheduling an appointment is as simple as adding a patient!

Format: `a-schedule pt/INDEX start/DATE&TIME end/DATE&TIME d/DESCRIPTION [t/TAGS]…`

* Schedules patient appointment for patient at INDEX in the displayed patient list.
* Appointment will be set to input DATE (format: YYYY-MM-DD) and TIME (format: HH:MM).
* TAGS should be alphanumeric.
* Appointment time (i.e. duration from `start` to `end`) cannot overlap with another existing appointment.
* Appointment duration should not exceed 24 hours.
* Appointment time must be indicated as HH:MM (i.e. 9AM must be `09:00`, and not `9:00`).

Examples:
* `a-schedule pt/2 start/2020-09-14 08:00 end/2020-09-14 10:00 d/Review Appointment` schedules an appointment for patient 2 on 2020-09-14 at 08-00 with appointment description Review Appointment.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Schedule_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-schedule`.</i>
<img src="images/UserGuide/Schedule_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-schedule`(New appointment added to list!).</i>
</div>

#### 2.3.2 Deleting an appointment : `a-delete`

Oh no! Your patient just called to cancel his appointment! Since we would not be needing it anymore, let's delete the appointment.

Format: `a-delete INDEX`

* Deletes the appointment at the specified INDEX.
* The index refers to the index number shown in the displayed appointment list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `a-list` followed by `a-delete 2` deletes the 2nd appointment in the Archangel.
* `a-find Review` followed by `a-delete 1` deletes the 1st appointment in the results of the find command.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Delete_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-delete`.</i>
<img src="images/UserGuide/Delete_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-delete'(Appointment is gone!).</i>
</div>

#### 2.3.3 Editing an appointment : `a-edit`

What if your patients decides to change his appointment details? Archangel allows you to edit existing patient appointments.

Format: `a-edit INDEX [start/DATE&TIME] [end/DATE&TIME] [pt/PATIENT INDEX] [d/DESCRIPTION] [t/TAGS]…`

* Edits the appointment at the specified INDEX. The index refers to the index number shown in the displayed appointment list. The index must be a positive integer 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the appointment will be removed i.e adding of tags is not cumulative.
* You can remove all the appointment’s tags by typing `t/` without specifying any tags after it.
* Tags must be alphanumeric and individual tags cannot be separated by spaces (i.e. `HighPriority` is a valid input, while `High Priority` is an invalid input).

Examples:
* `a-edit 1 start/2020-09-15 12:00 end/2020-09-15 14:00 pt/2` Edits the start and end date & time of the 1st appointment to be 15/9/2020 12:00 and 15/9/2020 14:00 respectively, and edits patient to 2nd patient in patient list.
* `p-edit 2 bd/1998-09-15 ` Edits the 2nd Patient on the PatientList to have a birthdate of 1998-09-15.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Edit_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-edit`.</i>
<img src="images/UserGuide/Edit_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-edit`(Appointment details changed!).</i>
</div>

#### 2.3.4 Setting appointment as completed : `a-complete`

You have just finished an appointment. Instead of deleting it, let's set it as completed. This way it will be hidden from you by default,
but you can still find it using specific commands.

Format: `a-complete INDEX`

* Edits the appointment at the specified INDEX.
* The index refers to the index number shown in the displayed appointment list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `a-complete 1` Sets the appointment at index 1 as completed.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Complete_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-complete 1`.</i>
<img src="images/UserGuide/Complete_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-complete 1`(Appointment 1 is now labelled as Done).</i>
</div>

#### 2.3.5 Listing all past and present appointments : `a-listall`

You can also view a combined list of all appointments including missed, completed and upcoming patient appointments.

Format: `a-listall`

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/ListAll_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-listall`.</i>
<img src="images/UserGuide/ListAll_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-listall`.</i>
</div>

#### 2.3.6 Filtering appointment list

If you are looking for a specific appointment, Archangel allows you to filter your appointment list in many different ways.

##### 2.3.6.1 Listing all upcoming appointments : `a-list`

Shows a list of all your uncompleted patient appointments in Archangel.

Format: `a-list`

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/List_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-list`.</i>
<img src="images/UserGuide/List_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-list`.</i>
</div>

##### 2.3.6.2 Finding appointments by patient name : `a-find`

Finds your appointments which the patient's name contains any of the given keywords.

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

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Find_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-find jack`.</i>
<img src="images/UserGuide/Find_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-find jack`.</i>
</div>

##### 2.3.6.3 Finding appointments by tags: `a-tag`
Finds your appointments which are tagged by any of the given keywords.

Format: `a-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `friends` will match `Friends`
* The order of the keywords does not matter. e.g. `friends enemy` will match `Friends Enemy`
* Only the tags inside the appointment will be searched.
* Only full words will be matched e.g. `Friend` will not match `Friends`
* Appointments matching at least one keyword will be returned (i.e. OR search).
  e.g. `friends enemy` will return Appointment tagged with `Friends`, `Jill Ous`

Examples:
* `a-tag friend` returns Appointments tagged `Friend`
* `a-tag friend enemy`  returns Appointments tagged `Friend` and `Enemy`

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Tag_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-tag`.</i>
<img src="images/UserGuide/Tag_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-tag`.</i>
</div>

##### 2.3.6.4 Finding an appointment by current date: `a-today`
Finds your uncompleted appointments scheduled on the current date.

Format: `a-today`

Examples:
* `a-today` returns Appointments scheduled today.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Today_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-today`.</i>
<img src="images/UserGuide/Today_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-today`.</i>
</div>

##### 2.3.6.5 Finding an appointment by current week: `a-upcoming`
Finds your uncompleted appointments scheduled in the current week.

Format: `a-upcoming`

Examples:
* `a-upcoming` returns uncompleted Appointments scheduled this week (from Sunday to Saturday).

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Upcoming_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-upcoming`.</i>
<img src="images/UserGuide/Upcoming_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-upcoming`.</i>
</div>

##### 2.3.6.6 Listing appointments that are completed: `a-completed`
Shows a list of all your appointments that have been completed.

Format: `a-completed`

Examples:
* `a-completed` returns all completed Appointments.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Completed_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-completed`.</i>
<img src="images/UserGuide/Completed_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-completed`.</i>
</div>

##### 2.3.6.7 Listing appointments that are missed: `a-missed`
Shows a list of all your appointments that have been missed.

Format: `a-missed`

Examples:
* `a-missed` returns all missed Appointments.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Missed_Example_1.png" width="95%" /> <br />
Figure 2.4.1.1: <i>Before `a-missed`.</i>
<img src="images/UserGuide/Missed_Example_2.png" width="95%" /> <br />
Figure 2.4.1.2: <i>After `a-missed`.</i>
</div>

### 2.4 General Commands

#### 2.4.1 Undoing the previous command : `undo`
"Oops, I accidentally deleted the wrong appointment!", fret not! You can undo your commands through the command `undo`

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* This command has no keywords  <br />
* This command does not work with filter commands (`a-completed`,`a-missed`,`a-upcoming`,`a-today`,`a-find`,`a-list`)  <br />
  as its implementation purpose is to assist the user in undo-ing his changes, filter commands do not make changes to the data.  <br />
  It also does not work with `p-edit` as the design requires patient details to be accurate as of time schedule, such that the  
  records can accurately reflect the patient's conditions at the time of the appointment. <br />
* A list of commands that can be undone can be found in the table under Command Summary.  <br />
* This command can be succeeded by a `redo` command
</div>

Format: `undo`

Examples:
* `p-delete 1` followed by `undo` undoes the edit command and make no changes to Archangel.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Undo_Example_1.png" width="150%"> <br />
Figure 2.4.1.1: <i>Before `a-delete 1`.</i>
<img src="images/UserGuide/Undo_Example_2.png" width="150%" /> <br />
Figure 2.4.1.2: <i>After `a-delete 1`(Roy is gone!).</i>
<img src="images/UserGuide/Undo_Example_3.png" width="150%" /> <br />
Figure 2.4.1.3: <i>After `undo`(Roy is back!).</i>
</div>

#### 2.4.2 Redoing the previous command : `redo`
When there is an `undo`, there is always a `redo`! You can always `redo` commands that you `undo` previously!

<div markdown="span" class="alert alert-primary">
:information_source: **Things to Note:**  <br />
* This command has no keywords  <br />
* This command must be preceded by `undo`
</div>

Format: `redo`

Examples:
* `p-delete 1` followed by `undo` then `redo` redoes the `undo` command and carries out the delete command.

<div style="text-align: center; padding-bottom: 2em">
<img src="images/UserGuide/Undo_Example_2.png" width="150%" /> <br />
Figure 2.4.2.1: <i>After `a-delete 1`(Roy is gone!).</i>
<img src="images/UserGuide/Undo_Example_3.png" width="150%" /> <br />
Figure 2.4.2.2: <i>After `undo`(Roy is back!).</i>
<img src="images/UserGuide/Redo_Example_1.png" width="150%" /> <br />
Figure 2.4.2.3: <i>After `redo`(Roy is gone!).</i>
</div>

### 2.5 Miscellaneous Features

#### 2.5.1 Suggestion Box
Find it troublesome to keep referring to the User Guide for the format of commands? You can always refer to the suggestion box which is shown once you typing your commands. As you type letter by letter, the suggestion box will automatically match your input to the most similar command, allowing you to refer to it on the go!

<div style="text-align: center; padding-bottom: 2em">
<img src="https://raw.githubusercontent.com/AY2021S1-CS2103T-W11-1/tp/master/docs/images/UserGuide/Suggestion_Box.gif" width="95%" /> <br />
Figure 2.5.1: <i>The suggestion box provides the format as you insert a `p-add` command.</i>
</div>

#### 2.5.2 In-built Calendar feature
You can refer to the in-built calendar feature to view all the appointments within the week at a glance. 

<div style="text-align: center; padding-bottom: 2em">
<img src="https://raw.githubusercontent.com/AY2021S1-CS2103T-W11-1/tp/master/docs/images/UserGuide/CalendarButton.png" width="50%" /> <br />
Figure 2.5.2.1: <i>Click on the calendar button.</i>  
<img src="https://raw.githubusercontent.com/AY2021S1-CS2103T-W11-1/tp/master/docs/images/UserGuide/CalendarView.png" width="95%" /> <br />
Figure 2.5.2.2: <i>The calendar panel will be shown with all the appointments in the week listed.</i>  
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

Q: How do I transfer my data to another Computer?<br>
A: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Archangel home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action                               | Format, Examples | Compatible with `undo`
-------------------------------------|------------------------------------------------------------------------------ | ---------------------------------------
Add Patient                          | `p-add n/NAME g/GENDER bd/YYYY-MM-DD bt/BLOODTYPE p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…`​ <br> e.g. `p-add n/John Doe g/MALE bd/2018-12-27 bt/A+ p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25` |  **YES**
List Patients                        | `p-list` | **NO**
Edit Patient                         | `p-edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br> e.g. `p-edit 2 n/James Lee e/jameslee@example.com` | **NO**
Find Patient                         | `p-find KEYWORD [MORE_KEYWORDS]` <br> e.g. `p-find James Jake` | **NO**
Delete Patient                       | `p-delete INDEX` <br>e.g. `p-delete 3` | **YES**
Adding Patient Remark                | `p-remark INDEX r/REMARK` <br>e.g. `p-remark 1 r/Likes to swim.` | **YES**
Removing Patient Remark              | `p-remark INDEX` <br>e.g. `p-remark 3` | **YES**
Help                                 | `help` | **NO**
Schedule Appointment                 | `a-schedule pt/INDEXOFPATIENT start/DATE&TIME end/DATE&TIME d/DESCRIPTION [t/TAGS]…`​<br> e.g. `a-schedule pt/2 start/2020-11-21 08:00 end/2020-11-21 10:00 d/Review Appointment` | **YES**
Delete Appointment                   | `a-delete INDEX` <br>e.g. `a-delete 3` | **YES**
Edit Appointment                     | `a-edit INDEX [start/DATE&TIME] [end/DATE&TIME] [d/DESCRIPTION] [t/TAGS]…` <br> e.g. `a-edit 2 start/2020-09-15 12:00 end/2020-09-15 14:00` | **YES**
Complete Appointments                | `a-complete INDEX` | **YES**
List Upcoming Appointments           | `a-list` | **NO**
List All Appointments                | `a-listall` | **NO**
Find Appointments by Patient         | `a-find KEYWORD [MORE_KEYWORDS]` <br> e.g. `a-find Jack` | **NO**
Find Appointments by Tags            | `a-tag KEYWORD [MORE_KEYWORDS]` <br> e.g. `a-find friends` | **NO**
Find Appointments by Current Date    | `a-today` | **NO**
Find Appointments by Current Week    | `a-upcoming` | **NO**
List Appointments by Completed       | `a-completed`| **NO**
List Appointments by Missed          | `a-missed` | **NO**
Undo the previous command            | `undo` | **NO**
Redo the previous command            | `redo` | **NO**



