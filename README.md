# Travel Website Project

This project is a travel website that allows administrators and moderators to manage secure information. It is built using modern Java technologies and frameworks.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Features](#features)
- [Installation](#installation)
- [WebApp presentation](#WebApp-presentation)
- [Contact Information](#contact-information)

## Technologies Used

- **Java**: Version 21
- **Spring Boot**: Version 3.3.2
- **Spring Security**: Used for securing the application, for authentication and authorization
- **Principles**: OOP (Object-Oriented Programming) and AOP (Aspect-Oriented Programming)
- **JPA and Hibernate**: For data persistence
- **Thymeleaf**: Template engine for rendering HTML views
- **Migrations**: Database migrations using Flyway tool
- **REST**: For creating RESTful web services
- **Roles**: User roles such as admin, moderator, and user

## Features

- **User Management**: Admins can view all users and assign roles (admin, moderator, user).
- **Tour Management**: Admins and moderators can create, update, and delete tour information.
- **Contact Management**: Admins and moderators can create, update, and delete contact information.
- **Role-Based Access Control**: Different functionalities are available based on user roles.

## Installation

### Prerequisites

- Java 21
- Maven (for dependency management)

### Steps

1. Clone the repository
    ```bash
    git clone https://github.com/your-username/travel-website.git
    cd travel-website
    ```
2. Build the project
    ```bash
    mvn clean install
    ```
3. Run the application
    ```bash
    mvn spring-boot:run
    ```

## WebApp-presentation
![img_3.png](img_3.png)
  
Only the Administeators and Moderators can view and can have access to the 'Edit', 'Delete' and 'Add New Tour' buttons. 
They can edit or delete tours or create new tours. 

![img_4.png](img_4.png)

### Adding a New Tour

To add a new tour, you can use the "Add Tour" form available in the application. This form allows you to input the necessary details about the tour, such as the name, description, price, duration, and other relevant information.

**Steps to Add a Tour:**

1. Navigate to the "Add Tour" page.
2. Fill in the tour details in the form fields.
3. Click the "Submit" button to add the tour to the database.

Upon submission, the form sends a POST request to the server to create a new tour record in the database.


![img_5.png](img_5.png)

To edit an existing tour, the application uses a two-step process involving GET and POST requests. This ensures that you can retrieve the current tour details, make the necessary changes, and then update the tour in the database.

### Edit a Tour

1. **GET Request:**
    - Navigate to the "Edit Tour" page.
    - The page sends a GET request to the server to fetch the current details of the tour you want to edit.
    - The server responds with the tour data, which is then pre-populated in the form fields.

  
2. **Modify Tour Details:**
    - Make the necessary changes to the tour details in the form fields.

3. **POST Request:**
    - After modifying the details, click the "Save Changes" button.
    - The form sends a POST request to the server with the updated tour information.
    - The server updates the tour record in the database with the new details.


![img_6.png](img_6.png)

### Deleting a Tour

To delete an existing tour, the application uses a DELETE request. This allows you to remove a tour from the database permanently.

**Steps to Delete a Tour:**

1. Navigate to the list of tours.
2. Find the tour you want to delete and click the "Delete" button next to it.
3. Confirm the deletion if prompted.

The application sends a DELETE request to the server to remove the tour from the database.

![img_7.png](img_7.png)

### User Management

Administrators have access to a special "Users" section in the navigation bar where they can view all registered users and change their roles. This functionality is restricted to administrators to ensure proper management and security.

**Steps to Manage Users and Change Roles:**

1. **Accessing the Users Section:**
    - Only administrators can see the "Users" button in the navigation bar.
    - Only administrators can have access to users.
    - Navigate to the "Users" section by clicking the "Users" button.

2. **Viewing All Registered Users:**
    - In the "Users" section, administrators can see a list of all registered users.
    - Each user entry displays relevant details such as username, email, and current role.

3. **Changing User Roles:**
    - Next to each user, there is an option to change their role.
    - Administrators can select a new role for the user (user, moderator, admin).
    - The application sends a POST request to update the user’s role in the database.

![img_8.png](img_8.png)

## Managing Contacts

### Adding a New Contact

To add a new contact, use the "Add Contact" form:
1. Navigate to the "Add Contact" page.
2. Fill in the contact details.
3. Click "Submit" to create a new contact record.

### Editing an Existing Contact

To edit an existing contact:
1. Navigate to the "Edit Contact" page.
2. The form sends a GET request to fetch the current contact details.
3. Modify the details and click "Save Changes" to send a POST request and update the contact.

### Deleting a Contact

To delete a contact:
1. Navigate to the list of contacts.
2. Click the "Delete" button next to the desired contact to send a DELETE request and remove the contact from the database.


## Contact Information

- Email: scutelnic.grigore10@gmail.com
- GitHub: [grisascutelnic](https://github.com/grisascutelnic)