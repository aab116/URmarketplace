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
 


<h2 align="center"> List of Figures </h2>
*No figures are included in this section.*

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
