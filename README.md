
<h1 align="center">
  <br>
  
  <img width="848" height="218" alt="UR Marketplace" src="https://github.com/user-attachments/assets/5248b0ad-5891-433f-bdaf-3716924afbcf" />


  <h3 align="center"> Your next move just got a whole lot easier.<h3>

<br>
<br>
<br>

<h2 align="center" >Project Quick Links</h2>
<h3 align="center">
  <strong><a href="Testing.md">Testing Records</a></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="Testing.md">Project Report</a></strong>
<br>
<br>
<br>
<br>

  <h2 align="center">Our Team</h2>
<br>   

  
<table align="center">
    <tr>
      <th>Group Members</th>
      <th>Tom Goncin</th>
      <th>Esteban Mendoza</th>
      <th>Amr Azouz</th>
    </tr>
    <tr>
      <th>Email</th>
      <td>tgj616@uregina.ca</th>
      <th>edp256@uregina.ca</th>
      <th>aab116@uregina.ca</th>
    </tr>
    <tr>
      <th>Student ID</th>
      <th>2004 12666</th>
      <th>2005 60450</th>
      <th>2005 06317</th>
    </tr>
  </table>


<br> </b>
<br> </b>
<br> </b>


<br>

<h2 align="center" id="quick-run">Already installed? <br>Use this .bat file to run</h2>
<br>

          bat@echo off
          echo ==========================================
          echo INSTALLING UR-MARKETPLACE DEPENDENCIES
          echo ==========================================
          call mvn clean install -DskipTests
          echo.
          echo RUNNING JUNIT 5 TESTS
          echo ==========================================
          call mvn test
          echo.
          echo STARTING UR-MARKETPLACE CONSOLE
          echo ==========================================
          call mvn exec:java -Dexec.mainClass="com.example.URMarketplaceConsole"
          pause
          
<br>
<br>
<h2 align="center" id="setup">Local Installation</h2>
<br>
<p align="center">Follow the directions below, or save this code as a <code>.bat</code> file and run it in your Visual Studio Code terminal.</p>
<br>
        bat@echo off
        SETLOCAL
        cls
        
        echo ==========================================
        echo   UR-Marketplace: Automated Setup ^& Run
        echo ==========================================
        
        :: 1. Check for Java 17 (REQUIRED by pom.xml)
        echo [1/4] Checking Java version...
        java -version >nul 2>&1
        if %errorlevel% neq 0 (
            echo ERROR: Java is not installed or not in your PATH.
            echo Please ensure Java 17 is installed.
            pause
            exit /b
        )
        
        :: 2. Install Dependencies (JUnit 5 and SQLite)
        echo [2/4] Installing dependencies...
        call mvn clean install -DskipTests
        if %errorlevel% neq 0 (
            echo ERROR: Maven build failed. Check your Maven installation.
            pause
            exit /b
        )
        
        :: 3. Run JUnit 5 Validation Tests
        echo [3/4] Running project tests...
        call mvn test
        if %errorlevel% neq 0 (
            echo WARNING: Some tests failed. Check the output above.
        )
        
        :: 4. Launch the Console Application
        echo [4/4] Launching URMarketplaceConsole...
        call mvn exec:java -Dexec.mainClass="com.example.URMarketplaceConsole"
        if %errorlevel% neq 0 (
            echo ERROR: The application failed to start.
        )
        
        pause
        ENDLOCAL
<br>
<ul style="margin-left: 40px;">
  <li><strong>Prerequisites:</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Java 17:</strong> 
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbspEnsure your JDK version is 17 as specified in the project properties.<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Apache Maven:</strong> 
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbspMaven must be installed and the <code>bin</code> directory added to your system PATH.
  </li>
  <br>
  <li><strong>Clone the repository:</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code>git clone &lt;repository-url&gt;</code><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code>cd UR-Marketplace</code>
  </li>
  <br>
  <li><strong>Verify your environment:</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run <code>java -version</code> to confirm you are using version 17.<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run <code>mvn -version</code> to ensure Maven is accessible.
  </li>
  <br>
  <li><strong>Automated setup & run:</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run the <code>run_marketplace.bat</code> file provided in the root directory.<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The script handles dependency management, test verification, and application launch.
  </li>
  <br>
  <li><strong>Manual execution (optional):</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Install dependencies: 
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<code>mvn clean install -DskipTests</code><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run tests:
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<code>mvn test</code><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Start application:
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<code>mvn exec:java -Dexec.mainClass="com.example.URMarketplaceConsole"</code>
  </li>
  <br>
  <li><strong>Note:</strong><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For lab machines, ensure <code>maven.compiler.source</code> in <code>pom.xml</code> is set to <code>17</code>.<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;If it shows <code>1.7</code>, update it manually to prevent compilation errors.
  </li>
</ul>
<br><br><br>
<p align="right"><a href="#"><strong>Back to top ↑</strong></a></p>
