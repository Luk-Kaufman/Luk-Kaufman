# Torn City Flight Automation

This Java project automates mouse movements and screen reading to interact with the browser-based game **Torn City**. The purpose is to assist with returning from the in-game location **South Africa** by performing flight actions automatically.

## Project Overview

While playing Torn City, players frequently need to return to their home country from travel locations like South Africa. This project takes periodic screenshots of the screen, analyzes them, and performs automated mouse movements and clicks to initiate a flight back — saving the player time and effort.

## Features

- Capture pixel data from the screen
- Detect specific screen elements using pixel color (for flight buttons, etc.)
- Move mouse to target locations
- Perform mouse clicks
- Can be extended with OCR or image matching for better accuracy

## Technologies Used

- Java (with the `java.awt.Robot` class)
- Visual Studio Code (VS Code)
- Java Development Kit (JDK)

## Getting Started

### Prerequisites

- Java JDK installed
- VS Code with Java extensions
- A screen resolution that matches the coordinates hardcoded in the app

### Running the Project

1. Clone or download the project.
2. Open it in VS Code.
3. Run the `MouseAutomation.java` file.
4. The robot will move the mouse, capture pixel colors, and click based on programmed logic.

> Make sure the game window is visible and not obstructed, and the browser is positioned correctly on the screen.

## Notes

- This is an automation script is purley designed for a way for me to learn more about various features/library in Java and to learn more about macros. Excessive automation may violate Torn City’s terms of service. Use responsibly.

## License

This project is open-source and intended for educational and personal use only.
