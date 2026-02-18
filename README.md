# MilestoneMind 🏆

MilestoneMind is a full-stack achievement tracking system. It allows users to document their personal milestones, set goals, and track progress through a unified web and mobile interface.

## 📌 Project Structure
This repository follows a multi-platform architecture:
* **/backend**: Spring Boot API providing authentication (JWT) and data persistence.
* **/mobile**: Android application built with Kotlin for on-the-go tracking.
* **/web**: React.js dashboard for a comprehensive desktop experience.
* **/docs**: Project documentation, including FRS and diagrams.

## 🚀 Features
- **Secure Authentication**: User registration and login with encrypted passwords (BCrypt).
- **Dynamic Dashboard**: View and manage personal achievements in a responsive list.
- **Profile Management**: Custom user profiles with editable details and secure logout.
- **Cross-Platform Sync**: Uses a shared PostgreSQL database (Supabase) for consistent data across Web and Mobile.

## 🛠️ Tech Stack
| Component | Technology |
| :--- | :--- |
| **Backend** | Spring Boot, Spring Security, PostgreSQL |
| **Web** | React.js, Tailwind CSS, Axios |
| **Mobile** | Kotlin, Android SDK, View Binding |
| **Database** | Supabase (Cloud PostgreSQL) |

## ⚙️ Setup Instructions
1. **Backend**: Navigate to `/backend`, configure your `application.properties`, and run `./mvnw spring-boot:run`.
2. **Web**: Navigate to `/web`, run `npm install` followed by `npm start`.
3. **Mobile**: Open the `/mobile` folder in Android Studio and sync Gradle files.

---
Created by **Clyde Benolirao** | IT342 Lab Session 2026