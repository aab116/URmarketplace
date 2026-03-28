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
 





<div align="center>
<h2> List of Figures </h2>

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
figure 3
</div>








<h2 align="center"> List of Tables </h2>
*No tables are included in this section.*


<h2 align="left" id="1-introduction">1 — Introduction</h2>

<ul style="margin-left: 40px;">
  
At the end of each academic term, students residing on the university's campus frequently leave behind personal items such as furniture, textbooks, kitchenware, and small appliances. These items are often still in good condition, usable and valuable to many; however, due to the lack of an easy-to-use and centralized system, many of these items are discarded or handled through informal channels. Not only does this void often result in unnecessary waste to students and the environment, but often a fiscal loss to the student leaving and the student in need. This issue will be alleviated by our software, **URMarketplace**. 

Existing solutions, such as social media groups or by word of mouth are currently the trend in which these student adhere to; therefore, through such circumstances it isn't surprising that these are the results. Our design is oriented to lay the groundwork to help out these students at the University of Regina. 

</ul>




## 2 — Design Problem<a id="2-design-problem"></a>

### 2.1 — Problem Definition<a id="21-problem-definition"></a>
<span style="font-size: 1em;">&nbsp;</span>

<ul style="margin-left: 40px;">
  
Informal marketplaces do not support essential features such as tracking the original owner of an item, applying holding or storage fees, or calculating earnings returned to the seller after a purchase. Furthermore, these platforms lack administrative oversight to manage listings such as these for students. UR Marketplace will enforce marketplace rules, and control the lifecycle of items once they are listed. This creates challenges for sellers attempting to recover value from their items and for buyers seeking trustworthy and legitimate transactions.

<strong>URMarketplace</strong> is ideal for addressing this gap, a dedicated software tool for the University of Regina's students living on campus. It will provide the necessary structure tailored to students' needs. The system must support, and not be limited to these key attributes focused on structure, transparency, and easy-to-use software that holds the administrative position to carry the weight so that the students can keep focusing on their academic studies during final and busiest times of their academic career. Strategically, this platform would fill the voids that other marketplace applications lack because it would be designed for students, by students. A few key characteristics of the user-end of the application would be, but not limited to:

<ul style="margin-left: 40px;">
<li> Posting items to sell.</li>
<li> Ability to counter offer.</li>
<li> An option for someone to seek out another person to store their item(s) temperarily until it sells; for a fee.</li>
<li> Ability to rate users on both ends.</li>
<li> University administration oversight ability for regulation and blacklisting if need be.</li>
<li> Proper handling of item life-cycle</li>
  <br>
</ul>

Functions such as these will lay the groundwork for a software solution that can be systematically tested and validated using established software testing techniques.

</ul>
<br>




### 2.2	— Design Requirements<a id="22-problem-requirements"></a>
<span style="font-size: 1em;">&nbsp;</span>

<ul style="margin-left: 40px;">

### <strong>2.2.1 — Functions<a id="221-functions"></a></strong>
  <ul style="margin-left: 40px;">
        •	Post items for sale with descriptions, photos, videos and prices.<br>
        •	Submit counteroffers on listed items.<br>
        •	Arrange temporary storage services for items with associated fees.<br>
        •	Rate buyers and sellers after transactions.<br>
        •	Allow administrators to oversee listings, enforce rules, and blacklist users.<br>
        •	Manage item lifecycle from listing to sale or removal/republishing option to avoid orphan listings.<br>
        •	Track original owners and calculate net seller earnings after fees.<br>
  </ul>
            <span style="font-size: 1em;">&nbsp;</span>

### <strong>2.2.2 — Objectives<a id="222-objectives"></a></strong>
   <ul style="margin-left: 40px;">
        •	User-friendly interface if we reach that far in testing for quick posting and browsing.<br>
        •	Transparent transaction history that will build trust.<br>
        •	Preventative processing for secure payments with fee deductions.<br>
        •	Efficient administrative controls for compliance.<br>
        •	Scalable to handle peak end-of-term traffic.<br>
        •	Reliable for accurate ratings.<br>
   </ul>
            <span style="font-size: 1em;">&nbsp;</span>

###  <strong>2.2.3 — Constraints<a id="223-constraints"></a></strong>
   <ul style="margin-left: 40px;">
        • Accessible only to verified University of Regina campus residents.<br>
        • Compliant with Canadian & University of Regina privacy laws (PIPEDA).<br>
        • Handles up to 1,000 concurrent users.<br>
        • Integrates no external payment gateways initially.<br>
        • Operational within university network policies<br>
   </ul>
            <span style="font-size: 1em;">&nbsp;</span>

</ul>

##  <strong>3 — Solutions<a id="3-solutions"></a></strong>

The proposed back-end solutions are done through the implementation of Java classes and interfaces to facilitate our systems architecture.

A Rating class will be developed to handle the evaluation logic for both sellers and purchasers. This class will include methods that allow users to assign a numerical rating between 1 and 5 using a switch statement. Additionally, a text-based comment feature will enable users to provide qualitative feedback alongside their numerical rating. These ratings and comments will be stored and referenced by other components of the system, ensuring consistent data exchange between related modules.


<ul style="margin-left: 40px;">
<b>
<p></p>
  
### 3.1	<strong> — Solution Set 1<a id="31-solution-set"></a></strong>

<br>
<p></p>


### UserDatabase Class / Interface:
<p></p>
This component will maintain user profile information and rating data. The primary fields include:
   <ul style="margin-left: 40px;">
        • firstName<br>
        • lastName<br>
        • phoneNumber<br>
        • email<br>
        • currentRating —> An aggregate or referenced value obtained from the Rating class/interface<br>
        • ratingComments —> textual feedback from other users (Maximum length: 250 characters
   </ul>
The design will ensure the storage of multiple user entries, supporting efficient retrieval and update operations. Looking into extending this or to interface with a storage layer, such as an SQL or NoSQL database system
<br>
<br>




### ProductDatabase Class / Interface:
<p></p>
This component will manage product-related information for user-listed items. The primary fields include:
   <ul style="margin-left: 40px;">
        • title<br>
        • description (maximum length: 500 characters)<br>
        • price<br>
        • biddingPrice<br>
        • currentRating —> An aggregate or referenced value obtained from the Rating class/interface<br>
        • ratingComments —> textual feedback from other users (Maximum length: 250 characters
   </ul>
This structure will enable users to post, modify, and query product listings, providing support for both fixed-price and bidding-based sales models.
<br>
<br>



### Rating Class 
<p></p>
This class will handle will handle the evaluation logic for both sellers and purchasers. <br>
This class will include methods that allow users to:
These ratings and comments will be stored and referenced by other components of the system, ensuring consistent data exchange between related modules.

   <ul style="margin-left: 40px;">
        • Assign a numerical rating between 1 and 5 using a switch statement<br>
        • Text-based comment feature will enable users to provide qualitative feedback alongside their numerical rating (Maximum length: 250 characters)<br>
   </ul>
These ratings and comments will be stored and referenced by other components of the system, ensuring consistent data exchange between related modules.
<br>
<p></p>
<p></p>


###  This table below involves the following:
   <ul style="margin-left: 40px;">
        • ModifyItem.java (concrete class)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (interface)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (implementation)<br>
        • FeeCalculator.java (interface);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• TrackOwnerAndCalculateFees.java (implementation)<br>
   </ul>
   
<br>
<p></p>
<p></p>
<br>

| Evaluation Criterion | Assessment | Analysis |
|----------------------|------------|----------|
| Clarity of Responsibility Separation | Moderate | Functional areas are grouped logically; however, validation, processing, and persistence logic are partially combined. The Single Responsibility Principle is not consistently applied. |
| Fault Isolation & System Reliability | Moderate to Low | Because validation and operational logic are intertwined, an error in one component may propagate to others, increasing the risk of cascading failures. |
| Enforcement of Boundary & Validation Constraints | Moderate | Validation rules exist but are embedded in multiple areas of the system. This may lead to inconsistent enforcement of rating limits, offer constraints, or lifecycle rules. |
| Protection Against Invalid Input & Misuse | Moderate | Input checks and authorization controls are present but not centralized. This increases the possibility of uneven rule enforcement across different execution paths. |
| Long-Term Maintainability & Scalability | Moderate to Low | Tightly coupled logic makes expansion and modification riskier. Introducing new features may require modifying multiple modules, increasing complexity. |

<br>
<p></p>
Although operationally correct, Solution 1 lacks strict separation of concerns and strong structural safeguards. As the system grows, these weaknesses could negatively impact maintainability and reliability. Therefore, refinement was pursued.










<br>
<p></p>

###  <strong>3.2	— Solution Set 2<a id="32-solution-set"></a></strong>

<p></p>
<ul style="margin-left: 40px;">
<br>










### User — Entity Class
<p></p>
Represents a system participant with profile information and aggregated rating data. Stores core identity fields (firstName, lastName, email, phoneNumber) alongside a computed currentRating (double average) and a collection of received UserComment objects. Serves as the primary entity linking ratings to individuals.
   <ul style="margin-left: 40px;">
        • id<br>
        • firstName<br>
        • lastName<br>
        • phoneNumber (1-5)<br>
        • email (250 char max)<br>
        • currentRating<br>  
        • List<UserComment>       
   </ul>
<p></p>
User  Testing Rules:
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
    <th>Valid Email?</th>
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
    <th>firstName Present?</th>
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
    <th>Create/Update User</th>
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

<br>
<br>



### Product — Entity Class
<p></p>
Models a marketplace listing created by a seller. Contains essential sales data: title for identification, description for details (500 char limit), price for fixed sales, biddingPrice for auctions, and sellerId foreign key. Enables product lifecycle management from posting to purchase.
   <ul style="margin-left: 40px;">
        • id<br>
        • title<br>
        • description (500 char max)<br>
        • price (1-5)<br>
        • comment (250 char max)<br>
        • biddingPrice<br>
        • sellerId
   </ul>
<p></p>
Product  Testing Rules:
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

<br>
<br>



### UserComment — Entity Classes
<p></p>
Captures individual rating events between users. Records raterId, rateeId for relationship tracking, numeric rating (1-5 integer), textual comment (250 char limit), and timestamp for audit trail. Foundation for average rating calculations and comment history display.
   <ul style="margin-left: 40px;">
        • id<br>
        • raterId<br>
        • rateeId<br>
        • rating (1-5)<br>
        • comment (250 char max)<br>
        • timestamp<br>     
   </ul>
<p></p>
UserComment Testing Rules:
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
<br>
<br>



### RatingService — Interface
<p></p>
Defines business logic for rating operations. <br>
Core methods include are for submitting/validating ratings and getting the average rating. Encapsulates switch statements as validation ( Range: 1-5 ). As well as comment persistence (Data surviving after program ends), which will decouple UI from rating rules.
   <ul style="margin-left: 40px;">
        • rateUser()<br>
        • raterId<br>
        • rateeId<br>
        • rating (1-5)<br>
        • comment (250 char max)<br>
        • timestamp<br>     
   </ul>
<p></p>
RatingService Testing Rules:
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
<br>
<br>



### UserRepository — Interface
<p></p>
Standardizing the data access contract for user persistence (Data surviving after program ends). 
Provides CRUD operations (saveUser(), findById(), findByEmail()) plus rating updates (updateRating()). Abstracts storage implementation, supporting in-memory, JDBC, JPA, or NoSQL backends through polymorphism.
   <ul style="margin-left: 40px;">
        • id<br>
        • raterId<br>
        • rateeId<br>
        • rating (1-5)<br>
        • comment (250 char max)<br>
        • timestamp<br>     
   </ul>
<p></p>
UserRepository Testing Rules:
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
<br>
<br>




<h2> ProductRepository — Interface </h2>
<p></p>
Data access layer for product listings. Exposes save(), findBySellerId(), and findById() methods. Ensures consistent product CRUD operations while hiding persistence details, allowing seamless database technology swaps without application code changes.
   <ul style="margin-left: 40px;">
        • id<br>
        • raterId<br>
        • rateeId<br>
        • rating (1-5)<br>
        • comment (250 char max)<br>
        • timestamp<br>     
   </ul>
<p></p>
ProductRepository Testing Rules:
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
<br>
<p></p>
###  This table below involves the following:
   <ul style="margin-left: 40px;">
        • ModifyItem.java (concrete class)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (interface)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• ArrangeStorage.java (implementation)<br>
        • FeeCalculator.java (interface);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• TrackOwnerAndCalculateFees.java (implementation)<br>
   </ul>
  <p></p>
| Evaluation Criterion | Assessment | Analysis |
|----------------------|------------|----------|
| Clarity of Responsibility Separation | High | Validation, business logic, persistence, and administrative functions are structurally isolated. Each service adheres closely to a single responsibility. |
| Fault Isolation & System Reliability | High | Errors are confined to individual components. Validation failures do not affect persistence, and administrative operations do not interfere with marketplace logic. |
| Enforcement of Boundary & Validation Constraints | High | Validation logic is centralized, ensuring consistent enforcement of offer limits, rating boundaries, and lifecycle rules across all system interactions. |
| Protection Against Invalid Input & Misuse | High | Authentication and authorization layers prevent unauthorized actions. Centralized validation ensures invalid inputs are rejected before reaching operational logic. |
| Long-Term Maintainability & Scalability | High | Low coupling and high cohesion allow new features to be added with minimal modification to existing components. This structure supports safe expansion and easier testing. |
<br>
<br>
Based on the results, "Solution 2: Refined Modular Architecture" provides:
   <ul style="margin-left: 40px;">
        • Stronger separation of concerns<br>
        • Improved reliability<br>
        • Strict layering principles<br>
        • Core domain entities (User, Product, UserComment) separated from business logic & handled through dedicated interfaces<br>
        • Data persistence, managed by repository abstractions<br>
        • Consistent validation enforcement<br>
        • Validation rules are centralized and consistently enforced<br>
        • Isolating responsibilities and minimizing coupling between components<br>
        • Greater long-term scalability<br>
   </ul>
Therefore, "Solution 2: Refined Modular Architecture" was selected as the architecture for URMarketplace.




### UserManager —  Service Class
<p></p>
Manages user authentication and registration within the system. Maintains a collection of registered users, and controls session states. It also handles user validation, including unique username enforcement and credential verification during login attempts. This provides the foundation for the user identity management across the marketplace, using:
 <ul style="margin-left: 40px;"> 
 • users — List of registered User objects<br> 
 • nextId — Auto-incremented ID counter for new users </ul> <p></p>
 <br>
Here are the UserManager Testing Rules (Register method):
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
<p></p>



### IssueManager — Service Class
<p></p>
Handles the reporting and tracking of user-reported issues within the platform; managing the lifecycle of support tickets from creation to resolution. Each issue maintains relevant metadata including category classification, current status, and reporter information. This provides a structured problem reporting system for marketplace moderation and support through the key implementations of:
   <ul style="margin-left: 40px;"> 
   • issues — List of reported Issue objects<br> 
   • nextId — Auto-incremented ID counter for new issues <br>
   </ul> 
<p></p>
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
<br>
<p></p>



### BiddingManager —  Service Class
<p></p>
Manages the bidding and auction lifecycle within the marketplace program. Key aspects such as managing listing creation, offering submission, bid validation, and automatic auction expiration. By taking this route, this program maintains separate collections for active listings and submitted offers, along with state tracking for both entities/users. Of course implementing key core marketplace logic, such as the buy-now functionality and outbid notifications. 
  <ul style="margin-left: 40px;"> 
    • listings — List of Listing objects (items for sale/auction)<br> 
    • offers — List of Offer objects (bids submitted)<br> 
    • listingStates — Map of listing IDs to current status (ACTIVE, SOLD, EXPIRED)<br>
    • offerStates — Map of offer IDs to current status (PENDING, ACCEPTED, REJECTED, OUTBID)<br> 
    • nextListingId — Auto-incremented ID counter for new listings<br> 
    • nextOfferId — Auto-incremented ID counter for new offers <br> 
  </ul> 
<p></p>
BiddingManager Testing Rules (makeOffer method):
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
BiddingManager Testing Rules (buyNow method):
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
<br>
<p></p>
Based on the results, "Solution 2: Refined Modular Architecture" provides:
   <ul style="margin-left: 40px;">
        • Stronger separation of concerns<br>
        • Improved reliability<br>
        • Strict layering principles<br>
        • Core domain entities (User, Product, UserComment) separated from business logic & handled through dedicated interfaces<br>
        • Data persistence, managed by repository abstractions<br>
        • Consistent validation enforcement<br>
        • Validation rules are centralized and consistently enforced<br>
        • Isolating responsibilities and minimizing coupling between components<br>
        • Greater long-term scalability<br>
   </ul>
Therefore, "Solution 2: Refined Modular Architecture" was selected as the architecture for URMarketplace.
<br>
<p></p>



</ul>
</ul>


### 3.3 Final Solution

<p></p>
The final solution selected for URMarketplace is a modular Java back-end supported by an SQLite database and verified through JUnit-based testing. This solution was selected over the earlier alternatives because it provides clearer separation between data representation, business logic, persistence, and validation. From a testing perspective, this structure is significantly better than a more tightly coupled design because each major responsibility can be tested in isolation and then re-tested together through integration scenarios.

In the final design, classes such as User, Product, Listing, Offer, and Issue represent the system state, while service-oriented classes such as UserManager, BiddingManager, IssueManager, ModifyItem, ArrangeStorageImpl, and TrackOwnerAndCalculateFees handle business rules and workflow execution. DatabaseHelper centralizes database connectivity and setup, which makes test initialization and controlled database reset easier. This separation improves testability because each class exposes a narrower and more predictable behavior surface. As a result, unit tests can target validation rules and state transitions, while integration tests can confirm that database-backed operations behave correctly under realistic usage.

A major reason for selecting this solution is that it supports both positive testing and edge-case testing more effectively than the previous design concepts. Instead of testing one large, mixed component, the final architecture allows direct verification of item posting, bidding, issue reporting, storage booking, fee calculation, login behavior, and object state updates. This makes fault localization easier: if a test fails, it is much easier to determine whether the defect is in validation, database mapping, persistence, or business logic. In software testing and validation, this is a strong advantage because it reduces debugging time and improves confidence in the correctness of the final system.
<p></p>

The comparison in Table  summarizes why this final solution was selected.

| Criterion | Earlier / More Coupled Solutions | Final Modular Solution |
|-----------|----------------------------------|------------------------|
| Testability | Lower, because logic and persistence are mixed together | Higher, because entities, managers, and utilities can be tested separately |
| Fault Isolation | Weak, failures can affect several responsibilities at once | Stronger, because failures are easier to trace to one component |
| Regression Testing | More difficult after changes | Easier, because each class can be re-tested independently |
| Edge-Case Coverage | Harder to organize systematically | Easier to organize around each component and rule |
| Maintainability | Lower as new features are added | Higher due to clearer responsibilities |
| Reliability | More dependent on manual checking | More reliable through repeatable automated tests |

Based on this comparison, the final modular solution was selected because it supports a more structured and repeatable verification process, which is especially important in a software testing and validation course.

#### 3.3.1 Components
<p></p>
The final solution is composed of several cooperating components, each with a specific responsibility in the system. The main components and their testing methods are shown in Table .
<p></p>

| Component | Main Purpose | Testing Method Used |
|-----------|--------------|---------------------|
| URMarketplaceConsole | Provides the command-line interface and connects user actions to system operations | Manual functional testing and scenario-based testing |
| DatabaseHelper | Creates the SQLite connection and initializes the required tables | Integration testing, schema verification, and database initialization tests |
| User | Stores user account data and tracks rating averages | Unit testing of getters, setters, login state, and rating calculations |
| UserManager | Handles registration, login, and rating persistence | Integration testing with SQLite and edge-case testing for duplicate users and invalid login attempts |
| Product | Represents a product record with price and seller information | Unit testing of constructor behavior and data access |
| Listing | Represents an active marketplace listing, including bidding and sale state | Unit testing of default state, setters, and status transitions |
| Offer | Represents an offer or bid placed on a listing | Unit testing of object initialization, timestamps, and status values |
| Issue | Represents a user-submitted issue report | Unit testing of default status, field storage, and update behavior |
| IssueManager | Stores and retrieves issue reports from the database | Integration testing for insert, retrieval, generated IDs, and status mapping |
| BiddingManager | Creates listings, processes offers, and handles buy-now operations | Integration testing with the database and boundary testing for inactive items, low bids, and invalid IDs |
| ModifyItem | Validates titles, descriptions, and prices before item changes are applied | Unit testing and boundary value analysis |
| ArrangeStorage / ArrangeStorageImpl | Handles temporary storage requests, fee calculation, and cancellation status | Unit testing and edge-case testing |
| FeeCalculator / TrackOwnerAndCalculateFees | Tracks original ownership and computes platform fee, storage fee, and seller payout | Unit testing, equivalence class testing, and negative-value testing |


<img width="1760" height="1360" alt="image" src="https://github.com/user-attachments/assets/39801251-ecc3-49f4-b81e-4928faec058e" />



#### 3.3.2 Environmental, Societal, Safety, and Economic Considerations

The design of URMarketplace was developed with environmental, societal, safety, and economic constraints in mind. Environmentally, the software contributes positively by encouraging item reuse rather than disposal. Students often discard usable furniture, books, appliances, and supplies when moving out of residence at the end of a term. By offering a structured local marketplace, the design helps reduce unnecessary waste and extends the useful life of these items. In this way, the solution supports more sustainable consumption behavior on campus.

From a societal perspective, the platform improves access and fairness within the student community. Instead of relying on informal social media posts or word-of-mouth transactions, URMarketplace provides a centralized and more transparent method for buying and selling used items. This helps students who may be under time pressure, may not have strong social connections, or may need lower-cost alternatives for household and academic goods. In addition, the issue-reporting mechanism gives users a formal way to report problems, which supports accountability and helps build trust in the platform.

Economic considerations were also important in the design. The system includes fee calculation and storage tracking features so that the financial outcome of a transaction is more transparent. The seller can better understand the effect of platform and storage fees, while the platform design remains lightweight by using Java and SQLite rather than more expensive infrastructure. This choice reduces development complexity and deployment cost, which is appropriate for an academic prototype. The decision to begin without external payment gateway integration also reduces cost and keeps the project within a manageable scope.

Safety and reliability were addressed primarily through validation and testing. Input validation is used to reject invalid prices, blank identifiers, and oversized text fields before data is accepted into the system. State-based rules are also enforced, such as preventing bids on inactive listings and preserving item status through the listing lifecycle. From a software safety standpoint, reliability was strengthened by writing repeatable automated tests for critical workflows and boundary cases. This reduces the likelihood that invalid input or inconsistent system state will silently produce incorrect outputs. Together, these choices make the design safer and more dependable for users while remaining realistic for a student engineering project.

#### 3.3.3 Test Cases and results

The test cases were developed using the JUnit 5 framework, encompassing unit, integration, and business logic tests. These tests rely on standard JUnit assertions to check for expected results across different events, functions, and scenarios.

The results demonstrate that the software's functions like user registration, bidding logic, and storage management behave properly and respect their intended limits. The tests successfully fail when given unsupported or invalid data, and pass when the data is acceptable for the scenario. Furthermore, they show a reliable connection with the SQLite database, correctly modifying table values and verifying those changes. The test suites also ensure consistency by running on a completely clean database slate, which guarantees predictable and expected results by using test isolation.

#### 3.3.4 Limitations

Since URMarketplace is designed for students and faculty to organize and track sales and inventory, certain operational boundaries exist. These stem from both explicit and inherent limitations within the software's various functional and non-functional aspects.

A primary external constraint is the physical storage capacity allocated by the campus for items sold via the platform. Since the system must account for goods stored by students departing the institution, the available physical space imposes direct limitations on the volume, size, and nature of the inventory that can be managed within the software

Access to the platform is strictly limited to authorized university members. People who have yet to be granted or do not have a university provided outlook/email account can not use the platform until they do due to one of the authentication methods checking if the email account that is being used to login or sign in is an active university account

The current scope of the platform does not include payment verification. As a result, URMarketplace cannot guarantee or validate transactions conducted through physical cash exchanges or third-party payment services. Users are responsible for confirming the completion of payments externally, as the system does not feature an integrated escrow or payment gateway.
