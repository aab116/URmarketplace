<h1 align="center"> University of Regina Marketplace </h1>
<b></b>
<b></b>
<h3 align="center"> ENSE 375 – Software Testing and Validation </h3>  
<b> </b>
<br>



  <h2 align="center">Team Members</h2>
<br>   
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



<br>
<br>
<h2 align="center"> Table of Contents </h2><b>
<br>
<br>

- [1 — Introduction](#1-introduction)
- [2 — Design Problem](#2-design-problem)
  - [2.1 — Problem Definition](#21-problem-definition)
  - [2.2 — Design Requirements](#22-problem-requirements)
    - [2.2.1 — Functions](#221-functions)
    - [2.2.2 — Objectives](#222-objectives)
    - [2.2.3 — Constraints](#223-constraints)
- [3 — Solutions](#3-solutions)
  - [3.1 — Solution Set 1](#31-solution-set)
  - [3.2 — Solution Set 2](#32-solution-set)
  - [3.3 — Final Solution](#33-final-solution)
    - [3.3.1 — Components](#331-components)
    - [3.3.2 — Environmental, Societal, Safety, and Economic Considerations](#332-3.3.2-Environmental,-societal,-safety,-&-economic-considerations)
    - [3.3.3 — Test Cases & results](#333-test-cases-&-results)
    - [3.3.4 — Limitations](#334-limitations)
- [4 — Team Work](#4-team-work)
  - [4.1 — Meeting 1](#41-meeting-1)
  - [4.2 — Meeting 2](#42-meeting-2)
  - [4.3 — Meeting 3](#43-meeting-3)
  - [4.4 — Meeting 4](#44-meeting-4)
- [5 — Project Management](#5-project-management)
  - [5.1 — Gantt Chart](#51-gantt-chart)
  - [5.2 — Task List, Predecessors, Slack Time, and Critical Path](#52-task-list)
  - [5.3 — Project Management Summary](#53-project-management-summary)
- [6 — Conclusion and Future Work](#6-conclusion-and-future-work)
  - [6.1 — Conclusion](#61-conclusion)
  - [6.2 — Future Work](#62-future-work)





<div align="center">
  <h2> List of Figures </h2>
  <ul style="margin-left: 40px;">
    <img width="1120" height="950" alt="image" src="https://github.com/user-attachments/assets/6d121a4f-61f1-45dc-bca4-c3d799dc7d90" />
    Use Case Diagram<br>
    Figure 1<br>
    <br>
    <br>
    <img width="2630" height="1630" alt="image" src="https://github.com/user-attachments/assets/53074ae4-2507-46ac-8824-5d39f4a2dc25" />
    Class Diagram<br>
    Figure 2<br>
    <br>
    <br>
    <img width="1760" height="1360" alt="image" src="https://github.com/user-attachments/assets/e5161fc7-4dab-4969-b687-9670e0b62cc7" />
    Layered Architecture Diagram<br>
    Figure 3<br>
    <br>
    <br>
  </ul>
</div>






<br>
<br>
<h2 align ="center"> List of Tables </h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <h2 align = "left" id = "1-table">User Class Testing</h2>
    <br>
    <br>
    <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>title Present?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>price &amp; description Valid?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
      </tr>
      <tr>
        <th>Save Product</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject Product</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 1</p>  <br>
    <br>
  </ul>


  
<h2 align = "left" id = "2-table">Product Class Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>title Present?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>price &amp; description Valid?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
      </tr>
      <tr>
        <th>Save Product</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject Product</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 2</p>  <br>
    <br>
  </ul>
  
  
  
  <h2 align = "left" id = "3-table">UserComment Class Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>Rating Between 1–5?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>comment ≤ 250 Chars?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
      </tr>
      <tr>
        <th>Save Comment</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject Comment</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 3</p>  <br>
    <br>
  </ul>

    

<h2 align = "left" id = "4-table">RatingService Interface Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>rating Between 1–5?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>rater &amp; ratee IDs valid?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
      </tr>
      <tr>
        <th>Process Rating</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Error</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 4</p>  <br>
    <br>
  </ul>



<h2 align = "left" id = "5-table">UserRepository Interface Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>userId Exists?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>data Valid?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
      </tr>
      <tr>
        <th>Update User</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Create User</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject</th>
        <th></th>
        <th>X</th>
        <th></th>
        <th>X</th>
        <th></th>
        <th></th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 5</p>  <br>
    <br>
  </ul>


  
  
<h2 align = "left" id = "6-table">ProductRepository Interface Testing</h2>    
<br>
<br>
  <ul style="margin-left: 40px;">
  <table align="center">
    <tr>
      <th>Condition</th>
      <th>Rule 1</th>
      <th>Rule 2</th>
      <th>Rule 3</th>
      <th>Rule 4</th>
      <th>Rule 5</th>
      <th>Rule 6</th>
      <th>Rule 7</th>
      <th>Rule 8</th>
    </tr>
    <tr>
      <th>sellerId Exists?</th>
      <th>T</th>
      <th>T</th>
      <th>F</th>
      <th>F</th>
      <th>T</th>
      <th>T</th>
      <th>F</th>
      <th>F</th>
    </tr>
    <tr>
      <th>product Data Valid?</th>
      <th>T</th>
      <th>F</th>
      <th>T</th>
      <th>F</th>
      <th>T</th>
      <th>T</th>
      <th>F</th>
      <th>F</th>
    </tr>
    <tr>
      <th>Action Stubs</th>
    </tr>
    <tr>
      <th>Save Product</th>
      <th>X</th>
      <th></th>
      <th></th>
      <th></th>
      <th>X</th>
      <th>X</th>
      <th></th>
      <th></th>
    </tr>
    <tr>
      <th>Reject</th>
      <th></th>
      <th>X</th>
      <th>X</th>
      <th>X</th>
      <th></th>
      <th></th>
      <th>X</th>
      <th>X</th>
    </tr>
  </table>
  <p align="center">Table 6</p>  <br>
  <br>
  </ul>


  

  <h2>Alternative Architecture Evaluation</h2>
  <br>
  <br>
    <ul style="margin-left: 40px;">
      <table align="center">
        <tr>
          <th>Evaluation Criterion</th>
          <th>Assessment</th>
          <th>Analysis</th>
        </tr>
        <tr>
          <td>Clarity of Responsibility Separation</td>
          <td align="center">Moderate</td>
          <td>Functional areas are grouped logically; however, validation, processing, and persistence logic are partially combined. The Single Responsibility Principle is not consistently applied.</td>
        </tr>
        <tr>
          <td>Fault Isolation & System Reliability</td>
          <td align="center">Moderate to Low</td>
          <td>Because validation and operational logic are intertwined, an error in one component may propagate to others, increasing the risk of cascading failures.</td>
        </tr>
        <tr>
          <td>Enforcement of Boundary & Validation Constraints</td>
          <td align="center">Moderate</td>
          <td>Validation rules exist but are embedded in multiple areas of the system. This may lead to inconsistent enforcement of rating limits, offer constraints, or lifecycle rules.</td>
        </tr>
        <tr>
          <td>Protection Against Invalid Input & Misuse</td>
          <td align="center">Moderate</td>
          <td>Input checks and authorization controls are present but not centralized. This increases the possibility of uneven rule enforcement across different execution paths.</td>
        </tr>
        <tr>
          <td>Long-Term Maintainability & Scalability</td>
          <td align="center">Moderate to Low</td>
          <td>Tightly coupled logic makes expansion and modification riskier. Introducing new features may require modifying multiple modules, increasing complexity.</td>
        </tr>
      </table>
      <p align="center">Table 7</p>
      <br>
      <br>
    </ul>
  </ul>





<h2>UserManager Class Testing</h2> 
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
      </tr>
      <tr>
        <th>Username unique?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Valid email format?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Register User (return true)</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject Registration (return false)</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 8</p>
  </ul>
  <br>
  <br>



  
  <h2>UserManager Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
      </tr>
      <tr>
        <th>Username exists?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Password matches?</th>
        <th>T</th>
        <th>-</th>
        <th>F</th>
        <th>-</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Login Success (return User)</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Login Failed (return null)</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
    <p align="center">Table 9</p>
  </ul>
  <br>
<br>





<h2>IssueManager Class Testing</h2>
    <br>
    <br>
    <ul style="margin-left: 40px;"> 
      <table align="center">
        <tr>
          <th>Condition</th>
          <th>Rule 1</th>
          <th>Rule 2</th>
          <th>Rule 3</th>
          <th>Rule 4</th>
          <th>Rule 5</th>
          <th>Rule 6</th>
          <th>Rule 7</th>
          <th>Rule 8</th>
        </tr>
        <tr>
          <th>Title present?</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
        </tr>
        <tr>
          <th>Description present?</th>
          <th>T</th>
          <th>F</th>
          <th>T</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
        </tr>
        <tr>
          <th>Category valid?</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
          <th>F</th>
          <th>F</th>
        </tr>
        <tr>
          <th>Action Stubs</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Create Issue (return ID)</th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Reject Issue (return -1)</th>
          <th></th>
          <th>X</th>
          <th>X</th>
          <th>X</th>
          <th>X</th>
          <th>X</th>
          <th>X</th>
          <th>X</th>
        </tr>
      </table>
      <p align="center">Table 10</p>
    </ul>
    <br>
    <br>




<h2>BiddingManager (makeOffer method) Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
      <table align="center"> 
        <tr> 
          <th>Condition</th> 
          <th>Rule 1</th> 
          <th>Rule 2</th> 
          <th>Rule 3</th> 
          <th>Rule 4</th> 
          <th>Rule 5</th> 
          <th>Rule 6</th> 
          <th>Rule 7</th> 
          <th>Rule 8</th> 
        </tr> 
        <tr> 
          <th>Listing exists?</th> 
          <th>T</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>F</th> 
          <th>F</th> 
        </tr> <tr> 
          <th>Listing ACTIVE?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> <tr> 
          <th>Amount > currentBid?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> 
        <tr> 
          <th>Bidder != seller?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> <tr> 
          <th>Action Stubs</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return offerId (>0)</th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> <th>Return -1 (listing not found)</th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th>X</th> 
        </tr> 
        <tr> 
          <th>Return -2 (listing inactive)</th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return -3 (bid too low)</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return -4 (cannot bid on own item)</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
      </table> 
    <p align="center">Table 11</p>
    </ul>
    <br>
    <br>




<h2>BiddingManager (buyNow method) Testing</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">  
      <table align="center">
        <tr>
          <th>Condition</th>
          <th>Rule 1</th>
          <th>Rule 2</th>
          <th>Rule 3</th>
          <th>Rule 4</th>
          <th>Rule 5</th>
          <th>Rule 6</th>
          <th>Rule 7</th>
          <th>Rule 8</th>
        </tr>
        <tr>
          <th>Listing exists?</th>
          <th>T</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
        </tr>
        <tr>
          <th>Listing ACTIVE?</th>
          <th>T</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>BuyNowPrice &gt; 0?</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>Buyer != seller?</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>Action Stubs</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>BuyNow Success (return true)</th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (listing not found)</th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th>X</th>
        </tr>
        <tr>
          <th>Return false (listing inactive)</th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (no buy now price)</th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (buying own item)</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
      </table>
    <p align="center">Table 12</p>
    </ul>
    <br>
    <br>

    

  <h2>Alternative Architecture Evaluation</h2>
    <br>
    <br>
    <ul style="margin-left: 40px;"> 
      <table align="center">
        <tr>
          <th>Evaluation Criterion</th>
          <th>Assessment</th>
          <th>Analysis</th>
        </tr>
        <tr>
          <td>Clarity of Responsibility Separation</td>
          <td align="center">Moderate</td>
          <td>Functional areas are grouped logically; however, validation, processing, and persistence logic are partially combined. The Single Responsibility Principle is not consistently applied.</td>
        </tr>
        <tr>
          <td>Fault Isolation & System Reliability</td>
          <td align="center">Moderate to Low</td>
          <td>Because validation and operational logic are intertwined, an error in one component may propagate to others, increasing the risk of cascading failures.</td>
        </tr>
        <tr>
          <td>Enforcement of Boundary & Validation Constraints</td>
          <td align="center">Moderate</td>
          <td>Validation rules exist but are embedded in multiple areas of the system. This may lead to inconsistent enforcement of rating limits, offer constraints, or lifecycle rules.</td>
        </tr>
        <tr>
          <td>Protection Against Invalid Input & Misuse</td>
          <td align="center">Moderate</td>
          <td>Input checks and authorization controls are present but not centralized. This increases the possibility of uneven rule enforcement across different execution paths.</td>
        </tr>
        <tr>
          <td>Long-Term Maintainability & Scalability</td>
          <td align="center">Moderate to Low</td>
          <td>Tightly coupled logic makes expansion and modification riskier. Introducing new features may require modifying multiple modules, increasing complexity.</td>
        </tr>
      </table>
     </ul>
    <p align="center">Table 13</p>
    <br>
  </ul>









  <h2 align="left" id="comparison-table">Testing & Reliability Comparison</h2>
    <br>
    <br>
    <ul style="margin-left: 40px;">
      <table align="center">
        <tr>
          <th>Criterion</th>
          <th>Earlier / More Coupled Solutions</th>
          <th>Final Modular Solution</th>
        </tr>
        <tr>
          <td>Testability</td>
          <td>Lower, because logic and persistence are mixed together</td>
          <td>Higher, because entities, managers, and utilities can be tested separately</td>
        </tr>
        <tr>
          <td>Fault Isolation</td>
          <td>Weak, failures can affect several responsibilities at once</td>
          <td>Stronger, because failures are easier to trace to one component</td>
        </tr>
        <tr>
          <td>Regression Testing</td>
          <td>More difficult after changes</td>
          <td>Easier, because each class can be re-tested independently</td>
        </tr>
        <tr>
          <td>Edge-Case Coverage</td>
          <td>Harder to organize systematically</td>
          <td>Easier to organize around each component and rule</td>
        </tr>
        <tr>
          <td>Maintainability</td>
          <td>Lower as new features are added</td>
          <td>Higher due to clearer responsibilities</td>
        </tr>
        <tr>
          <td>Reliability</td>
          <td>More dependent on manual checking</td>
          <td>More reliable through repeatable automated tests</td>
        </tr>
      </table>
    <p align="center">Table 14</p>
  </ul>
  <br>
  <br>











  <h2 align="left" id="component-testing-table">System Components</h2>
  <br>
  <br>
  <ul style="margin-left: 40px;">
      <table align="center">
        <tr>
          <th>Component</th>
          <th>Main Purpose</th>
          <th>Testing Method Used</th>
        </tr>
        <tr>
          <td>URMarketplaceConsole</td>
          <td>Provides the command-line interface and connects user actions to system operations</td>
          <td>Manual functional testing and scenario-based testing</td>
        </tr>
        <tr>
          <td>DatabaseHelper</td>
          <td>Creates the SQLite connection and initializes the required tables</td>
          <td>Integration testing, schema verification, and database initialization tests</td>
        </tr>
        <tr>
          <td>User</td>
          <td>Stores user account data and tracks rating averages</td>
          <td>Unit testing of getters, setters, login state, and rating calculations</td>
        </tr>
        <tr>
          <td>UserManager</td>
          <td>Handles registration, login, and rating persistence</td>
          <td>Integration testing with SQLite and edge-case testing for duplicate users and invalid login attempts</td>
        </tr>
        <tr>
          <td>Product</td>
          <td>Represents a product record with price and seller information</td>
          <td>Unit testing of constructor behavior and data access</td>
        </tr>
        <tr>
          <td>Listing</td>
          <td>Represents an active marketplace listing, including bidding and sale state</td>
          <td>Unit testing of default state, setters, and status transitions</td>
        </tr>
        <tr>
          <td>Offer</td>
          <td>Represents an offer or bid placed on a listing</td>
          <td>Unit testing of object initialization, timestamps, and status values</td>
        </tr>
        <tr>
          <td>Issue</td>
          <td>Represents a user-submitted issue report</td>
          <td>Unit testing of default status, field storage, and update behavior</td>
        </tr>
        <tr>
          <td>IssueManager</td>
          <td>Stores and retrieves issue reports from the database</td>
          <td>Integration testing for insert, retrieval, generated IDs, and status mapping</td>
        </tr>
        <tr>
          <td>BiddingManager</td>
          <td>Creates listings, processes offers, and handles buy-now operations</td>
          <td>Integration testing with the database and boundary testing for inactive items, low bids, and invalid IDs</td>
        </tr>
        <tr>
          <td>ModifyItem</td>
          <td>Validates titles, descriptions, and prices before item changes are applied</td>
          <td>Unit testing and boundary value analysis</td>
        </tr>
        <tr>
          <td>ArrangeStorage / ArrangeStorageImpl</td>
          <td>Handles temporary storage requests, fee calculation, and cancellation status</td>
          <td>Unit testing and edge-case testing</td>
        </tr>
        <tr>
          <td>FeeCalculator / TrackOwnerAndCalculateFees</td>
          <td>Tracks original ownership and computes platform fee, storage fee, and seller payout</td>
          <td>Unit testing, equivalence class testing, and negative-value testing</td>
        </tr>
      </table>
    <div align="center">
      <p>Table 15</p>
    </div>
  </ul>
  <br>

















<h1 align="left" id="1-introduction">1 — Introduction</h1>   <br>
  <ul style="margin-left: 40px;">
    At the end of each academic term, students residing on the university's campus frequently leave behind personal items such as furniture, textbooks, kitchenware, and small appliances. These items are often still in good condition, usable and valuable to many; however, due to the lack of an easy-to-use and centralized system, many of these items are discarded or handled through informal channels. Not only does this void often result in unnecessary waste to students and the environment, but often a fiscal loss to the student leaving and the student in need. This issue will be alleviated by our software, <strong>URMarketplace</strong>.         <br>
    <br>
    Existing solutions, such as social media groups or by word of mouth are currently the trend in which these student adhere to; therefore, through such circumstances it isn't surprising that these are the results. Our design is oriented to lay the groundwork to help out these students at the University of Regina.       <br>
  </ul>







<br>
<br>
<h1>2 — Design Problem<a id="2-design-problem"></a></h1>      <br>
  <ul style="margin-left: 40px;">






<h1>2.1 — Problem Definition<a id="21-problem-definition"></a></h1>     <br>
  <span style="font-size: 1em;">&nbsp;</span>
  <ul style="margin-left: 40px;">
    Informal marketplaces do not support important features such as tracking the original owner of an item, arranging temporary storage, recording issue reports, or calculating seller earnings after fees. As a result, sellers may struggle to recover value from their items, while buyers may have less structure and transparency during transactions. URMarketplace is intended to address this gap by providing a dedicated software tool for University of Regina students living on campus.    <br>
      <br>
    Rather than relying only on social media posts or word of mouth, the platform provides a more organized environment for listing items, submitting bids, using buy-now purchasing when available, reporting problems, and tracking storage-related costs. The goal is to create a marketplace prototype that is easier to test and validate than informal alternatives, while still being realistic for student use during busy end-of-term periods. A few key characteristics of the user-end of the application would be, but not limited to:    <br>
      <br>
    <ul style="margin-left: 40px;">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; • Posting items to sell                                                                                            <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; • Ability to submit offers or bids                                                                                 <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; • An option for someone to store item(s) temporarily until they sell; for a fee                                   <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; • Ability to submit issue reports                                                                                  <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; • Tracking original ownership and seller earnings after fees                                                       <br>
      <br>
    </ul>
      Functions such as these will lay the groundwork for a software solution that can be systematically tested and validated using established software testing techniques.      <br>
  </ul>
  <br>
  
  
  
  
  
  
  
  
  
  <h1>2.2	— Design Requirements<a id="22-problem-requirements"></a></h1> 
  <span style="font-size: 1em;">&nbsp;</span>
  
  <ul style="margin-left: 40px;">


  
  <h2><strong>2.2.1 — Functions<a id="221-functions"></a></strong></h2> 
  <ul style="margin-left: 40px;">
          • Register users and support login authentication.<br>
          • Post items for sale with descriptions and prices.<br>
          • Submit counteroffers or bids on listed items.<br>
          • Purchase items using a buy-now option when available.<br>
          • Arrange temporary storage services for items with associated fees.<br>
          • Submit issue reports related to marketplace activity.<br>
          • Track original owners and calculate net seller earnings after fees.<br>
    </ul>
              <span style="font-size: 1em;">&nbsp;</span>



  <h2><strong>2.2.2 — Objectives<a id="222-objectives"></a></strong></h2> 
     <ul style="margin-left: 40px;">
          •	User-friendly interface if we reach that far in testing for quick posting and browsing.<br>
          •	Transparent transaction history that will build trust.<br>
          •	Preventative processing for secure payments with fee deductions.<br>
          •	Efficient administrative controls for compliance.<br>
          •	Scalable to handle peak end-of-term traffic.<br>
          •	Reliable for accurate ratings.<br>
     </ul>
              <span style="font-size: 1em;">&nbsp;</span>


  
  <h2><strong>2.2.3 — Constraints<a id="223-constraints"></a></strong></h2>  
     <ul style="margin-left: 40px;">
          • Accessible only to verified University of Regina campus residents.<br>
          • Compliant with Canadian & University of Regina privacy laws (PIPEDA).<br>
          • Handles up to 1,000 concurrent users.<br>
          • Integrates no external payment gateways initially.<br>
          • Operational within university network policies<br>
     </ul>
              <span style="font-size: 1em;">&nbsp;</span>
  </ul>
  </ul>









<br>
<br>
<h1><strong>3 — Solutions<a id="3-solutions"></a></strong></h1>                      <br>
<br>
The proposed back-end solutions are done through the implementation of Java classes and interfaces to facilitate our systems architecture.      <br>

A Rating class will be developed to handle the evaluation logic for both sellers and purchasers. This class will include methods that allow users to assign a numerical rating between 1 and 5 using a switch statement. Additionally, a text-based comment feature will enable users to provide qualitative feedback alongside their numerical rating. These ratings and comments will be stored and referenced by other components of the system, ensuring consistent data exchange between related modules.      <br>


<ul style="margin-left: 40px;">
<b>
<p></p>










  
<h1> 3.1	<strong> — Solution Set 1<a id="31-solution-set"></a></strong></h1>
<br>
   <ul style="margin-left: 40px;"> 


   
  <h2>UserDatabase Class / Interface:</h2>
    <ul style="margin-left: 40px;"> 
      This component will maintain user profile information and rating data.                                       <br>
      <br>
      <ul style="margin-left: 40px;">
        The primary fields include:                                                                                <br>
        <br>
         <ul style="margin-left: 40px;">
              • firstName                                                                                          <br>
              • lastName                                                                                           <br>
              • phoneNumber                                                                                        <br>
              • email                                                                                              <br>
              • currentRating —> An aggregate or referenced value obtained from the Rating class/interface         <br>
              • ratingComments —> textual feedback from other users (Maximum length: 250 characters                <br>
         </ul>
      </ul>
      <br>
      The design will ensure the storage of multiple user entries, supporting efficient retrieval and update operations. Looking into extending this or to interface with a storage layer, such as an SQL or NoSQL database system   <br>
      <br>
    </ul>


  
  <h2>ProductDatabase Class / Interface:</h2>
    <ul style="margin-left: 40px;"> 
      This component will manage product-related information for user-listed items.                                 <br>
      <br>
      <ul style="margin-left: 40px;">
        The primary fields include:      <br>
        <br>
         <ul style="margin-left: 40px;">
              • title                                                                                                <br>
              • description (maximum length: 500 characters)                                                         <br>
              • price                                                                                                <br>
              • biddingPrice                                                                                         <br>
              • currentRating —> An aggregate or referenced value obtained from the Rating class/interface           <br>
              • ratingComments —> textual feedback from other users (Maximum length: 250 characters                  <br>
         </ul>
      </ul>
      <br>
      This structure will enable users to post, modify, and query product listings, providing support for both fixed-price and bidding-based sales models.      <br>
      <br>
    </ul>



  
  <h2>Rating Class </h2>
    <ul style="margin-left: 40px;"> 
      This class will handle will handle the evaluation logic for both sellers and purchasers.                                                                        <br>
      <br>
      <ul style="margin-left: 40px;">
        This class will include methods that allow users to:                                                                                                            <br>
        <br>
        <ul style="margin-left: 40px;">
                • Assign a numerical rating between 1 and 5 using a switch statement                                                                                    <br>
                • Text-based comment feature will enable users to provide qualitative feedback alongside their numerical rating (Maximum length: 250 characters)        <br>
        </ul>
      </ul>
      <br>
      These ratings and comments will be stored and referenced by other components of the system, ensuring consistent data exchange between related modules.          <br>
    <br>
    </ul>
    

  
  <h2 align="left" id="evaluation-table-2">Alternative Architecture — Evaluation — Summary Table</h2>
    <ul style="margin-left: 40px;"> 
      <h3>  This table below involves the following:</h3>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ModifyItem.java (concrete class)                   <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (interface)                    <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (implementation)               <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• FeeCalculator.java (interface)                     <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• TrackOwnerAndCalculateFees.java (implementation)   <br>
     <br>
     <ul style="margin-left: 40px;"> 
      <table align="center">
        <tr>
          <th>Evaluation Criterion</th>
          <th>Assessment</th>
          <th>Analysis</th>
        </tr>
        <tr>
          <td>Clarity of Responsibility Separation</td>
          <td align="center">Moderate</td>
          <td>Functional areas are grouped logically; however, validation, processing, and persistence logic are partially combined. The Single Responsibility Principle is not consistently applied.</td>
        </tr>
        <tr>
          <td>Fault Isolation & System Reliability</td>
          <td align="center">Moderate to Low</td>
          <td>Because validation and operational logic are intertwined, an error in one component may propagate to others, increasing the risk of cascading failures.</td>
        </tr>
        <tr>
          <td>Enforcement of Boundary & Validation Constraints</td>
          <td align="center">Moderate</td>
          <td>Validation rules exist but are embedded in multiple areas of the system. This may lead to inconsistent enforcement of rating limits, offer constraints, or lifecycle rules.</td>
        </tr>
        <tr>
          <td>Protection Against Invalid Input & Misuse</td>
          <td align="center">Moderate</td>
          <td>Input checks and authorization controls are present but not centralized. This increases the possibility of uneven rule enforcement across different execution paths.</td>
        </tr>
        <tr>
          <td>Long-Term Maintainability & Scalability</td>
          <td align="center">Moderate to Low</td>
          <td>Tightly coupled logic makes expansion and modification riskier. Introducing new features may require modifying multiple modules, increasing complexity.</td>
        </tr>
      </table>
     </ul>
    <p align="center">Evaluation Table — Table 7</p>
    <br>
    <br>
    Although operationally correct, Solution 1 lacks strict separation of concerns and strong structural safeguards. As the system grows, these weaknesses could negatively impact maintainability and reliability. Therefore, refinement was pursued.        <br>
    </ul>
    <br>
    <br>
    <p></p>
    </ul>





  <ul style="margin-left: 40px;">
  <br>
  <h1><strong>3.2	— Solution Set 2<a id="32-solution-set"></a></strong></h1>
  <p></p>
  <ul style="margin-left: 40px;">
  <br>
  <h2>User — Entity Class</h2> 
  <p></p>
  <ul style="margin-left: 40px;"> 
  Represents a system participant with profile information and aggregated rating data. Stores core identity fields (firstName, lastName, email, phoneNumber) alongside a computed currentRating (double average) and a collection of received UserComment objects. Serves as the primary entity linking ratings to individuals.
    <br>
    <br>
     <ul style="margin-left: 40px;">
          • id<br>
          • firstName<br>
          • lastName<br>
          • phoneNumber (1-5)<br>
          • email (250 char max)<br>
          • currentRating<br>  
          • List<UserComment>       
     </ul>
  <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
   <a href="#1-table">User — Entity Class — Testing Table 1</a>  </div>  <br>
  <br>
   </ul>


  <h2>Product — Entity Class</h2> 
  <p></p>
   <ul style="margin-left: 40px;"> 
  Models a marketplace listing created by a seller. 
  Contains essential sales data: title for identification, description for details (500 char limit), price for fixed sales, biddingPrice for auctions, and sellerId foreign key. Enables product lifecycle management from posting to purchase.
     <br>
     <br>
     <ul style="margin-left: 40px;">
          • id<br>
          • title<br>
          • description (500 char max)<br>
          • price (1-5)<br>
          • comment (250 char max)<br>
          • biddingPrice<br>
          • sellerId
     </ul>
  <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
 <a href="#2-table">Product Testing Rules — Testing Table 2</a>  </div>  <br>
  <br>
   </ul>



  <h2>UserComment — Entity Classes</h2> 
  <p></p>
   <ul style="margin-left: 40px;"> 
  Captures individual rating events between users. Records raterId, rateeId for relationship tracking, numeric rating (1-5 integer), textual comment (250 char limit), and timestamp for audit trail. Foundation for average rating calculations and comment history display.
     <br>
     <br>
     <ul style="margin-left: 40px;">
          • id<br>
          • raterId<br>
          • rateeId<br>
          • rating (1-5)<br>
          • comment (250 char max)<br>
          • timestamp<br>     
     </ul>
  <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
   <a href="#3-table">UserComment Testing Rules — Table 3</a>  </div>  <br>
  <br>
   </ul>
  

  <h2>RatingService — Interface</h2> 
    <p></p>
     <ul style="margin-left: 40px;"> 
    Defines business logic for rating operations. <br>
    Core methods include are for submitting/validating ratings and getting the average rating. Encapsulates switch statements as validation ( Range: 1-5 ). As well as comment persistence (Data surviving after program ends), which will decouple UI from rating rules.
       <br>
       <br>
       <ul style="margin-left: 40px;">
            • rateUser()<br>
            • raterId<br>
            • rateeId<br>
            • rating (1-5)<br>
            • comment (250 char max)<br>
            • timestamp<br>     
       </ul>
    <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
  <a href="#4-table">RatingService Testing Rules — Table 4</a>  </div>  <br>
  <br>
     </ul>



  <h2>UserRepository — Interface</h2> 
  <p></p>
   <ul style="margin-left: 40px;"> 
  Standardizing the data access contract for user persistence (Data surviving after program ends). 
  Provides CRUD operations (saveUser(), findById(), findByEmail()) plus rating updates (updateRating()). Abstracts storage implementation, supporting in-memory, JDBC, JPA, or NoSQL backends through polymorphism.<br>
     <br>
     <ul style="margin-left: 40px;">
          • id<br>
          • raterId<br>
          • rateeId<br>
          • rating (1-5)<br>
          • comment (250 char max)<br>
          • timestamp<br>     
     </ul>
  <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
   <a href="#5-table">UserRepository Testing Rules — Table 5</a>  </div>  <br>
  <br>
   </ul>



  <h2> ProductRepository — Interface </h2>
  <p></p>
   <ul style="margin-left: 40px;"> 
  Data access layer for product listings. Exposes save(), findBySellerId(), and findById() methods. Ensures consistent product CRUD operations while hiding persistence details, allowing seamless database technology swaps without application code changes.<br>
     <br>
     <ul style="margin-left: 40px;">
          • id<br>
          • raterId<br>
          • rateeId<br>
          • rating (1-5)<br>
          • comment (250 char max)<br>
          • timestamp<br>     
     </ul>
  <div align="right">Testing Table Here! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
   <a href="#6-table">ProductRepository Testing Rules — Table 6</a>  </div>  <br>
  <br>
   </ul>



  <h2 align="left" id="evaluation-table">Architecture Evaluation Table</h2>
     <ul style="margin-left: 40px;">
       <h3>This table constitutes of the following files: </h3>
       <br>
       <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ModifyItem.java (concrete class)                          >br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (interface)                           <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (implementation)                      <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• FeeCalculator.java (interface);                           <br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• TrackOwnerAndCalculateFees.java (implementation)          <br>
     </ul>
  <br>
  <h2 align="left" id="evaluation-table">Architecture — Evaluation — Summary Table</h2>
    <table align="center">
      <tr>
        <th>Evaluation Criterion</th>
        <th>Assessment</th>
        <th>Analysis</th>
      </tr>
      <tr>
        <td>Clarity of Responsibility Separation</td>
        <td align="center">High</td>
        <td>Validation, business logic, persistence, and administrative functions are structurally isolated. Each service adheres closely to a single responsibility.</td>
      </tr>
      <tr>
        <td>Fault Isolation & System Reliability</td>
        <td align="center">High</td>
        <td>Errors are confined to individual components. Validation failures do not affect persistence, and administrative operations do not interfere with marketplace logic.</td>
      </tr>
      <tr>
        <td>Enforcement of Boundary & Validation Constraints</td>
        <td align="center">High</td>
        <td>Validation logic is centralized, ensuring consistent enforcement of offer limits, rating boundaries, and lifecycle rules across all system interactions.</td>
      </tr>
      <tr>
        <td>Protection Against Invalid Input & Misuse</td>
        <td align="center">High</td>
        <td>Authentication and authorization layers prevent unauthorized actions. Centralized validation ensures invalid inputs are rejected before reaching operational logic.</td>
      </tr>
      <tr>
        <td>Long-Term Maintainability & Scalability</td>
        <td align="center">High</td>
        <td>Low coupling and high cohesion allow new features to be added with minimal modification to existing components. This structure supports safe expansion and easier testing.</td>
      </tr>
    </table>
    <p align="center">Evaluation Table</p>
    <br>
    <br>




  <h1>Solution 1 & Solution 2 Comparison — Conclussion</h1>  
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <strong>"Solution 2: Refined Modular Architecture"</strong>, as it provides:
    <br>
    <br>
      <ul style="margin-left: 40px;">
            &nbsp;&nbsp;&nbsp;&nbsp;• Stronger separation of concerns    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Improved reliability    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Strict layering principles<br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Core domain entities (User, Product, UserComment) separated from business logic & handled through dedicated interfaces    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Data persistence, managed by repository abstractions    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Consistent validation enforcement    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Validation rules are centralized and consistently enforced    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Isolating responsibilities and minimizing coupling between components    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;• Greater long-term scalability    <br>
      </ul>
      <br>
    Therefore, "Solution 2: Refined Modular Architecture" was selected as the architecture for URMarketplace.
  </ul>
  <br>
  <br>



<h2>UserManager —  Service Class</h2> 
<br>
  <br>
  Manages user authentication and registration within the system. Maintains a collection of registered users, and controls session states. It also handles user validation, including unique username enforcement and credential verification during login attempts. This provides the foundation for the user identity management across the marketplace, using:    <br>
  <br>
   <ul style="margin-left: 40px;"> 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• users — List of registered User objects    <br> 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• nextId — Auto-incremented ID counter for new users 
   </ul> 
   <br>
  Here are the UserManager Testing Rules (Register method):    <br>
  <br>
  <table align="center">
    <tr>
      <th>Condition</th>
      <th>Rule 1</th>
      <th>Rule 2</th>
      <th>Rule 3</th>
      <th>Rule 4</th>
    </tr>
    <tr>
      <th>Username unique?</th>
      <th>T</th>
      <th>F</th>
      <th>T</th>
      <th>F</th>
    </tr>
    <tr>
      <th>Valid email format?</th>
      <th>T</th>
      <th>T</th>
      <th>F</th>
      <th>F</th>
    </tr>
    <tr>
      <th>Action Stubs</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tr>
      <th>Register User (return true)</th>
      <th>X</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tr>
      <th>Reject Registration (return false)</th>
      <th></th>
      <th>X</th>
      <th>X</th>
      <th>X</th>
    </tr>
  </table>
  <br>
  Here are the UserManager Testing Rules (login method):
  <br>
  <br>
  <table align="center">
    <tr>
      <th>Condition</th>
      <th>Rule 1</th>
      <th>Rule 2</th>
      <th>Rule 3</th>
      <th>Rule 4</th>
    </tr>
    <tr>
      <th>Username exists?</th>
      <th>T</th>
      <th>F</th>
      <th>T</th>
      <th>F</th>
    </tr>
    <tr>
      <th>Password matches?</th>
      <th>T</th>
      <th>-</th>
      <th>F</th>
      <th>-</th>
    </tr>
    <tr>
      <th>Action Stubs</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tr>
      <th>Login Success (return User)</th>
      <th>X</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tr>
      <th>Login Failed (return null)</th>
      <th></th>
      <th>X</th>
      <th>X</th>
      <th>X</th>
    </tr>
  </table>
  <br>
<br>



<h2>IssueManager — Service Class</h2>     
  <br>
  <br>
  <ul style="margin-left: 40px;">
    Handles the reporting and tracking of user-reported issues within the platform; managing the lifecycle of support tickets from creation to resolution. Each issue maintains relevant metadata including category classification, current status, and reporter information. This provides a structured problem reporting system for marketplace moderation and support through the key implementations of:    <br>
    <br>
     <ul style="margin-left: 40px;"> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• issues — List of reported Issue objects<br> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• nextId — Auto-incremented ID counter for new issues <br>
       </ul> 
    <br>
    <table align="center">
      <tr>
        <th>Condition</th>
        <th>Rule 1</th>
        <th>Rule 2</th>
        <th>Rule 3</th>
        <th>Rule 4</th>
        <th>Rule 5</th>
        <th>Rule 6</th>
        <th>Rule 7</th>
        <th>Rule 8</th>
      </tr>
      <tr>
        <th>Title present?</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Description present?</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>F</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Category valid?</th>
        <th>T</th>
        <th>T</th>
        <th>T</th>
        <th>T</th>
        <th>F</th>
        <th>F</th>
        <th>F</th>
        <th>F</th>
      </tr>
      <tr>
        <th>Action Stubs</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Create Issue (return ID)</th>
        <th>X</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      <tr>
        <th>Reject Issue (return -1)</th>
        <th></th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
        <th>X</th>
      </tr>
    </table>
  </ul>
  <br>
  <br>

<h2> BiddingManager —  Service Class </h2>     <br>
  <br>
  <ul style="margin-left: 40px;">
    Manages the bidding and auction lifecycle within the marketplace program. Key aspects such as managing listing creation, offering submission, bid validation, and automatic auction expiration. By taking this route, this program maintains separate collections for active listings and submitted offers, along with state tracking for both entities/users. Of course implementing key core marketplace logic, such as the buy-now functionality and outbid notifications.     <br>
    <br>
      <ul style="margin-left: 40px;"> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• listings — List of Listing objects (items for sale/auction)<br> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• offers — List of Offer objects (bids submitted)<br> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• listingStates — Map of listing IDs to current status (ACTIVE, SOLD, EXPIRED)<br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• offerStates — Map of offer IDs to current status (PENDING, ACCEPTED, REJECTED, OUTBID)<br> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• nextListingId — Auto-incremented ID counter for new listings<br> 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• nextOfferId — Auto-incremented ID counter for new offers <br> 
      </ul> 
    <br>
    BiddingManager Testing Rules (makeOffer method):    <br>
    <br>
    <ul style="margin-left: 40px;">
      <table align="center"> 
        <tr> 
          <th>Condition</th> 
          <th>Rule 1</th> 
          <th>Rule 2</th> 
          <th>Rule 3</th> 
          <th>Rule 4</th> 
          <th>Rule 5</th> 
          <th>Rule 6</th> 
          <th>Rule 7</th> 
          <th>Rule 8</th> 
        </tr> 
        <tr> 
          <th>Listing exists?</th> 
          <th>T</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>F</th> 
          <th>F</th> 
        </tr> <tr> 
          <th>Listing ACTIVE?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> <tr> 
          <th>Amount > currentBid?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> 
        <tr> 
          <th>Bidder != seller?</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
          <th>-</th> 
          <th>F</th> 
          <th>T</th> 
          <th>-</th> 
          <th>-</th> 
        </tr> <tr> 
          <th>Action Stubs</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return offerId (>0)</th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> <th>Return -1 (listing not found)</th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th>X</th> 
        </tr> 
        <tr> 
          <th>Return -2 (listing inactive)</th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return -3 (bid too low)</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
        <tr> 
          <th>Return -4 (cannot bid on own item)</th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th></th> 
          <th>X</th> 
          <th></th> 
          <th></th> 
          <th></th> 
        </tr> 
      </table> 
      <p></p>
      <p></p>
      <br>
      BiddingManager Testing Rules (buyNow method):    <br>
      <br>
      <table align="center">
        <tr>
          <th>Condition</th>
          <th>Rule 1</th>
          <th>Rule 2</th>
          <th>Rule 3</th>
          <th>Rule 4</th>
          <th>Rule 5</th>
          <th>Rule 6</th>
          <th>Rule 7</th>
          <th>Rule 8</th>
        </tr>
        <tr>
          <th>Listing exists?</th>
          <th>T</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>F</th>
          <th>F</th>
        </tr>
        <tr>
          <th>Listing ACTIVE?</th>
          <th>T</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>BuyNowPrice &gt; 0?</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>Buyer != seller?</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
          <th>-</th>
          <th>F</th>
          <th>T</th>
          <th>-</th>
          <th>-</th>
        </tr>
        <tr>
          <th>Action Stubs</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>BuyNow Success (return true)</th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (listing not found)</th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th>X</th>
        </tr>
        <tr>
          <th>Return false (listing inactive)</th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (no buy now price)</th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <th>Return false (buying own item)</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th>X</th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
      </table>
    </ul>
    <br>
    <br>
    Based on the results, "Solution 2: Refined Modular Architecture" provides:
    <br>
    <br>
     <ul style="margin-left: 40px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Stronger separation of concerns    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Improved reliability    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Strict layering principles    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Core domain entities separated from business logic & handled through dedicated interfaces <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(User, Product, UserComment)    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Data persistence, managed by repository abstractions    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Consistent validation enforcement    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Validation rules are centralized and consistently enforced    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Isolating responsibilities and minimizing coupling between components    <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• Greater long-term scalability    <br>
     </ul>
     <br>
    Therefore, "Solution 2: Refined Modular Architecture" was selected as the architecture for URMarketplace.    <br>
    <br>
  </ul>








<h1 align="left" id="33-final-solution">3.3 — Final Solution</h1> 
  <br>
  <br>
  <ul style="margin-left: 40px;">
    <ul style="margin-left: 40px;">
      The final solution selected for URMarketplace is a modular Java back-end supported by an SQLite database and verified through JUnit-based testing. This solution was selected over the earlier alternatives because it provides clearer separation between data representation, business logic, persistence, and validation. From a testing perspective, this structure is significantly better than a more tightly coupled design because each major responsibility can be tested in isolation and then re-tested together through integration scenarios.    <br>
      <br>
      In the final design, classes such as User, Product, Listing, Offer, and Issue represent the system state, while service-oriented classes such as UserManager, BiddingManager, IssueManager, ModifyItem, ArrangeStorageImpl, and TrackOwnerAndCalculateFees handle business rules and workflow execution. DatabaseHelper centralizes database connectivity and setup, which makes test initialization and controlled database reset easier. This separation improves testability because each class exposes a narrower and more predictable behavior surface. As a result, unit tests can target validation rules and state transitions, while integration tests can confirm that database-backed operations behave correctly under realistic usage.<br>
      <br>
      A major reason for selecting this solution is that it supports both positive testing and edge-case testing more effectively than the previous design concepts. Instead of testing one large, mixed component, the final architecture allows direct verification of item posting, bidding, issue reporting, storage booking, fee calculation, login behavior, and object state updates. This makes fault localization easier: if a test fails, it is much easier to determine whether the defect is in validation, database mapping, persistence, or business logic. In software testing and validation, this is a strong advantage because it reduces debugging time and improves confidence in the correctness of the final system.  <br>
      <br>
    The comparison in Table  summarizes why this final solution was selected.    <br>
    <br>
    </ul>

  <h2 align="left" id="comparison-table">Testing & Reliability — Comparison Table</h2>
    <br>
    <ul style="margin-left: 40px;">
      <table align="center">
        <tr>
          <th>Criterion</th>
          <th>Earlier / More Coupled Solutions</th>
          <th>Final Modular Solution</th>
        </tr>
        <tr>
          <td>Testability</td>
          <td>Lower, because logic and persistence are mixed together</td>
          <td>Higher, because entities, managers, and utilities can be tested separately</td>
        </tr>
        <tr>
          <td>Fault Isolation</td>
          <td>Weak, failures can affect several responsibilities at once</td>
          <td>Stronger, because failures are easier to trace to one component</td>
        </tr>
        <tr>
          <td>Regression Testing</td>
          <td>More difficult after changes</td>
          <td>Easier, because each class can be re-tested independently</td>
        </tr>
        <tr>
          <td>Edge-Case Coverage</td>
          <td>Harder to organize systematically</td>
          <td>Easier to organize around each component and rule</td>
        </tr>
        <tr>
          <td>Maintainability</td>
          <td>Lower as new features are added</td>
          <td>Higher due to clearer responsibilities</td>
        </tr>
        <tr>
          <td>Reliability</td>
          <td>More dependent on manual checking</td>
          <td>More reliable through repeatable automated tests</td>
        </tr>
      </table>
    </ul>
    <p align="center">Comparison Table</p>
    <br>
    <br>
    Based on this comparison, the final modular solution was selected because it supports a more structured and repeatable verification process, which is especially important in a software testing and validation course.    <br>
    <br>
    <br>









<h2 align="left" id="331-components">3.3.1 — Components</h2> 
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
  The final solution is composed of several cooperating components, each with a specific responsibility in the system. The main components and their testing methods are shown in Table .
  </ul>
  <br>
  <h2 align="left" id="component-testing-table">System Components — Testing Methods — Summary Table</h2>
  <br>
  <ul style="margin-left: 40px;">
    <table align="center">
      <tr>
        <th>Component</th>
        <th>Main Purpose</th>
        <th>Testing Method Used</th>
      </tr>
      <tr>
        <td>URMarketplaceConsole</td>
        <td>Provides the command-line interface and connects user actions to system operations</td>
        <td>Manual functional testing and scenario-based testing</td>
      </tr>
      <tr>
        <td>DatabaseHelper</td>
        <td>Creates the SQLite connection and initializes the required tables</td>
        <td>Integration testing, schema verification, and database initialization tests</td>
      </tr>
      <tr>
        <td>User</td>
        <td>Stores user account data and tracks rating averages</td>
        <td>Unit testing of getters, setters, login state, and rating calculations</td>
      </tr>
      <tr>
        <td>UserManager</td>
        <td>Handles registration, login, and rating persistence</td>
        <td>Integration testing with SQLite and edge-case testing for duplicate users and invalid login attempts</td>
      </tr>
      <tr>
        <td>Product</td>
        <td>Represents a product record with price and seller information</td>
        <td>Unit testing of constructor behavior and data access</td>
      </tr>
      <tr>
        <td>Listing</td>
        <td>Represents an active marketplace listing, including bidding and sale state</td>
        <td>Unit testing of default state, setters, and status transitions</td>
      </tr>
      <tr>
        <td>Offer</td>
        <td>Represents an offer or bid placed on a listing</td>
        <td>Unit testing of object initialization, timestamps, and status values</td>
      </tr>
      <tr>
        <td>Issue</td>
        <td>Represents a user-submitted issue report</td>
        <td>Unit testing of default status, field storage, and update behavior</td>
      </tr>
      <tr>
        <td>IssueManager</td>
        <td>Stores and retrieves issue reports from the database</td>
        <td>Integration testing for insert, retrieval, generated IDs, and status mapping</td>
      </tr>
      <tr>
        <td>BiddingManager</td>
        <td>Creates listings, processes offers, and handles buy-now operations</td>
        <td>Integration testing with the database and boundary testing for inactive items, low bids, and invalid IDs</td>
      </tr>
      <tr>
        <td>ModifyItem</td>
        <td>Validates titles, descriptions, and prices before item changes are applied</td>
        <td>Unit testing and boundary value analysis</td>
      </tr>
      <tr>
        <td>ArrangeStorage / ArrangeStorageImpl</td>
        <td>Handles temporary storage requests, fee calculation, and cancellation status</td>
        <td>Unit testing and edge-case testing</td>
      </tr>
      <tr>
        <td>FeeCalculator / TrackOwnerAndCalculateFees</td>
        <td>Tracks original ownership and computes platform fee, storage fee, and seller payout</td>
        <td>Unit testing, equivalence class testing, and negative-value testing</td>
      </tr>
    </table>
  </ul>
  <p align="center">Component Testing Table</p>
  <br>
  <div align="center">
<img width="680" height="740" alt="image" src="https://github.com/user-attachments/assets/50f641dd-e546-4a1f-9c2d-8a0363cdb6b4" />
  <p> Architecture Figure <br> Figure 3</p>
  </div>
  <br>
  <br>
  <br>







<h2 align="left" id="332-environmental,-societal,safety,-&-economic-considerations">3.3.2  — Environmental, Societal, Safety, and Economic Considerations</h2> 
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
    The design of URMarketplace was developed with environmental, societal, safety, and economic constraints in mind. Environmentally, the software contributes positively by encouraging item reuse rather than disposal. Students often discard usable furniture, books, appliances, and supplies when moving out of residence at the end of a term. By offering a structured local marketplace, the design helps reduce unnecessary waste and extends the useful life of these items. In this way, the solution supports more sustainable consumption behavior on campus.      
    <br>
    <br>
    From a societal perspective, the platform improves access and fairness within the student community. Instead of relying on informal social media posts or word-of-mouth transactions, URMarketplace provides a centralized and more transparent method for buying and selling used items. This helps students who may be under time pressure, may not have strong social connections, or may need lower-cost alternatives for household and academic goods. In addition, the issue-reporting mechanism gives users a formal way to report problems, which supports accountability and helps build trust in the platform.    
    <br>
    <br>
    Economic considerations were also important in the design. The system includes fee calculation and storage tracking features so that the financial outcome of a transaction is more transparent. The seller can better understand the effect of platform and storage fees, while the platform design remains lightweight by using Java and SQLite rather than more expensive infrastructure. This choice reduces development complexity and deployment cost, which is appropriate for an academic prototype. The decision to begin without external payment gateway integration also reduces cost and keeps the project within a manageable scope.    
    <br>
    <br>
    Safety and reliability were addressed primarily through validation and testing. Input validation is used to reject invalid prices, blank identifiers, and oversized text fields before data is accepted into the system. State-based rules are also enforced, such as preventing bids on inactive listings and preserving item status through the listing lifecycle. From a software safety standpoint, reliability was strengthened by writing repeatable automated tests for critical workflows and boundary cases. This reduces the likelihood that invalid input or inconsistent system state will silently produce incorrect outputs. Together, these choices make the design safer and more dependable for users while remaining realistic for a student engineering project.
    <br>
    <br>
  </ul>











<h2 align="left" id="333-test-cases-&-results">3.3.3 — Test Cases & Results</h2> 
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
    The test cases were developed using the JUnit 5 framework, encompassing unit, integration, and business logic tests. These tests rely on standard JUnit assertions to check for expected results across different events, functions, and scenarios.
    <br>
    <br>
    The results demonstrate that the software's functions like user registration, bidding logic, and storage management behave properly and respect their intended limits. The tests successfully fail when given unsupported or invalid data, and pass when the data is acceptable for the scenario. Furthermore, they show a reliable connection with the SQLite database, correctly modifying table values and verifying those changes. The test suites also ensure consistency by running on a completely clean database slate, which guarantees predictable and expected results by using test isolation.
    <br>
    <br>
    The testing process specifically addresses the "No-Error Fallacy" by not only verifying successful paths but also actively seeking failure states. Using the Fail-Fast principle, the suite employs assertThrows to ensure the system immediately rejects invalid data such as negative price values, non-finite numbers, or unauthorized credentials before they can propagate to the database.
    <br>
    <br>
    The tests guarantee that the persistence layer is correctly structured through validation that spans multiple layers, from individual logic functions to database schema integrity and structure. This multi-layered approach checks that the application respects its operational limits and works as intended even when given incorrect user input or finds unexpected error states
    <br>
    <br>
  </ul>



  
  
<h2 align="left" id="334-limitations">3.3.4 — Limitations</h2>    
  <br>
  <br>
  <ul style="margin-left: 40px;"> 
    Since URMarketplace is designed for students and faculty to organize and track sales and inventory, certain operational boundaries exist. These stem from both explicit and inherent limitations within the software's various functional and non-functional aspects.
    <br>
    <br>
    A primary external constraint is the physical storage capacity allocated by the campus for items sold via the platform. Since the system must account for goods stored by students departing the institution, the available physical space imposes direct limitations on the volume, size, and nature of the inventory that can be managed within the software
    <br>
    <br>
    Access to the platform is strictly limited to authorized university members. People who have yet to be granted or do not have a university provided outlook/email account can not use the platform until they do due to one of the authentication methods checking if the email account that is being used to login or sign in is an active university account
    <br>
    <br>
    The current scope of the platform does not include payment verification. As a result, URMarketplace cannot guarantee or validate transactions conducted through physical cash exchanges or third-party payment services. Users are responsible for confirming the completion of payments externally, as the system does not feature an integrated escrow or payment gateway.
  </ul>
  </ul>

<h1 align="left" id="4-team-work">4 — Team Work</h1>
  <br>
  <br>
<ul style="margin-left: 40px;">
  Since this was a group project, the team maintained a fair distribution of tasks through regular meetings to assign work, review progress, and prepare the final deliverables.
  Because of the team work focused nature of the project, we held a few meetings to distribute tasks, decision making and check ins amongst each other to properly and in unity tackle the project's big milestones and the course's delivery dates.
</ul>
</ul>

<h2 align="left" id="41-meeting-1">4.1 — Meeting 1</h2>
  <br>
  <br>

**Time:** January 14, 2026, 1:00 pm to 3:00 pm  
**Agenda:** Project Idea and defintion brainstorming

| Team Member | Previous Task | Completion State | Next Task |
|---|---|---|---|
| Tom Goncin | N/A | N/A | Proposing possible ideas for the project and reviewing team's other options |
| Esteban Mendoza | N/A | N/A | Proposing possible ideas for the project and reviewing team's other options |
| Amr Azouz | N/A | N/A | Proposing possible ideas for the project and reviewing team's other options|

During this meeting, the team got together to decide on possible ideas scopes, challenges and issues to solve with different aproaches and solutions, discus each others ideas and suggestions and decide on what to focus on going forward.

<h2 align="left" id="42-meeting-2">4.2 — Meeting 2</h2>
  <br>
  <br>

**Time:** February 3, 2026, 4:00 pm to 5:00 pm  
**Agenda:** Distribution of Project Tasks for the initial structure of the software

| Team Member | Previous Task | Completion State | Next Task |
|---|---|---|---|
| Tom Goncin | Proposing possible ideas for the project and reviewing team's other options  | 100% | Work on the GitHub repository, core implementation, and architecture refinement |
| Esteban Mendoza | Proposing possible ideas for the project and reviewing team's other options | 100% | Support planning, workflow discussion, and implementation tasks |
| Amr Azouz | Proposing possible ideas for the project and reviewing team's other options | 100% | Generate tests, organize testing documentation, and support report planning |

During this meeting, the team agreed on the project scope, discussed the marketplace problem, and distributed the first major responsibilities. Tom took the lead on the GitHub repository and much of the implementation work, while Amr focused mainly on generating tests and organizing the testing-related documentation. Esteban supported planning, implementation discussion, and overall project coordination.

<h2 align="left" id="43-meeting-3">4.3 — Meeting 3</h2>
  <br>
  <br>

**Time:** March 9, 2026, 5:00 pm to 6:00 pm  
**Agenda:** Review of Individual Progress

| Team Member | Previous Task | Completion State | Next Task |
|---|---|---|---|
| Tom Goncin | GitHub repository work, implementation, and architecture refinement | 100% | Finalize core GitHub codebase, expand features, and support integration work |
| Esteban Mendoza | Planning and implementation support  | 100% | Continue supporting implementation, review progress, and help prepare final deliverables|
| Amr Azouz | Test generation and testing documentation | 100% | Expand generated tests and improve Testing.md and report testing sections |

During this meeting, the team reviewed the transition from planning into implementation. Tom had completed most of the GitHub and implementation progress by this stage, while Amr had made solid progress on generating tests and documenting the testing work. The team identified remaining work in integration, testing expansion, and report development.

<h2 align="left" id="44-meeting-4">4.4 — Meeting 4</h2>
  <br>
  <br>

**Time:** March 28, 2026, 4:30 pm to 5:30 pm  
**Agenda:** Testing Expansion and Report Refinement
**Time:** March 26, 2026, 6:30 pm to 11:30 pm  
**Agenda:** Final design implementation and Report Refinement

| Team Member | Previous Task | Completion State | Next Task |
|---|---|---|---|
| Tom Goncin | Implementation support and project coordination | 90% | Help with final fixes, presentation preparation, and system review |
| Esteban Mendoza | GitHub implementation and feature completion | 95% | Complete final codebase fixes and support demo preparation |
| Amr Azouz | Test generation and testing documentation | 90% | Add more tests, refine testing evidence, and finalize report testing content |

At this stage, the team confirmed that the core implementation was mostly complete. Esteban had completed most of the codebase work on GitHub, while Amr focused mainly on expanding and refining the generated tests. The team used this meeting to align the technical work, testing evidence, and report expectations.

### 4.5 Meeting 5

**Time:** April 9, 2026, 6:00 pm to 7:00 pm  
**Agenda:** Final Fixes, Presentation Preparation, and Submission Check

| Team Member | Previous Task | Completion State | Next Task |
|---|---|---|---|
| Tom Goncin | Final support, review, and coordination | 100% | Rehearse the demo and verify final functionality |
| Esteban Mendoza | Final GitHub fixes and implementation completion | 100% | Finalize demo support and confirm the repository is submission-ready |
| Amr Azouz | Final test generation, testing evidence, and report updates | 100% | Finalize presentation polishing and submission review |

In the final meeting, the team verified that the codebase, generated tests, report, and presentation were aligned. Esteban finalized the GitHub implementation work, while Amr finalized most of the generated tests and testing evidence. The remaining effort focused on polishing and submission readiness.

<h1 align="left" id="5-project-management">5 — Project Management</h1>
  <br>
  <br>

<h2 align="left" id="51-gantt-chart">5.1 — Gantt Chart</h2>
  <br>
  <br>

The project progressed in stages, beginning with requirements and architecture planning, followed by core implementation, then testing expansion, and finally presentation and submission preparation.

| Task | Jan 10-31 | Feb 1-13 | Feb 13-23 | Feb 24-28 | Mar 1-9 | Mar 10-21 | Mar 22-28 | Mar 29-Apr 8 | Apr 9-11 |
|---|---|---|---|---|---|---|---|---|---|
| Requirements and problem definition | X |  |  |  |  |  |  |  |  |
| Architecture alternatives and report structure |  | X | X | X |  |  |  |  |  |
| Core GitHub implementation and repository development |  |  |  |  | X | X |  |  |  |
| SQLite integration and feature completion |  |  |  |  | X | X |  |  |  |
| Generated test development and testing expansion |  |  |  |  |  |  | X | X |  |
| Testing.md and report refinements |  |  |  |  |  |  | X | X |  |
| Final fixes, polish, and validation |  |  |  |  |  |  |  |  | X |
| Presentation, demo, and final submission checks |  |  |  |  |  |  |  |  | X |

<h2 align="left" id="52-task-list">5.2 — Task List, Predecessors, Slack Time, and Critical Path</h2>
  <br>
  <br>

| ID | Task | Predecessor(s) | Slack Time | Critical? |
|---|---|---|---|---|
| A | Requirements and problem definition | None | 0 days | Yes |
| B | Architecture alternatives and report structure | A | 0 days | Yes |
| C | Core GitHub implementation and repository development | B | 0 days | Yes |
| D | SQLite integration and feature completion | C | 0 days | Yes |
| E | Generated test development and testing expansion | D | 0 days | Yes |
| F | Testing.md and report refinements | E | 2 day | No |
| G | Final fixes, validation, and polish | E, F | 0 days | Yes |
| H | Presentation, demo, and final submission checks | G | 0 days | Yes |

**Critical Path:** A -> B -> C -> D -> E -> G -> H

The critical path passed through the most important technical and documentation milestones: defining requirements, refining the architecture, completing the main GitHub implementation, integrating SQLite, expanding the generated tests, applying final fixes, and preparing the presentation. These tasks had little or no slack because delays in them would have directly affected the final submission.

<h2 align="left" id="53-project-management-summary">5.3 — Project Management Summary</h2>
  <br>
  <br>
  
Project management was structured around progressive milestones. The first phase focused on understanding the design problem, organizing the report, and comparing architecture alternatives. The second phase focused on GitHub implementation and feature development, largely driven through Esteban's codebase work. The third phase emphasized generated test development, Testing.md refinement, and report updates, which were mainly handled by Amr. The final phase addressed validation, polishing, and presentation preparation. This staged approach helped ensure that implementation, testing, and reporting advanced together instead of being left until the end.

<h1 align="left" id="6-conclusion-and-future-work">6 — Conclusion and Future Work</h1>
  <br>
  <br>

<h2 align="left" id="61-conclusion">6.1 — Conclusion</h2>
  <br>
  <br>

URMarketplace successfully addressed a real end-of-term campus problem by replacing informal selling methods with a structured Java-based prototype. The final solution achieved the core design functions and objectives within the intended course scope. In particular, the system supported user registration and login, listing creation, bidding, buy-now purchasing, issue reporting, temporary storage booking, and seller payout calculation after platform and storage fees. The project also achieved an important architectural objective by separating validation, business logic, and persistence, making the software easier to test, debug, and explain.

From a software testing and validation perspective, the project satisfied its testing requirements through multiple complementary techniques. These included boundary value testing, equivalence class testing, decision table testing, state transition testing, use case testing, path testing, data flow testing, and SQLite-backed integration testing. A major part of this validation work came from generating and refining the automated tests used to verify the system behaviour. The results showed that valid workflows completed correctly, invalid inputs were rejected properly, and important state changes such as storage handling, bidding behaviour, and payout calculation behaved as expected. Overall, the project met its main goal of producing a small but realistic software system whose behaviour could be validated directly through code and repeatable automated tests.

<h2 align="left" id="62-future-work">6.2 — Future Work</h2>
  <br>
  <br>
Although the project achieved its intended academic scope, several improvements could strengthen the system in future iterations.

- Add a full GUI or web-based interface instead of relying only on a console-based interface.
- Store temporary storage bookings in SQLite so that storage data persists across runs.
- Improve item browsing with stronger search, filtering, and category-based navigation.
- Expand the rating and feedback system into a more complete feature with clearer transaction history.
- Add secure payment integration or transaction verification, since the current scope does not validate external payments.
- Strengthen the system further with richer lifecycle features such as item deletion, stronger moderation tools, and broader automated workflow testing.

These improvements would make URMarketplace more practical, more user-friendly, and closer to a production-ready system while preserving the modular structure and testing advantages achieved in the current design.
