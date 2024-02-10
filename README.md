# movie-api
Movie API with Java Spring Boot

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Technical Implementation](#technical-implementation)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Overview

## Features

## Technologies Used

## Technical Implementation

## Usage

Base URL for each request is `https://localhost:8080/online-library/api`, so combine it with one of the following parts.

### User

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/users`      | GET           | Retrieve the list of all users.                    |
| `/users/{id}` | GET           | Retrieve specific user with provided `{id}`.    |
| `/users`      | POST          | Add new user to the database.                      |
| `/users/{id}` | PUT           | Update specific user's (`{id}`) fields.           |
| `/users/{id}` | DELETE        | Delete from the database user with provided `{id}`. |


### Book

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/books`      | GET           | Retrieve the list of all books.                    |
| `/books/{id}` | GET           | Retrieve specific book with provided `{id}`.    	|
| `/books/{id}` | DELETE         | Delete from the database book with provided `{id}`.    	|


### Borrowed

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/borrowed`     | GET         | Retrieve the list of all borrowed books.             |
| `/borrowed/{id}`| GET         | Retrieve specific borrowed book with provided `{id}`.    |
| `/borrowed/users/{userId}`   | GET         | Retrieve list of borrowed books that are assigned to the user `{userId}`. |


### Reserved

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/reserved`     | GET         | Retrieve the list of all reservations.             |
| `/reserved/{id}`| GET         | Retrieve specific reservation with provided `{id}`.    |
| `/reserved/users/{userId}`   | GET         | Retrieve list of reservations that are assigned to the user `{userId}`. |
| `/reserved/books/{bookId}`   | GET         | Retrieve reservation resource that is assigned to the book `{bookId}`.|

## Dependencies 

The project does not have any external dependencies.

## Contributing

If you'd like to contribute to Online Library, please fork the repository, create a new branch, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
