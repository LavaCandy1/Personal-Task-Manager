Personal Task Manager API DocumentationWelcome to the Personal Task Manager API. This document provides a detailed overview of all available endpoints to interact with the application.Authentication (/auth)Handles user registration and login.POST /auth/registerRegisters a new user in the system.Request Body:{
"name": "Test User",
"email": "test@example.com",
"password": "password123"
}
Response (200 OK):Returns a UserResponseDTO object for the newly created user (without the password).{
"id": 1,
"name": "Test User",
"email": "test@example.com"
}
POST /auth/loginAuthenticates a user and returns a token upon successful login.Request Body:{
"email": "test@example.com",
"password": "password123"
}
Response (200 OK):Returns a JWT token as a plain string.Users (/users)Endpoints for managing user accounts.GET /usersRetrieves a list of all registered users.Response (200 OK):Returns a list of UserResponseDTO objects.GET /users/{id}Retrieves a specific user by their unique ID.Path Variable: id (Long) - The ID of the user.Response (200 OK):Returns a single UserResponseDTO object.Response (404 Not Found): If no user with the given ID is found.GET /users/{id}/boardsRetrieves all boards owned by a specific user.Path Variable: id (Long) - The ID of the user.Response (200 OK):Returns a list of Board objects.Response (404 Not Found): If the user does not exist.PUT /users/{id}Updates the details of an existing user.Path Variable: id (Long) - The ID of the user to update.Request Body: UserRequestDTO with the fields to update.{
"name": "Updated Name",
"email": "updated@example.com",
"password": "newpassword123"
}
Response (200 OK):Returns the updated UserResponseDTO object.Response (404 Not Found): If the user does not exist.DELETE /users/{id}Deletes a user from the system.Path Variable: id (Long) - The ID of the user to delete.Response (200 OK): No content.Boards (/boards)Endpoints for managing task boards.GET /boardsRetrieves a list of all boards from all users.Response (200 OK):Returns a list of Board objects.POST /boards/{userId}Creates a new board for a specific user.Path Variable: userId (Long) - The ID of the user who will own the board.Request Body: A Board object.{
"name": "My New Project Board"
}
Response (200 OK):Returns the newly created Board object, including its generated ID and owner.Response (400 Bad Request): If the specified user does not exist.DELETE /boards/{id}Deletes a board by its ID.Path Variable: id (Long) - The ID of the board to delete.Response (200 OK):Returns the Board object that was deleted.Response (404 Not Found): If the board does not exist.GET /boards/{id}/tasksRetrieves all tasks associated with a specific board.Path Variable: id (Long) - The ID of the board.Response (200 OK):Returns a list of Task objects.Response (404 Not Found): If the board does not exist.POST /boards/{id}/createTaskCreates a new task and assigns it to a specific board.Path Variable: id (Long) - The ID of the board to add the task to.Request Body: A Task object.{
"title": "Design the homepage",
"description": "Create mockups in Figma.",
"dueDate": "2024-12-31",
"completed": false
}
Response (200 OK):Returns the newly created Task object.Response (404 Not Found): If the board does not exist.Tasks (/tasks)Endpoints for managing individual tasks.GET /tasksRetrieves a list of all tasks from all boards.Response (200 OK):Returns a list of Task objects.GET /tasks/{id}Retrieves a specific task by its ID.Path Variable: id (Long) - The ID of the task.Response (200 OK):Returns a single Task object.Response (404 Not Found): If the task does not exist.PUT /tasks/{id}/updateUpdates the details of an existing task.Path Variable: id (Long) - The ID of the task to update.Request Body: A Task object with the fields to update.{
"title": "Updated Task Title",
"description": "Updated description.",
"dueDate": "2025-01-15",
"completed": false
}
Response (200 OK):Returns the updated Task object.Response (404 Not Found): If the task does not exist.PUT /tasks/{id}/toggleToggles the completion status of a task (from true to false or false to true).Path Variable: id (Long) - The ID of the task to toggle.Response (200 OK):Returns the updated Task object with the new completion status.Response (404 Not Found): If the task does not exist.DELETE /tasks/{id}Deletes a task by its ID.Path Variable: id (Long) - The ID of the task to delete.Response (200 OK): No content.
