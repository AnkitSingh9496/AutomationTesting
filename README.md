# 🧪 SauceDemo Automation Framework

## 📌 Overview

This project is a Selenium-based test automation framework built using **Java, Maven, and TestNG**. It validates core user flows of the SauceDemo application such as login, inventory, cart, and checkout.

The framework follows the **Page Object Model (POM)** design pattern to ensure maintainability, scalability, and separation of concerns.

---

## 🧱 Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **CI/CD:** GitHub Actions

---

## 📁 Project Structure

```plaintext
sauceDemoAutomation/
│
├── src/
│   ├── main/java/
│   │   ├── pages/        # Page Object Model classes
│   │   └── utils/        # Driver & configuration utilities
│   │
│   └── test/java/
│       └── tests/        # Test classes
│
├── automation/           # Logical representation (as per requirements)
│   ├── pages/
│   ├── tests/
│   └── test-data/
│
├── docs/                 # Documentation
│   ├── test-plan.md
│   ├── test-cases.md
│   ├── bug-reports.md
│   ├── api-results.md
│   └── test-summary.md
│
├── ci/                   # CI pipeline definition
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

## 🧩 Framework Design

### ✔ Page Object Model (POM)

Each web page is represented as a separate class containing:

* Web elements (locators)
* Page actions (methods)

Examples:

* `LoginPage.java`
* `InventoryPage.java`
* `CartPage.java`
* `CheckoutPage.java`

---

### ✔ Test Layer

Test classes are located under:

```
src/test/java/tests/
```

They interact with page objects and validate application behavior.

---

### ✔ Utilities

* `Driver.java` → WebDriver initialization
* `ConfigReader.java` → Environment/config handling

---

## ▶️ How to Run Tests

### ✅ Prerequisites

* Java (JDK 11 or higher)
* Maven installed
* Chrome browser installed

---

### ▶️ Run via Terminal

```bash
mvn clean test
```

---

### ▶️ Run via IntelliJ

* Right-click test class → Run
* OR use Maven panel → Lifecycle → test

---

## 📊 Test Reports

### 📍 Default Maven Report

After execution:

```
target/surefire-reports/
```

Contains:

* Test results
* Logs
* Failure details

---

## 🔄 Data-Driven Testing

The framework supports parameterized testing using **TestNG DataProvider**.

Example:

```java
@DataProvider(name = "loginData")
public Object[][] getData() {
    return new Object[][] {
        {"standard_user", "secret_sauce"},
        {"locked_out_user", "secret_sauce"}
    };
}
```

---

## 🔄 CI/CD Pipeline (GitHub Actions)

Automated pipeline runs on every push.

### 📌 Stages:

1. **Checkout**

   * Clones repository

2. **Install Dependencies**

   * Sets up Java (JDK 17)
   * Builds project using Maven

3. **Run Tests**

   ```bash
   mvn test
   ```

4. **Publish Reports**

   * Uploads test results from:

   ```
   target/surefire-reports/
   ```

---

## ⚙️ Assumptions

* Tests are executed on Chrome browser
* Application under test is publicly accessible
* No authentication beyond login page
* CI runs in headless-compatible mode

---

## ⚠️ Limitations

* No cross-browser testing implemented
* No API automation (placeholder provided)
* Limited negative test coverage
* No advanced reporting (Extent/Allure)

---

## 📚 Documentation

Detailed documentation is available in the `docs/` folder:

* Test Plan
* Test Cases
* Bug Reports
* Test Summary

---

## 🚀 Future Enhancements

* Add Extent or Allure reports
* Implement API automation (RestAssured)
* Add parallel execution
* Integrate Docker for test execution
* Add cross-browser testing

---

## 👨‍💻 Author

Automation Testing Assignment Submission
