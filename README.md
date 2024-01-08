# :classical_building: Topic of the project:
Creating museum management system software.

------------------------------------------------------------------------------------------------

### Project goal:
The aim of the project is to design and create software for a museum management system. The "MuseoMaster" project is an application created to streamline and facilitate museum management processes. This application is intended to support administrative staff and museum managers by providing tools and functions enabling efficient organization and control over the collection of exhibits, exhibitions and staff.

------------------------------------------------------------------------------------------------

### Product functionalities:
The scope of the created product includes the creation of a desktop application and a database dedicated to it. Many users will be able to use the system at the same time. It will be a simple, intuitive system designed to facilitate the work of museum employees.

------------------------------------------------------------------------------------------------

### For all users:

•	Login to the system

• Logout option

• Selecting the type of user account

------------------------------------------------------------------------------------------------

### For administrative staff:

• Creating new users

• Deleting users

• Adding museum rooms

------------------------------------------------------------------------------------------------

### For museum curators:

• Creating exhibitions

• Adding new exhibits

• Removal of exhibits

• Editing exhibits

• Search for exhibits

• Assigning tasks related to exhibits to museum staff such as technical staff

------------------------------------------------------------------------------------------------

### A For exhibition technicians/security/museum guides/cleaning staff:

• View assigned tasks

• Confirmation of task completion

• Informing about the inability to complete the task

For normal users

• See list of exhibits

• Read exhibits description

• Hear audio about exhibits

------------------------------------------------------------------------------------------------

### A Tools we used:

• Java

• JavaFX

• MySQLserver


------------------------------------------------------------------------------------------------

# User documentation

## Login

![image](https://github.com/SenseiBunny/MuseoMaster/assets/54467678/fef46784-b664-4844-8b07-8b285d390262)


When we launch the application, the employee can log in to the created account.

------------------------------------------------------------------------------------------------

## A Registration

An ordinary user in our program is a user who can browse the list of exhibits in our museum, read their descriptions, or hear about them.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/54622636-a667-4a00-9107-2a76dc5a0454)

When we click "Join us now" in the login menu, it will take us to the account creation window

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/98c7c6dd-4ffb-40c5-ab3e-274acd3710c2)


When creating a user, we must provide a username, email and password that meet security standards.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/e4cbb14c-dff3-44a3-8d85-c2de18c15bf9)

------------------------------------------------------------------------------------------------

# Account authentication

In order for an ordinary user to use our application, he or she must confirm that he or she is not a bot using the code that was sent to his or her email address.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/5286a72a-6c08-4c08-abf1-533c9e0eb9d6)

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/729f4928-7e30-430f-b182-d97419889b84)


We receive such an e-mail with the code in our mailbox. The user must enter it and click the confirm button

After entering the correct code, we receive a notification of successful registration. Now our user has been entered into our database and can log in.

------------------------------------------------------------------------------------------------

## Administrator panel

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/78e25c96-8a78-410c-93ab-be59aafe6acf)

Create user – a page that allows you to create a new user and specify his personal data

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/bcdf7323-2354-439c-a010-d0780bf8768c)

In the user tab, we can define things such as name, surname, email, phone number, age, role, password and permissions. The password must meet security requirements and the authorizations allow the employee to assign tasks to subordinates.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/b0a087f7-5620-463b-bf29-432302d3d3e7)

In the add place tab, we can define the name of the new room, size and type of room

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/580f6427-89eb-48f1-a3bf-a2d890e2af0f)


In the user list tab, we see a list of all users along with their key data. We can also delete a user if necessary

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/dad54f1d-15e0-4bff-9595-20aebbbabe7d)

The error reports tab shows a list of reports sent by users related to incorrect operation of the program.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/1e00f127-2786-4fa0-bc64-4dc86726e837)


After clicking the report details button, a message with a note about the problem appears. Once the problem has been fixed, we can click delete report.

------------------------------------------------------------------------------------------------

## Regular Employee Panel:

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/4319254c-36bc-4cca-84b4-4f8bc2aedc9e)

The task list contains both a list of assigned tasks and a list of completed tasks, thanks to which the employee can control the progress of his work.
After completing a task, the employee can mark the task as completed, completed with a problem or as not completed

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/2f269551-1ae7-4d7b-8fe1-0248168e2bed)

After clicking on the content of the task, a window will open with a message from the superior.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/fbd6259f-5a39-42c5-bc7d-f6814f4cd066)


After clicking send report, a window appears where the user can describe the problem encountered and send the report to the administrator.

------------------------------------------------------------------------------------------------

## Employee+ panel (employee with permissions):

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/afbc7ed7-73f0-4362-8291-6539ccfed85a)


An employee+ user is very similar to a regular employee. The differences are:
- an additional list of assigned tasks thanks to which the manager can monitor the status of task completion
- assign a task page which will be described in more detail in the Curator's Panel.

------------------------------------------------------------------------------------------------


## Curator's Panel

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/b3492263-e756-4842-b0d8-9324d920702b)

In the "Task list" tab we see three lists. List of tasks that the employee is to perform. A list of completed tasks and a list of assigned tasks. The user can check the content of a given task by clicking the "Task content" button located in the cell of a given sentence. This cell also contains the start and end date of the task and information about the person who assigned it. After clicking, a window with the task content is displayed:

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/d165e354-225e-4d51-a567-ef852cd1037b)

We can close this window by clicking the "X" in the upper right corner of the window. Additionally, we can mark each task as completed by clicking the "Done" button, inform about a problem with the task by clicking the "Problem" button, or inform about the failure to complete the task by clicking "No execution". In each of these cases, the task is assigned to the list of completed tasks and the employee assigning the task is informed about the status in which the task has been completed. Below we will present what the view looks like after clicking the "Done" option.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/7f9a3461-3b24-4614-9f8c-375ea149c47d)


The task has been marked as done, now we will show that the change was also noted by the person assigning the task.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/03065464-3013-4b2b-a505-695d488c9acc)


### Assign a task

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/740cb36d-6171-44cc-a8cc-a18ddfa32628)

The assign task option is an option available to all authorized users. Allows you to assign a task to a given employee. At the beginning, a window appears in which we can search for the employee to whom we want to assign a task. We can search for an employee by name and surname or username. We can also use the role selection field where we specify the role of the employee to whom we want to assign the task. After specifying the search parameters, click the Search button. After clicking, a list of searched employees will be displayed as below

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/0d372094-f6aa-4988-9864-c3b42f24d044)


To assign a task, click on the square button after the text "Assign task" located next to the cell containing the employee to whom you want to assign the task, as in the image shown below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/9c59a8d3-6a8e-48fd-a8ac-00a1000ed3fd)


Once we have selected the employee to whom we want to assign a task, click the "Assign task" button at the bottom of the page. After clicking it, a page with creating a task will be displayed, as shown in the image below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/ea5ebc7c-b667-4485-9c30-acd0a173795a)

Now we can start the task creation process. Enter the topic of the task in the field under "Subject". Then, in the field under the test "Description", enter the description of the task. Later Select the start and end date within which the task is to be performed. We do this by clicking the button at the end of both fields representing the calendar. After clicking, a field with a date selection appears, where we click on it

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/3f302a8e-6265-42a6-9319-6185e6658ede)

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/82b35437-c23b-4759-9f97-36c0b5642424)

After correctly completing the form as presented above, we have two options: "Go to exhibits" and "Assign a task". The first of these options is available only if the employee we selected was a technical employee and takes us to the selection window of monuments, which we will show after the presentation. second option. The second option assigns a task if it has been created correctly.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/6ea5abed-412b-4257-8aa1-dd5019a1829c)

After creating the task, we are redirected to the task list page where, as we can see, the task appears in the list of assigned tasks. The employee to whom we assigned the task has been informed about it and can inform us about the completion of the task.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/ae6095d6-ab52-4f19-9895-97257181b441)

After the employee clicks on one of the 3 options, we will be informed about it. As below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/dd7158f6-df13-44d8-bcad-afb0d5610178)

As we can see, the cell with the assigned task has changed color, which suggests that the task has been completed successfully.
Now we will present the task assignment with the monuments added to it. We start this process in the same way as assigning a regular task, but after completing the form with the task, we click the "Go to exhibits" button.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/1f8b276d-3b2c-40e0-b4f3-1baba4d70ff4)

After clicking the button, the following page will be displayed

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/c3110b65-faaa-4a60-be85-7b8750517c92)

Here we can search for the monument we are interested in. We can search for monuments using various information, such as "Name of the exhibit", "Creator", "Subject matter", "Period of creation" and "Current place of storage". Below we will present what the search looks like when we know the name of the exhibit.

After completing the form, click the "Search" button. A list of selected monuments appears.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/6357d488-4591-425b-9618-89f57abebdee)

After clicking the "Detailed description of the exhibit" button, a window with a detailed description of the exhibit will be displayed, as shown below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/053f9e17-9d7e-4ea2-b026-4ed17d523f92)

We can close this window by clicking the "Close" button.
Continuing to allocate the monument, we select the monument we are interested in by clicking on the square window located on the right side of the cell with the monument and choose where the monument is to be moved, as shown below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/fdeac4a9-1b73-46d7-a658-e96325529f76)

After completing the form, click the "Assign task" button. After correct completion, we are transferred to the list of tasks where the task appears in the assigned tasks.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/04f419e3-6631-4109-b732-aedb4ab81fb0)

Now, when we enter the profile of the employee who received it, we see that a new task has appeared.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/168a808d-639c-4ce2-92da-2e3e5aa490fb)

After selecting the monument using the selection located on the right side of the monument cell, when the monument has been moved, we can confirm its transfer using the "Confirm" button at the bottom of the page.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/4b72c32a-10ac-41fb-80e3-ef58f84ae5a0)

After doing this, the current storage location of the relic will change.
After moving all the monuments from a given task, we can end the task as done.

### Create an exhibition

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/1319ad73-02ac-4e79-af67-630635560e7b)

After clicking the "Create exhibition" option, the above window for creating an exhibition is displayed. After entering all information about the exhibition, click the "Create exhibition" button and, if we have entered the information correctly, the exhibition will be created. An example of filling out the form is provided below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/c3ad6838-13c7-4a51-9ab9-da89c8386785)

### Exhibition List

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/4723aef2-0e28-4c99-bb0e-38a73ed73d8c)

The exhibition list contains all created exhibitions. It is possible to delete the exhibition using the "Delete" button

### Add exhibtion

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/1561b195-7805-4d6c-9206-467895552035)


After selecting this option, the monument creation window appears, where, after completing the form, we can add a monument. An example of filling out the form is presented below.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/10e6cbba-06d7-485c-8e77-cffdea479f58)


There is also a music file attached to a given monument. This allows it to be recreated by museum clients. View after clicking the "Add mp3 file" button

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/2c9af898-6288-4580-84df-b67afa44dbad)


If we want to attach a music file, we select it from the computer and it will be assigned to the monument.
After clicking "Add monument" we receive information about whether the monument has been created

### Search exhibit

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/43f52b47-27cd-43d1-afe3-c4f4e5bcc9bf)

The search for a monument option is similar to the one used when selecting a monument for a task. We can again search for a monument using the given parameters. For example, when we enter "Crown" in the name field, all crowns stored in museum collections will be displayed.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/b00a34d2-1ce4-4179-a633-571b7cfdf718)


For each monument, there are 3 buttons related to the description of the monument, its edition and its deletion.
View after clicking the "Description" button

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/18b5c96e-757e-438e-961a-93366ef6b705)


View after clicking the "Edit" button

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/ad282290-6f10-41ed-a0e1-7ddbed71ee4b)


After clicking this option, a window appears where you can edit the exhibit. This option is particularly useful when you have made a mistake while entering information about the exhibit. After making changes, click the "Confirm" button

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/e1d0a57d-5ff0-4171-ba66-03b5b53ba1de)

### Exhbibits list

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/739894b9-a210-4794-8cf2-e8aecd713243)


The list of monuments contains all the monuments available in the museum, similarly to the monument search option for each exhibit, we have 3 options to choose from.

------------------------------------------------------------------------------------------------


### Technical Employee Panel

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/b9ed25e1-53c0-4323-a318-89c6318dc226)

Similarly to the Superintendent's panel, we have tasks assigned to us and completed tasks. Just like for the Curator, we can see the content of the task and inform about its completion. When we click on one of the options, the task will appear in completed and information about the change in the task's status will be recorded in the list of tasks assigned to the person who assigned it.


List of Exhibits

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/0a0f26b2-562a-4afa-9ec0-4b31c52c8080)


The exhibit list contains a list of exhibits that the employee is to move. When the monument is moved to its place, select it and click the "Approve" button. The change in the monument's location will then be recorded in the system.

------------------------------------------------------------------------------------------------


### Regular user panel:

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/6dad5b30-4709-4c12-9d3d-0e8ee9ffa8c7)


The user can browse the exhibits, read their descriptions and listen to audio.

![image](https://github.com/SenseiBunny/MuseoMaster/assets/116729677/9cc6440d-3c0e-441c-a0b6-1e54d21b541d)


After clicking the button, the icon changes and audio starts playing (ultimately, it should be a short explanation of the history and origin of the monument)
