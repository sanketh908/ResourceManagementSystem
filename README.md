<h1>Resource Management System</h1>
A Resource Management System built using Spring Boot is a robust backend application designed for secure user registration, authentication, and comprehensive file management. The system allows users to upload, retrieve, and manage files while ensuring data integrity and security.

The application implements Spring Security with Basic Authentication, ensuring that only authorized users can access sensitive endpoints. It demonstrates core backend principles such as RESTful API design, multipart file handling, password encryption (BCrypt), and role-based access control. This project serves as an excellent foundation for building scalable cloud storage or internal document management solutions.

<hr>

Authentication & User Management
1. User Registration
2. 

Endpoint: POST /home/register

Description: Allows new users to register. Passwords are automatically hashed before being stored in the database.

<hr>

2. User Profile (Basic Auth)

Endpoint: GET /usersfiles/profile

Description: Fetches the logged-in user's details using Basic Authentication.

<hr>

File Management (Admin/User)
1. Upload File

Endpoint: POST /files/add

Description: Uploads a file to the system using multipart/form-data.

<hr>

2. Get All Files

Endpoint: GET /usersfiles/getall

Description: Retrieves a list of all resources stored in the system.

<hr>

3. Search File by Name

Endpoint: GET /usersfiles/getByName/{fileName}

Description: Search for a specific resource by its filename.

<hr>

4. Download File

Endpoint: GET /usersfiles/download/{id}

Description: Streams the file content for download based on the unique resource ID.

<hr>

5. Delete File

Endpoint: POST /files/delete/{id}

Description: Removes a resource from the system by its ID.

<hr>

Tech Stack
Backend: Java, Spring Boot

Security: Spring Security (Basic Auth, BCrypt)

Data Handling: Spring Data JPA / MongoDB

API Testing: Postman
