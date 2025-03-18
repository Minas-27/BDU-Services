# BDU Services App

Welcome to the **BDU Services App**! This app is designed to provide a seamless experience for users to explore and manage various services offered at Bahir Dar University (BDU). Whether you're looking for food, drinks, laundry services, or entertainment, this app has got you covered.

---

## Features

### 1. **Service Categories**
- Explore a wide range of service categories, including:
  - የጾም ምግቦች (Fasting Foods)
  - የፍስክ ምግቦች (Non-Fasting Foods)
  - ትኩስ መጠጦች (Hot Drinks)
  - የቀዝቃዛ መጠጦች (Cold Drinks)
  - የጀበና ቡና እና ሻይ (Traditional Coffee and Tea)
  - ዳቦና ተመሳሳይ አይነቶች (Bread and Similar Items)
  - ፋስት ፉድ ፣ ትኩስና ፈጣን ምግቦች (Fast Food and Quick Meals)
  - ፍራፍሬዎች (Fruits)
  - የሱቅ ዕቃዎች (Shop Items)
  - የላውንደሪ አገልግሎቶች (Laundry Services)
  - ጨዋታዎች (Entertainment)
  - የፎቶ ኮፒና ተዛማጅ አገልግሎቶች (Photocopy and Related Services)
  - የሴቶች ጸጉር ቤት (Women's Hair Salon)
  - የወንዶች ጸጉር ቤት (Men's Hair Salon)

### 2. **Favorites Management**
- Mark your favorite services for quick access.
- Add or remove services from your favorites list with a single tap.

### 3. **Detailed Service Information**
- View detailed information about each service, including:
  - Service Name
  - Price
  - Category

### 4. **User-Friendly Interface**
- Clean and intuitive UI designed for easy navigation.
- Responsive design for a smooth experience on all devices.

---

## Screenshots

| Home Screen | Categories Screen | Service Details | Favorites Screen | About Screen |
|-------------|-------------------|-----------------|------------------|--------------|
| ![Home Screen](https://github.com/user-attachments/assets/2a754f72-164d-4176-8019-530aa63b4a44) | ![Categories Screen](https://github.com/user-attachments/assets/6e33ff3b-04c9-43d6-98b1-bb3c213b9b7e) | ![Service Details](https://github.com/user-attachments/assets/eaf5f42c-39b2-454b-811a-aed157804d2d) |![Favorites Screen](https://github.com/user-attachments/assets/336f9bac-d16d-4a16-9ca8-05feb0760801) | ![About Screen](https://github.com/user-attachments/assets/75e41a16-6283-4a18-9d40-8a1385386cf0)
 |

---

## Installation

### Prerequisites
- Android Studio (latest version recommended)
- Android device or emulator with API level 21 or higher

### Steps
1. **Clone the Repository**
   ```bash
   git clone (https://github.com/Minas-27/BDU-Services)
   ```
2. **Open the Project in Android Studio**
   - Launch Android Studio.
   - Select `Open an existing Android Studio project`.
   - Navigate to the cloned repository and open it.

3. **Build and Run the App**
   - Connect an Android device or start an emulator.
   - Click `Run` in Android Studio to build and install the app on your device/emulator.

---

## Technologies Used

- **Kotlin**: Primary programming language for Android development.
- **Jetpack Compose**: Modern UI toolkit for building native Android UI.
- **Room Database**: Local database for storing favorite services.
- **LiveData**: For observing data changes and updating the UI.
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.
- **Material Design**: For a consistent and visually appealing UI.

---

## Project Structure

```
bdu-services-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/bduservices/
│   │   │   │   ├── data/
│   │   │   │   │   ├── ServiceData.kt          # Contains all service data
│   │   │   │   ├── database/
│   │   │   │   │   ├── Favorite.kt             # Favorite data class
│   │   │   │   │   ├── FavoriteDao.kt          # Data Access Object for favorites
│   │   │   │   │   ├── FavoriteDatabase.kt     # Room database setup
│   │   │   │   ├── repository/
│   │   │   │   │   ├── FavoriteRepository.kt   # Repository for favorites
│   │   │   │   ├── ui/
│   │   │   │   │   ├── FavoritesScreen.kt      # Favorites UI
│   │   │   │   │   ├── ServiceItem.kt          # Service item UI component
│   │   │   │   │   ├── ServicesList.kt         # List of services UI
│   │   │   │   ├── viewmodel/
│   │   │   │   │   ├── FavoritesViewModel.kt   # ViewModel for favorites
│   │   │   │   ├── MainActivity.kt             # Main entry point
│   │   ├── res/
│   │   │   ├── drawable/                       # App icons and images
│   │   │   ├── layout/                         # XML layouts (if any)
│   │   │   ├── values/                         # Colors, strings, and themes
```

---

## How to Contribute

We welcome contributions to improve the BDU Services App! Here’s how you can help:

1. **Fork the Repository**
   - Click the `Fork` button on the top right of the repository page.

2. **Create a New Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Your Changes**
   - Add new features, fix bugs, or improve documentation.

4. **Commit and Push**
   ```bash
   git add .
   git commit -m "Add your commit message here"
   git push origin feature/your-feature-name
   ```

5. **Create a Pull Request**
   - Go to the original repository and click `New Pull Request`.
   - Describe your changes and submit the PR.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- Special thanks to the Android developer community for providing excellent resources and tools.

---

## Contact

For questions, suggestions, or feedback, feel free to reach out:

- **Email**: abrahamaddisu217@gmail.com
- **GitHub**: [Minas-27](https://github.com/Minas-27)

---

Enjoy using the **BDU Services App**! 🚀
