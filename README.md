# hebtest
code for HEB take home assignment

# to run: 
<ol>
<li>import/clone from Github into Eclipse
<li>install SpringTools on Eclipe
<li>Built Project
<li>Run as SpringBoot from "Run" menu
</ol>

** Note the code assumes that the cart.json is in the directory that <b>Curl</b> is run from. The install will add a file to /main/java/resources callled "data.json" 
--(this is the couppn json file renamed) 


# API thusfar: 

<uL>
<li>http://localhost:8080/total::
    Requirement #1:  curl -v -H "Content-Type: application/json" -d @cart.json http://localhost:8080/total
<li>http://localhost:8080/calcTaxAll::
    Requirement #2:  curl -v -H "Content-Type: application/json" -d @cart.json http://localhost:8080/calcTaxAll
<li>http://localhost:8080/calcTaxable::
    Requirement #2:  curl -v -H "Content-Type: application/json" -d @cart.json http://localhost:8080/calcTaxable
<li>http://localhost:8080/calcAllAppyCoupons::
    Requirement #2:  curl -v -H "Content-Type: application/json" -d @cart.json http://localhost:8080/calcAllAppyCoupons
</ul>
