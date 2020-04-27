# Module 3 Assessment Exercise

This assessment will help you validate your understanding of the module objectives using Spring MVC. The following learning objectives are covered:

- Controllers
- Views & View logic using JSTL
- Passing data from controllers to views
- Handling request data
- Dynamic-link creation
- Query parameter access
- Dependency Injection

You also receive practice with coding assessments that you may encounter during the job interview process.

## Overview

The assessment uses Spring MVC as the Web Application framework. You will have one hour to complete as much of your assigned problem as you can.

Whatever you complete and submit should not have any compile or run-time errors. Any features you can complete should run successfully to receive credit.

If you are nearing the end of the hour and you have compile/run-time errors, consider commenting out or removing the code causing the errors before pushing your final effort.

In the end, you should push your final effort to your repository.

You are expected to remain in the classroom until you have completed the coding assessment.

If you finish before the end of the time-box, please be respectful of those still working. Please leave the classroom if you would like to talk with others that have completed the coding assignment.

## Required Tools

The following tools/software are used by students to complete the assessment:

- Eclipse or IntelliJ
- PostgreSQL

The script to set up the database is located under the `database` folder. Run `sh import-databases.sh` to build and populate the database.

## Instructions

1. Create a controller action in `PuppiesController` mapped to the root `/`. It will call `getAllPuppies()` in the DAO. The information that is returned should be returned to the `puppyList.jsp` view.
2. Change the `puppyList.jsp` view to show all the entries from the controller in the provided table. Weights should have `lbs` after it. The `paperTrained` value should show as 'Yes' when true and 'No' when false.
3. Create a controller action in `PuppiesController` that receives request data generated from the form on `puppyList.jsp` and saves that information as a new entry in the database by passing it to the `savePuppy(Puppy)` method in the DAO. Redirect the user to the controller action defined from step 1.
4. Create a controller action in `PuppiesController` that maps to `/puppy`. It will take an id as a query string parameter and then call `getPuppy(int)` in the DAO. The information that is returned will be passed to the `puppyDetail.jsp` view.
5. Change the `puppyList.jsp` view to make the name of the puppy a link to the controller action created in step 4.