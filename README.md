# PixelBlend 🎨🖼️

PixelBlend is a **Java-based image filtering application** that allows users to enhance and modify their photos using a variety of filters. Built using the **Decorator Design Pattern**, the app provides a flexible and scalable way to apply multiple filters while maintaining high performance.

## Features 🚀
- Apply various image filters:
  - 🏴 Grayscale
  - 🌟 Brightness Adjustment
  - 📦 Box Blur
  - 🌫️ Gaussian Blur
  - 🎭 Motion Blur
  - 🖌️ Emboss
  - 🔪 Sharpen
  - 🔍 Laplacian Edge Detection
- **Undo & Redo** applied filters 🔄
- **Command-Line Interface (CLI)** support 💻
- **Web Interface (Coming Soon) 🌐**

---

## Getting Started 🛠️

### Clone the Repository 📥
```bash
 git clone https://github.com/Sithum-Bimsara/PixelBlend.git
 cd PixelBlend
```

### Build & Run 🚀
Use Gradle to build the project and run the application:
```bash
 gradlew build 
 java -jar build/libs/PixelBlend.jar
```
Or run the main file in IntelliJ IDEA:
```bash
 Open the project in IntelliJ
 Navigate to `Main.java`
 Click ▶️ Run
```

---

## Example Run 📸
```bash
Enter image path: photo.png
Image Loaded Successfully
Width: 360
Height: 360
Choose an option:
1. Apply Grayscale Filter
2. Apply Brightness Filter
3. Apply Box Blur Filter
4. Apply Gaussian Blur Filter
5. Apply Motion Blur Filter
6. Apply Emboss Filter
7. Apply Sharpen Filter
8. Apply Laplacian Filter
9. Undo
10. Redo
11. Save and Exit
12. Save
```

Applying a Brightness Filter:
```bash
2
- Enter brightness percentage -
300
Filter Applied.
```

Saving the image:
```bash
12
Image saved as new_photo.png
```

---

## Screenshots 📷
Here are some screenshots showcasing the application's functionality:

### Grayscale Filter
### Grayscale Filter
<img src="assets/Indunil.jpg" alt="Screenshot" width="400">
<img src="assets/Laplacian_Indunil.jpg" alt="Screenshot" width="400">



---

## Future Development 🌱
- 🌐 Web Interface
- 🏎️ Performance Optimization
- 🖼️ More Filters!

---

## Contributions 🤝
Feel free to fork, modify, and contribute! PRs are welcome.

---

## License 📜
MIT License. See `LICENSE` for details.
