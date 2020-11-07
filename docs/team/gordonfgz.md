---
layout: page
title: Gordon Foo's Project Portfolio Page
---

## Project: Archangel

Archangel is a desktop address book application used for managing patient data and appointment scheduling for medical professionals.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature(s)**: Refactoring of Person class to Patient.
  * What it does: Changes the naming of person to patient.
  * Justification:  To standardise the terminologies between code, UG and DG to better suit our target audience.
  * Credits: *Original CS2103T AddressBook implementation is unchanged, just the naming is changed.*

* **New Feature(s)**: Added more fields for Patient - Gender, Birthdate and Bloodtype.
  * What it does: allows users to store the above information for their patients.
  * Justification: As Archangel is an app made for medical professionals to make storing and accessing data easier for them, being able to store such medical information is paramount to our app.
  * Highlights: These features are essential for the modelling of Archangel as an appointment scheduling and patient data storage application.
  * Credits: *Original CS2103T AddressBook implementation of `Address`, `Email` and `Phone` was heavily referenced for the implementation of additional Patient fields.*
  
* **New Feature(s)**: Added functionality for Patient - Remark command.
    * What it does: allows users to store exclusive information regarding the patient.
    * Justification: As service in the medical industry is very personalised, we allow for storing of more exclusive information such as allergies/preferences under the Remark section.
    * Highlights: These feature makes Archangel more flexible of an assistant to the medical professionals as it can store non-restrictive data.
    * Credits: *Original CS2103T tutorial for adding remarks into AddressBook was heavily referenced for the implementation of Remark command.*

* **New Feature**: Added code foundation for a new model - Appointment.
  * What it does: allows users to be able to use Appointment-type commands (which my team have implemented).
  * Justification: This feature is fundamental to the objective of our product since Archangel focuses on appointments scheduling.
  * Highlights: This feature affects almost all other commands that works on Appointment-type features.
  It required an in-depth analysis of design alternatives - to mimic Patient model implementation or if changes are necessary.
  The implementation too was challenging as it required retrieval of Patient data that exists in Archangel instead of simply parsing primitve-type inputs to existing commands.
  * Credits: *Original CS2103T AddressBook implementation of `Person` model was heavily referenced for the implementation of `Appointment` model.*

* **New Feature**: First iteration of White-Blue themed UI
  * What it does: Cleaner and more user-friendly UI, which separated Archangel from the original AddressBook. Replaced original structure with a borderpane, and replaced DarkTheme with a WhiteBlueTheme.
  * Justification: The change in UI allowed us to display both Appointment and Patient lists side by side. This maximised the vertical space and made viewing information from both lists way easier.
  * Highlights: The application became more aesthetically pleasing and more practical as a data management app.
  * Credits: *Original CS2103T AddressBook UI was used as the back-bone.*

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=gordonfgz)

* **Project management**:
  * In charge of overall code architecture of Appointment
  * In charge of functionality decisions of Archangel (e.g. delaying the time an appointment gets marked as missed)
  * In charge of testing
  
  Before:
  
    ![AddressBook3](https://raw.githubusercontent.com/jimvae/tp/branch-user-guide-v1.4/docs/images/Addressbook3.png)
    
    After:
    
    

* **Enhancements to existing features**:
  * Wrote tests for Patient-type fields
  * Wrote test for Patient-type parsers
  * Wrote tests for Appointment-type commands 
  * Write tests for Appointment-type parsers

* **Documentation**:
  * User Guide:
    * Added documentation for the features `a-schedule`, `a-delete` and `a-edit`: [\#98](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/98), [\#126](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/126)
    * Did cosmetic tweaks to existing documentation of features for patient-type commands: [\#84](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/84)
  * Developer Guide:
    * Added implementation details of the `a-schedule`, `a-delete`, `a-edit` features with relevant diagrams: [\#102](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/102)
    * Edited implementation details of the `p-add`, `p-delete`, `p-edit` features: [\#102](https://github.com/AY2021S1-CS2103T-W11-1/tp/pull/102)

* **Community**:
  * Reported bugs that are very severe for other teams in the class (examples: [1](https://github.com/gordonfgz/ped/issues/6))
  * Helped my teammates to rationalise the 
