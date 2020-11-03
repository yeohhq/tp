---
layout: page
title: Kim Guan's Project Portfolio Page
---

## Project: Archangel

Archangel is an appointment management system designed for Psychiatrists. The project simulates an ongoing software
 project written in Java for a desktop application (called Archangel) used for managing appointment thru a CLI and a GUI
 built using JavaFX. It is written in OOP fashion. It provides a reasonably well-written code base bigger (around 6 KLoC) than what
students usually write in beginner-level SE modules, without being overwhelmingly big.
It comes with a reasonable level of user and developer documentation.

Given below are my contributions to the project.

* **New Feature**: Added the ability to undo/redo previous commands.
  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.


* **New Feature**: Add a Calendar feature built using JFXtra's Agenda's extension,iCalendarAgenda. 
![CalendarFeature](images/CalendarTab.png)
  * What it does: Allows the user to view all the appointments that have been scheduled in an integrated surface.
  * Justification: This feature improves the product significantly because a user can have a clean overview of his/her upcoming schedule and keep track of it in an organised manner.
  * Highlights: This feature had to be integrated with the current data that is stored inside Archangel. It required one to think out of the box and make careful analysis of what resource 
  was already available.
  * Credits: *JFxtras-agenda*


* **Code contributed**: [RepoSense link]()

* **Project management**:
  * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
  * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:
  * User Guide:
    * Added documentation for the features `delete` and `find` [\#72]()
    * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
  * Developer Guide:
    * Added implementation details of the `delete` feature.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Contributed to forum discussions (examples: [1](), [2](), [3](), [4]())
  * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
  * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]())

* **Tools**:
  * Integrated a third party library (Natty) to the project ([\#42]())
  * Integrated a new Github plugin (CircleCI) to the team repo

* _{you can add/remove categories in the list above}_
