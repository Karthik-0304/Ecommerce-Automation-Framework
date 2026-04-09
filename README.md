# 🛒 Ecommerce Automation Framework

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Selenium-4.40.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white" />
  <img src="https://img.shields.io/badge/Cucumber-7.34.2-23D96C?style=for-the-badge&logo=cucumber&logoColor=white" />
  <img src="https://img.shields.io/badge/TestNG-7.12.0-red?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/ExtentReports-5.1.2-blueviolet?style=for-the-badge" />
</p>

<p align="center">
  A robust end-to-end test automation framework for e-commerce web applications, built with <strong>Java 21</strong>, <strong>Selenium WebDriver</strong>, <strong>Cucumber BDD</strong>, and <strong>TestNG</strong> — structured around the Page Object Model (POM) design pattern with rich ExtentReports HTML reporting.
</p>

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Framework Architecture](#-framework-architecture)
- [Test Scenarios](#-test-scenarios)
- [Running Tests](#-running-tests)
- [Test Reporting](#-test-reporting)
- [CI/CD Integration](#-cicd-integration)
- [Contributing](#-contributing)

---

## 🔍 Overview

The **Ecommerce Automation Framework** automates end-to-end testing of e-commerce web workflows using a BDD (Behaviour-Driven Development) approach with Cucumber feature files. Tests are orchestrated by TestNG, browser interactions are handled by Selenium WebDriver with automatic driver management via WebDriverManager, and results are published as rich HTML reports through ExtentReports and Cucumber Reporting.

**Key Highlights:**
- ✅ BDD test scenarios written in Gherkin (`.feature` files)
- ✅ Page Object Model (POM) for clean, maintainable test structure
- ✅ Cucumber + TestNG integration for structured suite execution
- ✅ Zero manual driver setup — WebDriverManager handles ChromeDriver automatically
- ✅ ExtentReports + Cucumber HTML reports with screenshots on failure
- ✅ GitHub Actions CI/CD pipeline included
- ✅ Java 21 with Maven build lifecycle

---

## 🛠 Tech Stack

| Tool / Library       | Purpose                                        | Version  |
|----------------------|------------------------------------------------|----------|
| Java                 | Core programming language                      | 21       |
| Maven                | Build tool & dependency management             | 3.x      |
| Selenium WebDriver   | Browser automation                             | 4.40.0   |
| TestNG               | Test runner, assertions, suite management      | 7.12.0   |
| Cucumber (Java)      | BDD feature file execution                     | 7.34.2   |
| Cucumber-TestNG      | Cucumber–TestNG integration bridge             | 7.34.2   |
| WebDriverManager     | Automatic ChromeDriver/GeckoDriver management  | 6.3.3    |
| ExtentReports        | Rich interactive HTML test reports             | 5.1.2    |
| Cucumber Reporting   | Cucumber-specific HTML/JSON reports            | 5.7.4    |
| Commons IO           | File I/O utilities for screenshots             | 2.15.1   |
| GitHub Actions       | CI/CD pipeline automation                      | —        |

---

## 📁 Project Structure

```
Ecommerce-Automation-Framework/
│
├── .github/
│   └── workflows/
│       └── ci.yml                         # GitHub Actions CI pipeline
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/                     # Page Object Model classes
│   │           ├── BasePage.java
│   │           ├── HomePage.java
│   │           ├── LoginPage.java
│   │           ├── ProductPage.java
│   │           ├── CartPage.java
│   │           └── CheckoutPage.java
│   │
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   │   └── SubmitOrderTest.java   # Cucumber TestNG runner
│       │   ├── stepdefs/
│       │   │   ├── LoginSteps.java
│       │   │   ├── CartSteps.java
│       │   │   └── CheckoutSteps.java
│       │   └── utils/
│       │       ├── DriverFactory.java
│       │       ├── ExtentReportManager.java
│       │       └── Hooks.java
│       │
│       └── resources/
│           └── features/
│               ├── login.feature
│               ├── cart.feature
│               └── checkout.feature
│
├── reports/                               # Auto-generated HTML/JSON reports
├── .gitignore
├── pom.xml                                # Maven dependencies & build config
├── testng.xml                             # TestNG suite definition
└── README.md
```

---

## ✅ Prerequisites

- Java JDK 21 (with `JAVA_HOME` set)
- Apache Maven 3.8+
- Google Chrome (latest stable)
- Git
- IntelliJ IDEA (recommended)

---

## ⚙️ Installation & Setup

**1. Clone the repository**

```
git clone https://github.com/Karthik-0304/Ecommerce-Automation-Framework.git
cd Ecommerce-Automation-Framework
```

**2. Install all Maven dependencies**

```
mvn clean install -DskipTests
```

**3. Verify your Java version**

```
java -version
```

Should output `openjdk version "21.x.x"` or higher.

> WebDriverManager automatically downloads and configures the correct ChromeDriver binary — no manual installation required.

---

## 🏗 Framework Architecture

The framework is layered so each concern is separated and independently maintainable:

**Feature Files (Gherkin)** describe what to test in plain English — readable by both technical and non-technical stakeholders.

**Step Definitions** translate each Gherkin step into Java method calls that interact with the Page Objects.

**Page Object Layer** encapsulates all locators and browser interactions for each page of the application. Any change to the UI only requires updating the relevant Page Object class.

**BasePage** holds all shared Selenium actions (click, type, wait, screenshot) so they are defined once and reused across all page classes.

**Utilities** handle cross-cutting concerns — driver lifecycle, ExtentReports setup, and before/after test hooks that capture screenshots on failure.

---

## 🧪 Test Scenarios

| Module         | Scenario                                          | Tag         |
|----------------|---------------------------------------------------|-------------|
| Authentication | Login with valid credentials                      | @smoke      |
| Authentication | Login with invalid password shows error           | @regression |
| Authentication | Login with empty fields shows validation message  | @regression |
| Product Search | Search returns matching products                  | @smoke      |
| Product Search | Search with no results shows empty state          | @regression |
| Cart           | Add a product to cart                             | @smoke      |
| Cart           | Remove a product from cart                        | @regression |
| Cart           | Update product quantity updates total             | @regression |
| Checkout       | Submit order with valid shipping and payment      | @smoke      |
| Checkout       | Submit order with empty shipping fields fails     | @regression |
| Checkout       | Order confirmation page displays after success    | @smoke      |

---

## ▶️ Running Tests

**Run the full suite via Maven**

```
mvn clean test
```

**Run via TestNG XML directly**

```
mvn test -DsuiteXmlFile=testng.xml
```

**Run only smoke tests**

```
mvn test -Dcucumber.filter.tags="@smoke"
```

**Run only regression tests**

```
mvn test -Dcucumber.filter.tags="@regression"
```

**Run in headless mode** — uncomment the headless argument in `DriverFactory.java`, then run any of the above commands.

---

## 📊 Test Reporting

After every test run, three reports are automatically generated in the `reports/` directory:

| Report                           | File                                  | Tool               |
|----------------------------------|---------------------------------------|--------------------|
| Interactive HTML dashboard       | `reports/index.html`                  | ExtentReports      |
| Feature-level breakdown          | `reports/cucumber-html-report.html`   | Cucumber Reporting |
| Machine-readable JSON output     | `reports/cucumber.json`               | Cucumber JSON      |

Open `reports/index.html` in any browser to view pass/fail/skip counts, step-by-step logs, embedded failure screenshots, and execution timelines.

---

## 🔁 CI/CD Integration

A GitHub Actions workflow is included at `.github/workflows/ci.yml`. It automatically triggers on every push or pull request to the `master` branch, sets up Java 21, installs Chrome, runs the smoke suite in headless mode, and uploads the `reports/` directory as a build artifact for download.

---

## 🤝 Contributing

1. Fork this repository
2. Create a feature branch — `git checkout -b feature/your-scenario`
3. Add your `.feature` file and corresponding step definitions
4. Commit your changes — `git commit -m "feat: add product filter scenario"`
5. Push the branch — `git push origin feature/your-scenario`
6. Open a Pull Request

---

## 📄 License

This project is open-source under the [MIT License](LICENSE).

---

<p align="center">Made with ❤️ by <a href="https://github.com/Karthik-0304">Karthik</a></p>
