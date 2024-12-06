# Crop Monitoring System Backend

This is the backend application for the **Crop Monitoring System** developed for **Green Shadow (Pvt) Ltd.**, a mid-scale farm specializing in root crops and cereals. The system is built using **Spring Boot** and **MySQL** to manage the farm's resources, crops, staff, vehicles, and monitoring logs efficiently. The application includes RESTful APIs for CRUD operations and features role-based access control.

## Purpose
The Crop Monitoring System automates and systematizes farm management by integrating:
- **Field Management**: Allocate and monitor fields for specific crops.
- **Crop Monitoring**: Track crop details, growth stages, and field observations.
- **Resource Management**: Manage staff, vehicles, and equipment allocation.
- **Log Tracking**: Record field and crop activities through logs.
- **Data Analysis**: Evaluate relational, spatial, and temporal data for better decision-making.

## Features

### Role-Based Access
- **MANAGER**: Full access to all system functionalities.
- **ADMINISTRATIVE**: Limited access; cannot modify crop-related data.
- **SCIENTIST**: Restricted access; read-only for staff, vehicle, and equipment data.

### CRUD Operations
- Manage fields, crops, staff, vehicles, equipment, and monitoring logs.

### Resource Management
- Allocate staff, vehicles, and equipment to specific fields and activities.

### Data Analysis
- Relational Analysis: Evaluate resource allocations.
- Spatial and Temporal Analysis: Location- and time-based evaluations.

## Technologies Used

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **Programming Language**: Java (Version 17)
- **Build Tool**: Gradle
- **Authentication**: Spring Security with JWT
- **Version Control**: GitHub
- **API Standards**: REST

## Project Architecture

The system follows a three-layer architecture:
1. **API Layer**: Handles client requests and responses.
2. **Service Layer**: Contains business logic.
3. **Persistence Layer**: Manages database interactions.

## API Endpoints

### Field Management
- `GET /green-shadow/api/v1/fields`: Fetch all fields.
- `POST /green-shadow/api/v1/fields`: Add a new field.
- `GET /green-shadow/api/v1/fields/{id}`: Fetch a specific field.
- `PUT /green-shadow/api/v1/fields/{id}`: Update field details.
- `DELETE /green-shadow/api/v1/fields/{id}`: Delete a field.

### Crop Management
- `GET /green-shadow/api/v1/crops`: Fetch all crops.
- `POST /green-shadow/api/v1/crops`: Add a new crop.
- `GET /green-shadow/api/v1/crops/{id}`: Fetch a specific crop.
- `PUT /green-shadow/api/v1/crops/{id}`: Update crop details.
- `DELETE /green-shadow/api/v1/crops/{id}`: Delete a crop.

### Authentication
- `POST /green-shadow/api/v1/auth/signIn`: Log in to the system.
- `POST /green-shadow/api/v1/auth/signUp`: Register a new user.
