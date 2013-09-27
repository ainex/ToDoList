ToDoList
========
The "ToDo List" application running on web server. 
The application allows viewing and managing personal to-do items. 
Initially the application has several To-Do items for demo purposes.


The application supports the following functionality:
------------------------------------------------------
- The application has a single main page that shows the Tree with the folders. 
  (allows organizing To-Do items like folders). When a user selects a particular folder 
  it shows the list of To-Do items created in this folder.
- The folder structure is not editable. The initial folders are created with the initial To-Do items.
- Non-expired items are displayed in a normal font face. The expired items are displayed in bold.
- The application stores data on the server-side (memory-based data storage in the session scope).
- The application allows adding/editing/removing new to-do items.


Technical Details:
--------------------

*Java - Ajax – jQuery – Tomcat*

Application uses:
- run on Tomcat Web server (http://tomcat.apache.org/) 
- jQuery library (http://jquery.com/) ver. jquery-1.9.1.js 
- jQuery plugins for UI controls ver.jquery-ui-1.10.3.custom.js
- jQuery timepicker plugin (http://jonthornton.github.io/jquery-timepicker/) jquery.timepicker.js
- Java toolkit for JSON (https://code.google.com/p/json-simple/) ver. 1.1.1

Installation:
---------------
Copy  the " ToDoList.war"  file into webapp folder of Tomcat Web server.
All jQuery  libraries, .css files and etc. are already included in .war.
Main page: http://host/ToDoList/index.html.
 
