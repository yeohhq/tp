---
layout: page
title: Jim Vincent Andes Engay's Project Portfolio Page
---

## Project: Archangel

Archangel is a desktop address book application used for managing patient data and appointment scheduling for medical professionals.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added code foundation for filter commands.
  * What it does: Allows users to filter appointments.
  * Justification: This feature is necessary to provide the different queries on appointments.
  * Credits: *Original CS2103T AddressBook implementation of `SearchNameFilter`  was heavily referenced for the implementation of `appointmentfilters`.*

* **New Feature(s)**: Added daily and upcoming commands.
  * What it does: Filter appointments to show daily and weekly appointments.
  * Justification: These are core features needed to make this application appointment-centric.
  * Highlights: This feature provided the backbone for the calendar feature and commands that involved filters which my teammates have implemented.
  * Credits: *Original CS2103T AddressBook implementation of `PatientFindCommand` was heavily referenced for the implementation of `AppointmentTodayCommand` and `AppointmentWeekCommand`.*

* **New Feature(s)**: Added commands that filters tags and patient in appointment.
  * What it does: Filter appointments to appointments based on the keywords provided.
  * Justification: These features enable better appointment organisation, which is one of the focus of this Archangel.
  * Credits: *Original CS2103T AddressBook implementation of `PatientFindCommand` was heavily referenced for the implementation of `AppointmentTagCommand` and `AppointmentFindPatientCommand`.*
  
* **New Feature**: Overall UI and Tabs
  * What it does: Cleaner and more user-friendly UI, which separated Archangel from the original AddressBook. I also replaced all the wrapper to AnchorPane and implemented tabs for the dashboard and calendar.
  * Justification: The change in UI helped us implement other features like Calendar and ensured that you have the patient list all times.
  * Highlights: The application became more intuitive and suited our team of clinical data management app.
  * Credits: The idea, and the base code to organise the ui in tabs came from [KeepToo Youtube Channel](https://www.youtube.com/watch?v=ZVtys3GgkMo)
  
  Before:

  ![AddressBook3](docs/images/Addressbook3.png)
  
  After:
  
  ![Archangel](docs/images/Archangel.png)

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=jimvae)

* **Project management**:
  * In charge of implementing Filters, Filters Testing and UI
  * Ensured features being implemented are sound and intuitive
  * Improved code quality for some classes

* **Enhancements to existing features**:
  * Wrote tests and increase code coverage (Pull requests [\#57](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/75)

* **Documentation**:
  * README
    * Updated README to match our current project: [\#31](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/31) 
  * User Guide:
    * Added documentation for the all the filter features and laid out the overall table of content format: [\#83](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/83)
  * Developer Guide:
    * Added implementation details of all the filter commands: [\#83](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/83), [\#101](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/102)
    * Updated and added class and sequence diagrams for Model and UI components: [\#101](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/102)

* **Community**:
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/yeohhq/ped/issues/6), [2](https://github.com/yeohhq/ped/issues/2), [3](https://github.com/yeohhq/ped/issues/3))
  * Helped my teammates with major logic bugs like scheduling appointments
